#!/usr/bin/env bash

# Hope your Docker Engine already installed ))

# Creating docker's network
docker network create socialserver
# Removing existing containers
docker rm -f app rest
# Pulling and running RestFul service (rest) and WebApp (app)
docker run -d --net=socialserver --name=rest alexanderborohov/socialrest:2.0
docker run -d --net=socialserver --name=app -p 8080:8080 alexanderborohov/socialapp:2.0