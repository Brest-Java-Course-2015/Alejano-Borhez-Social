#!/usr/bin/env bash

# Hope your Docker Engine already installed ))

# Removing existing containers
docker rm -f app rest
# Removing existing networks
docker network rm socialserver