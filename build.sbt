ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "2.13.13"

lazy val root = (project in file("."))
  .settings(
    name := "final-reality",
    libraryDependencies += "org.scalameta" %% "munit" % "0.7.29" % Test
  )
