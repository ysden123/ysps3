ThisBuild / scalaVersion := "3.3.1"
ThisBuild / version := "0.4.3"
ThisBuild / organization := "com.stulsoft"
ThisBuild / organizationName := "stulsoft"

lazy val root = (project in file("."))
  .settings(
    name := "ysps3",
    libraryDependencies += "com.typesafe.scala-logging" %% "scala-logging" % "3.9.5",
    libraryDependencies += "ch.qos.logback" % "logback-classic" % "1.4.7",
    libraryDependencies += "com.lihaoyi" %% "os-lib" % "0.9.1",
    libraryDependencies += "commons-io" % "commons-io" % "2.13.0",
    libraryDependencies += "org.scala-lang.modules" %% "scala-xml" % "2.1.0",

    libraryDependencies += "org.scalatest" %% "scalatest" % "3.2.15" % Test
  )