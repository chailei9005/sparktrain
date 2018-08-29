package com.chailei.zuoye

import com.chailei.day14sparkcore.LogUtils
import org.apache.spark.{SparkContext, SparkConf}


/**
  * Created by chailei on 18/8/26.
  */
object ResourceFileTopNApp {


  def main(args: Array[String]) {


    val sparkConf = new SparkConf().setAppName("ResourceFileTopNApp").setMaster("local[2]")

    val sc = new SparkContext(sparkConf)


    val lines = sc.textFile("output.txt")

    // 以资源文件访问次数倒序排序
    lines.map(line => {
      val values = line.split("\t")
      val resourceFile = LogUtils.parseResourceFile(values(4))
      (resourceFile,1)
    }).reduceByKey(_ + _).sortBy(_._2,false).collect().foreach(println)


    sc.stop()




  }

}
