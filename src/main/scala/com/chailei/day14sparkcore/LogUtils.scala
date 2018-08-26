package com.chailei.day14sparkcore

import org.apache.spark.util.LongAccumulator

object LogUtils {

  def parseTraffic(trafficValue: String,right: LongAccumulator,error: LongAccumulator) = {

    var traffic = 0L
    try{
      traffic = trafficValue.trim.toLong  //  这里一定要转换成数值类型
      right.add(1)
    }catch {
      case e : Exception => {
        traffic = 0L
        error.add(1)
      }

    }

    traffic

  }

  def parseResourceFile(file: String): String = {

    val str = file.replaceAll("//","")
    val firstIndex = str.indexOf("/")
    var ss = ""
    if(firstIndex != -1){
      ss = str.substring(firstIndex)
    }
    ss

    val lastIndex = ss.indexOf("?")

    var result = ss
    if(lastIndex != -1){
      result = ss.substring(0,lastIndex)
    }
    result
  }

}
