package org.hxbweixin.weixin.controller;

//import java.io.ByteArrayOutputStream;
//import java.io.ObjectOutputStream;
import java.io.StringReader;

import javax.xml.bind.JAXB;

import org.hxbweixin.weixin.domain.InMessage;
import org.hxbweixin.weixin.service.MessageTypeInMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/weixin_1/weixin/receiver")
public class MessageReceiverController {
	
	private static final Logger LOG=LoggerFactory.getLogger(MessageReceiverController.class);
	
	@Autowired
	@Qualifier("inMessageTemplate")
	private RedisTemplate<String,InMessage> inMessageTemplate;
	
	@GetMapping 
	public String echo(
			@RequestParam("signature") String signature,
			@RequestParam("timestamp") String timestamp,
			@RequestParam("nonce") String nonce, 
			@RequestParam("echostr") String echostr
	) {
		return echostr;
	}
	@PostMapping
	public String onMessage(
			@RequestParam("signature") String signature,
			@RequestParam("timestamp") String timestamp,
			@RequestParam("nonce") String nonce, 
			@RequestBody String xml) {
		LOG.debug("收到用户发送给公众号的信息: \n-----------------------------------------\n"
				+ "{}\n-----------------------------------------\n", xml);
		
		
		String type=xml.substring(xml.indexOf("<MsgType><![CDATA[") +18);
		type=type.substring(0,type.indexOf("]]></Msgtype>"));
		
		Class<InMessage> cla=MessageTypeInMapper.getClass(type);
		
		InMessage inMessage=JAXB.unmarshal(new StringReader(xml), cla);
		LOG.debug("转换得到的消息对象 \n{}\n",inMessage.toString());
		
		inMessageTemplate.convertAndSend("weixin_1"+inMessage.getMsgType(),inMessage);
//		inMessageTemplate.execute(new RedisCallback<String>() {
//			
//			@Override
//			public String doInRedis(RedisConnection connection) throws DataAccessException{
//				
//				try {
//					String channel="weixin_1_"+inMessage.getMsgType();
//					
//					ByteArrayOutputStream out=new ByteArrayOutputStream();
//					ObjectOutputStream oos= new ObjectOutputStream(out);
//					oos.writeObject(inMessage);
//					
//					Long l = connection.publish(channel.getBytes(), out.toByteArray());
//					System.out.println("发布结果：" + l);
//				}catch (Exception e) {
//					LOG.error("把消息放入队列时出现问题：" + e.getLocalizedMessage(), e);
//				}	
//					return null;
//				}
//			});
		
	/*	inMessageTemplate.execute(new SessionCallback<String>() {

			@Override
			public <K, V> String execute(RedisOperations<K, V> operations) throws DataAccessException {
				// TODO Auto-generated method stub
				
				return null;
			}
			
			
		}); */
		
		return "success";
	}
}
