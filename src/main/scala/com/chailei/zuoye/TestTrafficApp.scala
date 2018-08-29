package com.chailei.zuoye

import com.chailei.day14sparkcore.LogUtils
import org.apache.spark.{SparkContext, SparkConf}

/**
  * Created by chailei on 18/8/26.
  */
object TestTrafficApp {

  def main(args: Array[String]) {


    val sparkConf = new SparkConf().setAppName("ResourceFileTopNApp").setMaster("local[2]")

    val sc = new SparkContext(sparkConf)


    val lines = sc.textFile("/Users/chailei/data/user_traffic.txt")

    // 以资源文件访问次数倒序排序
    lines.map(line => {
      val values = line.split("\t")
      (values(0),values(1),values(2))
    }).collect().foreach(println)


    sc.stop()

  }

}
