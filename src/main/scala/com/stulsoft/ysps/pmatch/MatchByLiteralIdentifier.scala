/*
 * Copyright (c) 2023. StulSoft
 */

package com.stulsoft.ysps.pmatch

import com.typesafe.scalalogging.StrictLogging

/**
 * Playing with literal identifier
 */
object MatchByLiteralIdentifier extends StrictLogging:

  private case class SomeClass(name: String)

  private case class SomeAction(someClass: SomeClass)

  private def test1(): Unit =
    logger.info("==>test1")

    val sc1 = SomeClass("1111")
    val sc2 = SomeClass("2222")
    val sc3 = SomeClass("3333")

    println(`sc1`)
    println(`sc3`)
    println(`sc2`)

    println(s"sc1: ${`sc1`}")
    println(s"sc3: ${`sc3`}")
    println(s"sc2: ${`sc2`}")

  private def test2(): Unit =
    logger.info("==>test2")

    val sc1 = SomeClass("1111")
    val sc2 = SomeClass("2222")
    val sc3 = SomeClass("3333")

    def fTest(sc: SomeClass): Unit =
      sc match
        case `sc1` => println("sc1")
        case `sc2` => println("sc2")
        case `sc3` => println("sc3")

    fTest(sc2)
    fTest(sc3)
    fTest(sc1)

  /**
   * Works correct
   */
  private def test3(): Unit =
    logger.info("==>test3")
    val sc1 = SomeClass("1111")
    val sc2 = SomeClass("2222")
    val sc3 = SomeClass("3333")

    def fTest(someAction: SomeAction): Unit =
      someAction match
        case SomeAction(`sc1`) => println("Action for sc1")
        case SomeAction(`sc2`) => println("Action for sc2")
        case SomeAction(`sc3`) => println("Action for sc3")

    fTest(SomeAction(`sc2`))
    fTest(SomeAction(`sc3`))
    fTest(SomeAction(`sc1`))

  /**
   * Works incorrect
   */
  private def test4(): Unit =
    logger.info("==>test4")
    val sc1 = SomeClass("1111")
    val sc2 = SomeClass("2222")
    val sc3 = SomeClass("3333")

    @annotation.nowarn def fTest(someAction: SomeAction): Unit =
      someAction match
        case SomeAction(sc1) => println("Action for sc1")
        case SomeAction(sc2) => println("Action for sc2")
        case SomeAction(sc3) => println("Action for sc3")

    fTest(SomeAction(`sc2`))
    fTest(SomeAction(sc3))
    fTest(SomeAction(sc1))

  def main(args: Array[String]): Unit =
    logger.info("==>main")
    test1()
    test2()
    test3()
    test4()

