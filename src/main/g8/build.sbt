organization := "$package$"

name := "$app_name$"

version := "$app_version$"

seq(sbtappengine.Plugin.webSettings:  _*)

libraryDependencies ++= Seq(
  "net.databinder" %% "unfiltered-filter" % "$unfiltered_version$",
  "net.databinder" %% "unfiltered-spec" % "$unfiltered_version$" % "test"
) ++ Seq( // local testing
  "javax.servlet" % "servlet-api" % "2.3" % "provided",
  "org.eclipse.jetty" % "jetty-webapp" % "7.4.5.v20110725" % "jetty"
)

resolvers ++= Seq(
 "jboss" at  "https://repository.jboss.org/nexus/content/groups/public/"
) 