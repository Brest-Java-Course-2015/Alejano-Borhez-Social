FROM tomcat:8
COPY /target/social-app-1.0-SNAPSHOT.war /usr/local/tomcat/webapps/social.war
RUN apt-get update && apt-get install -y nano \
vim \
curl
