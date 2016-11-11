
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

    val x: util.List[FormProperty] = formService.getStartFormData(pi.getProcessDefinitionId).getFormProperties

    for(xx<-x){
      println(xx.getId, xx.getName)
    }

    val formData = new util.HashMap[String, String]()
    formData.put("numberOfDays", "2")
    formData.put("startDate", "20-06-2017")
    formData.put("vacationMotivation", "R&R")
    formData.put("vacationApproved", "true")
    formService.submitTaskFormData(task.getId, formData)

  }

  "task name " should "be" in {

    val historyData: util.List[HistoricDetail] = historyService.createHistoricDetailQuery().formProperties().list()

    for (v <- historyData) {
      println(v.asInstanceOf[HistoricFormProperty].getPropertyId,
        v.asInstanceOf[HistoricFormProperty].getPropertyValue)
    }

    repoService.createDeployment().addClasspathResource("VacationRequest.bpmn20.xml").deploy()
    runtimeService.startProcessInstanceByKey("vacationRequest")
    val task = taskService.createTaskQuery().singleResult()
    println(task)
  }

}
