/*
 * Copyright (c) 2022. StulSoft
 */

plugins {
    scala
    application
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.scala-lang:scala3-library_3:3.2.1")

    testImplementation("org.scalatest:scalatest_3:3.2.14")
    testImplementation("org.scalatestplus:junit-4-13_3:3.2.14.0")
}

application {
    mainClass.set("com.stulsoft.ysps.App")
}
