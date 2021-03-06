name := "gbin"

version := "1.0-SNAPSHOT"

libraryDependencies ++= Seq(
  javaJdbc,
  javaEbean,
  cache,
  "postgresql" % "postgresql" % "9.1-901-1.jdbc4",
  "org.webjars" %% "webjars-play" % "2.2.0",
  "org.webjars" % "bootstrap" % "3.0.2",
  "com.fasterxml.jackson.datatype" % "jackson-datatype-joda" % "2.2.2",
  "com.google.guava" % "guava" % "15.0"
)



play.Project.playJavaSettings
