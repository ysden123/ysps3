/*
 * Copyright (c) 2023. StulSoft
 */

package com.stulsoft.ysps.pmethod

object MethodMultiArgListEx2:
  private def func1(x: Int)(y: Int): String =
    println(s"x=$x")
    println(s"y=$y")

    s"x=$x, y=$y, sum=${x + y}"
  private def func2(x: Int)(y: Int): Int =
    println(s"x=$x")
    println(s"y=$y")

    x + y

  private def test1():Unit=
    println("==>test1")
    println(func1(1)(2))

  private def test2():Unit=
    println("==>test2")
    println(func1(10))  // No error in compilation!
    println(func2(10))  // No error in compilation!

  def main(args: Array[String]): Unit = {
    println("==>main")
    test1()
    test2()
  }
