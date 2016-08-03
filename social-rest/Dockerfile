FROM tomcat:8-jre8
RUN apt-get update && apt-get install -y nano \
vim \
curl

COPY social-rest/build/libs/social-rest-1.0-SNAPSHOT.war /usr/local/tomcat/webapps/rest.war

EXPOSE 8080