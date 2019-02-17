package com.aiprojekt.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="users")
public class User {
	
	@Id
	@Column(name="user_id")
	private long user_id;
	
	@Column(name="login_name")
	private String login_name;
	
	@Column(name="display_name")
	private String display_name;
	
	public User() {}
	
	public User(long user_id, String login_name, String display_name) {
		this.user_id = user_id;
		this.login_name = login_name;
		this.display_name = display_name;
	}



	
	
	/*---------------------------------------
	 * 			GETTER/SETTERs
	 * -------------------------------------*/
	
	public long getUser_id() {
		return user_id;
	}

	public void setUser_id(long user_id) {
		this.user_id = user_id;
	}

	public String getLogin_name() {
		return login_name;
	}

	public void setLogin_name(String login_name) {
		this.login_name = login_name;
	}

	public String getDisplay_name() {
		return display_name;
	}

	public void setDisplay_name(String display_name) {
		this.display_name = display_name;
	}
	
}
