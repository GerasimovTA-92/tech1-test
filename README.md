# **tech1-test**

## **Contents**
1. [Task](#Task)
2. [Features](#Features)
3. [Project structure](#Project-structure)
4. [Technologies](#Technologies)
5. [How to run project](#How-to-run-project)
____

## **Task**

Create a WEB application that allow to perform operations(Create) and read(Read)
with entities User and Article. I also wrote tests for the repository layer for the User

[:arrow_up:Contents](#Contents)
____

## **Features**

* create User
* create Article
* display all Users who are older than a certain value
* display all users from articles in which the color is a certain value from enum {BLUE, WHITE, RED, BLACK, GREEN}
* display a unique name from Users who have more than 3 articles

[:arrow_up:Contents](#Contents)
____

## **Project structure**

### Project built on 3-tier architecture:
1. Data access layer (DAO).
2. Application layer (service).
3. Presentation layer (controllers).

Entities relation: Many-to-one relationship between Article User

[:arrow_up:Contents](#Contents)
____

## **Technologies**
* Java 8
* Spring Boot
* Spring Data 
* Apache Maven
* H2 DB

[:arrow_up:Contents](#Contents)
____

## **How to run project**

### Tools to run project:
* IntelliJ Idea Ultimate

### How to run
1. Clone this project
2. To test the functionality you can use the collection in [Postman](src/main/resources/tech1.postman_collection.json)

[:arrow_up:Contents](#Contents)
____
