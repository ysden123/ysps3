/*
 * Copyright (c) 2022. StulSoft
 */

package com.stulsoft.ysps.collection

import com.typesafe.scalalogging.StrictLogging

object GetNSortedItems extends StrictLogging:
  private def buildListOfFirstNItems(src:Seq[Int], quantityToLeave:Int):Seq[Int] =
    val sorted = src.sortBy(i => i)
    val totalSize = sorted.size
    sorted.take(totalSize - quantityToLeave)

  private def test1():Unit =
    logger.info("==>test1")
    val l1 = List(4,5,6,2,1,3)
    var r = buildListOfFirstNItems(l1, 2)
    logger.info("l1: {}, 2-> r: {}", l1, r)
    r = buildListOfFirstNItems(l1, 4)
    logger.info("l1: {}, 4-> r: {}", l1, r)
    r = buildListOfFirstNItems(l1, 5)
    logger.info("l1: {}, 5-> r: {}", l1, r)

  def main(args: Array[String]): Unit = {
    test1()
  }
