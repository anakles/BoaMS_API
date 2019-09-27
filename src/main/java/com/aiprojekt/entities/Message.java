package com.aiprojekt.entities;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name="messages")
public class Message {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@ApiModelProperty(notes="Unique identifier of a message depending on the chatroom")
	@Column(name="message_id")
	private long messageId;
	
	@ApiModelProperty(notes="Unique identifier on the chatroom the message was send to/from")
	@Column(name="message_chatroom_id")
	private long messageChatroomId;
	
	@ApiModelProperty(notes="Content of a message")
	@Column(name="message_txt")
	private String messageTxt;
	
	@ApiModelProperty(notes="Unique identifier of the author of a message")
	@Column(name="message_author_id")
	private long messageAuthorId;
	
	@ApiModelProperty(notes="Auto-generated date of when the message was created/sent")
	@Column(name="message_creation_date")
	private LocalDateTime messageCreationDate;
	
	public Message() {}
	
	public Message(String messageTxt, long messageAuthorId) {
		this.messageTxt = messageTxt;
		this.messageAuthorId = messageAuthorId;
		
		createdAt();
	}
	
	@PrePersist
	public void createdAt() {
		this.messageCreationDate =  LocalDateTime.now();
	}	


	
	
	/*---------------------------------------
	 * 			GETTER/SETTERs
	 * -------------------------------------*/
	
	public long getMessage_id() {
		return messageId;
	}

	/*	
	public void setMessage_id(long message_id) {
		this.message_id = message_id;
	}*/

	public long getMessage_chatroom_id() {
		return messageChatroomId;
	}

	public void setMessage_chatroom_id(long message_chatroom_id) {
		this.messageChatroomId = message_chatroom_id;
	}

	public String getMessage_txt() {
		return messageTxt;
	}

	public void setMessage_txt(String message_txt) {
		this.messageTxt = message_txt;
	}

	public long getMessage_author_id() {
		return messageAuthorId;
	}

	public void setMessage_author_id(long message_author_id) {
		this.messageAuthorId = message_author_id;
	}

	public LocalDateTime getMessage_creation_date() {
		return messageCreationDate;
	}
	
	/*
	public void setMessage_creation_date(Date message_creation_date) {
		this.message_creation_date = message_creation_date;
	}*/
	
	
}
