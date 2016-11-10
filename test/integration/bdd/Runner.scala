package integration.bdd

import cucumber.api.CucumberOptions
import cucumber.api.junit.Cucumber
import org.junit.runner.RunWith

/**
  * Developed by:    cubanguy 
  * Date:            21.10.16
  * Project:         sbt-playCukes
  */
@CucumberOptions(features = Array("test/integration/bdd/features"), glue = Array("integration.bdd.stories"),
  plugin = Array("pretty", "html:test/integration/bdd/report"), tags = Array("@dev"))
@RunWith(classOf[Cucumber])
class Runner {

}
