package org.hxbweixin.weixin.domain.text;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.hxbweixin.weixin.domain.InMessage;

import com.fasterxml.jackson.annotation.JsonProperty;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name="xml")
public class TextInMessage extends InMessage {
	
	@XmlElement(name="Content")
	@JsonProperty("Content")
	private String content;
	
	public TextInMessage() {
		super.setMsgType("text");
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return "TextInMessage [content=" + content + ", getToUserName()=" + getToUserName() + ", getFormUserName()="
				+ getFormUserName() + ", getCreateTime()=" + getCreateTime() + ", getMsgType()=" + getMsgType()
				+ ", getMsgId()=" + getMsgId() + "]";
	}
	
}
