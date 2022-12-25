/*
 * Copyright (c) 2022. StulSoft
 */

package com.stulsoft.ysps.collection

import com.typesafe.scalalogging.StrictLogging

object CountEx1 extends StrictLogging:
  private def test1():Unit =
    logger.info("==>test1")
    val l = List(1,2,3)
    val c = l.count(i => i >= 2)
    logger.info("count={}", c)

  def main(args: Array[String]): Unit = {
    test1()
  }
