# Spring Boot Elasticsearch Demo

This project shows how to build a Spring Boot application using Elasticsearch for storage and retrieval of data.

## Built With
- Java 17
- Spring Boot 3.1.2
- Spring Data Elasticsearch
- Elasticsearch 7.16.1

## Usage 

The application exposes REST endpoints for CRUD operations on a `Book` entity that is persisted in Elasticsearch.

Some key components:

- Spring Data Elasticsearch - Provides integration with Elasticsearch
- BookRepository - Interface extending ElasticsearchRepository for CRUD ops  
- BookService - Business logic for creating/updating/deleting Books
- BookController - REST controller exposing endpoints

## Running Locally

### Start Elasticsearch

Download and install Elasticsearch locally, then start it:

### Step 1: Pull Elasticsearch Image
```
docker pull docker.elastic.co/elasticsearch/elasticsearch:7.16.1
```
### Step 2: Run Elasticsearch Container
```
docker run -d --name elasticsearch -p 9200:9200 -p 9300:9300 \
-e "discovery.type=single-node" \
docker.elastic.co/elasticsearch/elasticsearch:7.16.1
```
### Step 3: Access Elasticsearch
Access the Elasticsearch REST API at `http://localhost:9200` to interact with Elasticsearch and perform various operations.

### Step 4: Stop and Remove Container
```
docker stop elasticsearch
docker rm elasticsearch
```
Elasticsearch will run on port 9200.

### Build Spring Boot App
```
mvn clean install
```

### Run Spring Boot App

The app will run on port 8080.

## Usage

The REST endpoints support CRUD operations for the `Book` entity:

### Create a Book
```
curl -X POST "http://localhost:8080/books" \
-H "Content-Type: application/json" \
-d '{"title":"New Book","author":"John Doe","description":"A new book"}'
```

### Get a Book by ID
```
curl -X GET "http://localhost:8080/books/{id}"
```
### Update a Book
```
curl -X PUT "http://localhost:8080/books/{id}" \
-H "Content-Type: application/json" \
-d '{"title":"Updated Book","author":"Jane Smith","description":"An updated book"}'
```
### Delete a Book
```
curl -X DELETE "http://localhost:8080/books/{id}"
```

