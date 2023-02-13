/*
 * Copyright (c) 2023. StulSoft
 */

package com.stulsoft.ysps.pmap

import scala.collection.mutable

/**
 * @author Yuriy Stul
 */
object MapEx2 {
  private def test1(): Unit = {
    println("==>test1")
    val m = mutable.TreeMap[String, Int]("aaa" -> 1, "bbb" -> 2)
    println("foreach")
    m.foreach(t=> println(s"${t._1} -> ${t._2}"))

    println("foreachEntry")
    m.foreachEntry((k,v) => println(s"$k -> $v"))

    println("for")
    for(e <- m){
      println(s"${e._1} -> ${e._2}")
    }

    println("case")
    m foreachEntry {
      case (key:String, value:Int) => println(s"$key -> $value")
    }
  }

  def main(args: Array[String]): Unit = {
    println("==>main")
    test1()
  }
}
