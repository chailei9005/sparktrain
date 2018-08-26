package com.chailei.day14sparkcore

import org.apache.spark.{SparkConf, SparkContext}

object LogApp {


  def main(args: Array[String]): Unit = {

    val sparkConf = new SparkConf().setAppName("LogApp").setMaster("local[2]")

    val sparkContext = new SparkContext(sparkConf)


    val lines = sparkContext.textFile("F:\\chailei\\project\\sparktrain\\output")

    println(lines.count())

    val countAccuAccumulator = sparkContext.longAccumulator("count")

    val errorAccuAccumulator = sparkContext.longAccumulator("errorCount")
    //TODO 需求一 每个域名的流量

    // 1. 获取域名 和 流量字段  输出 log => (a,b)
    // 2. 按照域名分组求和

    lines.map(line => {
      val values = line.split("\t")

      val traffic = LogUtils.parseTraffic(values(1), countAccuAccumulator, errorAccuAccumulator)

      (values(0),traffic)
    }).reduceByKey(_ + _).foreach(println)


    println("rigthCount = "  + countAccuAccumulator.value + "\t" +
    "errorCount = " + errorAccuAccumulator.value)

    //TODO 求每个省份的访问次数TopN

    lines.map(line => {
      val strings = line.split("\t")
      val ip = strings(3)
      (ip,1)
    }).reduceByKey(_ + _).sortBy(ll => {
      ll._2
    },true).take(3).foreach(println)

    lines.map(line => {
      val strings = line.split("\t")
      val ip = strings(3)
      (ip,1)
    }).reduceByKey(_ + _).sortBy(_._2,true).take(3).foreach(println)


    //TODO 每个域名下访问次数最多额资源文件

    // 资源文件： 第一个/后到第一个？之前的内容

//    lines.map(line => {
//      val strings = line.split("\t")
//      val resourceFile = strings(4)
//      val domain = strings(0)
//
//      ((domain,LogUtils.parseResourceFile(resourceFile)),1)
//
//    }).reduceByKey(_ + _).groupBy(_._1._1).mapValues(_.toList.sortBy(_._2).reverse)
//
//      .foreach(println)

//    lines.map(line => {
//      val strings = line.split("\t")
//      val resourceFile = strings(4)
//      val domain = strings(0)
//
//      (domain,(LogUtils.parseResourceFile(resourceFile),1))
//
//    }).groupBy(_._1).foreach(println)


    // TODO 求访问次数最多的资源文件

    sparkContext.stop()

  }
}
