import org.activiti.engine.ProcessEngineConfiguration
import org.scalatest.FlatSpec

/**
  * Developed by:    cubanguy 
  * Date:            08/11/16
  * Project:         sbt-playCukes
  */


class MyTests extends FlatSpec {
  val fileName = "VacationRequest.bpmn20.xml"

  val processEngine = ProcessEngineConfiguration.createStandaloneInMemProcessEngineConfiguration().
    setDatabaseSchemaUpdate(ProcessEngineConfiguration.DB_SCHEMA_UPDATE_CREATE_DROP)
    .setJdbcUrl("jdbc:h2:mem:activiti;DB_CLOSE_DELAY=1000").setJdbcPassword("")
    .setJdbcUsername("sa").setJobExecutorActivate(true).buildProcessEngine()

  val repositoryService = processEngine.getRepositoryService


  "BPM process  " should "start Holiday Request Tasks" in {
    repositoryService.createDeployment().addClasspathResource(fileName).deploy()
    val runtimeService = processEngine.getRuntimeService
    val processInstance = runtimeService.startProcessInstanceByKey("vacationRequest")
    assert(processInstance != null)
    val task = processEngine.getTaskService.createTaskQuery().singleResult()
    assert("Handle vacation request" == task.getName)
  }
  it should "display all the tasks" in {
    repositoryService.createDeployment()
      .addClasspathResource(fileName)
      .deploy()

    println("Number of process definitions: " + repositoryService.createProcessDefinitionQuery().count())
  }

}
