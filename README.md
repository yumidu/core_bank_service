# core_bank_service
## Core banking soap service and rest integrator

###Core Banking SOAP service (bank.soap.service)
- Spring boot application with Spring Web and Spring Web Services
- The wsdl file can be reached at localhost:8090/corebank/accounts.wsdl
- Maven plugin com.spotify is used to generate the docker images
  
###Core Banking REST Integrator (bank.rest.service)This is the REST integrator created for Core Banking SOAP service
•	Apache CXF /Wsdl2j was used to generate the java classes for the SOAP service form the .wsdl of the SOAP service
•	Audit events are added to each endpoint and they are saved to a MySQL database using Audit4j 
o	Database: localhost:3306/bank_rest
o	User/pass: root/root
•	The service can be reached and localhost:8080/corebankintegrator/
•	Basic spring security is added
o	Username / Password: user / user
•	Maven plugin com.spotify is used to generate the docker images
•	This can be executed against mysql:latest docker image
Dockerfiles
•	Dockerfile for each project can be found in the root folder of the project
Docker Images
•	bank.soap.service – dockeryumi/ bank.soap.service
•	bank.rest.service – dockeryumi/bank.rest.service
•	mysql (dependency)
Docker-compose.yml file
•	Known issues:
o	Created a docker-compose.yml file to start the three docker containers (bank.soap.service / bank.rest.service / mysql). When running the .yml file, Audit4j fails to start as it is looking for a database connection. The issue here seems to be that the bank.rest.service container starts and looks for the database connection before the mysql container is fully started and starts accepting connections. Tried to solve this using wait-for-it.sh but had no luck.
If the mysql container is started manually and then mvn:install is executed in the project after some time, Audit4j starts without any issue
Swagger Documentation
•	Documentation is created using Swagger Inspector and Swagger Hub
•	Shared at https://app.swaggerhub.com/apis/yumiduyj/CoreBankIntegrator/0.1

•	Known issues:
o	403 error is returned when trying to access links in the documentation. Was not able to resolve this issue in time. Tried to resolve this with permitting Swagger and then all requests through the WebSecurityConfiguration but still getting the error

