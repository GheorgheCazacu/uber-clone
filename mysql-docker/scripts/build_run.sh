#!/usr/bin/env sh

docker build -t mysql-uber:1.0 ../

docker rm mysql-uber-clone
docker run --publish 3306:3306 --detach --name mysql-uber-clone mysql-uber:1.0
