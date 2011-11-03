organization := "$package$"

name := "$name$"

version := "$version$"

seq(sbtappengine.Plugin.webSettings:  _*)

libraryDependencies ++= Seq(
  "net.databinder" %% "unfiltered-filter" % "$unfiltered_version$",
  "net.databinder" %% "unfiltered-spec" % "$unfiltered_version$" % "test",
  "com.google.appengine" % "appengine-java-sdk" % "$gae_version$",
  "com.google.appengine" % "appengine-api-1.0-sdk" % "$gae_version$",
  "com.google.appengine" % "appengine-jsr107cache" % "$gae_version$",
  "com.google.appengine" % "appengine-api-labs" % "$gae_version$",
  "net.sf.jsr107cache" % "jsr107cache" % "1.1",
  "com.google.appengine" % "appengine-tools-sdk" % "$gae_version$",
  "com.googlecode.objectify" % "objectify" % "$objectify_version$",
  "javax.persistence" % "persistence-api" % "1.0"
) ++ Seq( // local testing
  "javax.servlet" % "servlet-api" % "2.3" % "provided",
  "org.eclipse.jetty" % "jetty-webapp" % "7.4.5.v20110725" % "jetty"
)

resolvers ++= Seq(
 "jboss" at  "https://repository.jboss.org/nexus/content/groups/public/",
 "objectify-appengine" at "http://objectify-appengine.googlecode.com/svn/maven"
) 