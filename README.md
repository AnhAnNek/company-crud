## **Company CRUD API**
This API service provides data for the Company Management application.

## **Run With Docker**
*Setup*
```
docker pull mysql:latest
```

To run
```
docker-compose up --build
```

To stop
```
Ctrl + C
```

Remove container without deleting MySQL data
```
docker-compose down
```

To apply change

*Step 1:*
```
docker-compose build
```

*Step 2:*
```
docker-compose up --force-recreate
```

## **Information of deployment**
``` properties
spring_profiles_active=prod
PROD_DB_HOST=containers-us-west-71.railway.app
PROD_DB_PORT=7719
PROD_DB_NAME=railway
PROD_DB_PASSWORD=k857JrmNJzUfhFKbXsUq
PROD_DB_USERNAME=root
```
