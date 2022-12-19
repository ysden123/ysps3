/*
 * Copyright (c) 2022. StulSoft
 */

package com.stulsoft.ysps.collection

import com.typesafe.scalalogging.StrictLogging

import scala.collection.immutable.HashSet

class CollectionEx(col: Iterable[String]) extends StrictLogging:
  def resultOfMap(): Unit = {
    logger.info("==>resultOfMap")
    val res = col.map(i => i + " modified")
    logger.info(s"res: $res")
  }

@main
def runCollectionEx(): Unit = {
  val ceList = new CollectionEx(List("aaa", "bbb"))
  ceList.resultOfMap()

  val ceSet = new CollectionEx(HashSet("aaa", "bbb"))
  ceSet.resultOfMap()
}
