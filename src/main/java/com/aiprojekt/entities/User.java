package com.aiprojekt.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name="users")
public class User {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@ApiModelProperty(notes="Unique identifier for every user")
	@Column(name="user_id")
	private long userId;
	
	@ApiModelProperty(notes="Login name used for the directory service")
	@Column(name="login_name")
	private String loginName;
	
	@ApiModelProperty(notes="Display name of a user provided by the directory service")
	@Column(name="display_name")
	private String displayName;
	
	public User() {}
	
	public User(String loginName, String displayName) {
		this.loginName = loginName;
		this.displayName = displayName;
	}



	
	
	/*---------------------------------------
	 * 			GETTER/SETTERs
	 * -------------------------------------*/
	
	/*public long getUser_id() {
		return user_id;
	}

	
	public void setUser_id(long user_id) {
		this.user_id = user_id;
	}*/

	public String getLogin_name() {
		return loginName;
	}

	public void setLogin_name(String login_name) {
		this.loginName = login_name;
	}

	public String getDisplay_name() {
		return displayName;
	}

	public void setDisplay_name(String display_name) {
		this.displayName = display_name;
	}
	
}
