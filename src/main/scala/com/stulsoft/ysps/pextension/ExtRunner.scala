package com.stulsoft.ysps.pextension

import com.typesafe.scalalogging.Logger
import com.stulsoft.ysps.pextension.ext1 // It is optional in this case. It is visible inside same package.

@main
def runExtensionEx(): Unit =
  val logger = Logger("runExtensionEx")
  logger.info("==>runExtensionEx")
  val c = new SomeClassForExtension(123)
  logger.info("{}, c.ext1={}", c, c.ext1)