package com.chailei.day03

// object 修饰的类不需要new就可以使用
// 相当于静态类

object Timer {

  var count = 0

  def currentCount():Long = {
    count += 1
    count
  }

  def main(args: Array[String]): Unit = {
    println(currentCount())
    println(currentCount())
    println(currentCount())
    println(currentCount())
  }

}
