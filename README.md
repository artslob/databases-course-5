# databases

Dependencies:
- docker
- docker-compose

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
    docker-compose run --rm admin bash
    # inside admin container:
    psql -U postgres -h pg -c "SELECT * FROM raiting;"
    # to exit container:
    exit  # or <ctrl+D>
    docker-compose down
    ```
