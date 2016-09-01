package top.johnxiao.blog.dto;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;


public class MessageInfo implements Serializable{
//	留言编号
	private Integer messageId;
//	留言发送者
	private UserInfo sender;
//	留言接收者
	private UserInfo receiver;
//	留言内容
	private String messageContent;
//	留言时间
	private Timestamp messageDate;
//	是否删除,软删除
	private Boolean msgIsDel;
	
	
public MessageInfo() {}


public MessageInfo(Integer messageId, UserInfo sender, UserInfo receiver,
		String messageContent, Timestamp messageDate, Boolean msgIsDel) {
	this.messageId = messageId;
	this.sender = sender;
	this.receiver = receiver;
	this.messageContent = messageContent;
	this.messageDate = messageDate;
	this.msgIsDel = msgIsDel;
}


public Integer getMessageId() {
	return messageId;
}


public void setMessageId(Integer messageId) {
	this.messageId = messageId;
}


public UserInfo getSender() {
	return sender;
}


public void setSender(UserInfo sender) {
	this.sender = sender;
}


public UserInfo getReceiver() {
	return receiver;
}


public void setReceiver(UserInfo receiver) {
	this.receiver = receiver;
}


public String getMessageContent() {
	return messageContent;
}


public void setMessageContent(String messageContent) {
	this.messageContent = messageContent;
}


public Timestamp getMessageDate() {
	return messageDate;
}


public void setMessageDate(Timestamp messageDate) {
	this.messageDate = messageDate;
}


public Boolean getMsgIsDel() {
	return msgIsDel;
}


public void setMsgIsDel(Boolean msgIsDel) {
	this.msgIsDel = msgIsDel;
}

	
}
