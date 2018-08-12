package com.chailei.day03

object CaseClassApp {

  def main(args: Array[String]): Unit = {

    val dog = Dog("baixue")

    println(dog.name + " is a dog ")

  }

}
// case class 的用途
// 1) case class 不用new就可以直接用
// 2) 模式匹配
case class Dog(name:String)
