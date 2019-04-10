#!/usr/bin/env bash

psql -U postgres -h pg -c "SELECT * FROM rating LIMIT 1;"
