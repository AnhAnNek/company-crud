# company-crud

## **Run With Docker**
To Run
```
docker-compose up --build
```

To Stop
```
Crl + C
```

To remove container (remove data in mysql)
```
docker-compose down --volumes
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