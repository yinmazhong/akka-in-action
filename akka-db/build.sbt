name := "akka-db"

version := "1.0"

scalaVersion := "2.12.1"

// https://mvnrepository.com/artifact/com.typesafe.akka/akka-actor
libraryDependencies += "com.typesafe.akka" %% "akka-actor" % "2.5.15"
// https://mvnrepository.com/artifact/com.typesafe.akka/akka-testkit
libraryDependencies += "com.typesafe.akka" %% "akka-testkit" % "2.5.15" % Test
// https://mvnrepository.com/artifact/org.scalatest/scalatest
libraryDependencies += "org.scalatest" %% "scalatest" % "3.2.0-SNAP10" % Test

// https://mvnrepository.com/artifact/org.scalacheck/scalacheck
libraryDependencies += "org.scalacheck" %% "scalacheck" % "1.14.0" % Test


        