/*
 * Copyright (c) 2022. StulSoft
 */

package com.stulsoft.ysps.cortege

import com.typesafe.scalalogging.StrictLogging

object CortegeEx1 extends StrictLogging:
  private def test1():Unit =
    logger.info("==>test1")
    val cortege = List((1,"a"), (2, "b"))
    cortege.foreach(c => logger.info("{} - {}", c._1, c._2))
    cortege.foreach(c => logger.info("{}", c))

  private def test2():Unit =
    logger.info("==>test2")
    val cortege = List((1,"a"), (2, "b"))
    logger.info(cortege.reduceLeft((c1,c2) => if c1._1 <= c2._1 then c1 else c2).toString())
    logger.info(cortege.reduceRight((c1,c2) => if c1._1 <= c2._1 then c1 else c2).toString())

  def main(args: Array[String]): Unit =
    test1()
    test2()
