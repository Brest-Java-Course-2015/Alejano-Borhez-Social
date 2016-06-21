FROM tomcat:8
COPY /target/social-rest-1.0-SNAPSHOT.war /usr/local/tomcat/webapps/rest.war
RUN apt-get update && apt-get install -y nano \
vim \
curl
EXPOSE 8080