package com.chailei.zuoye

import org.apache.hadoop.mapred.lib.MultipleTextOutputFormat
import org.apache.spark.{SparkContext, SparkConf}

/**
  * Created by chailei on 18/8/28.
  */

class FileMultipleTextOutputFormat extends MultipleTextOutputFormat[Any,Any] {




  override def generateFileNameForKeyValue(key: Any,value: Any,name: String): String ={
    key.asInstanceOf[String]
  }

  override def generateActualValue(key:Any,value: Any): String ={
    println(value)

    val index: Int = value.toString.indexOf("CompactBuffer(")
    println(index)
    value.toString.substring(index + "CompactBuffer(".length,value.toString.length-2).replaceAll(",","\n").replaceAll(" ","")

  }

}
object GroupSaveFileApp {




  def main(args: Array[String]) {

    val sparkConf = new SparkConf().setAppName("ResourceFileTopNApp").setMaster("local[2]")

    val sc = new SparkContext(sparkConf)


    val lines = sc.textFile("/Users/chailei/data/emp.txt")


    lines.map(line => {

      val split: Array[String] = line.split("\t")
      val date = split(4)
      (date.split("-")(0),line)
    }).groupByKey().saveAsHadoopFile("/Users/chailei/project/git/sparktrain/output",
      classOf[String], classOf[String],
      classOf[FileMultipleTextOutputFormat])


    sc.stop()


  }

}
