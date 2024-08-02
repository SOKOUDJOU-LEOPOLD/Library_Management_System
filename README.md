# Library_Management_System
Welcome to the online Library Management System! This application is designed to streamline library operations, providing features for catalog management, user accounts, lending services, and more. Built with Java, Spring Boot, and Spring REST, it offers a robust and scalable solution for managing library resources efficiently.

![library system](https://github.com/user-attachments/assets/fb9d3b17-7ede-41ed-ab92-cc1e2e7f2b3f)

# Table of Contents
Features
Installation
API Endpoints
Usage
Contributing
License

# Features
Book Cataloging: Add, update, and delete books with ease.
User Management: Manage user accounts and profiles.
Lending Services: Track and manage book loans and returns.
Search and Filter: Easily search and filter books and users.
RESTful API: Integrate with external applications using the REST API.

# Installation
To install and run the Library Management System locally, follow these steps:

## Clone the repository:

bash
Copy code
git clone https://github.com/yourusername/library-management-system.git
Navigate to the project directory:

bash
Copy code
cd library-management-system
Build the project using Maven:

bash
Copy code
mvn clean install
Run the application:

bash
Copy code
mvn spring-boot:run
Access the application:

Open your web browser and go to http://localhost:8080.

# API Endpoints

The application provides a RESTful API for managing library resources. Here are some key endpoints:

## Authors:

GET /api/authors: Retrieve the list of authors whose books are registered and stored in the library.

GET /api/authors/{id}/items: Retrieve items of authors by author's id.

PUT /api/authors/{id}: Update author Information.

DELETE /api/authors/{id}: Delete author by id.

## Items: an item can be a Book, CD/DVD, Magazins, Articles.

GET /api/items: Get the list of Items.

POST /api/items: Add items.

GET /api//items/{id}: Get a item from its id.

PUT /api/items/{id}: Update an Item Information.

DELETE /api/items/{id}: Delete item by id.

## Subscribers/USers:

GET /api/subscibers: Retrieve a list of all users.

POST /api/subscribers: Add a new user.

PUT /api/subscribers/{id}: Update user details.

DELETE /api/subscribers/{id}: Delete a user.

## Lending:

GET /api/borrows: Retrieve a list of borrowed items.

POST /api/borrows: Lend an item to a user.

POST /api/borrows/return/{id}: Return a borrowed item.

GET /api/borrows/{id}/fee: Check the fee for borrowing an item.

GET /api/subscribers/{subId}/borrows: Searching for user's borrowings not yet returned.

GET /api/borrows/not-returned: searching for all borrowings not returned.

## Domains:

GET /api/domains: Get The list of all different domains present.

POST /api/domains: Add a new domain to the database.

GET /api/domains/{id}: Get a domain from its id.

GET /api/domains/dom/{domCode}: Get a domain from its Code.

PUT /api/domains/{id}: Update a domain Information.

DELETE /api/domains/{id}: Deleting a domain By id.

DELETE /api//domains/dom/{domCode}: Deleting a domain By Code.

## Libraries:

GET /api/libraries: Get The list of all different Libraries present.

POST /api/libraries: Add Library.

GET /api/libraries/{id}:  Get a Library from its id.

GET /api/libraries/lib/{libCode}: Get a Library from its Code.

PUT /api/libraries/{id}: Update a Library Info.

DELETE /api//libraries/{id}: Deleting a library By Id.

DELETE /api/libraries/lib/{libCode}: Deleting a library By Code.


## Registration:

GET /api/registrations: Get registrations.

## Shelf:

GET /api/shelfs:  Get the list of shelfs.

POST /api/shelfs: Add a new Shelf.

GET /api/shelfs/{id}: Get a shelf by id.

PUT /api/shelfs/{id}: Update a shelf.

DELETE /api/shelfs/{id}: Delete shelf by code. 


# Usage
Add Books: Use the web interface or API to add new books to the catalog.
Manage Users: Create and manage user accounts.
Lend Books: Record book loans and track due dates.
Return Books: Process book returns and update inventory.

# Contributing
We welcome contributions to the Library Management System project! If you'd like to contribute, please follow these steps:

Fork the repository.
Create a new branch for your feature or bug fix.
Commit your changes and push the branch to your fork.
Submit a pull request with a description of your changes.

# License
This project is licensed under the MIT License. See the LICENSE file for more information.
