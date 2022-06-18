
/*
 * Lawrence Artl III | lorenarms
 * CS-305 Software Security 22EW5
 * Southern New Hampshire University
 * June 18, 2022
 * Project 2 Submission
 * 
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * http://artllj.com
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * https://github.com/lorenarms
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * 
 * Mock-up of a REST server that takes in a customer name and returns it's hash value
 * OR creates a business document with the business name and an id and returns
 * OR takes in customer name and optional hash algorithm and returns a hash of the name
 * 
 * use https://localhost:8443/hash for defaults
 * use {{url}}/hash?name=[name] for name queries
 * use {{url}}/hash?algorithm=[algorithm] for algorithm changes
 * 		NOTE: the above throws an error if the algorithm selected does not exist
 * 		Accepts all MessageDigest algorithms
 * 
 * use {{url}}/doc for document generation and hashing
 * 		NOTE: the above returns the hash as a string to the web browser
 * use {{url}}/greeting for greeting generation and hashing
 * 		NOTE: the above returns the hash in JSON format 
 * 
 * All controllers make use of the Checksum class
 * All data is sent as objects and hashed as objects; some discrepancies
 * may exist when comparing the hash of raw strings
 * 
 * EXAMPLE: 
 * 	Standard Hash of "Angelina Dominguez":
 * 		94389CE00C572E5AC267068BEAB80714FE69E2A06EB36EF12D1B4C7FD1419DA6
 * 		
 * 	Hash of "Angelina Dominguez" object:
 * 		80CD6B21DE8BC5EEE0FD02060F354AFA269FC72FB9B5E5E1D41E8BA4F5CCA27B
 * 
 * 	NOTE that both make use of the SHA256 algorithm, but because the data is
 * 		transferred in different formats, the hash is different. This was deemed 
 * 		acceptable by the development team, as the data's plain-text is still the 
 * 		same.
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



