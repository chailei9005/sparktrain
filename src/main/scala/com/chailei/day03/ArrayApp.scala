package com.chailei.day03

import scala.collection.mutable.ArrayBuffer

object ArrayApp {

  def main(args: Array[String]): Unit = {


    val a = new Array[String](5)


    val b = Array("aaa","bbb","ccc")

    var c = Array(1,2,3)

    println(b.mkString(","))

    val dd = ArrayBuffer[String]()
    dd.append("chailei","baixue")

    dd.foreach(println)

    dd += "leileinishihaoren"
    dd ++= Array("chaichai","leilei")

    println(dd.mkString(","))

    dd.flatMap(x => x).foreach(println)

  }

}
