package com.snhu.sslserver;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.security.MessageDigest;

public class Checksum {
	// private checksum method
	
	public Checksum(){
		
	}
		   
    // checksum method, for hashing objects
    String checksum(final MessageDigest digest, final Object obj) {
    	
    	// turn the object into a byte array, digest to appropriate algorithm
    	ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream oos;
		try {
			oos = new ObjectOutputStream(bos);
			oos.writeObject(obj);
			oos.flush();
		} catch (IOException e) {
			e.getMessage();
			e.printStackTrace();
		}
        byte [] b = bos.toByteArray();
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
