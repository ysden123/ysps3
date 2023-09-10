/*
 * Copyright (c) 2023. StulSoft
 */

package com.stulsoft.ysps.collection

object InitEx01:
  def main(args: Array[String]): Unit = {
    println("==>main")
    val seq = 1 :: 2 :: 3 :: 4 :: Nil
    val init = seq.init
    println(s"original: $seq, init: $init")
  }
