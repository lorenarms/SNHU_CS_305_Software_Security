package com.snhu.sslserver;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
class DocController	{
	
	private static final String template = "Business name: %s";
	private final AtomicLong counter = new AtomicLong();
	private MessageDigest digest;
	
	// RequestMapping allows for queries in the address bar
	@RequestMapping("/doc")
    public String docHash(@RequestParam(value = "name", defaultValue = "Business") String name) throws NoSuchAlgorithmException {
		
		DocData doc = new DocData(counter.incrementAndGet(), name);
		
		// create instance of MessageDigest class
		// use SHA512 for hashing of message
		digest = MessageDigest.getInstance("SHA512");
		
		// error handling
		try {
			
			// send MessageDigest and data to checksum method
			String hash = doc.getChecksum(digest, doc);
						
			// return the data as a hash formatted for readability
			return String.format(template, name) + "<p>" + 
			"Document ID: " + doc.getId() + "<p>" + 
			"Hashing Algorithm: " + digest.getAlgorithm() + "<p>" +
			"Document CheckSum Value: " + hash;	
			
		} catch (Exception e) {
			
			System.out.println("Cause: " + e.getCause().toString());
    		e.printStackTrace();
    		
		}
		
		return "Failed";
	}
}