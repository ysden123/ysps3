/*
 * Copyright (c) 2022. StulSoft
 */

package com.stulsoft.ysps.concurrent

import com.typesafe.scalalogging.StrictLogging

import scala.concurrent.{ExecutionContext, Future, Promise}
import scala.util.{Failure, Success}

object ConcurrentEx03 extends StrictLogging:
  given ExecutionContext = ExecutionContext.global
  private def longProcess(): Future[Int] =
    logger.info("==>longProcess")
    val promise = Promise[Int]()
    Future {
      logger.info("Running long process")
      Thread.sleep(1_000)
      promise.success(234)
    }
    logger.info("<==longProcess")
    promise.future

  def main(args: Array[String]): Unit =
    logger.info("==>main")
    longProcess().onComplete {
      case Success(result) => logger.info("result={}", result)
      case Failure(exception) => logger.error(exception.getMessage, exception)
    }

    // Wait until thread finish
    Thread.sleep(1_500)
