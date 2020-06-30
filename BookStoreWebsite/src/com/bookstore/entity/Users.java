package com.bookstore.entity;
// Generated 28 Jun. 2020, 8:22:25 pm by Hibernate Tools 5.2.12.Final

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Users generated by hbm2java
 */
@Entity
@Table(name = "users", catalog = "bookstore")
public class Users implements java.io.Serializable {

	private int userId;
	private String email;
	private String password;
	private String fullName;

	public Users() {
	}

	public Users(int userId, String email, String password, String fullName) {
		this.userId = userId;
		this.email = email;
		this.password = password;
		this.fullName = fullName;
	}


	@Column(name = "user_id")
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getUserId() {
		return this.userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "full_name")
	public String getFullName() {
		return this.fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

}
