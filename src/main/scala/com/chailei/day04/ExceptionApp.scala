package com.chailei.day04

import java.io.FileNotFoundException

import scala.io.Source

// java.lang.ArithmeticException: / by zero
object ExceptionApp {

  def main(args: Array[String]): Unit = {


  try{
//    val a = 1/0
  val file = Source.fromFile("")
  }catch {
    case e:Exception => println("范围比较大的异常")
    case e:ArithmeticException => throw new RuntimeException("被除数不能为0")
    case e:FileNotFoundException => println("文件不存在")
  }finally{
    println("111")
  }
  //    case e:Exception => println("范围比较大的异常")
  //    case e:ArithmeticException => println("被除数不能为0")
  //    case e:FileNotFoundException => println("文件不存在")
  }
}
