ThisBuild / scalaVersion := "3.2.2"
ThisBuild / version := "0.3.2"
ThisBuild / organization := "com.stulsoft"
ThisBuild / organizationName := "stulsoft"

lazy val root = (project in file("."))
  .settings(
    name := "ysps3",
    libraryDependencies += "com.typesafe.scala-logging" %% "scala-logging" % "3.9.5",
    libraryDependencies += "ch.qos.logback" % "logback-classic" % "1.4.5",
    libraryDependencies += "com.lihaoyi" %% "os-lib" % "0.9.1",
    libraryDependencies += "commons-io" % "commons-io" % "2.11.0",


    libraryDependencies += "org.scalatest" %% "scalatest" % "3.2.15" % Test
  )