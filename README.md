# todo-app
Spring boot application for todo app with swagger

\## Requirements

1\. Java - 1.8.x

2\. Maven - 3.x.x

3\. H2 Database

\## Steps to Setup

\*\*1\. Clone the application\*\*

```bash
git clone git@github.com:callicoder/spring-boot-mongodb-angular-todo-app.git
```

\*\*2\. Build and run the backend app using maven\*\*

```bash
cd todo-app
mvn package
java -jar target/todo-app-0.0.1-SNAPSHOT.jar
```

Alternatively, you can run the app without packaging it using -

```bash
mvn spring-boot:run
```

The backend server will start at <http://localhost:8080>
The Swagger UI will start at http://localhost:8080/swagger-ui.htm
The app directory is containing the pre generated jar for easy of deployment and testing.
