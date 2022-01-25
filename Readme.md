# Spring Boot
[Spring Initializr](https://start.spring.io/),

Add the following dependencies

1. spring web
2. Dev tool
3. data jpa
4. lombok

## Folders

- controller
-  entity
-  dto
-  exceptions
-  service  -> implementation
- repository

## Reference code Repos-
- [RameshMF/springboot-blog-rest-api: Source code of course - Building Real-Time REST APIs with Spring Boot (github.com)](https://github.com/RameshMF/springboot-blog-rest-api)
- [Learn Spring Boot | Baeldung](https://www.baeldung.com/spring-boot)
- [Maven Repository: Search/Browse/Explore (mvnrepository.com)](https://mvnrepository.com/)

## Application Properties configurations

		spring.datasource.url=jdbc:postgresql://localhost:5432/test_db

		spring.datasource.username=postgres

		spring.datasource.password=123

		#hibernateproperties

		spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect

		#Hibernateddlauto(create,create-drop,validate,update)

		spring.jpa.hibernate.ddl-auto=update
		spring.jpa.show-sql=true  
		spring.jpa.properties.hibernate.format_sql=true