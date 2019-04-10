FROM ubuntu:18.04

RUN apt-get update && apt-get install -y postgresql-client mysql-client iputils-ping

RUN echo 'alias psql="psql -U postgres -h pg"' >> ~/.bashrc

WORKDIR /workdir

COPY ./default_command.sh .

CMD ["/bin/bash", "default_command.sh"]
