lazy val snippets = (project in file("."))
  .settings(
    organization := "com.github.kondaurovdev",
    scalaVersion := "2.11.8",
    version := "1.0.0-SNAPSHOT",
    libraryDependencies ++= Seq(
      "commons-codec" % "commons-codec" % "1.10",
      "org.specs2" %% "specs2-core" % "3.8.5" % "test"
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
    licenses += ("MIT", url("http://opensource.org/licenses/MIT")),
    pomExtra :=
      <url>https://github.com/kondaurov-scala/snippets</url>
        <scm>
          <url>git@github.com:kondaurov-scala/snippets.git</url>re
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
