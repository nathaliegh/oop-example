1. ```shell 
   docker pull mongo:4.0.4
   ```
2. ```shell
   docker run -d -p 27017:27017 --name oop-mongo mongo:4.0.4
   ```
3. ```shell
    docker exec -it oop-mongo bash
   ```
4. ```shell
   mongo
   ```
5. ```shell
   show dbs
   ```
6. ```shell
   use oop 
   ```
7. ```shell
   db.createUser({
        user: "admin",
        pwd: "admin",
        roles: ["dbOwner"]
    })
   ```