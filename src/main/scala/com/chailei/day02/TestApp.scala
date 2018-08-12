package com.chailei.day02

object TestApp {


  def main(args: Array[String]): Unit = {

    def add(a:Int,b:Int) : Int = {

      a + b
    }
    println(add(1,2))

    def eat()={
      println("eat big data")
    }
    eat()
    eat

    println(1 to 10)

    for(value <- 1 to 10 if value % 2 == 0){
      println(value)
    }


    Array("spark","hadoop","hbase").foreach(println)


    // 默认参数
    def loadSparkConf(filename:String = "spark-default.conf")={
      println(filename)
    }

    loadSparkConf("chailei")
    loadSparkConf()

    def teacher(linux:String ,name:String)={
      println(linux)
      println(name)
    }

    teacher("hadoop","chailei")

    teacher(linux = "bigdata",name = "baixue")

    teacher(name = "chailei",linux = "shuxue")


    def addSum(a:Int*):Int = {
      var result = 0

      for(value <- a){
        result += value
      }
      result
    }

    println(addSum(1,2,3,4,5))


    println(addSum(1.to(10):_*))

    def printTeacher(teachers:String*): Unit ={
      for(teacher <- teachers){
        println(teacher)
      }
    }

    printTeacher(Array("chailei","baixue"):_*)

 }
}
