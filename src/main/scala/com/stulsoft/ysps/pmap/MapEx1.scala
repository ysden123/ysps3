/*
 * Copyright (c) 2023. StulSoft
 */

package com.stulsoft.ysps.pmap

import scala.collection.mutable

object MapEx1 {

  private def test1():Unit={
    println("==>test1")

    val m = new mutable.TreeMap[String,Int]
    val first = m.getOrElse("first", 0)
    println(s"first = $first, size=${m.size}")

    val first2 = m.getOrElseUpdate("first2", 0)
    println(s"first2 = $first2, size=${m.size}")
    m.put("second1", m.getOrElseUpdate("second1", 0) + 1)
    var second1 = m.get("second1")
    println(s"second1 = $second1, size=${m.size}")

    m.put("second1", m.getOrElseUpdate("second1", 0) + 1)
    second1 = m.get("second1")
    println(s"second1 = $second1, size=${m.size}")
  }
  def main(args: Array[String]): Unit = {
    println("==>main")
    test1()
  }
}
