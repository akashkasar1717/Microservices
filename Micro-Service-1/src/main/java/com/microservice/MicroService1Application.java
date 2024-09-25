package com.microservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class MicroService1Application {

	public static void main(String[] args) {
		SpringApplication.run(MicroService1Application.class, args);
	}
//http://akash-k:8084/actuator/health   --to check the health of the application.
//http://akash-k:8084/actuator/info     --application information
//http://akash-k:8084/actuator/env      -- Shows environment properties
//http://akash-k:8084/actuator/metrics  --JVM memory usage, garbage collection, and custom application metrics.
//http://akash-k:8084/actuator/heapdump --Provides a heap dump of the JVM. file is downloaded in your system.
//http://akash-k:8084/actuator/configprops --Displays db configuration properties
//http://akash-k:8084/actuator/scheduledtasks --Provides information about scheduled tasks.
//http://akash-k:8084/actuator/loggers     --Provides logging-related information.
//http://akash-k:8084/actuator/threaddump --information about the current state of all threads in the JVM.

}
