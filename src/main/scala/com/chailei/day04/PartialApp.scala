package com.chailei.day04

object PartialApp {

  def main(args: Array[String]): Unit = {

    def sayChineseName:PartialFunction[String,String] = {

      case "A" => "nibi"
      case "B" => "haikeyi"
      case _ => "couhuo"
    }

    println(sayChineseName("B"))

  }
}
