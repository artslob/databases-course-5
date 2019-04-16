FROM ubuntu:18.04

RUN apt-get update && apt-get install -y postgresql-client mysql-client iputils-ping gnupg2 locales vim && \
    rm -rf /var/lib/apt/lists/* && localedef -i en_US -c -f UTF-8 -A /usr/share/locale/locale.alias en_US.UTF-8

ENV LANG en_US.utf8

# add mongo repo
RUN apt-key adv --keyserver hkp://keyserver.ubuntu.com:80 --recv 9DA31620334BD75D9DCB49F368818C72E52529D4 && \
    echo "deb [ arch=amd64 ] http://repo.mongodb.org/apt/ubuntu bionic/mongodb-org/4.0 multiverse" | tee /etc/apt/sources.list.d/mongodb-org-4.0.list

RUN apt-get update && apt-get install -y mongodb-org-shell

RUN echo 'alias psql="psql -U postgres -h pg"' >> ~/.bashrc

WORKDIR /workdir

COPY ./default_command.sh .

CMD ["/bin/bash", "default_command.sh"]
