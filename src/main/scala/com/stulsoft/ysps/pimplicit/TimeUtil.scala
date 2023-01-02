/*
 * Copyright (c) 2023. StulSoft
 */

package com.stulsoft.ysps.pimplicit

object TimeUtil:
  def doSomethingWithProcessingTime(sec: Second): String =
    s"${sec.t} seconds"
