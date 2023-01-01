/*
 * Copyright (c) 2023. StulSoft
 */

package com.stulsoft.ysps.ptry

import com.typesafe.scalalogging.StrictLogging

import scala.util.{Failure, Success, Try}

object TryEx1 extends StrictLogging:
  private def try1(i: Int): Try[Int] =
    if i > 0 then Success(i * 123) else Failure(new RuntimeException("Non acceptable value"))

  private def try2(i: Int): Option[Int] =
    try1(i).toOption

  private def try3(i:Int): Either[Throwable, Int] =
    try1(i).toEither

  private def test1():Unit =
    logger.info("==>test1")
    try1(123) match
      case Success(result) => logger.info("try1(123) = {}", result)
      case Failure(exception) => logger.error(s"try1(123) = {}", exception.getMessage)

    try1(-123) match
      case Success(result) => logger.info("try1(-123) = {}", result)
      case Failure(exception) => logger.error(s"try1(-123) = {}", exception.getMessage)

  private def test2():Unit =
    logger.info("==>test2")
    try2(123) match
      case Some(result) => logger.info("try2(123) = {}", result)
      case None => logger.error(s"try2(123) = {}", "Not exists")

    try2(-123) match
      case Some(result) => logger.info("try2(-123) = {}", result)
      case None => logger.error(s"try2(-123) = {}", "Not exists")

  private def test3(): Unit =
    logger.info("==>test3")
    try3(123) match
      case Left(exception: Throwable) => logger.error(exception.getMessage, exception)
      case Right(result) => logger.info("try3(123) = {}", result)

    try3(-123) match
      case Left(exception: Throwable) => logger.error("try3(-123): " + exception.getMessage, exception)
      case Right(result) => logger.info("try3(-123) = {}", result)

  def main(args: Array[String]): Unit =
    test1()
    test2()
    test3()


