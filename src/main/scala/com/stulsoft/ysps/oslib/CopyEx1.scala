/*
 * Copyright (c) 2022. StulSoft
 */

package com.stulsoft.ysps.oslib

import com.typesafe.scalalogging.StrictLogging
import os.Path
import os.PathChunk.StringPathChunk

import javax.print.attribute.standard.Destination

object CopyEx1 extends StrictLogging:
  def copyOneFile(from: Path, to: Path): Unit =
    logger.info("==>copyOneFile")
    logger.info("Copying from {} to {}", from, to)
    //    from.segments.foreach(println)
    try
      os.remove(to)
      os.copy(from, to, createFolders = true, replaceExisting = true)
    catch
      case exception: Exception => exception.printStackTrace()

  def copyOneFileToDir(from: Path, toDir: Path): Unit =
    logger.info("==>copyOneFileToDir")
    logger.info("Copying from {} to {}", from, toDir)
    try
      os.remove(toDir)
      os.copy.into(from, toDir, createFolders = true, replaceExisting = true)
    catch
      case exception: Exception => exception.printStackTrace()

end CopyEx1

@main
def runCopyEx1(): Unit =
  val from = os.pwd / "README.adoc"
  val to = Path("""c:\work\test\README.adoc""")
  CopyEx1.copyOneFile(from, to)

  val toDir = Path("""c:\work\test2""")
  CopyEx1.copyOneFileToDir(from, toDir)
