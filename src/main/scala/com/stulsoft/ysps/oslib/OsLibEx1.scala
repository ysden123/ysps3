/*
 * Copyright (c) 2022. StulSoft
 */

package com.stulsoft.ysps.oslib

import com.stulsoft.ysps.oslib.SkipDirBuilder.buildSkipDirs
import com.typesafe.scalalogging.StrictLogging
import os.Path
import os.PathChunk.StringPathChunk

/**
 * Playing with os-lib framework.
 *
 * See [[https://github.com/com-lihaoyi/os-lib/#getting-started]]
 */
object OsLibEx1 extends StrictLogging:
  def pwdEx01(): Unit =
    logger.info("==>pwdEx01")
    val pwd = os.pwd
    logger.info("pwd Path = {}", pwd)

    val wd = os.pwd / "my-test-folder"
    logger.info("wd Path = {}", wd)

  /**
   * Find the largest three files in the given folder tree
   */
  def findLargestFiles(): Unit =
    logger.info("==>findLargestFiles")
    val wd = os.pwd
    val largestThree = os.walk(wd)
      .filter(os.isFile(_, followLinks = false))
      .map(x => os.size(x) -> x).sortBy(-_._1)
      .take(3)
    logger.info("largestThree: {}", largestThree)

  def walkWithFilter(): Unit =
    logger.info("==>walkWithFilter")
    val wd = os.pwd
    logger.info(s"walk on $wd")

    logger.info("Directories inside src:")
    os.walk(wd / "src",
      skip = p => p.toIO.isFile
    ).foreach(p => logger.info("{}", p))

    val skipDirectories = buildSkipDirs(wd)
    logger.info("Directories without {}:", skipDirectories)
    os.walk(wd,
      skip = p => p.toIO.isFile || skipDirectories.contains(p)
    ).foreach(p => logger.info("{}", p))

  def selectFilesNotIncludedInAList(): Unit =
    logger.info("==>selectFilesNotIncludedInAList")

    val wd = os.pwd
    logger.info(s"(1) walk on $wd")
    val skipDirectories = buildSkipDirs(wd)
    var count = 0
    os.walk(wd)
      .filter(p => p.toIO.isFile && !skipDirectories.exists(skipPath => p.startsWith(skipPath)))
      .foreach(p =>
        logger.info("{}", p)
        count += 1
      )
    logger.info("Found {} files", count)

    logger.info(s"(2) walk on $wd")
    var dirCount = 0
    var fileCount = 0
    count = 0
    os.walk(wd, skip = p => skipDirectories.exists(skipPath => p.startsWith(skipPath)))
      .map(p =>
        if p.toIO.isDirectory then dirCount += 1
        p
      )
      .filter(p => p.toIO.isFile)
      .foreach(p =>
        logger.info("{}", p)
        count += 1
        fileCount += 1
      )
    logger.info("Found {} files in {} directories.", fileCount, dirCount)

end OsLibEx1

@main
def runOsLibEx1(): Unit =
  OsLibEx1.pwdEx01()
  OsLibEx1.findLargestFiles()
  OsLibEx1.walkWithFilter()
  OsLibEx1.selectFilesNotIncludedInAList()
