package org.hxbweixin.weixin.service;

import org.hxbweixin.weixin.domain.InMessage;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.SerializationException;

public class JsonRedisSerializer extends Jackson2JsonRedisSerializer<InMessage> {
	
	public JsonRedisSerializer() {
		super(InMessage.class);
	}
	@Override
	public byte[] serialize(InMessage t) throws SerializationException{
		return super.serialize(t);
	}
	
	@Override
	public InMessage deserialize(byte[] bytes) throws SerializationException{
		return super.deserialize(bytes);
	}
}
