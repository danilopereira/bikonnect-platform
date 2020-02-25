# BIKONNECT PLATFORM

 This is the backend side for the bike locker developed to the Bikonnect project. The main responsibility of
 this project is configure and handle any heavy process and data send by each bike locker connected to the platform.
 
## Stack
This project have been built with:
- Java 8
- Spring Boot
- MySQL
- Paho MQTT Library
- JUnit

This project is divided is composite by different maven modules, each one with your designed management. The modules are:
- platform-common
- platform-dao
- platform-database
- platform-locker-microservices
- platform-rider-microservices
- platform-rider-services
- platform-mqtt-subscriber

Let's go deep into each one:

### platform-common
This module is basically a library, responsible to gather everything related with persistence and the DTOs

### platform-dao
On this module you'll find the repositories of the project. Every persistence control should be on here.

### platform-database
An implementation of the Flyway Migration Framework, this module manage the tables on the database.

### platform-locker-microservices
This module put all the controllers and the business logic (as validations and some managements) regarding the *locker*.
Currently is just implemented a GET endpoint to request the last positions of a locker.

### platform-rider-microservices
This is another module of controllers, but this one gather all the *rider* endpoints (basically a CRUD).

### platform-rider-services
This one is a library used by the **platform-rider-microservices** module. It consumes the needed repositories from the **platform-dao** module and manipulate the responses.

### platform-mqtt-subscriber
This part of the project is a command line runner that consumes the mqtt broker configured getting the geo-positions from the locker and persisting them on the database.
