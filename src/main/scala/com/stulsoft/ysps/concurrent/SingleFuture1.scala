/*
 * Copyright (c) 2023. StulSoft
 */

package com.stulsoft.ysps.concurrent
import com.typesafe.scalalogging.StrictLogging

import scala.concurrent.{ExecutionContext, Future}
import scala.util.{Failure, Success}

object SingleFuture1 extends StrictLogging:
  def main(args: Array[String]): Unit =
    given ExecutionContext = ExecutionContext.global
    logger.info("==>main")
    Future{
      logger.info("Future started")
      Thread.sleep(500)
      logger.info("Future completed")
    }.onComplete {
      case Failure(exception) => logger.error(exception.getMessage)
      case Success(_) => logger.info("Succeeded")
    }

    Thread.sleep(1000)
