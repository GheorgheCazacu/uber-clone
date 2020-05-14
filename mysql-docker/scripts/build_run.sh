#!/usr/bin/env sh

docker rm mysql-uber-clone
docker build -t mysql-uber:1.0 ../

docker run --publish 3306:3306 --detach --name mysql-uber-clone mysql-uber:1.0
#--network uber-network
