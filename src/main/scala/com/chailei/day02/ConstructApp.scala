package com.chailei.day02

// 构造函数
object ConstructApp {

  def main(args: Array[String]): Unit = {

//    val girl = new Girl("cindy",18)
//    println("name = " + girl.name + ",age = " + girl.age )
//    girl.love()

    val girl = new Girl("cindy",18,"1333333333")
    println("name = " + girl.name + ",age = " + girl.age + " " + girl.phone)

//    var s :String= _


    val litGirl = new LitGirl("baixue",10,"bigdata")

    println("name = " + litGirl.name + ",age = " + litGirl.age + " " + litGirl.major)

    println(litGirl)
  }



}

// 主构造函数
// 构造器中的属性和类中定义的属性（非private的）
// 都直接能够当做对象的属性来使用
class Girl(val name:String,val age:Int){
  println("girl enter")

  val  address = "shanghai"
  def love()={
    println( name + " love " + "xx")
  }
  println("girl leave")

  var phone = ""

  // 附属构造函数

  // 第一行 必须调用主构造器和附属构造器
  def this(name :String , age :Int, phone :String){
    this(name,age)
    this.phone = phone
  }
}

class LitGirl(name:String,age:Int,val major:String) extends Girl(name,age){

  println("LitGirl enter")


  override def toString: String = " chai lei ni hao "
  println("LitGirl leave")
}
