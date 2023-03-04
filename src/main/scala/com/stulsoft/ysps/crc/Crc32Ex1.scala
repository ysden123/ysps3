/*
 * Copyright (c) 2023. StulSoft
 */

package com.stulsoft.ysps.crc

import java.util.zip.CRC32

/*
* See https://www.quickprogrammingtips.com/java/how-to-calculate-crc32-checksum-in-java.html
*/
object Crc32Ex1 {
  private def showResult(crc32: CRC32): Unit =
    println(s"crc32 = 0x${crc32.getValue.toHexString}")

  private def test1(): Unit = {
    println("==>test1")
    val data: Array[Byte] = Array(0x01, 0x00, 0x02)
    val crc32 = new CRC32()
    crc32.update(data)
    showResult(crc32)
  }

  private def test2(): Unit = {
    println("==>test2")
    val data: Array[Byte] = Array(0x01, 0x02, 0x00)
    val crc32 = new CRC32()
    crc32.update(data)
    showResult(crc32)
  }

  private def test3(): Unit = {
    println("==>test3")
    val data: Array[Byte] = Array(0x00)
    val crc32 = new CRC32()
    crc32.update(data)
    showResult(crc32)
  }

  private def test4(): Unit = {
    println("==>test4")
    val data: Array[Byte] = Array(0x00, 0x00)
    val crc32 = new CRC32()
    crc32.update(data)
    showResult(crc32)
  }

  def main(args: Array[String]): Unit = {
    test1()
    test2()
    test3()
    test4()
  }
}
