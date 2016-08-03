# Alejano-Borhez-Social. Gradle Version
This project represents administration tools for a simple social network.
You can manage a list of users and also a friendship between users.
Web-application has a user-friendly web-interface.

1. Before running this project you should check for system requirements:
- [Java RE 8](http://www.oracle.com/technetwork/java/javase/downloads/jre8-downloads-2133155.html) or later
- [Gradle 2.14](https://gradle.org/gradle-download/) or later
- [Docker 1.11](https://docs.docker.com/engine/installation/) or later 

2. Clone this project and run
```sh
$ gradle build
```

3. Run with Docker
```sh
$ sh dockerbuild.sh && sh run.sh
```

4. To stop Docker containers run
```sh
$ sh stop.sh
```

5. Application will be available at [http://localhost:8080/social/](http://localhost:8080/social/) 
