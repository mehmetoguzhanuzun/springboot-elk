# OVERVIEW
This demo project helps you to transfers and storages **Spring Boot** application logs on **Elastic** via **Logstash** and let you visualize and query them via **Kibana**.


## HOW IT WORKS ? 
In this project **Spring Boot** application runs at 8034 and there is nothing special except turning on logs on properties file.
Apart from that, we will write our specific logs to our log file with the help of **Aspect-Around**.
**You can check LoggingAspect.java.** 

**Logstash** has responsibility to listen this file for new inputs and transport them to **Elastic**.
At the last step **Kibana** will let us to visualize and to query logs over **Elastic**.

![ELK](https://github.com/mehmetoguzhanuzun/springboot-elk/blob/master/elk-architecture.png?raw=true)