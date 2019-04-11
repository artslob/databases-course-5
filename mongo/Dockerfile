FROM mongo:4.0.8-xenial

ENV entrypoint /docker-entrypoint-initdb.d/

RUN mkdir -p ${entrypoint}

COPY init/*.js ${entrypoint}
