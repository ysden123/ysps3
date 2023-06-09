/*
 * Copyright (c) 2023. StulSoft
 */

package com.stulsoft.ysps.poption

object OptionFuncParam:
  private case class SomeClass1(func: (text: String) => Unit):
    def test(): Unit =
      func("Test1")

  private case class SomeClass2(private var func: Option[String => Unit] = None):
    def test(): Unit =
      if func.isDefined then func.get("Test2")

    def defineFunc(func: Option[String => Unit]):Unit=
      this.func=func

  def main(args: Array[String]): Unit =
    println("==>main")

    def fff(t: String): Unit =
      println(t)

    def fff2(t: String): Unit =
      println(t + " 2222")

    val sc1 = SomeClass1(fff)
    sc1.test()

    val sc2 = SomeClass2(Some(fff))
    sc2.test()

    sc2.defineFunc(Some(fff2))
    sc2.test()
