package com.snhu.sslserver;

import java.io.Serializable;

public class DocData implements Serializable {
	
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
    
    
}
