package com.stulsoft.ysps.pextension

extension (scfe: SomeClassForExtension)
  def ext1: String = scfe.length.toString + " modified"
