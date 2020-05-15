#!/usr/bin/env sh

docker rm uber-ms-eureka-server
docker build -t uber-ms-eureka-server:1.0 ../
