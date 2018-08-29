package com.chailei.day03

import java.io.{File, PrintWriter}
import java.util.Date

import org.apache.commons.lang3.time.FastDateFormat

import scala.util.Random

object FileApp {

  def main(args: Array[String]): Unit = {



    val domains = Array("www.baidu.com","www.zhibo8.com","www.ruozedata.com")

    val ips = Array("223.104.18.110","113.101.75.194","27.17.127.135")

    val resource = Array("/chaileibaixue.mp5?xxxxsss&eeee","/leileixuexie?djfkdjfk&jdkfjd","/bigdata?ruozeshuju"
      ,"/ruozedata/bigdata/leilei/chai?id=110","/ruozedata1/bigdata/leilei/chai?id=110","/ruozedata2/bigdata/leilei/chai?id=110")

    val traffic = 500000 + Random.nextInt(100000)

    val fdf = FastDateFormat.getInstance("yyyy-MM-dd HH:mm:ss")

    val pw = new PrintWriter(new File("output.txt"))

    for(i <- 1 to 500){

//      println(domains(Random.nextInt(3)) + "\t" +
//        (500000 + Random.nextInt(200000)) + "\t" +
//      fdf.format(new Date().getTime - Random.nextInt(30*24*60*60)*1000))

      if(i % 10 == 0){
        val domain = domains(Random.nextInt(3))
        pw.println(domain + "\t" +
          "-" + "\t" +
          fdf.format(new Date().getTime - Random.nextInt(30*24*60*60)*1000) + "\t" +
          ips(Random.nextInt(3)) + "\t" + "http://" + domain + resource(Random.nextInt(6)))
      }else{
        val domain = domains(Random.nextInt(3))
        pw.println(domain + "\t" +
          (500000 + Random.nextInt(200000)) + "\t" +
          fdf.format(new Date().getTime - Random.nextInt(30*24*60*60)*1000) + "\t" +
          ips(Random.nextInt(3)) + "\t" + "http://" +domain + resource(Random.nextInt(6)))
      }

    }

    pw.close()

  }

}
