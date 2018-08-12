package com.chailei.day03

import scala.collection.mutable.ListBuffer

object ListApp {

  def main(args: Array[String]): Unit = {


    val listBuffer = ListBuffer[Int]()
    listBuffer +=(1,2,3,4)
    listBuffer ++=List(5,6,7,8)

    listBuffer--=List(1,2,4)
//    listBuffer--=List(3,5,6,7)
    listBuffer.foreach(println)
    println(listBuffer.head)
    println(listBuffer.tail.tail.tail)

    // 变长转定长
    listBuffer.toList

  }

}
