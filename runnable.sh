#!/usr/bin/env bash

# Hope your Docker Engine already installed ))

docker network create socialserver
docker rm -f app rest
docker run -d --net=socialserver --name=rest alexanderborohov/socialrest:1.0
docker run -d --net=socialserver --name=app -p 8080:8080 alexanderborohov/socialapp:1.0