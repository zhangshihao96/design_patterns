package com.zsh.demo.repository.behavior.impl;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.Resource;

import com.zsh.demo.repository.behavior.Put;
import com.zsh.demo.repository.gateway.SFTPTransferGateway;
/**
 * sftp文件上传的实现.
 * 
 * @author zhangshihao
 *
 */
public class SFTPPutImpl implements Put{
	/**
	 * 加载日志类.
	 */
	private static Logger LOGGER = LoggerFactory.getLogger(SFTPPutImpl.class);
	/**
	 * spring integration-sftp headers
	 */
	private static final String HEADERS_REMOTEFILEPARH = "targetDirectory";
    /**
     * spring integration-sftp headers
     */
	private static final String HEADERS_REMOTEFILENAME = "remoteFileName";
	/**
	 * spring integration-sftp gateway.
	 */
	private SFTPTransferGateway sftpTransferGateway;
	/**
	 * 远端目录.
	 */
	private String remoteFolderPath;

	public SFTPPutImpl(String remoteFolderPath, SFTPTransferGateway sftpTransferGateway) {
		this.sftpTransferGateway = sftpTransferGateway;
		this.remoteFolderPath = remoteFolderPath;
	}
	
	@Override
	public String uploadResource(Resource resource, String rename) throws IOException {
		LOGGER.info("get upload remote folder path: {}", remoteFolderPath);
		Map<String, String> headers = new HashMap<String, String>();
		headers.put(HEADERS_REMOTEFILEPARH, remoteFolderPath);
		headers.put(HEADERS_REMOTEFILENAME, rename);
		return sftpTransferGateway.putFile(headers, IOUtils.toByteArray(resource.getInputStream()));
	}
}
