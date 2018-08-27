package com.xxh

import akka.actor.{Actor, Status}
import akka.event.Logging

import scala.collection.mutable.HashMap
import scala.com.xxh.messages.{GetRequest, SetRequest}

/**
  * Created by xxh on 18-8-27.
  */
class AkkaDB extends Actor {
  val map = new HashMap[String,String]

  val log = Logging(context.system,this)
  override def receive: Receive = {
    case SetRequest(key,value) => {
      log.info("received SetRequest - key;{} value: {}",key,value)
      map.put(key,value)
    }
    case GetRequest(key) => {
      log.info("received GetRequest - key:{}",key)
      val response: Option[String] = map.get(key)
      response match {
        case Some(x) => sender() ! x
        case None =>  sender() ! Status.Failure(new ClassNotFoundException())
      }
    }
    case o =>
      log.info("received unknown message:{}",o)
      Status.Failure(new ClassNotFoundException)
  }
}
