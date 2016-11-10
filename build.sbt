name := """sbt-playCukes"""

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.11.7"

val akkaVersion = "2.4.0"
val activitiVersion = "5.19.0"
val activemqVersion = "5.10.0"
val camelVersion = "2.13.1"


libraryDependencies ++= Seq(
  jdbc,
  cache,
  ws,
  "org.scalatestplus.play" %% "scalatestplus-play" % "1.5.1" % Test,
  "org.apache.camel" % "camel-test" % camelVersion % "test",
  "org.activiti" % "activiti-camel" % activitiVersion withSources() withJavadoc()
)
libraryDependencies += "info.cukes" % "cucumber-scala_2.11" % "1.2.4"
libraryDependencies += "info.cukes" % "cucumber-junit" % "1.2.4"
libraryDependencies += "junit" % "junit" % "4.12"
libraryDependencies += "org.activiti" % "activiti-engine" % "5.19.0"
libraryDependencies += "com.h2database" % "h2" % "1.4.190" % "test"
libraryDependencies += "org.scalatest" %% "scalatest" % "2.2.4" % "test"