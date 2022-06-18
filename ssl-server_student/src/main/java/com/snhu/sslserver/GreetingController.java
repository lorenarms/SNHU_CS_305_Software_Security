package com.snhu.sslserver;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

	private static final String template = "Hello, %s!";
	private String data;
	private MessageDigest digest;
	private final AtomicLong counter = new AtomicLong();

	@GetMapping("/greeting")
	public Greeting greeting(@RequestParam(value = "name", 
		defaultValue = "Lawrence Artl") String name) 
		throws NoSuchAlgorithmException {
	
		// data to hash
		data = name;
		
		// error handling
		try {
			
			// create instance of MessageDigest class
			// use SHA512 for hashing of message
			digest = MessageDigest.getInstance("SHA-512");
			
			// create checksum object
			Checksum chk = new Checksum();
			
			// send MessageDigest and data to appropriate checksum method
			String hash = chk.checksum(digest, data);
			chk = null;
			
			// return the object and hash value as JSON to browser
			return new Greeting(counter.incrementAndGet(), 
				String.format(template, name),
				digest.getAlgorithm(),
				hash);
											
		} catch (Exception e) {
			
			return new Greeting(counter.incrementAndGet(), String.format(template, name), e.getMessage(), e.getMessage());  		
		}
		
		
	}
}
