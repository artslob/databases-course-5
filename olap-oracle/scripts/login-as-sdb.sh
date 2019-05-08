#!/usr/bin/env bash

${ORACLE_HOME}/bin/sqlplus $@ sys/Oracle18@localhost/XE as sysdba
