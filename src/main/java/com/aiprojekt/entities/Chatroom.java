package com.aiprojekt.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name="chatrooms")
public class Chatroom {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@ApiModelProperty(notes="Unique identifier of a chatroom")
	@Column(name="chatroom_id")
	private long chatroomId;

	@ApiModelProperty(notes="Given name to a conversation or a group chat")
	@Column(name="chatroom_name")
	private String chatroomName;
	
	@ApiModelProperty(notes="Date and time the chatroom was created")
	@Column(name="chatroom_creation_date")
	private Date chatroomCreationDate;
	
	@ApiModelProperty(notes="Unique identifier of the owner/creator of a chatroom")
	@Column(name="chatroom_owner_id")
	private long chatroomOwnerId;
	
	@ManyToMany(
		cascade={ CascadeType.PERSIST, CascadeType.MERGE},
		fetch=FetchType.EAGER)
	@JoinTable(name = "chatrooms_users",
		joinColumns = @JoinColumn(name = "user_id"),
		inverseJoinColumns = @JoinColumn(name = "chatroom_id")
	)
	//@JsonManagedReference
	private Set<User> users = new HashSet<User>();
	
	public Chatroom() {}
	
	public Chatroom(String chatroomName, long chatroomOwnerId) {
		this.chatroomName = chatroomName;
		this.chatroomOwnerId = chatroomOwnerId;
	}

	@PrePersist
	public void createdAt() {
		this.chatroomCreationDate = new Date();
	}	
	
	
	
	
	
	/*---------------------------------------
	 * 			GETTER/SETTERs
	 * -------------------------------------*/
	
	public long getChatroom_id() {
		return chatroomId;
	}

	/*public void setChatroom_id(long chatroom_id) {
		this.chatroomId = chatroom_id;
	}*/

	public String getChatroom_name() {
		return chatroomName;
	}

	public void setChatroom_name(String chatroom_name) {
		this.chatroomName = chatroom_name;
	}

	/*public Date getChatroom_creation_date() {
		return chatroom_creation_date;
	}

	public void setChatroom_creation_date(Date chatroom_creation_date) {
		this.chatroom_creation_date = chatroom_creation_date;
	}*/

	public long getChatroom_owner_id() {
		return chatroomOwnerId;
	}

	public void setChatroom_owner_id(long chatroom_owner_id) {
		this.chatroomOwnerId = chatroom_owner_id;
	}

	public Set<User> getUsers() {
		return users;
	}

	/*public void setUsers(Set<User> users) {
		this.users = users;
	}*/
	
	public void addUser(User user) {
		this.users.add(user);
	}
	
	
	
	
}
