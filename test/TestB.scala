
/**
  * Developed by:    cubanguy 
  * Date:            08/11/16
  * Project:         sbt-playCukes
  */


import java.util

import MyActivitiEngine._
import org.activiti.engine.form.FormProperty
import org.activiti.engine.history.{HistoricDetail, HistoricFormProperty}

import scala.collection.JavaConversions._


class TestB extends RuntimeProcess {

  "process Instance " should "not be null " in {

    repoService.createDeployment().addClasspathResource("VacationRequest.bpmn20.xml").deploy()
    val pi = runtimeService.startProcessInstanceByKey("vacationRequest")

    val task = taskService.createTaskQuery().singleResult()
    println(task)

    val xs = new java.util.ArrayList[FormProperty]()
    xs.addAll(formService.getStartFormData(pi.getProcessDefinitionId).getFormProperties)

    for(xx<-xs){
      println(xx.getId, xx.getName, xx.getValue, xx.getType.getName)
    }
    val formData = new util.HashMap[String, String]()
    formData.put("numberOfDays", "2")
    formData.put("startDate", "20-06-2017")
    formData.put("vacationMotivation", "R&R")
    formData.put("vacationApproved", "true")
    formService.submitTaskFormData(task.getId, formData)
    val h = new java.util.ArrayList[FormProperty]()


  }

  "task name " should "be" in {

//    val historyData = new java.util.ArrayList[HistoricDetailQuery]()

   val historyData:util.List[HistoricDetail] = historyService.createHistoricDetailQuery().formProperties().list()

    for(v<-historyData){
//      println(v.getActivityInstanceId, v.getExecutionId, v.getId, v.getProcessInstanceId, v.getTaskId, v.getTime)
        println(v.asInstanceOf[HistoricFormProperty].getPropertyId,
          v.asInstanceOf[HistoricFormProperty].getPropertyValue)
    }

//    var formProperty = historyData.get(0).asInstanceOf[HistoricFormProperty]
//
//    println(formProperty.getPropertyId, formProperty.getPropertyValue)
//    formProperty = historyData.get(1).asInstanceOf[HistoricFormProperty]
//    println(formProperty.getPropertyId, formProperty.getPropertyValue)
//

    repoService.createDeployment().addClasspathResource("VacationRequest.bpmn20.xml").deploy()
    val pi = runtimeService.startProcessInstanceByKey("vacationRequest")
    val task = taskService.createTaskQuery().singleResult()
    println(task)
  }

}
