/*
 * Copyright (c) 2023. StulSoft
 */

package com.stulsoft.ysps.pimplicit

object ImplicitConversion:
  given Conversion[Int, Second] = Second(_)
