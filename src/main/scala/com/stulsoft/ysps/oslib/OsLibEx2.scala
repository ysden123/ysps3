package com.stulsoft.ysps.oslib

import os.Path
import os.PathChunk.StringPathChunk

import java.nio.file.Paths

class OsLibEx2:
  def concat(root: Path, suffix: String): Path =
    root / StringPathChunk(suffix)

@main
def runOsLibEx2(): Unit =
  val osLibEx2 = new OsLibEx2
  var result = osLibEx2.concat(os.pwd, "test")
  println(result)

  result = osLibEx2.concat(os.pwd, """test\test""")
  println(result)
