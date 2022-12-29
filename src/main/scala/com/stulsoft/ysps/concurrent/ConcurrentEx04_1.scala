/*
 * Copyright (c) 2022. StulSoft
 */

package com.stulsoft.ysps.concurrent

import com.typesafe.scalalogging.StrictLogging

import scala.concurrent.{Await, ExecutionContext, Future, Promise}
import scala.concurrent.duration._
import scala.util.{Failure, Success}

object ConcurrentEx04_1 extends StrictLogging:
  given ExecutionContext = ExecutionContext.global

  private def longProcess(): Future[Int] =
    logger.info("==>longProcess")
    def process():Int =
      logger.info("Running long process")
      Thread.sleep(1_000)
      123

    Future(process())

  def main(args: Array[String]): Unit =
    logger.info("==>main")
    val result = Await.result(longProcess(), 3.seconds)
    logger.info("result={}", result)