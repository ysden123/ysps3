/*
 * Copyright (c) 2022. StulSoft
 */

package com.stulsoft.ysps.concurrent

import com.typesafe.scalalogging.StrictLogging

import java.util.concurrent.{Executors, ThreadPoolExecutor}
import scala.concurrent.{Await, ExecutionContext, Future, Promise}
import scala.concurrent.duration.*

object ConcurrentEx05 extends StrictLogging:
  private lazy val threadPoolExecutor =  Executors.newFixedThreadPool(1)
  given executionContext: scala.concurrent.ExecutionContext  = ExecutionContext.fromExecutor(threadPoolExecutor)

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

    val result = Await.result(longProcess(), 3.seconds)
    logger.info("result={}", result)
    threadPoolExecutor.shutdown()
