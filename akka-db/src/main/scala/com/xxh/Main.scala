package com.xxh

import akka.actor.{ActorSystem, Props}

/**
  * Created by xxh on 18-8-27.
  */
object Main extends App{

  val system = ActorSystem("akkadb")
  system.actorOf(Props[AkkaDB],name = "akka-db-name")
}
