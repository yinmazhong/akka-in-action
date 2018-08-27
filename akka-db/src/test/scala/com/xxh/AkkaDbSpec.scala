package com.xxh

import akka.actor.ActorSystem
import akka.testkit.TestActorRef
import akka.util.Timeout
import com.xxh.messages.SetRequests
import org.scalatest.{FunSpecLike, Matchers}

import scala.concurrent.duration._

/**
  * Created by xxh on 18-8-27.
  */
class AkkaDbSpec extends FunSpecLike with Matchers{


  implicit val system = ActorSystem()
  implicit val timeout = Timeout(5 seconds)

  describe("akkadb"){
    describe("give SetRequest"){
      it("should place key/value to map"){
        val actorRef = TestActorRef(new AkkaDB)
        actorRef ! SetRequests("xu","xianhong")

        val akkaDb = actorRef.underlyingActor
        akkaDb.map.get("xu") should equal(Some("xianhong"))
      }
    }
  }
}
