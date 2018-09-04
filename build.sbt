
val vcsPath = "https://github.com/kondaurov-scala/snippets"

lazy val snippets = (project in file("."))
  .settings(
    version := "1.1.0",
    akCommonVcsPath := vcsPath,
    name := "snippets",
    libraryDependencies ++= Seq(
      "commons-codec" % "commons-codec" % "1.10",
      "com.github.kondaurovdev" %% "snippets-iface" % "1.0.0",
      "org.specs2" %% "specs2-core" % "3.9.1" % "test"
    )
  )

lazy val iface = (project in file("iface"))
  .settings(
    version := "1.0.0",
    akCommonVcsPath := vcsPath,
    name := "snippets-iface"
  )