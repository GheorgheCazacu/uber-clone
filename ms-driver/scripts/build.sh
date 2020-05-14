#!/usr/bin/env sh

docker rm uber-ms-driver
docker build -t uber-ms-driver:1.0 ../
