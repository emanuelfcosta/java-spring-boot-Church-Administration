## About

This is a system for managing churches and religious temples. It was developed with Java Spring Boot, React and Mysql.

![List of churches](https://erp.emanuelcosta.com.br/img-sistemas/church-mern-1.png)

![Add Member](https://erp.emanuelcosta.com.br/img-sistemas/church-mern-2.png)

## Run the Project
Frontend:
```
cd frontend
cd church-front-react
npm install
npm run dev 
```

Backend:

1- Update the application.properties file with your database configurations (username, password, and database name). Here is an example:

```
spring.application.name=church
spring.datasource.url=jdbc:mysql://localhost:3306/my_database_name
spring.datasource.username=root
spring.datasource.password=root
spring.jpa.properties.hibernate.dialect= org.hibernate.dialect.MySQLDialect
spring.jpa.hibernate.dll-auto=update
```

2- Create the MySQL database with the same name "my_database_name" you provided in application.properties.

3- Run the ChurchApplication.java file.
