package com.zsh.demo.repository.transform;

import java.io.InputStream;
import java.util.List;

import org.springframework.messaging.Message;

/**
 * spring-integration 返回结果转换器.
 * 
 * @author zhangshihao
 *
 */
public class SFTPTransformer {
	/**
	 * 转换下载结果.
	 * 
	 * @param message
	 *            message
	 * @return InputStream
	 */
	public InputStream convertGetResponse(Message<?> message) {
		InputStream in = (InputStream) message.getPayload();
		return in;
	}

	/**
	 * 转换上传结果.
	 * 
	 * @param message
	 *            message
	 * @return String
	 */
	public String convertPutResponse(Message<?> message) {
		return (String) message.getPayload();
	}

	/**
	 * 转换删除结果.
	 * 
	 * @param message
	 *            message
	 * @return boolean
	 */
	public boolean convertRmResponse(Message<?> message) {
		Object obj = message.getPayload();
		return (boolean) obj;
	}

	/**
	 * 转换查询结果.
	 * 
	 * @param message
	 *            message
	 * @return List
	 */
	@SuppressWarnings("unchecked")
	public List<String> convertLsResponse(Message<?> message) {
		List<String> list = (List<String>) message.getPayload();
		return list;
	}

}
