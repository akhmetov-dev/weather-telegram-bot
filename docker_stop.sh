#!/bin/bash

docker container stop postgres

docker container rm postgres

docker image rm postgres postgres:13

docker container ls -a

docker image ls -a
