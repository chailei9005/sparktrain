package com.chailei.day04

import scala.io.Source

object FileApp extends App {



  // currying 颗粒化
  def sum(a:Int)(b:Int) = {
    a + b
  }
  println(sum(2)(3))

  def readFile(name:String): Unit ={
    val file = Source.fromFile(name)

    for(line <- file.getLines()){
      println(line)
    }
  }

  readFile("F:\\chailei\\test.txt")

// 重点掌握  获取接口信息
  def readURL(name:String): Unit ={
    val line = Source.fromURL(name)
    for(content <- line.getLines()){
      println(content)
    }
  }

  readURL("http://www.baidu.com")

}
