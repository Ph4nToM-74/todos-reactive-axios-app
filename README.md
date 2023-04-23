# Todos Application

This *application* is **developed** using:
* *Spring* **R2DBC** & **WebFlux** for *API*;
* **PostgreSQL** for *database*;
* **Maven** for *building*;
* **Axios** for *consuming*;
* **Docker** for *containerization*.

<hr/>

## Requirements

The **stable** releases of the following *technologies* are used:

| Technology  | Version |
| ----------- | ------- |
| JDK         | 17+     |
| Spring Boot | 3.0+    |
| Lombok      | 1.18+   |
| PostgreSQL  | 42+     |
| Maven       | 3.8+    |
| Axios       | 1.3+    |
| Bootstrap   | 4.6+    |
| Docker      | 20+     |

P.S. For *production* purposes, only **Docker** is *sufficient*.

<hr/>

## Development

For **development** purposes, *follow* as below:

### Usage

**Run** the Docker **Container** with this *command*:

>docker run --detach --env POSTGRES_USER=dev-user --env POSTGRES_PASSWORD=dev-pass --env POSTGRES_DB=dev-todos --name dev-pgsql --publish 5432:5432 postgres:15.2-alpine

**Use** the following *properties* for **Spring** in the "*application.properties*" file:

```
spring.r2dbc.url=r2dbc:postgresql://localhost:5432/dev-todos
spring.r2dbc.username=dev-user
spring.r2dbc.password=dev-pass
```

**Run** the "*TodosApplication*" class with this *command*:

>mvn spring-boot:run

Go to this *URL* to **consume** the *API*:

>http://localhost:8080/reactive/todos

**Open** the "*index.html*" file to **test** it.

### Monitoring

**Connect** to the PostgreSQL **DB** at the following *URL*:

>jdbc:postgresql://localhost:5432/dev-todos

... with these **credentials**:

>dev-user:dev-pass

<hr/>

## Production

For **production** purposes, *follow* as below:

### Usage

**Run** the Docker **Compose** with this *command*:

>docker-compose up

Go to this *URL* to **consume** the *API*:

>http://localhost:6969/reactive/todos

**Open** the "*index.html*" file to **check** it.

**Stop** the Docker **Compose** with this *command*:

>docker-compose down

### Monitoring

**Connect** to the PostgreSQL **DB** at the following *URL*:

>jdbc:postgresql://localhost:4242/todos-db


... with these **credentials**:

>root:p4$$w0rd

<hr/>

**Thank** you for *using* it!

<hr/>