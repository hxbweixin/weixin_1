package org.hxbweixin.weixin.domain.shortvideo;

import javax.xml.bind.annotation.XmlElement;

import org.hxbweixin.weixin.domain.InMessage;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ShortVideoInMessage extends InMessage {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@XmlElement(name="ThumbMediaId")
	@JsonProperty("ThumbMediaId")
	private String thumbMediaId;
	
	@XmlElement(name="MediaId")
	@JsonProperty("MediaId")
	private String mediaId;
	
	public ShortVideoInMessage() {
		super.setMsgType("shortvideo");
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
