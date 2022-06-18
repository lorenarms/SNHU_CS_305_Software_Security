package com.snhu.sslserver;

public class Greeting {

	private final long id;
	private final String name;
	private final String alg;
	private final String hash;

	public Greeting(long id, String name, String alg, String hash) {
		this.id = id;
		this.name = name;
		this.alg = alg;
		this.hash = hash;
	}

	public long getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
		
	public String getAlgorithm() {
		return alg;
	}

	public String getHash() {
		return hash;
	}
	
}
