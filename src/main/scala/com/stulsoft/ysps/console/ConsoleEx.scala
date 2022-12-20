/*
 * Copyright (c) 2022. StulSoft
 */

package com.stulsoft.ysps.console

import com.typesafe.scalalogging.StrictLogging

import scala.Console.{BLINK, BOLD, GREEN, RESET}

object ConsoleEx extends StrictLogging:
  def colorizedOutput(): Unit = {
    logger.info("==>colorizedOutput")
    Console.println(s"$RESET${GREEN}This is green text$RESET")
  }
  def blinkedOutput(): Unit = {
    logger.info("==>blinkedOutput")
    Console.println(s"$RESET${BLINK}This is blinked text$RESET")
  }

  def boldOutput(): Unit = {
    logger.info("==>boldOutput")
    Console.println(s"$RESET${BOLD}This is bold text$RESET")
  }

@main
def runConsoleEx(): Unit =
  ConsoleEx.colorizedOutput()
  ConsoleEx.blinkedOutput()
  ConsoleEx.boldOutput()
