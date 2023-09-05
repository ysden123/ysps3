/*
 * Copyright (c) 2023. StulSoft
 */

package com.stulsoft.ysps.psort

object SortGeneric01:
  private def sort1[T: Numeric](collection: Seq[T]): Seq[T] =
    collection.sorted

  private def sort2[T: Ordering](collection: Seq[T]): Seq[T] =
    collection.sorted

  private def test1(): Unit =
    println("==>test1")
    val unsortedCollection = Seq(2, 1, 3)
    val sortedCollection = sort1(unsortedCollection)
    println(s"unsorted: $unsortedCollection")
    println(s"sorted: $sortedCollection")

  private def test2(): Unit =
    println("==>test2")
    val unsortedCollection = Seq(2, 1, 3)
    val sortedCollection = sort2(unsortedCollection)
    println(s"unsorted: $unsortedCollection")
    println(s"sorted: $sortedCollection")

  private def test3(): Unit =
    println("==>test3")
    val unsortedCollection = Seq("two", "one", "three")
    val sortedCollection = sort2(unsortedCollection)
    println(s"unsorted: $unsortedCollection")
    println(s"sorted: $sortedCollection")

  private def test4(): Unit =
    println("==>test4")
    val unsortedCollection = Seq((1, "two", 3), (2, "two", 1), (3, "two", 2))
    val sortedCollection = unsortedCollection.sortBy(d => d._3)

    println(s"unsorted: $unsortedCollection")
    println(s"sorted: $sortedCollection")

  def main(args: Array[String]): Unit =
    println("==>main")
    test1()
    test2()
    test3()
    test4()
