package com.aiprojekt.entities;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name="chatrooms")
public class Chatroom {

	@Id
	@ApiModelProperty(notes="Unique identifier of a chatroom")
	@Column(name="chatroom_id")
	private long chatroom_id;

	@ApiModelProperty(notes="Given name to a conversation or a group chat")
	@Column(name="chatroom_name")
	private String chatroom_name;
	
	@ApiModelProperty(notes="Date and time the chatroom was created")
	@Column(name="chatroom_creation_date")
	private Date chatroom_creation_date;
	
	@ApiModelProperty(notes="Unique identifier of the owner/creator of a chatroom")
	@Column(name="chatroom_owner_id")
	private long chatroom_owner_id;
	
	public Chatroom() {}
	
	public Chatroom(long chatroomId, String chatroomName, Date chatroomCreationDate, long chatroomOwnerId) {
		this.chatroom_id = chatroomId;
		this.chatroom_name = chatroomName;
		this.chatroom_creation_date = chatroomCreationDate;
		this.chatroom_owner_id = chatroomOwnerId;
	}


	
	
	
	
	
	
	/*---------------------------------------
	 * 			GETTER/SETTERs
	 * -------------------------------------*/
	
	public long getChatroom_id() {
		return chatroom_id;
	}

	public void setChatroom_id(long chatroom_id) {
		this.chatroom_id = chatroom_id;
	}

	public String getChatroom_name() {
		return chatroom_name;
	}

	public void setChatroom_name(String chatroom_name) {
		this.chatroom_name = chatroom_name;
	}

	public Date getChatroom_creation_date() {
		return chatroom_creation_date;
	}

	public void setChatroom_creation_date(Date chatroom_creation_date) {
		this.chatroom_creation_date = chatroom_creation_date;
	}

	public long getChatroom_owner_id() {
		return chatroom_owner_id;
	}

	public void setChatroom_owner_id(long chatroom_owner_id) {
		this.chatroom_owner_id = chatroom_owner_id;
	}
	
	
}
