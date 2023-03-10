/*
 * Copyright (c) 2023. StulSoft
 */

package com.stulsoft.ysps.pfunction

import com.typesafe.scalalogging.LazyLogging

/**
 * @author Yuriy Stul
 */
object AdderEx1 extends LazyLogging{

  private def test1():Unit=
    logger.info("==>test1")
    def ffff(i1:Int, i2:Int):Int=
      i1 * i2

    val lll = List(1,2,3,4)

    println(lll.fold(0)(_ + _))
    println(lll.fold(1)(ffff))

  def main(args: Array[String]): Unit = {
    logger.info("==>main")
    test1()
  }
}
