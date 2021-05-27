#!/bin/bash

docker container stop telegram_bot_postgres

docker container rm telegram_bot_postgres

docker image rm telegram_bot_postgres postgres:13

docker container ls -a

docker image ls -a
