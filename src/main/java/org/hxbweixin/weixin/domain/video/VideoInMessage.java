package org.hxbweixin.weixin.domain.video;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.hxbweixin.weixin.domain.InMessage;

import com.fasterxml.jackson.annotation.JsonProperty;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name="xml")
public class VideoInMessage extends InMessage {
	
	@XmlElement(name="ThumbMediaId")
	@JsonProperty("ThumbMediaId")
	private String thumbMediaId;
	
	@XmlElement(name="MediaId")
	@JsonProperty("MediaId")
	private String mediaId;
	
	public VideoInMessage() {
		super.setMsgType("video");
	}

	public String getThumbMediaId() {
		return thumbMediaId;
	}

	public void setThumbMediaId(String thumbMediaId) {
		this.thumbMediaId = thumbMediaId;
	}

	public String getMediaId() {
		return mediaId;
	}

	public void setMediaId(String mediaId) {
		this.mediaId = mediaId;
	}
}
