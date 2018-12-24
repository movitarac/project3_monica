Introduction
1.    General Context
Project 3 has a goal to create a library management system that can be accessible by all member or users of the e-library. This system includes :
o    A web site designed with responsive web design (RWD). The user can perform different things such as :

    Find different works and their available copies

    Borrow different books

    Search books by author’s name

    Check their borrowing status and period

    Extend their borrowing period

    Return borrowed books


o    A batch that is scheduled to run and send automatically email. This email will be sent to all users who have not returned their borrowed books. Everybody in general can browse book, find works, use the ‘find a book by author’ search part and access home page. 
To borrow a book and access the profile page, a registered member must log in.

After member login successfully, they can access the profile page, consult their borrowing list, extend and or return their loan, also make a new loan.
A member can only extend once their borrowing period and the borrowing period will be extended for another 4weeks. 

2.    Technologies

Technologies used in general to develop this application are :

•    Apache maven 3.6.0

•    Apache Tomcat 9

•    MySQL 8.0.13

•    Spring Framework 5.1.2 RELEASE

•    Spring Data 2.1.2 RELEASE

•    Spring MVC 5.1.2 RELEASE

•    Hibernate 5.1.0.Final


By using Apache Maven, we decided to divide our Maven project into multiple modules

•    library-batch        : containing batch to send automatically email

•    library-business    : containing services / business logic

•    library-consumer    : containing repository to connect to database

•    library-model        : containing different entities

•    library-webapp        : containing the view and controllers

•    library-webservice    : containing webservice (in construction)


Configuration and Deployment

1.    Database MySQL(8.0.13)

    Create a database called ‘citylibrary’

    Create 6 tables (information can be found in library.sql file)

    Enter the data for all the tables using information from library.sql 


2.    In IDE (Intellij or Eclipse)

    Change the configuration in library-webapp module by going to library-servlet.xml and in bean section ‘dataSource, change :

o     Values for property name “username” by your database username and for “password” by your database password

o    ?serverTimezone=UTC can be added after value for property name ‘url’
“jdbc:mysql://localhost:3306/citylibrary?serverTimezone=UTC” in case of problem with timezone.


3.    Web App
https://github.com/movitarac/project3_resource   -> to download all resources (images, css and js)

    For the image, css and js files, we put them in Apache server, inside a folder called ‘resources’, we add 2 folders, ‘assets’ for images and ‘style’ for css + js. To call an image, for example, we enter the url ‘ http://localhost:80/resources/assets/1.jpeg’ . This url is one of an attribute called ‘imageUrl’ in ‘Work’ table.



    For the moment the web service is still on progress. To make the web application part works, the web application is momentarily connected to the database (later version, only the web service will be connected to the database). The library-webapp.war can be deployed in Apache Tomcat 9:

o    Using IDE, in Intellij, 
Run – Edit Configurations – click + – Tomcat Server Local – Deployment – click + Artifact library-webapp-war – delete all text found in Application context – Apply OK – Run


In http://localhost:8080/ the application will appear


Application web
1.    Class diagram

A member is inherited a user. An e-library has several different works, while for each work, it has different copies that can be borrowed by a member. A borrowing relates between a book (or a copy) and a member. A borrowing contains only a book.

Batch

Batch is still on progress.

Web service
This part is still on progress and construction.
