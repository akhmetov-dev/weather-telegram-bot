FROM postgres:13

COPY deploy_db.sql /docker-entrypoint-initdb.d/deploy_db.sql
