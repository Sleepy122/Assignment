package com.bnsf.inventory.driver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.*;
import com.bnsf.inventory.util.*;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;

import com.bnsf.inventory.beans.InventoryItem;
import com.bnsf.inventory.controller.InventoryController;
import com.bnsf.inventory.dao.InventoryDaoImpl;

@EnableCircuitBreaker
@SpringBootApplication
@ComponentScan(basePackageClasses = InventoryController.class)
@EnableSwagger2
public class InventoryServiceApplication {
	public static void main(String args[]) {
		SpringApplication.run(InventoryServiceApplication.class, args);

	}
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).select()
		                                  
        .apis(RequestHandlerSelectors.basePackage("com.bnsf.inventory"))              
        .paths(PathSelectors.any())                          
        .build();
	}

}
