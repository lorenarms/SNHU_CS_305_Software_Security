package com.snhu.sslserver.server;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class ServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServerApplication.class, args);
	}

}

@RestController
class ServerController{
	
	private static final String template = "Hello, %s";
	
	// RequestMapping allows for queries in the address bar
	// /hash?name=Name
	@RequestMapping("/hash")
    public String myHash(@RequestParam(value = "name", defaultValue = "Lawrence Artl") String name) throws NoSuchAlgorithmException{
		
		// create instance of MessageDigest class
		// use SHA256 for hashing of message
		MessageDigest digest = MessageDigest.getInstance("SHA256");
		
		// data to hash
		// if default, then 'Lawrence Artl'
		String data = name;
		
		// try / catch block for error handling
    	try {
    		// send MessageDigest and data to checksum method
    		String hash = checksum(digest, data);
    		
    		// return the data as a hash
    		return String.format(template, name) + "<p>" + digest.getAlgorithm() + " CheckSum Value: " + hash;
    	} catch (Exception e) {
    		
    		System.out.println("Cause: " + e.getCause().toString());
    		e.printStackTrace();
    	}
    	
    	// 
		return "Failed"; 	
        
    }
    
    private String checksum(MessageDigest digest, String data) {
    	
    	// turn the string into a byte array
    	byte[] b = data.getBytes();
    	
    	// digest the byte array using the selected algorithm
    	digest.update(b);
    		
    	// update byte array from the MessageDigest
    	b = digest.digest();
    	
    	// create a new string builder object
    	StringBuilder sb = new StringBuilder();
    	
    	// loop through byte array, convert decimal to hex, 
    	// add to string builder object
    	
    	
    	for (byte bytes : b) {
            sb.append(String.format("%02X ", bytes));
        }
    	
    
    	
    	// return string builder object as string
    	return sb.toString();
    	}
	
}


