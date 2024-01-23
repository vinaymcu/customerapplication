package com.customer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/**
 * Spring boot main Application class for customer application
 */
@Slf4j
@SpringBootApplication
public class MyApplication {
	public static void main(String[] args) {
	   SpringApplication.run(MyApplication.class, args);
		log.info("  MyApplication is started  ");
    }
}            