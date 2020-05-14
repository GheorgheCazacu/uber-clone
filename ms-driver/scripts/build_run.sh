#!/usr/bin/env sh

docker rm uber-ms-driver
docker build -t uber-ms-driver:1.0 ../

docker run --publish 5151:5151 --detach --name uber-ms-driver uber-ms-driver:1.0
