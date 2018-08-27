package com.xxh.akkadbclient

import akka.actor.ActorSystem
import akka.util.Timeout
import akka.pattern.ask

import scala.com.xxh.messages.{GetRequest, SetRequest}
import scala.concurrent.duration._

/**
  * Created by xxh on 18-8-27.
  */
class DbClient(remoteAddress:String) {
  private implicit val timeout = Timeout(2 seconds)
  private implicit val system = ActorSystem("LocalSystem")
  private val remoteDb = system.actorSelection(s"akka.tcp://akkadb@$remoteAddress/user/akka-db-name")

  def set(key:String,value:String) = {
    remoteDb ? SetRequest(key,value)
  }

  def get(key:String)={
    remoteDb ? GetRequest(key)
  }
}

object DbClientTest{
  def main(args: Array[String]): Unit = {
    new DbClient("127.0.0.1:12552").get("xu")
  }
}
