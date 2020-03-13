FROM tomcat:8-jdk11

WORKDIR $CATALINA_HOME

ADD target/alura-forum-0.0.1-SNAPSHOT.war webapps/ROOT.war
