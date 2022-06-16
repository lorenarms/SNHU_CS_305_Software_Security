package com.snhu.sslserver;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.security.MessageDigest;

public class DocData implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String businessName;
	private final long id;
	 
    public DocData(long id, String name)
    {
    	this.id = id;
    	businessName = name;
    }

    public long getId()
    {
    	return id;
    }
    public String getName() {
    	return businessName;
    }
    
    public String getChecksum(MessageDigest digest, DocData doc) {
		return checksum(digest, doc);
    	
    }

        
 // private checksum method
    private String checksum(final MessageDigest digest, final DocData doc) {
    	
    	// turn the document into a byte array, digest to appropriate algorithm
    	ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream oos;
		try {
			oos = new ObjectOutputStream(bos);
			oos.writeObject(doc);
			oos.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
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
