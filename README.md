# Welcome to Endpoint REST API

We proudly announce to you our new API that enables you to do lots of things.
##### Features
  - Register yourself
  - Validate if account is registered
  - Create machines
  - Modify machines info (only some info, not everything)
  - List all cloud machines (Yes, you are able to see other users machines)
  - Delete machines
  - Turn machines of/off

All our API are calls need authorization, except for user registering.
And though you are able to see others machines info, only the owner of the machine is able to modify it. And by the way **WE DO NOT SUPPORT HTTPS**.

# Set up system environment
Here is a list of programs to have installed:
  - Java 8
  - Maven 4.11

After you have installed these, you will need to add their executables to your **PATH** environment, in order to be able to run them from the command line.

# Running the system
### Clone IT!
Seriously, the first step to run our system is to clone it from the git repository.
### Setting database config
You will first need to define a place to the database (we use an embedded database called **HSQLDB**). From the root directory of our project, open file ```src/main/resources/application.properties``` and edit the following line ```spring.datasource.url=jdbc:hsqldb:file:/home/vinicius/.hsqldb/teste.db``` where ```/home/vinicius/.hsqldb/teste.db``` should be the path where you want to store the database info. Note that file ```teste.db``` should not be created by you. Our system will take care of it.
### Starting up
Enter in the root directory of our project and type ```./run_backend.sh```. This script will download all dependency that is needed and will also start the system. Note however that this script will only work for **Linux** machines. If you are using **Windows** you will need to type the following command in the root directory ```mvn spring-boot:run```.

# Tests
### Setting database config
From the root directory of our project, open file ```src/test/resources/application.properties``` and edit the following line ```spring.datasource.url=jdbc:hsqldb:file:/home/vinicius/.hsqldb/mockteste.db``` where ```/home/vinicius/.hsqldb/mockteste.db``` should be the path where you want to store the database info. Note that file ```mockteste.db``` should not be created by you. Our system will take care of it.
### Running tests
Enter in the root directory of our project and type ```./run_tests.sh```. This script will download all dependency that is needed and will also run the tests. Note however that this script will only work for **Linux** machines. If you are using **Windows** you will need to type the following command in the root directory ```mvn test```. 
#### ALERT
There are only three tests and one of them is not working. We are investigating the issue meanwhile.

# How do I use it ?
Now that you have everything working, you might be asking yourself how do you use it. Well, since it is a REST API, you might do http calls by using your favorite tool, but that wouldn't be very practical and because of that we created our **FRONTEND MANAGER** which is located [here](https://github.com/lsvinicius/endpoint-client). So clone the project and follow its instructions.
