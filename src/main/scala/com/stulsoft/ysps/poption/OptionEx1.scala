/*
 * Copyright (c) 2023. StulSoft
 */

package com.stulsoft.ysps.poption

import com.typesafe.scalalogging.StrictLogging

object OptionEx1 extends StrictLogging:
  def test1[T](t:T):Unit=
    logger.info("==>test1, t:  {}", t)
    val option = Option(t)
    logger.info("option: {}", option)

  def main(args: Array[String]): Unit = {
    logger.info("==>main")
    test1("test") // Some(test)
    test1(null)   // None
  }
