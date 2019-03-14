package com.grizzly.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="user_details")
public class UserDetailsEntity {

	@Id
	@Column(name = "user_name")
	private String username;

	@Column(name="user_password")
	private String password;
	
	@Column(name="user_role")
	private String role;
	
	@Column(name="user_status")
	private String status;

	public UserDetailsEntity()
	{
		
	}
	
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
