# Project 3

Project 3 has a goal to create a library management system that can be accessible by all member or users of the e-library. This system includes :
o    A web site designed with responsive web design (RWD). The user can perform different things such as :

    Find different works and their available copies ,borrow different books,search books by author’s name, check their borrowing status and period, extend their borrowing period and return borrowed books


o    A batch that is scheduled to run and send automatically email. This email will be sent to all users who have not returned their borrowed books. 


## Technologies

Technologies used in general to develop this application are :

•   Apache maven 3

•   Apache Tomcat 9

•   Apache Server

•   MySQL 8.0.13

•   JPA

•   Spring Core Framework 

•   Spring Data 

•   Spring MVC 

• 	Quartz Scheduler


## Maven project into multiple modules


•    library-batch       :containing batch to send automatically email

•    library-business    :containing services / business logic

•    library-consumer    :containing repository to manage the database

•    library-model       :containing different entities

•    library-webapp      :containing 2 different projects: 
		o	Presentation project: view and controller (Spring MVC)
		o	Web service project: Expose APIs for business logic

## Configuration and Deployment

### 1. Database MySQL(8.0.13)

```
-Install MySQL
```
```
-Execute the script library-database-and-user.sql at the server (you can use phpmyadmin or mysql workbench) to create user and database.

```

### 2. Resources images, css and js

```
- Install and start Apache Server Local
```
```
- Download  the resources folder to get all images, css and js from https://github.com/movitarac/project3_resource   
```
```
- Put the ‘resources’ folder in Apache server - Document Root, this folder contains 2 folders, ‘assets’ for images and ‘style’ for css + js. To call an image, for example, we enter the url ‘ http://localhost:80/resources/assets/1.jpeg’ . 
This url is one of an attribute called ‘imageUrl’ in ‘Work’ table.
```

### 3. Deployment of presentation project and web services project from a war file
```
- You need the Tomcat installed in your machine. Let the default port to 8080
```
```
- Download from OC the file library-webapp.war and library-webservice.war. 
```
```
- Put them to the directory <YOUR_TOMCAT_DIRECTORY>/webapps
```
```
- Start your tomcat
```
```
- Go to your database citylibrary and execute the script library-data-test.sql
```
```
- Access to the app: http://localhost:8080/library-webapp
```
```
- Access to the webservice wsdl http://localhost:8080/library-webservice/ws/workWs
```
```
- Use the following user informations to login:
username georgelulu / password 1234lulu

```

### 4. In IDE (Intellij or Eclipse)

- Download sources from github (zip is better): 
```
https://github.com/movitarac/project3_monica
```
- Unzip your download project3_monica-master

- Import the project project3_monica-master/library in your chosen IDE (Intellij or Eclipse) as a Maven Project

-   Build the parent project (maven install)
```
mvn clean install (on parent project -> library)
```

-  To run on embedded server in Intellij: 
```
Run – Edit Configurations – click + – Tomcat Server Local – Deployment – click + Artifact library-webapp-war – write /library-webapp in Application context – Apply OK – Run
```

o   To run on embedded server  in Eclipse, 
```
Run on server - Select Tomcat v9.0 Server- Click next - Add library-webapp - Click finish - Run the server
```
```
In http://localhost:8080/library-webapp the application will appear (same url for both IDE)
```

### 5. Batch 

•	In Linux and MacOs

```
i.	Put the jar file library-batch-1.0-SNAPSHOT-jar-with-dependencies.jar and script shell at the $HOME (example /Users/<currentusername>) 
```
```
ii.	Run the send.sh file in terminal ./send.sh
```

•	In Windows

```
i.	Put the jar file library-batch-1.0-SNAPSHOT-jar-with-dependencies.jar at the %homepath% (example \Users\<currentusername>)
```
```
ii.	Run the send.bat 
```

•	In general we can launch the jar by executing 
```
java -jar library-batch-1.0-SNAPSHOT-jar-with-dependencies.jar 
```


## Application web
A member is inherited a user. 

An e-library has several different works, while for each work, it has different copies that can be borrowed by a member. 

A borrowing relates between a book (or a copy) and a member. 

A borrowing contains only a book.

## Batch

For this part, the application calls a client of a webservice to get all unreturned books (book’s availability = false) or all borrowing with status ‘ongoing’ and ‘extended’. 

From then, it compares the return date and today. 

If the return date is after today, the application gathers members’ information and send them a reminding email related to their borrowing period. 

It is scheduled to be automatically launch every 5 seconds (only for presentation/test).

## Web service

Inside library-webapp, there is a package corresponding to webservice (SOAP webservice). 


The webservice is connected to database and constructed with bottom up method. 


All the web methods found in this package call all methods found in library-business. 


It means the application web does not directly call the library-business.


WSDL files can be accessed after deploying the library-webapp.war in Tomcat http://localhost:8080/library-webservice/ws/workWs
