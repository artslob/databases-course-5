FROM mysql:8

ENV entrypoint /docker-entrypoint-initdb.d/

RUN mkdir -p ${entrypoint}

# TODO utf-8
COPY init/*.sql ${entrypoint}
