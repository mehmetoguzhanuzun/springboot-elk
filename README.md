# OVERVIEW
This demo project helps you to transfers and storages **Spring Boot** application logs on **Elastic** via **Logstash** and let you visualize and query them via **Kibana**.


## HOW IT WORKS ? 
In this project **Spring Boot** application runs at 8034 and there is nothing special except turning on logs on properties file.      
Apart from that, we will write our specific logs to our log file with the help of **Aspect-Around**.  
**You can check LoggingAspect.java.** 

**Logstash** has responsibility to listen this file for new inputs and transport them to **Elastic**.  
At the last step **Kibana** will let us to visualize and to query logs over **Elastic**.

![ELK](https://github.com/mehmetoguzhanuzun/springboot-elk/blob/master/elk-architecture.png?raw=true)

### Elasticsearch 7.5.1 Docker Installation
Run command below to install **Elasticsearch** on your **Docker**.  
You can find **docker-elastic-compose.yml** file on project root.  
In this file you will see 2 ports.  
Lets make it clear;  
9200 : RESTful API  
9300 : Required to communicate between nodes in the cluster.  

This file needs **elasticsearch.yml**.  
Please be sure that you put it in right directory.  
```bash
$ docker-compose -f docker-elastic-compose.yml up
```

#### Lets check it up!
Run command below;  
If it returns you a meaningful json which ends with **You Know, for Search** then we can say it works!   
```bash
$ curl http://localhost:9200
```

### Logstash Installation
I could not install **Logstash** on **Docker** with a configuration file which i especially mentioned.  
It always configured to its default definitions.  
So i installed it manually.   
**I will spare time to this issue and share information about installing it on the docker.**  

Install **Logstash** via **brew** then let it start!  
```bash
$ brew tap elastic/tap
$ brew install elastic/tap/logstash-full
$ logstash -f /Users/username/IdeaProjects/springboot-elk/logstash/logstash.conf
```

#### Lets check it up!
Run command below;  
If it returns you a meaningful json and status field is **green** then we can say that works!   
```bash
$ curl http://localhost:9600
```

#### Run Spring Boot Demo Application and make some requests
Start your spring boot application, we will request it for triggering **logstash** to transport datas to **elastic**.
Run this command several times.
```bash
curl --location --request GET http://localhost:8034/demo
```

### Kibana 7.5.1 Docker Installation
Run command below to install **Kibana** on your **Docker**.  
Before run it change **elasticsearch.hosts** field of **kibana.yml** file.     
You have to change it with your server or local machine ip.  
**It wont accept http://localhost:9200 or http://127.0.0.1:9200**.  
 
You can find **docker-kibana-compose.yml** file on project root. 
 
This file needs **kibana.yml**. Please be sure that you put it in right directory.  
```bash
$ docker-compose -f docker-kibana-compose.yml up
``` 
Open your browser and go to http://localhost:5601, **Kibana** does not require username and password with default configuraiton.    
Go to **discover** tab, it is top of left menu for this version.

In this page you can follow steps below to create your index pattern.  
If you dont see demo_log pattern please check your installations.
demo_log refers to index field in **logstash.conf**  
![ELK](https://github.com/mehmetoguzhanuzun/springboot-elk/blob/master/kibana-index-pattern.gif?raw=true)

Go to discover page again and see your logs like below.
![ELK](https://github.com/mehmetoguzhanuzun/springboot-elk/blob/master/kibana-log-view.gif?raw=true)

Enjoy it.







