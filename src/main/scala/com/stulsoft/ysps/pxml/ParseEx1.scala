/*
 * Copyright (c) 2023. StulSoft
 */

package com.stulsoft.ysps.pxml

import java.net.URLDecoder
import scala.io.Source
import scala.util.{Failure, Success, Using}
import scala.xml.XML

object ParseEx1:
  private def getXmlString(filename: String): String =
    Using(Source.fromFile(filename)) {
      source => {
        val buffer = StringBuilder()
        var start = false
        source.getLines().foreach(line =>
          if start then buffer.append(line)
          else  start = line.startsWith("<body")
          if start then buffer.append(line)
        )
// todo: URL encoded to decode
        URLDecoder.decode(buffer.toString(), "utf-8")
      }
    }match
      case Success(xmlString) => xmlString
      case Failure(exception) =>
        exception.printStackTrace()
        throw exception

  private def test1():Unit=
    val xmlAsString = getXmlString("src/test/resources/test1.html")
    try
      val body = XML.loadString(xmlAsString)
      println(s"body.length=${body.length}")
    catch
      case exception: Exception => exception.printStackTrace()

  def main(args: Array[String]): Unit =
    test1()
/*
    val xmlAsString = "<a>123</a>"
    try
      val ttt = XML.loadString(xmlAsString)
      println(ttt)

    catch
      case exception: Exception => exception.printStackTrace()
*/
