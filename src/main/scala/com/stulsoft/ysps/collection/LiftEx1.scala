/*
 * Copyright (c) 2023. StulSoft
 */

package com.stulsoft.ysps.collection

object LiftEx1:
  private def test1():Unit=
    println("==>test1")
    val seq=Seq("zero","one","two")
    println("1")
    var i = seq.lift(1)
    i.foreach(i => println(s"1 -> i"))
    i=seq.lift(10)
    println("10")
    i.foreach(i => println(s"1 -> i"))

  def main(args: Array[String]): Unit = {
    test1()
  }
