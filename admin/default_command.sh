#!/usr/bin/env bash

# TODO wait for databases to load
while :; do sleep 100; done
#psql -U postgres -h pg -c "SELECT * FROM person LIMIT 1;";
#mysql -u root -hmysql uni -e "SELECT * FROM uni.person;"
#mongo mongo/uni --eval "printjson(db.getCollectionNames())"
