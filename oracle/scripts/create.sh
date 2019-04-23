#!/usr/bin/env bash

: "${workdir:=/workdir}"

sql_name="create"

echo "@${workdir}/${sql_name}.sql" | ${ORACLE_HOME}/bin/sqlplus sys/Oracle18@localhost/XE as sysdba
