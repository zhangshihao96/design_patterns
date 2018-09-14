package com.zsh.demo.repository.behavior.impl;

import java.io.IOException;
import java.io.InputStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;

import com.zsh.demo.repository.behavior.Get;
import com.zsh.demo.repository.gateway.SFTPTransferGateway;
/**
 * sftp文件下载的实现.
 * 
 * @author zhangshihao
 *
 */
public class SFTPGetImpl implements Get{
	/**
	 * 加载日志类.
	 */
	private static Logger LOGGER = LoggerFactory.getLogger(SFTPGetImpl.class);
	/**
	 * spring integration-sftp gateway.
	 */
	private SFTPTransferGateway sftpTransferGateway;
	/**
	 * 远端目录.
	 */
	private String remoteFolderPath;

	public SFTPGetImpl(String remoteFolderPath, SFTPTransferGateway sftpTransferGateway) {
		this.sftpTransferGateway = sftpTransferGateway;
		this.remoteFolderPath = remoteFolderPath;
	}
	
	@Override
	public Resource getResource(String filename) throws IOException {
		LOGGER.info("get download remote folder path: {}", remoteFolderPath);
		InputStream in = sftpTransferGateway.getFile(remoteFolderPath + filename);
		return new InputStreamResource(in);
	}
}
