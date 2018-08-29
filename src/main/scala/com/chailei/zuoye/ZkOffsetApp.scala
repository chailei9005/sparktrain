package com.chailei.zuoye


import java.util

import org.apache.curator.framework.{ CuratorFrameworkFactory}
import org.apache.curator.retry.ExponentialBackoffRetry

import scala.collection.mutable
import scala.collection.mutable.HashMap
import scala.collection.mutable.ArrayBuffer

/**
  * Created by chailei on 18/8/26.
  */
object ZkOffsetApp {

  val zookeeperConnectionString = "biaoyuan01:2181"
  val retryPolicy = new ExponentialBackoffRetry(1000, 3)
  val client = CuratorFrameworkFactory.newClient(zookeeperConnectionString, retryPolicy);
  client.start();

  def main(args: Array[String]) {


    val topic = "bioqas"

    val partitions = 3

    val group_test = "G314"

    val array = ArrayBuffer[OffsetRange]()

    for( partition <- 0 until partitions){

//      println(partition)

      val offsetRange = OffsetRange(topic,partition,0,100)

      array.append(offsetRange)
    }

//    storeOffsets(array,group_test)

    val topicAndPartitions: mutable.HashMap[TopicAndPartition, Long] = obtainOffsets(topic,group_test)

    for((topic,partition) <- topicAndPartitions){
      println("topic : " + topic + "\t" + "partition = " + partition)
    }



    close()

  }

  def close() = {
    client.close()
  }


  def storeOffsets(offsetsRanges:ArrayBuffer[OffsetRange],
                   groupName:String) = {
    // TODO...

    for(value <- 0 until offsetsRanges.size){
      val path: String = s"/test/${groupName}/offsets/${offsetsRanges(value).topic}/partiton/${offsetsRanges(value).partition}"
      client.create()
          .creatingParentsIfNeeded()
        .forPath(path,
        (offsetsRanges(value).fromOffset+","+ offsetsRanges(value).utilOffset).getBytes())

    }
  }

  case class TopicAndPartition(topic:String, partition:Int)

  def obtainOffsets(topic:String,
                    group:String): HashMap[TopicAndPartition, Long] = {
    // TODO...

    val path: String = s"/test/${group}/offsets/${topic}/partiton"

    val dataPath: String = s"/test/${group}/offsets/${topic}/partiton/${}"

    val childPath: util.List[String] = client.getChildren().forPath(path)

    val hashMap = HashMap[TopicAndPartition,Long]()

    for(partition <- 0 until childPath.size()){
      println(childPath.get(partition))
      val dataPath: String = s"/test/${group}/offsets/${topic}/partiton/${childPath.get(partition)}"

      val topicAndPartition = TopicAndPartition(topic,partition)
      hashMap.put(topicAndPartition,partition)

      // 获取topic 下 partition下的 offset
      //      val data: Array[Byte] = client.getData().forPath(dataPath)
      //      val offsetRange = OffsetRange(topic,childPath.get(partition).toInt,
      //        data.toString.split(",")(0).toLong,data.toString.split(",")(1).toLong)

    }

    hashMap


  }

  case class OffsetRange(
                          val topic: String,
                          val partition: Int,
                          val fromOffset: Long,
                          val utilOffset: Long
                        )

}
