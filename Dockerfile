FROM tomcat:8-jdk11

RUN mvn clean package

COPY target/alura-forum-0.0.1-SNAPSHOT.war webapps/ROOT.war
