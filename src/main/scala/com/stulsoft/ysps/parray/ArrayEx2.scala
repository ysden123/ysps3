/*
 * Copyright (c) 2023. StulSoft
 */

package com.stulsoft.ysps.parray

object ArrayEx2:
  private def test1():Unit=
    println("==>test1")
    val arr = Array.ofDim[Any](2,3)
    for(row <- 0 to 1)
      arr(row)(0) = "str1" + row
      arr(row)(1) = 65.2 + row
      arr(row)(2) = 123 + row

    println(arr(0)(0))
    println(arr(1)(0))
    println(arr(1)(1))

  def main(args: Array[String]): Unit =
    println("==>main")
    test1()