/*
 * Copyright (c) 2023. StulSoft
 */

package com.stulsoft.ysps.hierarhy

import com.typesafe.scalalogging.StrictLogging

object HierarchyEx2 extends StrictLogging:
  trait Animal:
    def plus(a1: Animal): Animal

  case class Dog(name: String) extends Animal:
    override def plus(a1: Animal): Dog = Dog(name + " " + a1.asInstanceOf[Dog].name)

  case class Cat(name: String) extends Animal:
    override def plus(a1: Animal): Cat = Cat(name + " " + a1.asInstanceOf[Cat].name)

  case class Robot(i:Int) extends Animal:
    override def plus(a1: Animal): Robot = Robot(i + a1.asInstanceOf[Robot].i)


  object AnimalService:
    def combineAnimals(a1: Animal, a2: Animal): Animal =
      a1.plus(a2)

  def test1(): Unit =
    logger.info("==>test1")
    val d1 = Dog("dog 1")
    val d2 = Dog("dog 2")
    val dCombined = AnimalService.combineAnimals(d1, d2)
    logger.info("dCombined: {}", dCombined)

    val c1 = Cat("cat 1")
    val c2 = Cat("cat 2")
    val cCombined = AnimalService.combineAnimals(c1, c2)
    logger.info("cCombined: {}", cCombined)

    val r1 = Robot(1)
    val r2 = Robot(2)
    val rCombined = AnimalService.combineAnimals(r1, r2)
    logger.info("rCombined: {}", rCombined)

    val s1 = "str 1"
    val s2 = "str 2"
  // Compilation error
  // val sCombined = AnimalService.combineAnimals(s1,s2)

  def main(args: Array[String]): Unit =
    logger.info("==>main")
    test1()

end HierarchyEx2

