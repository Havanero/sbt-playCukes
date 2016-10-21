name := """sbt-playCukes"""

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.11.7"

libraryDependencies ++= Seq(
  jdbc,
  cache,
  ws,
  "org.scalatestplus.play" %% "scalatestplus-play" % "1.5.1" % Test
)
libraryDependencies += "info.cukes" % "cucumber-scala_2.11" % "1.2.4"
libraryDependencies += "info.cukes" % "cucumber-junit" % "1.2.4"
libraryDependencies += "junit" % "junit" % "4.12"
