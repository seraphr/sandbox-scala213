val Organization = "jp.seraphr"
val fatalWarning = settingKey[Boolean]("")

ThisBuild / fatalWarning      := false
Global / onChangedBuildSource := ReloadOnSourceChanges

val CommonDependencies = Seq(
  Dependencies.jvm.scalatest  % "test",
  Dependencies.jvm.scalacheck % "test"
)

val CommonSettings = Seq(
  organization := Organization,
  Test / testOptions := Seq(
    Tests.Argument("-oS"),
    Tests.Argument("-l", "org.scalatest.tags.Slow")
  ),
  Compile / doc / scalacOptions ++= Seq("-groups", "-implicits", "-diagrams"),
  scalacOptions ++= {
    val tBase = Seq(
      "-encoding",
      "UTF-8",
      "-feature",
      "-deprecation",
      "-unchecked",
      "-Xlint:_,-missing-interpolator",
      "-Ywarn-dead-code",
      "-Ywarn-unused:patvars"
    )

    val tFatalWarning = if (fatalWarning.value) Seq("-Xfatal-warnings") else Seq()
    tBase ++ tFatalWarning
  },
  javacOptions ++= Seq("-encoding", "UTF-8")
)

// sub projects

lazy val subProject = {
  (project in file("subproject"))
    .settings(CommonSettings)
    .settings(
      libraryDependencies ++= CommonDependencies
    )
}
