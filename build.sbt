name := "cbidb-public-web"

version := "0.1"

scalaVersion := "2.12.4"

enablePlugins(ScalaJSPlugin)
enablePlugins(ScalaJSBundlerPlugin)

name := "CBI DB Public Web"

// This is an application with a main method
scalaJSUseMainModuleInitializer := true

libraryDependencies += "org.scala-js" %%% "scalajs-dom" % "0.9.2"
libraryDependencies += "fr.hmil" %%% "roshttp" % "2.0.2"

npmDependencies in Compile += "snabbdom" -> "0.7.0"
