/*
 * Copyright (c) 2022. StulSoft
 */

package com.stulsoft.ysps.logging

import com.typesafe.scalalogging.StrictLogging
import org.junit.runner.RunWith
import org.scalatest.funsuite.AnyFunSuite
import org.scalatestplus.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class LoggingSuite extends AnyFunSuite, StrictLogging:
  test("Check test logging log") {
    logger.info("Running test {}", "test1")
    (new LoggingEx01).show()
  }
