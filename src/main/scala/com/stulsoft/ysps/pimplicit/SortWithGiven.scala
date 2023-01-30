/*
 * Copyright (c) 2023. StulSoft
 */

package com.stulsoft.ysps.pimplicit

import com.typesafe.scalalogging.StrictLogging

/**
 * See [[https://blog.rockthejvm.com/scala-3-given-using/ Given and Using Clauses in Scala 3]]
 */
object SortWithGiven extends StrictLogging:
  case class Person(surname: String, name: String, age: Int)

  given personOrdering: Ordering[Person] with {
    override def compare(x: Person, y: Person): Int =
      x.surname.compareTo(y.surname)
  }

  private def listPeople(persons: Seq[Person])(using ordering: Ordering[Person]) =
    persons.sorted(ordering).foreach(println)

  private def test1() =
    logger.info("==>test1")
    val persons = Seq(Person("yyy", "sss", 15), Person("aaa", "bbb", 17))
    println("Original list:")
    persons.foreach(println)

    println("")
    println("Sorted list:")
    listPeople(persons)

  def main(args: Array[String]) =
    logger.info("==>main")
    test1()
end SortWithGiven

