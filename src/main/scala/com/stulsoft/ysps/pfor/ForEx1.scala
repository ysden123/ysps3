/*
 * Copyright (c) 2023. StulSoft
 */

package com.stulsoft.ysps.pfor

import com.typesafe.scalalogging.LazyLogging

object ForEx1 extends LazyLogging:
  private def f1(x: Int, y: Int):Iterable[String] =
    for {
      theX <- 1 to x if x > 3
    } yield s"theX($theX) -> y($y)"

  private def f2(x: Int, y: Int):Iterable[String] =
    for {
      theX <- 1 to x if theX > 3
    } yield s"theX($theX) -> y($y)"

  private def test1():Unit=
    logger.info("==>test1")
    println(f1(3,5))

  private def test2():Unit=
    logger.info("==>test2")
    println(f1(5,6))
    println(f2(5,6))

  def main(args: Array[String]): Unit =
    logger.info("==>main")
    test1()
    test2()
