/*
 * Copyright (c) 2022. StulSoft
 */

package com.stulsoft.ysps.pusing

import com.typesafe.scalalogging.{Logger, StrictLogging}

import scala.util.{Failure, Success, Using}
import scala.util.Using.Releasable

class SomeAutoCloseable extends AutoCloseable, StrictLogging:
  val text = "Some text"

  override def close(): Unit =
    logger.info("==>close")

  def builderResult(): String =
    text + " <- it is the result"

@main
def usingSomeAutoCloseable(): Unit =
  val logger = Logger("usingSomeAutoCloseable")
  logger.info("==>usingSomeAutoCloseable")

  Using(new SomeAutoCloseable) { _ => {
    logger.info("Do something")
  }
  }

  Using(new SomeAutoCloseable) { ttt => {
    logger.info("text is {}", ttt.text)
  }
  }

  val aResult = Using(new SomeAutoCloseable) { sa => {
    sa.builderResult()
  }
  } match
    case Success(text) => text
    case Failure(error) => error.getMessage

  logger.info("aResult={}", aResult)

  /*
  May throw uncatched exception
  */
  val aResult2 = Using.resource(new SomeAutoCloseable) { sa => {
    sa.builderResult()
  }
  }
  logger.info("aResult2={}", aResult2)

end usingSomeAutoCloseable



