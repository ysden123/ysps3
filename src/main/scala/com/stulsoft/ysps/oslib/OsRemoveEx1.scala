/*
 * Copyright (c) 2022. StulSoft
 */

package com.stulsoft.ysps.oslib

import com.typesafe.scalalogging.StrictLogging
import org.apache.commons.io.FileUtils
import os.Path

import java.io.File


object OsRemoveEx1 extends StrictLogging:
  private def removeHidden():Unit =
    logger.info("==>removeHidden")
    try
      val result = FileUtils.deleteQuietly(new File("c:\\work\\d1"))
      logger.info("result={}", result)
    catch
      case exception: Exception => logger.error(exception.getMessage, exception)


  def main(args: Array[String]): Unit =
    removeHidden()
