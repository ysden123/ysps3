/*
 * Copyright (c) 2023. StulSoft
 */

package com.stulsoft.ysps.parray

object InitArray:

  private def printArray[T](a: Array[Array[T]], rows: Int, columns: Int): Unit =
    println(s"==>printArray rows=$rows, columns=$columns")
    for (x <- 0 until rows) {
      for (y <- 0 until columns) {
        print(a(x)(y))
        print(" ")
      }
      println()
    }

  private def initMultiDimArray(): Unit =
    println("==>initMultiDimArray")
    val arr = Array(Array(1.0, 2.0), Array(2.0, 4.0), Array(3.0, 10.0))
    printArray(arr, 3, 2)

  def main(args: Array[String]): Unit =
    println("==>main")
    initMultiDimArray()
