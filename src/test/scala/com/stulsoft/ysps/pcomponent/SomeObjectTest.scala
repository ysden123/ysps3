/*
 * Copyright (c) 2023. StulSoft
 */

package com.stulsoft.ysps.pcomponent

import org.scalatest.funsuite.AnyFunSuiteLike

import scala.util.{Failure, Success}

class SomeObjectTest extends AnyFunSuiteLike {

  test("testFromString") {
    val so = SomeObject.fromString("123")
    println(so.text)
  }

  test("testFromStringWithTry") {
    SomeObject.fromStringWithTry("456") match
      case Failure(exception)=> println("Error: " + exception.getMessage)
      case Success(value)=>println(value)
  }

}
