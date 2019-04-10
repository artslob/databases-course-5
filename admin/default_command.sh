#!/usr/bin/env bash

# TODO wait for databases to load
psql -U postgres -h pg -c "SELECT * FROM person LIMIT 1;";
#mysql -u root -hmysql uni -e "SELECT * FROM uni.test;"
