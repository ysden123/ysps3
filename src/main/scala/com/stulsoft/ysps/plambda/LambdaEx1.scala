/*
 * Copyright (c) 2023. StulSoft
 */

package com.stulsoft.ysps.plambda

object LambdaEx1 {

  private def f1(i: Int): Int = i * 3

  private val f2 = (i: Int) => i * 4

  private def test1(f: Int => Int): Unit = {
    println(s"f(2) = ${f(2)}")
  }

  def main(args: Array[String]): Unit = {
    println("==>main")

    println("f1")
    test1(f1)

    println("f2")
    test1(f2)
  }
}
