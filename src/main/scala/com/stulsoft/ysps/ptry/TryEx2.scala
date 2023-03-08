/*
 * Copyright (c) 2023. StulSoft
 */

package com.stulsoft.ysps.ptry

import com.stulsoft.ysps.pusing.SomeAutoCloseable
import com.typesafe.scalalogging.StrictLogging

import scala.util.{Failure, Success, Try, Using}

object TryEx2 extends StrictLogging:
  private def someService1[T](arg: Int)(f: Int => T): Try[T] =
    Try {
      f(arg)
    }
  private def someService2[T](arg: Int)(f: Int => T): Try[T] =
    Try{
      Using(new SomeAutoCloseable) { _ =>
        f(arg)
      } match {
        case Success(result) => result
        case _ =>
          throw new RuntimeException("test")
      }
    }

  def test1(): Unit =
    someService1(123)(i => i.toString) match {
      case Success(value) => println(value)
      case Failure(exception) => exception.getMessage
    }

  def test2(): Unit =
    someService2(456)(i => i.toString) match {
      case Success(value) => println(value)
      case Failure(exception) => exception.getMessage
    }

  def main(args: Array[String]): Unit = {
    logger.info("==>main")
    test1()
    test2()
  }
