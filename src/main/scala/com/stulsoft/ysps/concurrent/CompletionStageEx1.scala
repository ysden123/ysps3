/*
 * Copyright (c) 2023. StulSoft
 */

package com.stulsoft.ysps.concurrent

import com.typesafe.scalalogging.StrictLogging

import java.util.concurrent.{CompletableFuture, CompletionStage}

object CompletionStageEx1 extends StrictLogging:
  case class SomeObject(name:String)

  private def test1():CompletionStage[SomeObject] =
    logger.info("==>test1")
    val result = CompletableFuture[SomeObject]
    result.complete(SomeObject("test"))
    result
  def main(args: Array[String]): Unit =
    logger.info("==>main")

    test1().whenComplete((someObject,_) => logger.info("{}", someObject))
