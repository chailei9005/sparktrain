package com.chailei.day02

object SimpleClassApp {

  def main(args: Array[String]): Unit = {

    val person = new Person()
//    person.name = "baixue"
//    person.age = 20
//    println(person.eat())

    println(person.name + " " + person.age + " " + person.address)
  }

}

class Person{

  // 占位符 数据类型不可以省略
  var name:String = _

  var age = 10

  //限定了变量的使用范围
  private[chailei] val address = "北京"

  def eat(): String ={
    name + " " + age + " eat "
  }
}
