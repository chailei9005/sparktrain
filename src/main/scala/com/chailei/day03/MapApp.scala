package com.chailei.day03

import scala.collection.mutable

object MapApp extends App {

  println("lei")

  // map 底层是 hashset
  val  a = Map("chailei" -> 13,"baixue" -> 22) // 不可修改

  val c = mutable.HashMap("chailei" -> 33,"baixue" -> 44)


  c.foreach(println)

  println(a("chailei"))

  // ************
  println(a.getOrElse("chailei1",null))


  for((key,value) <- c){
    println(key + "  " + value)
  }

  private val set: collection.Set[String] = c.keySet
  private val values: Iterable[Int] = c.values
//  while(values.iterator.hasNext){
//    println(values.iterator.next())
//  }
}
