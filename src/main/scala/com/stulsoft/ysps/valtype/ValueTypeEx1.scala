/*
 * Copyright (c) 2023. StulSoft
 */

package com.stulsoft.ysps.valtype

import com.typesafe.scalalogging.StrictLogging

object ValueTypeEx1 extends StrictLogging:
  opaque type FirstName = String

  object FirstName:
    def apply(s: String): FirstName = s

    def safe(value: String): Option[FirstName] = if value.startsWith("f") then Some(value) else None

  opaque type SecondName = String

  object SecondName:
    def apply(s: String): SecondName = s

    def safe(value: String): Option[SecondName] = if value.startsWith("s") then Some(value) else None

  type ZipCode = String
  type Address = String

  case class Person(firstName: FirstName, secondName: SecondName)

  case class Data(zipCode: ZipCode, address: Address)

  private def test1(): Unit =
    logger.info("==>test1")
    val fn: FirstName = "masha"
    val sn: SecondName = "zina"
    val p1 = Person(fn, sn)
    println(s"p1: $p1")

    // No error
    val p2 = Person("kuku", "mumu")
    println(s"p2: $p2")

    // No error
    val p3 = Person(sn, fn)
    println(s"p3: $p3")

  private def test2(): Unit =
    logger.info("==>test2")
    val zc1: ZipCode = "123456"
    val ad1: Address = "non street 26"
    val d1 = Data(zc1, ad1)
    println(s"d1: $d1")

    val d2 = Data("zippp", "streetttt")
    println(s"d2: $d2")

    val d3 = Data(ad1, zc1)
    println(s"d3: $d3")

  private def test3(): Unit =
    logger.info("==>test3")
    val fn1 = FirstName("first name 1")
    val sn1 = SecondName("second name 1")

    val p1 = Person(fn1, sn1)
    println(s"p1: $p1")

    val p2 = Person(sn1, fn1)
    println(s"p2: $p2")

    val p3 = Person(SecondName("second name 2"), FirstName("first name 2"))
    println(s"p3: $p3")

    val test1 = p3.firstName == SecondName("second name 2")
    println(s"test1: $test1")

    val test2 = p3.firstName == "second name 2"
    println(s"test2: $test2")

  private def test4(): Unit =
    logger.info("==>test4")
    val fn1 = FirstName.safe("tttt")
    println(s"fn1: $fn1")

    val fn2 = FirstName.safe("ftt")
    println(s"fn2: $fn2")

    val sn1 = SecondName.safe("second name 1")
    println(s"sn1: $sn1")


  def main(args: Array[FirstName]): Unit =
    logger.info("==>main")
    test1()
    test2()
    test3()
    test4()

