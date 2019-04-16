FROM mysql:8

ENV entrypoint /docker-entrypoint-initdb.d/

RUN mkdir -p ${entrypoint}

COPY init/*.sql ${entrypoint}

# utf8 support
COPY ./custom.cnf /etc/mysql/conf.d/
RUN chmod 444 /etc/mysql/conf.d/custom.cnf