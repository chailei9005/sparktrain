package com.chailei.day03

import java.io.{File, PrintWriter}
import java.util.Date

import org.apache.commons.lang3.time.FastDateFormat

import scala.util.Random

object FileApp {

  def main(args: Array[String]): Unit = {



    val domains = Array("www.baidu.com","www.zhibo8.com","www.ruozedata.com")


    val traffic = 500000 + Random.nextInt(100000)

    val fdf = FastDateFormat.getInstance("yyyy-MM-dd HH:mm:ss")

    val pw = new PrintWriter(new File("output"))

    for(i <- 1 to 500000){

      println(domains(Random.nextInt(3)) + "\t" +
        (500000 + Random.nextInt(200000)) + "\t" +
      fdf.format(new Date().getTime - Random.nextInt(30*24*60*60)*1000))

      pw.println(domains(Random.nextInt(3)) + "\t" +
        (500000 + Random.nextInt(200000)) + "\t" +
        fdf.format(new Date().getTime - Random.nextInt(30*24*60*60)*1000))
    }

    pw.close()

  }

}
