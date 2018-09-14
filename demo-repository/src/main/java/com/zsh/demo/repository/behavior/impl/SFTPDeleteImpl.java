package com.zsh.demo.repository.behavior.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.zsh.demo.repository.behavior.Delete;
import com.zsh.demo.repository.gateway.SFTPTransferGateway;

/**
 * sftp文件删除的实现.
 * 
 * @author zhangshihao
 *
 */
public class SFTPDeleteImpl implements Delete {
	/**
	 * 加载日志类.
	 */
	private static Logger LOGGER = LoggerFactory.getLogger(SFTPDeleteImpl.class);
	/**
	 * spring integration-sftp gateway.
	 */
	private SFTPTransferGateway sftpTransferGateway;
	/**
	 * 远端目录.
	 */
	private String remoteFolderPath;

	public SFTPDeleteImpl(String remoteFolderPath, SFTPTransferGateway sftpTransferGateway) {
		this.sftpTransferGateway = sftpTransferGateway;
		this.remoteFolderPath = remoteFolderPath;
	}

	@Override
	public boolean deleteResource(String filename) {
		LOGGER.info("get delete remote folder path: {}", remoteFolderPath);
		return sftpTransferGateway.rmFile(remoteFolderPath + filename);
	}
}
