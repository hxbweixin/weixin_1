package org.hxbweixin.weixin.domain;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonProperty;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name="xml")
public abstract class InMessage {
	
	@XmlElement(name="ToUserName")
	@JsonProperty("ToUsername")
	private String toUserName;
	
	@XmlElement(name="FormUserName")
	@JsonProperty("FormUserName")
	private String formUserName;
	
	@XmlElement(name="CreateTime")
	@JsonProperty("CreateTime")
	private long createTime;
	
	@XmlElement(name="MsgType")
	@JsonProperty("MsgType")
	private String msgType;
	
	@XmlElement(name="MsgId")
	@JsonProperty("MsgId")
	private String msgId;

	public String getToUserName() {
		return toUserName;
	}

	public void setToUserName(String toUserName) {
		this.toUserName = toUserName;
	}

	public String getFormUserName() {
		return formUserName;
	}

	public void setFormUserName(String formUserName) {
		this.formUserName = formUserName;
	}

	public long getCreateTime() {
		return createTime;
	}

	public void setCreateTime(long createTime) {
		this.createTime = createTime;
	}

	public String getMsgType() {
		return msgType;
	}

	public void setMsgType(String msgType) {
		this.msgType = msgType;
	}

	public String getMsgId() {
		return msgId;
	}

	public void setMsgId(String msgId) {
		this.msgId = msgId;
	}
	
}
