/*
 * Copyright (c) 2023. StulSoft
 */

package com.stulsoft.ysps.collection

import com.typesafe.scalalogging.StrictLogging

object ScanEx1 extends StrictLogging:
  private def scan1(): Unit =
    logger.info("==>scan1")
    val initialCollection = Seq(1, 2, 3, 4, 5)
    val scannedResult = initialCollection.scan(1)(_ + _)
    logger.info("Initial collection: {}", initialCollection)
    logger.info("Scanned result: {}", scannedResult)

  private def scan2(): Unit =
    logger.info("==>scan2")
    val initialCollection = Seq(1, 2, 3, 4, 5)
    val scannedResult = initialCollection.scanLeft(1)(_ + _)
    logger.info("Initial collection: {}", initialCollection)
    logger.info("Scanned result: {}", scannedResult)

  private def scan3(): Unit =
    logger.info("==>scan3")
    val initialCollection = Seq(1, 2, 3, 4, 5)
    val scannedResult = initialCollection.scanLeft(1)((p1,p2) => {
      logger.info("p1={}, p2={}", p1, p2)
      p1 * p2
    })
    logger.info("Initial collection: {}", initialCollection)
    logger.info("Scanned result: {}", scannedResult)

  def main(args: Array[String]): Unit =
    logger.info("==>main")
    scan1()
    scan2()
    scan3()
