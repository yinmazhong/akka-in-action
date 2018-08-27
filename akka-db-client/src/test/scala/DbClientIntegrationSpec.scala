import com.xxh.akkadbclient.DbClient
import org.scalatest.{FunSpecLike, Matchers}

import scala.concurrent._

import scala.concurrent.duration._

/**
  * Created by xxh on 18-8-27.
  */
class DbClientIntegrationSpec  extends FunSpecLike with Matchers{
  val client = new DbClient("127.0.0.1:12552")
  describe("DB client"){
    it("should set a value"){
      client.set("123","321")
      val futureResult = client.get("123")
      val result = Await.result(futureResult,10 seconds)
      result should equal("321")
    }
  }
}
