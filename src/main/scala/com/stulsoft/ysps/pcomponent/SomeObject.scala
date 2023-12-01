/*
 * Copyright (c) 2023. StulSoft
 */

package com.stulsoft.ysps.pcomponent

import scala.util.Try

case class SomeObject(text: String)

object SomeObject:
  def fromString(text: String): SomeObject =
    SomeObject("test")

  def fromStringWithTry(text: String): Try[SomeObject] =
    Try {
      SomeObject(text)
    }
