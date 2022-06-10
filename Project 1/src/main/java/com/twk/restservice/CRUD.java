package com.twk.restservice;

public class CRUD {
	private final String content;
    private final String content2;

    public CRUD(String content) {
        this.content = content;
        this.content2 = content;
    }

    public CRUD(String content1, String content2) {
        this.content = content1;
        this.content2 = content2;
    }

    public String getContent() {
        return content;
    }

    public String getContent2() {
        return content2;
    }

}
