<h1 align="center">Blogging API 
</h1>

The BLogging API is a RESTful API designed to facilitate the management of user,post and comments of the blogs posted by user. It provides endpoints for users , posts by users and comments on it

## Prerequisites
* ![MySql](https://img.shields.io/badge/DBMS-MYSQL%205.7%20or%20Higher-red)
 * ![SpringBoot](https://img.shields.io/badge/Framework-SpringBoot-green)
* ![Java](https://img.shields.io/badge/Language-Java%208%20or%20higher-yellow)

## Getting Started
* Clone or download the project from the repository.
* Import the project into your preferred Java Integrated Development Environment (IDE).
* Ensure that the required dependencies are resolved and imported correctly.

## Data flow
 The application is built using the SpringBoot framework and consists of three layers: model, service, and repository.-

* **Controller** - The controller layer handles the HTTP requests, translates the JSON parameter to object, and authenticates the request and transfer it to the business (service) layer. In short, it consists of views i.e., frontend part.
* **Service** -The business layer handles all the business logic. It consists of service classes and uses services provided by data access layers.
* **Repository** - This layer mainatains the h2-database thing on which CRUD operations are performed
* **Model** - This layer consists basically the class level things- the various classes required for the project and these classes consists the attributes to be stored.





## Project Summary
The Blogging Api will allow a user to create its account and post a blog with a comment section on it which is linked with the repository . The user will post and other users who are seeing the post can comment on it .







