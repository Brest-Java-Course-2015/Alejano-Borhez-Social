# Alejano-Borhez-Social
This project represents administration tools for a simple social network.
You can manage a list of users and also a friendship between users.
Web-application has a user-friendly web-interface.

To install this application proceed several simply steps:

1. Download a repository with project to your local machine 
   (I suppose that you already have Apache Tomcat Server installed)
2. Cd to the root directory of a project: cd /../../Alejano-Borhez-Social-master
3. Prompt maven install command: mvn clean install
4. Cd to the web-application folder: cd social-web/target
5. Copy .WAR file to the CATALINA_HOME/webapps: cd social-web-1.0-SNAPSHOT.war /../../apache-tomcat/webapps
6. Restart your tomcat server
7. Access the project by URL: localhost:port/social-web-1.0-SNAPSHOT
8. Alternatively you may use a web-interface of your tomcat server: localhost:port/manager --> deploy by choosing a .WAR file

Other ways to run application:
1. Alternatively you may run an application on a jetty-server: cd social-web --> mvn jetty:run
2. After that an application will be available at: localhost:8081/web/
3. Deploy rest-client to your server cd social-rest/ --> mvn clean install --> deploy
4. Change rest.prefix in social-app/src/main/resources/social-app.properties file to a root URL of rest-client, e.g. http://localhost:8080/social-rest-1.0-SNAPSHOT/
5. Deploy app-client to your server cd social-app/ --> mvn clean install --> deploy
6. Acces your application by URL, e.g. http://localhost:8080/social-app-1.0-SNAPSHOT/
11. Enjoy! And leave a feedback to alexander.borohov17@gmail.com
