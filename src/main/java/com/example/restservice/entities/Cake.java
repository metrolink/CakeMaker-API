package com.example.restservice.entities;

public class Cake {

	private final long id;
	private final String content;

	public Cake(long id, String content) {
		this.id = id;
		this.content = content;
	}

	public long getId() {
		return id;
	}

	public String getContent() {
		return content;
	}
}
