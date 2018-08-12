package com.chailei.day04

object WordCountApp {


  def main(args: Array[String]): Unit = {


    val list = List("spark,hadoop","hadoop,bigdata",
      "spark,hive","hbase,spark","hive,oozie")

    list.flatMap(x => x.split(","))//.foreach(println)
      .map(value => (value,1))
      .groupBy(value => value._1)
      .map(x => (x._1,x._2.size))
      .foreach(println)





  }
}
