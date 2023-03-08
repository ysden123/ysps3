/*
 * Copyright (c) 2023. StulSoft
 */

package com.stulsoft.ysps.pmatch

object MatchOption:

  private def matcher[T](value:Option[T]):Unit=
    println("==>matcher")

    value match
      case Some(_:String) =>
        println("It is a string")
      case Some(_) =>
        println("It is not a string")
      case None =>
        println("It is the empty")


  private def test1():Unit=
    println("==>test1")
    println("String:")
    matcher(Option("sss"))

    println("Boolean:")
    matcher(Option(true))

    println("Int:")
    matcher(Option(123))

    println("None:")
    matcher(Option.empty)

  def main(args: Array[String]): Unit = {
    println("==>main")
    test1()
  }
