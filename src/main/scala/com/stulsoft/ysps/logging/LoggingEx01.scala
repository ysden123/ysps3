/*
 * Copyright (c) 2022. StulSoft
 */

package com.stulsoft.ysps.logging

import com.typesafe.scalalogging.{Logger, StrictLogging}

class LoggingEx01 extends StrictLogging {
  def show(): Unit = {
    logger.info("LoggingEx01::show")
  }
}

class LoggingEx02{
  private lazy val logger = Logger("LoggingEx02")
  def show(): Unit = {
    logger.info("LoggingEx02::show")
  }
}

class LoggingEx03{
  private lazy val logger = Logger (classOf[LoggingEx03])
  def show(): Unit = {
    logger.info("LoggingEx03::show")
  }
}
@main
def runLogging(): Unit = {
  val logger = Logger("RunLogging")
  logger.info("Start")
  (new LoggingEx01).show()
  (new LoggingEx02).show()
  (new LoggingEx03).show()
}
