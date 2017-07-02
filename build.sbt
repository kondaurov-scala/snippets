lazy val snippets = (project in file("."))
  .settings(
    scalaVersion := "2.12.2",
    version := "1.0.0",
    organization := "com.github.kondaurovdev",
    libraryDependencies ++= Seq(
      "commons-codec" % "commons-codec" % "1.10",
      "org.specs2" %% "specs2-core" % "3.9.1" % "test"
    ),
    publishTo := {
      if (isSnapshot.value) {
        Some("Sonatype Nexus Repository Manager" at "https://oss.sonatype.org/content/repositories/snapshots/")
      } else {
        publishTo.value
      }
    },
    bintrayRepository := "maven",
    publishArtifact in (Compile, packageDoc) := false,
    bintrayReleaseOnPublish := !isSnapshot.value,
    licenses += ("MIT", url("http://opensource.org/licenses/MIT")),
    credentials ++= Seq(
      Credentials(Path.userHome / ".ivy2" / ".sonatype")
    ),
    publishMavenStyle := true,
    pomExtra :=
      <url>https://github.com/kondaurov-scala/snippets</url>
        <scm>
          <url>git@github.com:kondaurov-scala/snippets.git</url>
          <connection>scm:git:git@github.com:kondaurov-scala/snippets.git</connection>
        </scm>
        <developers>
          <developer>
            <id>kondaurovdev</id>
            <name>Alexander Kondaurov</name>
            <email>kondaurov.dev@gmail.com</email>
          </developer>
        </developers>,
    pomIncludeRepository := { _ => false }
  )