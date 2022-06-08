# Simple Lobox APIs
Simple lobox API created by spring boot,spring data!

I create a Spring Boot project(Rest APIs) lobox
- Spring-Boot 2.7.0.RELEASE
- Lombok 1.18.8
- JavaSE 11
- Maven 3.3.9

# Dependencies
Open the pom.xml file for spring-aop configuration:

      <parent>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-parent</artifactId>
        <version>2.7.0.RELEASE</version>
        <relativePath/> <!-- lookup parent from repository -->
      </parent>
      
and dpendencies:

       <!-- SPRING -->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>
         <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-jdbc</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-data-jpa</artifactId>
        </dependency>
       <!-- PROJECT LOMBOK -->
        <dependency>
            <groupId>org.projectlombok</groupId>
            <artifactId>lombok</artifactId>
        </dependency>
          <dependency>
            <groupId>com.h2database</groupId>
            <artifactId>h2</artifactId>
            <scope>runtime</scope>
        </dependency>


# Features

1. Return all the titles in which both director and writer are the same person and he/she
   is still alive 
