package com.aiprojekt.entities;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name="messages")
public class Message {

	@Id
	@ApiModelProperty(notes="Unique identifier of a message depending on the chatroom")
	@Column(name="message_id")
	private long message_id;
	
	@ApiModelProperty(notes="Unique identifier on the chatroom the message was send to/from")
	@Column(name="message_chatroom_id")
	private long message_chatroom_id;
	
	@ApiModelProperty(notes="Content of a message")
	@Column(name="message_txt")
	private String message_txt;
	
	@ApiModelProperty(notes="Unique identifier of the author of a message")
	@Column(name="message_author_id")
	private long message_author_id;
	
	@ApiModelProperty(notes="Auto-generated date of when the message was created/sent")
	@Column(name="message_creation_date")
	private Date message_creation_date;
	
	public Message() {}
	
	public Message(long messageId, long messageChatroomId, String messageTxt, long messageAuthorId, Date messageCreationDate) {
		this.message_id = messageId;
		this.message_chatroom_id = messageChatroomId;
		this.message_txt = messageTxt;
		this.message_author_id = messageAuthorId;
		this.message_creation_date = messageCreationDate;
	}


	
	
	/*---------------------------------------
	 * 			GETTER/SETTERs
	 * -------------------------------------*/
	
	public long getMessage_id() {
		return message_id;
	}

	public void setMessage_id(long message_id) {
		this.message_id = message_id;
	}

	public long getMessage_chatroom_id() {
		return message_chatroom_id;
	}

	public void setMessage_chatroom_id(long message_chatroom_id) {
		this.message_chatroom_id = message_chatroom_id;
	}

	public String getMessage_txt() {
		return message_txt;
	}

	public void setMessage_txt(String message_txt) {
		this.message_txt = message_txt;
	}

	public long getMessage_author_id() {
		return message_author_id;
	}

	public void setMessage_author_id(long message_author_id) {
		this.message_author_id = message_author_id;
	}

	public Date getMessage_creation_date() {
		return message_creation_date;
	}

	public void setMessage_creation_date(Date message_creation_date) {
		this.message_creation_date = message_creation_date;
	}
	
	
}
