import org.activiti.engine.ProcessEngineConfiguration
import org.scalatest.{BeforeAndAfterEach, FlatSpec, Suite, SuiteMixin}

trait TestSpec extends FlatSpec with SuiteMixin {
  this: Suite =>

  abstract override def withFixture(test: NoArgTest) = {
    val fileName = "VacationRequest.bpmn20.xml"
    println("running set")
    val processEngine = ProcessEngineConfiguration.createStandaloneInMemProcessEngineConfiguration().
      setDatabaseSchemaUpdate(ProcessEngineConfiguration.DB_SCHEMA_UPDATE_CREATE_DROP)
      .setJdbcUrl("jdbc:h2:mem:activiti;DB_CLOSE_DELAY=1000").setJdbcPassword("")
      .setJdbcUsername("sa").setJobExecutorActivate(true).buildProcessEngine()

    //    val repositoryService = processEngine.getRepositoryService
    //    repositoryService.createDeployment().addClasspathResource(fileName).deploy()
    //    val runtimeService = processEngine.getRuntimeService
    //    val processInstance = runtimeService.startProcessInstanceByKey("vacationRequest")
    try super.withFixture(test)
    finally "done"

  }
}

trait RuntimeProcess extends FlatSpec with Suite with BeforeAndAfterEach {

  override def beforeEach() {
    println("Running Setup for test", testNames.toList.map(_.lines.next()))

    super.beforeEach()
  }

  override def afterEach() {
//    MyActivitiEngine.MyActivitiEngine.getProcessEngineConfiguration.buildProcessEngine()

    println("--------------->Cleaning up<----------------")
    super.afterEach()
//    finally  MyActivitiEngine.MyActivitiEngine.close()
  }
}
