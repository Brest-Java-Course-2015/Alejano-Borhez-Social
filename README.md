# Alejano-Borhez-Social
This project represents administration tools for a simple social network.
You can manage a list of users and also a friendship between users.
Web-application has a user-friendly web-interface.

Part I.
For testing purposes use Docker.
1. Install it from here: https://docs.docker.com/engine/installation/
2. To run:
     2.1. Run runnable.sh from your terminal (first give permissions to run the script "chmod 755 runnable.sh")
     2.2. Access WebApp via "http://localhost:8080/social" (make sure your local port 8080 is available)
3. To stop:
     3.1. Run stoppable.sh from your terminal (first give permissions to run the script "chmod 755 stoppable.sh")

Part II.
For standalone application use.
To install this application proceed several simply steps:

1. Download a repository with project to your local machine 
   (I suppose that you already have Apache Tomcat Server installed)
2. Cd to the root directory of a project: cd /../../Alejano-Borhez-Social-master
3. Prompt maven install command: mvn clean install
4. After all tests successfully passed browse to the rest-service folder: cd social-rest/target
5. Copy .WAR file to the CATALINA_HOME/webapps: cd social-rest-1.0-SNAPSHOT.war /../../apache-tomcat/webapps
6. Restart your tomcat server
7. Change rest.prefix in social-app/src/main/resources/social-app.properties file to a root URL of rest-client, e.g. http://localhost:8080/social-rest-1.0-SNAPSHOT/ (depends on your tomcat properties)
8. Browse to social-app, run mvn install
9. Deploy app-client to your server cd social-app/ --> mvn clean install --> deploy
10. Access your application by URL, e.g. http://localhost:8080/social-app-1.0-SNAPSHOT/
11. Enjoy! And leave a feedback to alexander.borohov17@gmail.com
