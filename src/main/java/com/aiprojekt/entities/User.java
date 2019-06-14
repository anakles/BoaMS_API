package com.aiprojekt.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

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

	@ManyToMany(
			mappedBy="users",
			fetch=FetchType.EAGER,
			cascade={CascadeType.PERSIST, CascadeType.REMOVE}
			//cascade=CascadeType.ALL
			)
	@JsonBackReference
	@ApiModelProperty(notes="List of all chatrooms this user is included")
	private Set<Chatroom> chatrooms = new HashSet<Chatroom>();
	
	public User() {}
	
	public User(String loginName, String displayName) {
		this.loginName = loginName;
		this.displayName = displayName;
	}



	
	
	/*---------------------------------------
	 * 			GETTER/SETTERs
	 * -------------------------------------*/
	
	public long getUser_id() {
		return userId;
	}

	/*
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

	public Set<Chatroom> getChatrooms() {
		return chatrooms;
	}

	public void setChatrooms(Set<Chatroom> chatrooms) {
		this.chatrooms = chatrooms;
	}
	
	public void addChatroom(Chatroom chatroom) {
		this.chatrooms.add(chatroom);
	}
	
	public boolean removeChatroom(Chatroom chatroom) {
		Chatroom temp = null;
		
		for(Chatroom chat : chatrooms) {
			if(chat.getChatroom_id() == chatroom.getChatroom_id())
				temp = chat;
		}
		
		
		if(temp == null) return false;
		
		chatrooms.remove(temp);
		return true;
	}
	
}
