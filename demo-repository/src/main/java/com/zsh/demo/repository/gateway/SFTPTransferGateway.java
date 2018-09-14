package com.zsh.demo.repository.gateway;

import java.io.InputStream;
import java.util.List;
import java.util.Map;

import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;

/**
 * spring integration gateway proxy bean
 * 
 * @author zhangshihao
 *
 */
public interface SFTPTransferGateway {
	/**
	 * command -get.
	 * 
	 * @param filePath
	 *            文件路径
	 * @return
	 */
	InputStream getFile(@Payload String filePath);

	/**
	 * command -put.
	 * 
	 * @param headers
	 *            头信息
	 * @param byteArray
	 *            文件内容
	 */
	String putFile(@Headers Map<String, String> headers, @Payload byte[] byteArray);

	/**
	 * command -rm.
	 * 
	 * @param filePath
	 *            文件路径
	 * @return
	 */
	boolean rmFile(@Payload String filePath);

	/**
	 * command -ls.
	 * 
	 * @param filePath
	 *            文件路径
	 * @return
	 */
	List<String> lsFile(@Payload String filePath);

}
