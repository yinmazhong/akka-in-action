
name := "akka-db-client"

organization := "com.yinma"

version := "1.0-SNAPSHOT"

scalaVersion := "2.12.1"

libraryDependencies += "yinma" %% "akka-db" % "1.0-SNAPSHOT"

// https://mvnrepository.com/artifact/com.typesafe.akka/akka-testkit
libraryDependencies += "com.typesafe.akka" %% "akka-testkit" % "2.5.15" % Test
// https://mvnrepository.com/artifact/org.scalatest/scalatest
libraryDependencies += "org.scalatest" %% "scalatest" % "3.2.0-SNAP10" % Test

// https://mvnrepository.com/artifact/org.scalacheck/scalacheck
libraryDependencies += "org.scalacheck" %% "scalacheck" % "1.14.0" % Test

mappings in (Compile, packageBin) ~= { _.filterNot { case (_, name) =>
  Seq("application.conf").contains(name)
}}


/*
enablePlugins(JavaServerAppPackaging)

mainClass in Compile := Some("cn.epoque.shoes.aip.ml.platform.rest.WebServer")
//mainClass in Compile := Some("cn.epoque.shoes.aip.ml.platform.dimensional.Root")
//mainClass in Compile := Some("epoque.bigdata.footinfo.loader.WebServerHttps")

mappings in Universal ++= {
  // optional example illustrating how to copy additional directory
  directory("scripts") ++
    // copy configuration files to config directory
    contentOf("src/main/resources").toMap.mapValues("config/" + _)
}

// add 'config' directory first in the classpath of the start script,

// an alternative is to set the config file locations via CLI parameters
// when starting the application
scriptClasspath := Seq("../config/") ++ scriptClasspath.value

licenses := Seq(("CC0", url("http://creativecommons.org/publicdomain/zero/1.0")))*/
