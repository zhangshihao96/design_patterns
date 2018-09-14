package com.zsh.demo.repository.behavior.impl;

import java.io.IOException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.zsh.demo.repository.behavior.Ls;
import com.zsh.demo.repository.gateway.SFTPTransferGateway;
/**
 * sftp文件查询的实现.
 * 
 * @author zhangshihao
 *
 */
public class SFTPLsImpl implements Ls {
	/**
	 * 加载日志类.
	 */
	private static Logger LOGGER = LoggerFactory.getLogger(SFTPLsImpl.class);
	/**
	 * spring integration-sftp gateway.
	 */
	private SFTPTransferGateway sftpTransferGateway;
	/**
	 * 远端目录.
	 */
	private String remoteFolderPath;

	public SFTPLsImpl(String remoteFolderPath, SFTPTransferGateway sftpTransferGateway) {
		this.sftpTransferGateway = sftpTransferGateway;
		this.remoteFolderPath = remoteFolderPath;
	}

	@Override
	public List<String> listFile() throws IOException {
		LOGGER.info("get lsFile remote folder path: {}", remoteFolderPath);
		return sftpTransferGateway.lsFile(remoteFolderPath);
	}
}
