/*
 * Copyright (c) 2023. StulSoft
 */

package com.stulsoft.ysps.pimplicit

import com.typesafe.scalalogging.StrictLogging

object AdderWithGiven extends StrictLogging:
  trait Adder[T]:
    def addTwo(t1: T, t2: T): T

  case class Person(n: String)

  case class Robot(i: Int)

  case class ForWithoutGiven(p: Int)

  given addingPerson: Adder[Person] with {
    override def addTwo(t1: Person, t2: Person): Person = Person(t1.n + " - " + t2.n)
  }

  given addingRobot: Adder[Robot] with {
    override def addTwo(t1: Robot, t2: Robot): Robot = Robot(t1.i + t2.i)
  }

  private def addPeople(person1: Person, person2: Person)(using adder: Adder[Person]): Person =
    adder.addTwo(person1, person2)

  private def addRobot(robot1: Robot, robot2: Robot)(using adder: Adder[Robot]): Robot =
    adder.addTwo(robot1, robot2)

  private def addForWithoutGiven(f1: ForWithoutGiven, f2: ForWithoutGiven)(using adder: Adder[ForWithoutGiven]): ForWithoutGiven =
    adder.addTwo(f1, f2)

  private def test(): Unit =
    logger.info("==>test")
    val summaryPeople = addPeople(Person("n1"), Person("n2"))
    println(s"summaryPeople: $summaryPeople")

    val summaryRobot = addRobot(Robot(1), Robot(2))
    println(s"summaryRobot: $summaryRobot")

  private def test1(): Unit =
    logger.info("==>test1")
    val f1 = ForWithoutGiven(1)
    val f2 = ForWithoutGiven(2)

/*
    val err = addForWithoutGiven(f1, f2) // Compilation error: No given instance of type Adder[ForWithoutGiven]
*/

  def main(args: Array[String]): Unit =
    logger.info("==>main")
    test()
    test1()