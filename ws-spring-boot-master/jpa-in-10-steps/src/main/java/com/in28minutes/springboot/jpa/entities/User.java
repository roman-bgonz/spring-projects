package com.in28minutes.springboot.jpa.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class User {

	@Id
	@GeneratedValue
	private long id;

	private String name;
	private String role;

	protected User() {
	}

	public long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getRole() {
		return role;
	}

	public User(String name, String role) {
		super();
		this.name = name;
		this.role = role;
	}
}
