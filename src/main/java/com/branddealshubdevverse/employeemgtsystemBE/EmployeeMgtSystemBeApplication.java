package com.branddealshubdevverse.employeemgtsystemBE;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@OpenAPIDefinition(
//		servers = {
//				@Server(url = "/employeemgtsys/", description = "Default Server URL")
//		}
//)
public class EmployeeMgtSystemBeApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeMgtSystemBeApplication.class, args);
	}

}
