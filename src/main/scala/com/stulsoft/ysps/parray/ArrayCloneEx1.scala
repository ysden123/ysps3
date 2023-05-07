/*
 * Copyright (c) 2023. StulSoft
 */

package com.stulsoft.ysps.parray

object ArrayCloneEx1:
  private def printArray(a:Array[Array[Int]], n:Int):Unit=
    for(x<-0 until n){
      for (y<- 0 until n){
        print(a(x)(y))
      }
      println()
    }
  def test1(): Unit =
    println("==>test1")
    val a=Array.ofDim[Int](3,3)
    a(0)(0) = 1
    a(0)(1) = 0
    a(0)(2) = 0

    a(1)(0) = 0
    a(1)(1) = 1
    a(1)(2) = 0

    a(2)(0) = 0
    a(2)(1) = 0
    a(2)(2) = 1

    println("Original array:")
    printArray(a,3)

    val c = a.clone()

    println("Cloned array:")
    printArray(c, 3)

  def main(args: Array[String]): Unit =
    println("==>main")
    test1()
