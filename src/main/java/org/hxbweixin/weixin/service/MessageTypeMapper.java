package org.hxbweixin.weixin.service;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.hxbweixin.weixin.domain.InMessage;
import org.hxbweixin.weixin.domain.Image.ImageInMessage;
import org.hxbweixin.weixin.domain.event.EventInMessage;
import org.hxbweixin.weixin.domain.link.LinkInMessage;
import org.hxbweixin.weixin.domain.location.LocationInMessage;
import org.hxbweixin.weixin.domain.shortvideo.ShortVideoInMessage;
import org.hxbweixin.weixin.domain.text.TextInMessage;
import org.hxbweixin.weixin.domain.video.VideoInMessage;
import org.hxbweixin.weixin.domain.voice.VoiceInMessage;

public class MessageTypeMapper {

	private static Map<String,Class<? extends InMessage>> typeMap=new ConcurrentHashMap<>();
	
	static {
		typeMap.put("text", TextInMessage.class);
		typeMap.put("image", ImageInMessage.class);
		typeMap.put("voice", VoiceInMessage.class);
		typeMap.put("video", VideoInMessage.class);
		typeMap.put("location", LocationInMessage.class);
		typeMap.put("shortvideo", ShortVideoInMessage.class);
		typeMap.put("link", LinkInMessage.class);
		
		typeMap.put("event", EventInMessage.class);
		//typeMap.put("event", EventInMessage.class);
	}
	@SuppressWarnings("unchecked")
	public static <T extends InMessage> Class<T> getClass(String type){
		return(Class<T>) typeMap.get(type);
	}
}
