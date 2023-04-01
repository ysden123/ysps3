/*
 * Copyright (c) 2023. StulSoft
 */

package com.stulsoft.ysps.psource

import scala.io.Source

object SourceFromString:
  private def printLines(source:Source):Unit=
    source.getLines().foreach(println)

  def main(args: Array[String]): Unit =
    val text =
      """
        |line 1
        |line 2
        |line 3
        |""".stripMargin

    printLines(Source.fromString(text))