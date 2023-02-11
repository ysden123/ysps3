/*
 * Copyright (c) 2023. StulSoft
 */

package com.stulsoft.ysps.ppartialfunction

/**
 * @author Yuriy Stul
 */
object PartialFunctionE1 {

  val p1: PartialFunction[Int, String] = {
    case 1 => "one"
    case 2 => "two "
  }

  def main(args: Array[String]): Unit = {
    println("==>main")
    println(s"${p1.isDefinedAt(1)}")
    println(s"${p1.isDefinedAt(3)}")
    println(s"${p1(2)}")

    try
      val ss = p1(7)
      println(ss)
    catch
      case exception: Exception =>
        exception.printStackTrace()
  }
}
