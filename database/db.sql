alter session set "_ORACLE_SCRIPT"=true;

CREATE USER reto IDENTIFIED BY a657q394;
GRANT CREATE TABLE TO reto;




CREATE TABLE reto.test (

id number(10),
name varchar2(40),
description varchar2(100),
CONSTRAINT test_pk PRIMARY KEY (id)
);




spring.datasource.url=jdbc:oracle:thin:@localhost:1521:xe
spring.datasource.username=reto
spring.datasource.password=a657q394
spring.jpa.show-sql=true
spring.sql.init.schema-locations=reto