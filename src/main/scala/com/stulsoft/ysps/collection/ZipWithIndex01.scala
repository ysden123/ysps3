/*
 * Copyright (c) 2023. StulSoft
 */

package com.stulsoft.ysps.collection

object ZipWithIndex01:
  private def test1():Unit=
    println("==>test1")
    val seq=Seq("one","two","three")
    val seqWithIndex=seq.zipWithIndex
    seqWithIndex.foreach((value, index) => println(s"$index $value"))

  def main(args: Array[String]): Unit = {
    test1()
  }
