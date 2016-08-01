# Alejano-Borhez-Social. Gradle Version
This project represents administration tools for a simple social network.
You can manage a list of users and also a friendship between users.
Web-application has a user-friendly web-interface.

1. Before running this project you should check for system requirements:
* Java RE 7 or later ()
* Gradle 2.14 or later ()
2. Clone this project and run
```sh
$ gradle build
```
3. Running rest-service: 
 Choose an option what database to use: in-memory HSQL, or MySQL.
* To alter options - uncomment/comment required row in web.xml.
* For HSQL - uncomment <param-value>/WEB-INF/social-rest-spring-jpa.xml</param-value>
* For MySQL - uncomment <param-value>/WEB-INF/social-rest-spring-jpa-mysql.xml</param-value>
 Then run following command
```sh
$ cd social-rest
$ gradle jettyRun
```
4. Running web-application:
To run we-app run following command
```sh
$ cd social-app-freemarker
$ gradle jettyRun
```
5. Application would be available at [http://localhost:8082/social-app-freemarker/](http://localhost:8082/social-app-freemarker/) 