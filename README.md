# online-todo-list
 Application to manage to do list for logged in users

<hr>

# About this project

- Predefined users can (admin/admin, user/user) can login to the system
- Logged in users can add/edit/modify/delete TODO tasks 
- Application will be automatically logged out if inactive for 60 seconds


Tech Stack:
-----------

- Java 8
- JSP
- Springboot 2.5.6
- H2 DB
- Apache Maven 3.6.3


<hr>

# Architecture
Application is developed following the spring boot mvc architecture. User interface will communicate to the backend controller based on user actions which in turn call the 
services and then repository which connects to H2 in-memory database to persist the data  

<hr>

# How to run this project locally

- Use STS or Command Line
- import the project
- run the command  `mvn clean install` 
- run the command  `mvn spring-boot:run` 
- services will be up in below port
	
	http://localhost:8085
	
- As the application is built in spring boot, inbuilt tomcat container is attached hence no need to deploy it separately. It is possible to deploy in a seperate tomcat server as well but I haven't tested and verified it.
war file is attached inside war folder

#Functionalities Implemented
-----------------------------
- login & logout
- user can create tasks
- user can modify, list and delete her/his own tasks
- all the changes are persisted to the H2 database
- each tasks displays the date of last update and description
- basic error handling
- unit test partially implemented (not all the cases)


#Functionalities Pending
-----------------------------
- option for user to check/uncheck items from list 
- edit fuctionality is not correctly populating status and date field values
- date formatting
- form validations
- security implementation such as password encryption and so on
- unit test completion

 
# ROADMAP
  -----------
  - Security implementation
  - Exception Handling
  - Logging
  - UI styling
  - search based on various parameters
  - display the record count
  - pagination 
  - user management
