package com.stulsoft.ysps.concurrent

import com.typesafe.scalalogging.Logger

import java.util.concurrent.{Executors, ThreadPoolExecutor}
import scala.concurrent.{Await, ExecutionContext, Future}
import scala.util.{Failure, Success}

private lazy val logger: Logger = Logger("ConcurrentEx01")
private lazy val executorService = Executors.newFixedThreadPool(1)
private lazy val executionContext = ExecutionContext.fromExecutor(executorService)

private def func(): Future[Int] = Future {
  logger.info("==>func")
  123
}(executionContext)

@main
def runConcurrentEx01(): Unit =
  val result = func()
  logger.info("{}", result)

  result.onComplete {
    case Success(i) =>
      logger.info("i={}", i)
      executorService.shutdown()
    case Failure(exception) =>
      logger.error(exception.getMessage, exception)
      executorService.shutdown()
  }(executionContext)