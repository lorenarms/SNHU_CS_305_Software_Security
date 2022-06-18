package com.snhu.sslserver;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
class ServerController	{
	
	private static final String template = "Hello, %s!";
	private String data;
	private MessageDigest digest;
	
	// RequestMapping allows for queries in the address bar
	// /hash?name=Name
	@RequestMapping("/hash")
    public String myHash(@RequestParam(value = "name", 
    	defaultValue = "Lawrence Artl") String name, 
    	@RequestParam(value = "algorithm", defaultValue = "SHA-512") String algorithm) 
    		throws NoSuchAlgorithmException {
		
		// data to hash
		data = name;
		
		// error handling
		try {
			
			try {
				
				digest = MessageDigest.getInstance(algorithm);
				
			} catch (NoSuchAlgorithmException e) {
					    		
	    		return data + " hash failed. " + algorithm + " not available to use for hashing. "
	    				+ "Perhaps it doesn't exist?" + "<p>" + e.getMessage();
			}
			
			
			// create new checksum object
			Checksum chk = new Checksum();
			
			// send MessageDigest and data to appropriate checksum method
			String hash = chk.checksum(digest, data);
			chk = null;
			
			// return the data as a hash
			return String.format(template, name) + "<p>" + 
			"Hash Algorithm: " + digest.getAlgorithm() + "<p>" + 
			"Name CheckSum Value: " + hash;	
			
		} catch (Exception e) {
			
			return data + " hash failed, unknown error.<p>" + e.getMessage();
		}
		
		
		
	}
	
}


