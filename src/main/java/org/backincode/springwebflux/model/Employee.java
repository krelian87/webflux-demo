package org.backincode.springwebflux.model;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Employee implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2377915330050375303L;

	@Id
	private String id;
	private String name;
	private String role;
	
	public Employee(String name, String role) {
		this.setName(name);
		this.setRole(role);
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}

}
