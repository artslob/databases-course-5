# databases

Dependencies:
- docker
- docker-compose
- Oracle Database 18c Express Edition for Linux x64 (see below)

## Execution
- Default

    Run all containers:  
    ```bash
    docker-compose up --build
    ```  
    This command will start up all databases containers and then run script
    `admin/defaut_command.sh` to check a connection (sanity check).  
    As it takes time for databases to start, first attempts to check connection
    will fail.

    Then:  
    ```bash
    # <ctrl+C>
    docker-compose down
    ```

- Run admin interactively:

    ```bash
    docker-compose build
    docker-compose run --rm admin bash
    # inside admin container:
    psql -c "SELECT * FROM raiting;"  # psql - alias for 'psql -U postgres -h pg'
    # to exit container:
    exit  # or <ctrl+D>
    docker-compose down
    ```

## Oracle
Build image with name `oracle-xe:18c` because its required for `oracle/Dockerfile`.
Follow any of these instructions:
- [github.com/fuzziebrain/docker-oracle-xe](https://github.com/fuzziebrain/docker-oracle-xe) (Recommended)

    You need to
    [download](https://www.oracle.com/technetwork/database/database-technologies/express-edition/downloads/index.html)
    oracle installer: `oracle-database-xe-18c-1.0-1.x86_64.rpm`.

- [official docs](https://github.com/oracle/docker-images/tree/master/OracleDatabase/SingleInstance)

    This method requires `.zip` installer.
