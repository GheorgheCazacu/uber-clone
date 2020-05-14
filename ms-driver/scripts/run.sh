#!/usr/bin/env sh

docker rm uber-ms-driver
docker run --publish 5151:5151 --name uber-ms-driver uber-ms-driver:1.0
#--detach
