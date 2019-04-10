#!/usr/bin/env bash

psql -U postgres -h pg -c "SELECT * FROM student LIMIT 1;"
