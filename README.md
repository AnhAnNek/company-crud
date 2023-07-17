## **Company CRUD API**
This API service provides data for the Company Management application.

### Sections
- [Clone repository](#clone-repository)
- [Access Path (URL)](#access-path-url)
- [Run with docker](#run-with-docker)
- [Debug](#debug)
- [Documentation](#documentation)

## **Clone repository**
```terminal
git clone https://github.com/AnhAnNek/company-crud.git
```

## **[Access Path (URL)](http://localhost:8000/)**

## **Technical**
1. Tools: IntelliJ IDE, Docker, MySQL Workbench.
2. SQL: MySql.
3. Framework: spring boot.
4. Concepts: JPA, MVC, SOLID, DI, Spring Security.

## **Run With Docker**

### To Run
```
docker-compose up --build --force-recreate
```
###### *To stop*
```
Ctrl + C
```

#### Remove container without deleting MySQL data
```
docker-compose down
```

## **Debug**
### Setup

*Step 1: Click "Edit Configurations"*

![Edit Configurations](images/edit-configurations.png)

*Step 2: Click "+" -> "Remote JVM Debug"*

![Remote Debug](images/add-remote-debug.png)

*Step 3:*

![Config Remote Debug](images/config-remote-debug.png)

1. Set Name: remote-debugging (or any name)
2. Set Host: localhost
3. Set Port: 5005
4. Click "Ok"

### Perform debugging on the running app

![Run Remote Debug](images/run-remote-debug.png)

Set a breakpoint and click <1> to start debugging

## **Documentations**
...coming soon...
