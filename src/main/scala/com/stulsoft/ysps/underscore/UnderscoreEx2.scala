/*
 * Copyright (c) 2023. StulSoft
 */

package com.stulsoft.ysps.underscore

class DObject:
  private var anOption: Option[Int] = None

  def theOption: Option[Int] = anOption

  def theOption_=(a: Option[Int]): Unit =
    anOption = a

  override def toString: String =
    s"DObject anOption=$anOption"

object UnderscoreEx2:
  def main(args: Array[String]): Unit =
    println("==>main")
    val dObject = DObject()
    println(dObject)

    dObject.theOption = Some(123)
    println(dObject)

    var ttt = dObject.theOption
    ttt = Some(456)
    println(dObject)
