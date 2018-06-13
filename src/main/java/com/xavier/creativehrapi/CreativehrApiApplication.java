package com.xavier.creativehrapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import com.xavier.creativehrapi.config.property.CreativehrApiProperty;

@SpringBootApplication
@EnableConfigurationProperties(CreativehrApiProperty.class)
public class CreativehrApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(CreativehrApiApplication.class, args);
	}
}
