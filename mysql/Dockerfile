FROM mysql:8

ENV entrypoint /docker-entrypoint-initdb.d/

RUN mkdir -p ${entrypoint}

COPY init/*.sql ${entrypoint}
