/*
 * Copyright (c) 2023. StulSoft
 */

package com.stulsoft.ysps.javascala

/**
 * Passing arguments of Java type Number or Java Comparable
 */
object JavaScalaEx01:
  private class Interface1:
    def method1(n: java.lang.Number): Unit =
      println(s"method1: n=$n")

    def method2[T](k:Comparable[T]):Unit=
      println(s"method2: k=$k")


  def main(args: Array[String]): Unit = {
    println("==>main")
    val i1 = Interface1()
    i1.method1(1)
    i1.method1(2.0)
    //    i1.method1("text")  // Compilation error

    i1.method2(1)
    i1.method2(2.0)
    i1.method2("text")
  }
