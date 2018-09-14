package com.zsh.demo.repository.behavior.impl;

import java.io.File;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;

import com.zsh.demo.repository.behavior.Get;
import com.zsh.demo.repository.exception.TransferGenericResourceException;

/**
 * 普通文件下载的实现.
 * 
 * @author Henry
 *
 */
public class GenericGetImpl implements Get {
	/**
	 * 加载日志类.
	 */
	private static Logger LOGGER = LoggerFactory.getLogger(GenericGetImpl.class);
	/**
	 * 目标目录.
	 */
	private File destinationDirectory;

	public GenericGetImpl(File destinationDirectory) {
		this.destinationDirectory = destinationDirectory;
	}

	@Override
	public Resource getResource(String filename) throws TransferGenericResourceException {
		File destinationFile = new File(destinationDirectory, filename);
		if (destinationFile.exists()) {
			return new FileSystemResource(destinationFile);
		} else {
			LOGGER.error("Resource not exist");
			throw new TransferGenericResourceException("Resource not exist");
		}
	}
}
