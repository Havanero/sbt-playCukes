
/**
  * Developed by:    cubanguy 
  * Date:            08/11/16
  * Project:         sbt-playCukes
  */


import java.util

import MyActivitiEngine._
import org.activiti.engine.form.FormProperty

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



  }

  "task name " should "be" in {
    repoService.createDeployment().addClasspathResource("VacationRequest.bpmn20.xml").deploy()
    val pi = runtimeService.startProcessInstanceByKey("vacationRequest")
    val task = taskService.createTaskQuery().singleResult()
    println(task)
  }

}
