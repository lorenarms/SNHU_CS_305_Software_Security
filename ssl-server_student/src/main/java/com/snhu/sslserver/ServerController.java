package com.snhu.sslserver;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
class ServerController	{
	
	private static final String template = "Hello, %s";
	private String data;
	private MessageDigest digest;
	
	// RequestMapping allows for queries in the address bar
	// /hash?name=Name
	@RequestMapping("/hash")
    public String myHash(@RequestParam(value = "name", defaultValue = "Lawrence Artl") String name) throws NoSuchAlgorithmException {
		
		// create instance of MessageDigest class
		// use SHA512 for hashing of message
		digest = MessageDigest.getInstance("SHA512");
		
		// data to hash
		data = name;
		
		// error handling
		try {
			
			// send MessageDigest and data to checksum method
			String hash = checksum(digest, data);
			
			// return the data as a hash
			return String.format(template, name) + "<p>" + 
			"Hash Algorithm: " + digest.getAlgorithm() + "<p>" + 
			"Name CheckSum Value: " + hash;	
			
		} catch (Exception e) {
			
			System.out.println("Cause: " + e.getCause().toString());
    		e.printStackTrace();
    		
		}
		
		return "Failed";
		
	}
	

    
	// private checksum method
    private String checksum(MessageDigest digest, String data) {
    	
    	// turn the string into a byte array, digest to SHA512
    	byte[] b = data.getBytes();
    	digest.update(b);
    	b = digest.digest();
    	
    	// create a new string builder object
    	StringBuilder sb = new StringBuilder();
    	
    	// loop through byte array, convert decimal to hex, 
    	// add to string builder object
    	for (byte bytes : b) {
            sb.append(String.format("%02X ", bytes));
        }
    	
    	// return the stringbuilder object as a string
    	return sb.toString();
    	}
	
}


