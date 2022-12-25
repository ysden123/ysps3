/*
 * Copyright (c) 2022. StulSoft
 */

package com.stulsoft.ysps.collection

import com.typesafe.scalalogging.StrictLogging

import scala.util.Try

object ReduceLeftEx1 extends StrictLogging:
  private def test1(): Unit =
    logger.info("==>test1")
    val l = List(3, 2, 1)
    val result = l.reduceLeft((a, b) => if a < b then a else b)
    logger.info("min={}", result)

  private def test2(): Unit =
    logger.info("==>test2")
    val l = List[Int]()
    val result = Try(l.min)
    logger.info("min={}", result)

  private def test3(): Unit =
    logger.info("==>test3")
    val l = List[Int]()
    val result = Try(l.reduceLeft((a, b) => if a < b then a else b))
    logger.info("min={}", result)

  private def test4(): Unit =
    logger.info("==>test4")
    val l = List[Int](1)
    val result = l.reduceLeft((a, b) => if a < b then a else b)
    logger.info("min={}", result)

  private def test5(): Unit =
    logger.info("==>test5")
    val l = List(3, 2, 1)
    val result = l.reduceLeft(_ min _)
    logger.info("min={}", result)

  def main(args: Array[String]): Unit = {
    test1()
    test2()
    test3()
    test4()
  }
