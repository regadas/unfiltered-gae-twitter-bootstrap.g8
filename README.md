A [giter8][g8] template for [Unfiltered][unfiltered] applications on Google App Engine. Includes [Twitter Bootstrap][twitter].

## install

* download google app engine SDK and set APPENGINE_SDK_HOME
* install [giter8][g8]
* using this template
    g8 regadas/unfiltered-gae-twitter-bootstrap
* run
    sbt
    jetty-run
* app engine deploy
    sbt appengine:deploy

## defaults

    description=This template generates a Google App Engine ready Unfiltered project with small template based on Twitter Bootstrap.
    gae_app_id=appengineid
    gae_app_version=1
    package=com.example
    sessions_enabled=false
    name=My App Name
    version=0.1.0-SNAPSHOT
    gae_version=1.5.4
    unfiltered_version=0.5.1
    twitter_bootstrap_version=1.3.0
    objectify_version=3.0

## using

* sbt appengine [plugin]

[plugin-gae]: https://github.com/eed3si9n/sbt-appengine
[g8]: http://github.com/n8han/giter8#readme
[unfiltered]: http://github.com/n8han/unfiltered#readme
[twitter] http://twitter.github.com/bootstrap/
