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

    // Logging
    implementation("com.typesafe.scala-logging:scala-logging_3:3.9.5")
    implementation("ch.qos.logback:logback-classic:1.4.5")

    // Test
    testImplementation("org.scalatest:scalatest_3:3.2.14")
    testImplementation("org.scalatestplus:junit-4-13_3:3.2.14.0")
}

/*
java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}
*/

application {
    mainClass.set("com.stulsoft.ysps.appMain")
}
