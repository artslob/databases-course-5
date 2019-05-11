#!/usr/bin/env bash

: "${workdir:=/workdir}"

sql_name="insert"

echo "@${workdir}/${sql_name}.sql" | ${ORACLE_HOME}/bin/sqlplus -S ifmo/ifmo@localhost/XE
