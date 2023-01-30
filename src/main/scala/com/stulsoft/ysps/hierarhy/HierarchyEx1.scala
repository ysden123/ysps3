/*
 * Copyright (c) 2023. StulSoft
 */

package com.stulsoft.ysps.hierarhy

object HierarchyEx1:
  private trait ServiceType[T]:
    def add(t1:T, t2:T):T

  case class P1(n:String)
  case class P2(i:Int)

  private object SomeService1 extends ServiceType[P1]:
    override def add(t1:P1, t2:P1): P1 =
      P1(t1.n + " - " + t2.n)

  private object SomeService2 extends ServiceType[P2]:
    override def add(t1:P2, t2:P2): P2 =
      P2(t1.i + t2.i)

  private def test1():Unit=
    println("==>test1")
    val p11=P1("n1")
    val p12=P1("n2")
    val p1 = SomeService1.add(p11, p12)
    println(s"p11:$p11, p12:$p12, p1:$p1")

    val p21=P2(123)
    val p22=P2(456)
    val p2 = SomeService2.add(p21,p22)
    println(s"p21:$p21, p22:$p22, p2:$p2")

  def main(args: Array[String]): Unit =
    println("==>main")
    test1()
