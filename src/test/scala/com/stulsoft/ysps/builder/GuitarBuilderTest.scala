/*
 * Copyright (c) 2023. StulSoft
 */

package com.stulsoft.ysps.builder

import org.scalatest.flatspec.AnyFlatSpec

class GuitarBuilderTest extends AnyFlatSpec:
  "GuitarBuilder" should "create new instance with default values" in {
    val expectedGuitar = Guitar()
    val actualGuitar = GuitarBuilder().build()
    assertResult(expectedGuitar)(actualGuitar)
  }
