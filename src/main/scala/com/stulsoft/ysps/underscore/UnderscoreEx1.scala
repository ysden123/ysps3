/*
 * Copyright (c) 2023. StulSoft
 */

package com.stulsoft.ysps.underscore

class ProductRegular:
  private val a = 0
  var b: Int = _

  //  def price(): Int = a
  def price: Int = a
  /*
    def price(i:Int):Unit=
      a = i
  */
end ProductRegular

/**
 * Demonstrates assignment operators (setters overriding)
 * See [[https://www.baeldung.com/scala/underscore#4-assignment-operators-setters-overriding]Assignment Operators (Setters overriding)]]
 */
class Product:
  private var a = 0

  def price: Int = a

  def price_=(i: Int): Unit = {
    require(i > 10)
    a = i
  }
end Product

object UnderscoreEx1:
  def main(args: Array[String]): Unit =
    val productRegular = ProductRegular()
    // Compilation error
    // productRegular.price = 10

    println(s"productRegular.price=${productRegular.price}")
    println(s"productRegular.b=${productRegular.b}")
    productRegular.b = 123
    println(s"productRegular.b=${productRegular.b}")

    val product = Product()
    product.price = 20
    println(s"product.price == 20: ${product.price == 20}")
    try {
      product.price = 7 // Will fail because 7 is not greater than 10
    } catch
      case _: IllegalArgumentException => println(s"product.price != 7: ${product.price != 7}")