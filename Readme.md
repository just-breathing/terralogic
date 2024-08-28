## Implementation
- In this assessment 2 microservices are build
- docker is used to containerize postgresql database, Nginx server for reverse proxy and api gateway and 2 spring boot microservices
- authentication and node are 2 micro services
- Authentication micro service : 4  API end points - create user, Login, fetch all users, update username  - all users fetch and updating username end point are authenticated with JWT
 - Nodes : 2 API end points - fetch all nodes, Add node
 
Constraints/ Validations  : 
while creating a user, I am assuming username, Name, Email, password(password to have  at least 1 capital letter, 1 special character, 1 number and length 10) and primary group name are only required fields
while adding a node all null values are validated and special characters (“!@#$%^&*()”) are not allowed. (assuming while adding a node all fields are required and validation to be done to not have any special characters)

## Nginx
- used Nginx as an api gateway with port on 85
- individual microservices are running on port 8080 and 8081
- requests with /user path forwarded to authentication microservice
- requests with /node path forwarded to node microservice

## PostgresSQL

- used PostgresQl image in docker inorder to use a database

## Rest Api Access

### Authentication Micro service
- To create a new user
http://localhost:85/user/auth/create-user 

- to login using already created credentials
http://localhost:85/user/auth/login

- to fetch all users
http://localhost:85/user/all-users

- to update an user name
http://localhost:85/user/update

### Node Micro service

- To create a new node
http://localhost:85/node/create-user

- To fetch all nodes
 http://localhost:85/node/all-nodes

## Execution 
- ``` mvn clean install or mvn install``` to insall dependecies 

## Docker 
- ```mvn package``` to get jar files needed for docker 
[!NOTE] Make sure you have docker installed in your system and ports 85,8080,8081,5234 are free
- to run micro services and test API'S using docker just run
```docker compose up```
- included  postman collection JSON file import it in postman and you can test these apis
- to test authentication microservice with postman i set the dynamic token from login as collection variable in entire authentication sub folder and used this as token in fetch all users and update api end points
- 
## To run micro services with out docker
- configure JDBC connection params in application.properties files 
- change rest api end points respectively i.e ip address and ports
- ```mvn spring-boot:run``` run this to start microservice

