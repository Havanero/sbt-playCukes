package integration.bdd.stories
import cucumber.api.scala.{EN, ScalaDsl}
import org.scalatest.MustMatchers

/**
  * Developed by:    cubanguy 
  * Date:            21.10.16
  * Project:         sbt-playCukes
  */
class HelloWorld extends ScalaDsl with EN with MustMatchers {

  Given("""^that I am on the main site$""") { () =>
    print("ok")
  }

  When("""^the index page is display$""") { () =>
    //// Write code here that turns the phrase above into concrete actions
  }
  Then("""^I should see "([^"]*)"$""") { (arg0: String) =>
    //// Write code here that turns the phrase above into concrete actions
  }

}
