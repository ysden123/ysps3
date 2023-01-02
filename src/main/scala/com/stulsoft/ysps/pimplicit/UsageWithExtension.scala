/*
 * Copyright (c) 2023. StulSoft
 */

package com.stulsoft.ysps.pimplicit

object UsageWithExtension:
  import Extension._
  private val processingTime = 100
  private def test():Unit =
    println(TimeUtil.doSomethingWithProcessingTime(processingTime.toSecond))

  def main(args: Array[String]): Unit =
    println("==>main")
    test()
