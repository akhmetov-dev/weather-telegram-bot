#!/bin/bash

docker build -t telegram_bot_postgres:latest .

docker image ls -a

docker run --name telegram_bot_postgres -p 5432:5432 -e POSTGRES_PASSWORD=66xLyOMyf7Jr -d telegram_bot_postgres

docker container ls -a
