#!/usr/bin/env bash

psql -U postgres -h pg -c "SELECT * FROM person LIMIT 1;"
