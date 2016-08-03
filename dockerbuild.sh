#!/usr/bin/env bash
docker build -t alexanderborohov/socialrest:2.0 -f social-rest/Dockerfile . &&
docker build -t alexanderborohov/socialapp:2.0 -f social-app-freemarker/Dockerfile .