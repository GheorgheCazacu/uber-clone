#!/usr/bin/env sh

docker rm uber-ms-eureka-server
docker run --publish 8761:8761 --name uber-ms-eureka-server uber-ms-eureka-server:1.0
#--detach
