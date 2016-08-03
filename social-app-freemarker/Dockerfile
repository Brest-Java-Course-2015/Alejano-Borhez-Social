FROM tomcat:8-jre8
RUN apt-get update && apt-get install -y nano \
vim \
curl
COPY social-app-freemarker/build/libs/social-app-freemarker-1.0-SNAPSHOT.war /usr/local/tomcat/webapps/social.war
