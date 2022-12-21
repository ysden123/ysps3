/*
 * Copyright (c) 2022. StulSoft
 */

package com.stulsoft.ysps.oslib

import os.Path
import os.PathChunk.StringPathChunk

object SkipDirBuilder:
  private val skipDirs = List(".git", ".bsp", ".idea", "logs", "target", """project\project""", """project\target""")

  def buildSkipDirs(wd: Path): Seq[Path] =
    skipDirs.map(sd => wd / StringPathChunk(sd))

