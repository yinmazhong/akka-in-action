package scala.com.xxh

/**
  * Created by xxh on 18-8-27.
  */
package object messages {
  case class SetRequest(key:String, value:String)
  case class GetRequest(key:String)
  case class KeyNotFoundException(key:String)
}
