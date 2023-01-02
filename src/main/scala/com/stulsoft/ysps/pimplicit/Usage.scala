/*
 * Copyright (c) 2023. StulSoft
 */

package com.stulsoft.ysps.pimplicit

object Usage:

  import ImplicitConversion.given

  private val processingTime = 100

  private def test(): Unit =
    //auto conversion from Int to Second using given
    println(TimeUtil.doSomethingWithProcessingTime(processingTime))

  def main(args: Array[String]): Unit =
    println("==>main")
    test()
