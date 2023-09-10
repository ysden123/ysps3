/*
 * Copyright (c) 2023. StulSoft
 */

package com.stulsoft.ysps.collection

object AddStringEx01:
  private def test01(collection: Iterable[Int]): Unit =
    println("==>test01")
    val sb = StringBuilder()
    collection.addString(sb)
    println(s"addString: ${sb.toString}")

  private def test02(collection: Iterable[Int]): Unit =
    println("==>test02")
    val sb = StringBuilder()
    collection.addString(sb, ":")
    println(s"addString: ${sb.toString}")

  private def test03(collection: Iterable[Int]): Unit =
    println("==>test03")
    val sb = StringBuilder()
    collection.addString(sb, "start", ":", "end")
    println(s"addString: ${sb.toString}")

  def main(args: Array[String]): Unit =
    println("==>main")
    val collection = Seq(1, 2, 3)
    test01(collection)
    test02(collection)
    test03(collection)
