#!/usr/bin/env bash

: "${workdir:=/workdir}"

sql_name="user"

echo "@${workdir}/${sql_name}.sql" | ${ORACLE_HOME}/bin/sqlplus -S sys/Oracle18@localhost/XE as sysdba
