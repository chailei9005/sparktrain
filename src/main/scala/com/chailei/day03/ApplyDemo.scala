package com.chailei.day03

class ApplyDemo{

  def applyDemoTT()={
    println("applyDemoClass")
  }
  def apply(): ApplyDemo = {
    println("class ApplyDemo invoked...")
    new ApplyDemo()
  }
}

object ApplyDemo {

  println("ApplyDemo object enter")

  // object 的 apply new 一个 class
  def apply(): ApplyDemo = {
    println("object ApplyDemo invoked...")
    new ApplyDemo()
  }

  var count = 0

  def incr():Long = {
    count = count + 1
    count
  }

  def static()={
    println("this is static function....")
  }
  println("ApplyDemo object leave")
}


object ApplyDemoApp{

  def main(args: Array[String]): Unit = {

    // object 直接调用函数，不需要new
    //ApplyDemo.static()

//    for(i <- 1 to 10 by 1){
//      ApplyDemo.incr()
//    }
//    println(ApplyDemo.incr())

//    val a = new ApplyDemo()

//    println(a)
//    a.applyDemo()

    // 其实就是在apply底层给我们new了一个class，
    // 所以我们可以直接调用class的方法

    // 伴生（） 没有new的，其实底层调用的是伴生object里面的apply方法
    val a = ApplyDemo()

//    a.applyDemoTT()

    println(a())

  }
}
