/*
 * Copyright (c) 2023. StulSoft
 */

package com.stulsoft.ysps.prandom

import scala.collection.mutable.ListBuffer
import scala.util.Random

object RandomEx1:
  private def test1(): Unit =
    println("==>test1")
    val random = Random
    val values = ListBuffer[Int]()
    for (i <- 1 to 100)
      values += random.nextInt(100)

    val duplicates = findDuplicates(values)

    println(s"duplicates size=${duplicates.size}")
  end test1

  private def findDuplicates(values:ListBuffer[Int]):Iterable[Int]=
    val map = values.groupBy(i => i)
    map.filter((k, list) => list.size > 1).map((k,Seq) => k)

  def main(args: Array[String]): Unit =
    println("==>main")
    test1()
  end main
end RandomEx1

