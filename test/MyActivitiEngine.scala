import org.activiti.engine._

/**
  * Developed by:    cubanguy 
  * Date:            09/11/16
  * Project:         sbt-playCukes
  */
object MyActivitiEngine {

  val MyActivitiEngine = ProcessEngineConfiguration.createStandaloneInMemProcessEngineConfiguration().
    setDatabaseSchemaUpdate(ProcessEngineConfiguration.DB_SCHEMA_UPDATE_CREATE_DROP)
    .setJdbcUrl("jdbc:h2:mem:activiti;DB_CLOSE_DELAY=1000").setJdbcPassword("")
    .setJdbcUsername("sa").setJobExecutorActivate(true).buildProcessEngine()

  val repoService = MyActivitiEngine.getRepositoryService
  val runtimeService = MyActivitiEngine.getRuntimeService
  val taskService = MyActivitiEngine.getTaskService
  val historyService = MyActivitiEngine.getHistoryService
  val formService = MyActivitiEngine.getFormService

}
