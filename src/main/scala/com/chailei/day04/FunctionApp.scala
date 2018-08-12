package com.chailei.day04

object FunctionApp {

  def main(args: Array[String]): Unit = {


    val l = List(1,2,3,4,5,6,7,8,9,10)

    val m = List(1,2,3,4,5,6)

    //TODO 将集合中的元素乘以2

    l.map((x:Int) => x * 2)

    l.map(x => x * 2)


//    l.map(_*2).foreach(println)

    println(l.reduce((x,y) => x+y))

    println(l.reduce((x,y) => x-y))
    println(l.reduceLeft((x,y) => x-y))

    println(l.reduceRight((x,y) => x-y))

    println(l.foldLeft(10)(_+_))

    println(l.count(_ > 6))

    println(l.zip(m))

    val ll = List(List(1,2),List(3,4))
    ll.flatten.foreach(println)

    val domain = "192.168.3.11:7108"
//    (ip,port) = domain.split(":")

    val b = s"""
            |
            |大数据
            |人工智能
            |$domain
            """.stripMargin

    println(b)
  }

}
