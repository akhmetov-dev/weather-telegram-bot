#!/bin/bash

docker build -t postgres .

docker image ls -a

docker run --name postgres -p 5432:5432 -e POSTGRES_PASSWORD=66xLyOMyf7Jr -d postgres

docker container ls -a
