package com.yinma.myakka.http

import akka.actor.ActorSystem
import akka.http.scaladsl.Http
import akka.http.scaladsl.model._
import akka.http.scaladsl.server.Directives._
import akka.stream.ActorMaterializer

import scala.io.StdIn

object WebServer {
  def main(args: Array[String]): Unit = {
    implicit val system = ActorSystem("yinma-my-akka-http-demo")
    implicit val materializer = ActorMaterializer()
    implicit val executionContext = system.dispatcher

    val route =
      path("hello") {
        get {
          complete(HttpEntity(ContentTypes.`application/json`,s"""{"a":"b"}"""))
        }
      }
    val bindingFuture = Http().bindAndHandle(route, "localhost", 1118)

    println(s"Server online at http://localhost:1118/\nPress RETURN to stop...")

    StdIn.readLine()

    bindingFuture
      .flatMap(_.unbind())
      .onComplete(_ => system.terminate())
  }

}
