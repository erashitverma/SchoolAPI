# SchoolAPI

How to start the SchoolAPI application
---

1. Run `mvn clean install` to build your application
1. Start application with `java -jar target/SchoolAPI-1.0-SNAPSHOT.jar server config.yml`
1. To check that your application is running enter url `http://localhost:9000`

Use `docker-compose up` to start local postgres database.

Health Check
---

To see your applications health enter url `http://localhost:9001/healthcheck`

Postman Collection
---
https://www.getpostman.com/collections/82dde8cd5083e391bd7b

Swagger
---
 http://api-internet-load-balancer-1890435678.us-east-1.elb.amazonaws.com/swagger
 
ALB(AWS) Url
---
Deployed on AWS ( internet-facing load balancer) - http://api-internet-load-balancer-1890435678.us-east-1.elb.amazonaws.com

Architecture
---
![Alt text](doc/Arch_dia.jpg?raw=true "Arch_dia")

Push commands to AWS ECR
---
* `aws ecr get-login-password --region us-east-1 | docker login --username AWS --password-stdin <AccountId>.dkr.ecr.us-east-1.amazonaws.com`
* `docker build -t schoolapirepo .` - Build docker image.
* `docker tag schoolapirepo:latest <AccountId>.dkr.ecr.us-east-1.amazonaws.com/schoolapirepo:latest`
* `docker push <AccountId>.dkr.ecr.us-east-1.amazonaws.com/schoolapirepo:latest`

Next Steps/ Remaining work (Due to time restriction):
---
* Implement logging
* Complete test cases.
* Use terraform for deployment.
* Comment code correctly.
* Improve docker compose file to run sql script at start of container.
