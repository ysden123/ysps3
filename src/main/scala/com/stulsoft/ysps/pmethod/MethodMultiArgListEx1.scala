/*
 * Copyright (c) 2023. StulSoft
 */

package com.stulsoft.ysps.pmethod

object MethodMultiArgListEx1:
  private def func1[A, B](f1: () => A)(f2: A => B): B =
    f2(f1())

  private val f11: () => Int =
    () => 123

  private val f21: Int => String =
    (i:Int) => s"i=$i"

  private val f12: () => String =
    () => "This is a test"

  private val f22: String => Int =
    (s:String) => s.length

  private def test1(): Unit =
    println("==>test1")
    println(func1(() => 123)((i: Int) => s"i=$i"))

  private def test2(): Unit =
    println("==>test2")
    println(func1[Int, String](() => 456)((i: Int) => s"i=$i"))

  private def test3(): Unit =
    println("==>test3")
    val r = func1(f11)(f21)
    println(r)
    println(func1(f11)(f21))

  private def test4():Unit =
    println("==>test4")
    val r = func1(f12)(f22)
    println(r)
    println(func1(f12)(f22))

  def main(args: Array[String]): Unit = {
    println("==>main")
    test1()
    test2()
    test3()
    test4()
  }
