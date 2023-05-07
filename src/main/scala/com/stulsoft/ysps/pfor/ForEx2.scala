/*
 * Copyright (c) 2023. StulSoft
 */

package com.stulsoft.ysps.pfor

import com.typesafe.scalalogging.StrictLogging

object ForEx2 extends StrictLogging:
  private def generateMatrix(n: Int): Array[Array[Boolean]] =
    val m = Array.ofDim[Boolean](n, n)
    for (x <- 0 until n) {
      for (y <- 0 until n) {
        m(x)(y) = if (x + y) % 2 == 0 then true else false
      }
    }
    m

  private def test1(): Unit =
    logger.info("==>test1")
    val n = 3
    val m = generateMatrix(n)
    for (x <- 0 until n) {
      println(" ")
      for (y <- 0 until n) {
        print(s"${if m(x)(y) then 1 else 0} ")
      }
    }

    logger.info(s"count={}",countTrue(m, n))

  private def countTrue(m: Array[Array[Boolean]], n: Int): Int =
    (for {
      x <- 0 until n
      y <- 0 until n if m(x)(y)
    } yield 1).size

  def main(args: Array[String]): Unit = {
    logger.info("==>main")
    test1()
  }
