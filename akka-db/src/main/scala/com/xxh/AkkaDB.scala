package com.xxh

import akka.actor.Actor
import akka.event.Logging
import com.xxh.messages.SetRequests

import scala.collection.mutable.HashMap

/**
  * Created by xxh on 18-8-27.
  */
class AkkaDB extends Actor {
  val map = new HashMap[String,Object]

  val log = Logging(context.system,this)
  override def receive: Receive = {
    case SetRequests(key,value) => {
      log.info("received SetRequest - key;{} value: {}",key,value)
      map.put(key,value)
    }
    case o => log.info("received unknown message:{}",o)
  }
}
