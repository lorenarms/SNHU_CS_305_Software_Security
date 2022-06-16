
/*
 * Mock-up of a REST server that takes in a customer name and returns it's hash value
 * OR creates a business document with the business name and an id and returns
 * it's hash value 
 */

package com.snhu.sslserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SslServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SslServerApplication.class, args);
	}

}



