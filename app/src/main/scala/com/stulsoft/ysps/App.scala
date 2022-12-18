/*
 * Copyright (c) 2022. StulSoft
 */

package com.stulsoft.ysps

object App {
  def greeting(): String = "Hello, world!"
}

@main
def appMain():Unit=
  println(App.greeting())
