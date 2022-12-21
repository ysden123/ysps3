/*
 * Copyright (c) 2022. StulSoft
 */

package com.stulsoft.ysps.oslib

import com.stulsoft.ysps.oslib.PathEx1._
import com.typesafe.scalalogging.StrictLogging
import os.Path
import os.PathChunk.StringPathChunk

object PathEx1 extends StrictLogging:
  def test1(path: Path): Unit =
    logger.info("==>test1")
    logger.info("path: {}", path)
    logger.info("path.baseName: {}", path.baseName)
    logger.info("path.last: {}", path.last)
    logger.info("path.segments.toList.head: {}", path.segments.toList.head)
    logger.info("path.segments.toList.tail: {}", path.segments.toList.tail)

  def buildOutputPath(src:Path, dstDir:Path):Path =
    logger.info("==>buildOutputPath")
    logger.info("src: {}, dstDir: {}", src, dstDir)
    val result = src.segments.toList.tail.map(s => StringPathChunk(s)).foldLeft(dstDir) { (acc, b) => acc / b }
    logger.info("outputPath: {}", result)
    result

end PathEx1

@main
def runPathEx1(): Unit =
  test1(os.pwd / "README.adoc")
  buildOutputPath(os.pwd / "README.adoc", Path("""c:\work\test3"""))


