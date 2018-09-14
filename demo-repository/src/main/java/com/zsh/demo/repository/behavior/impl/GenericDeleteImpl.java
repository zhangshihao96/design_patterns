package com.zsh.demo.repository.behavior.impl;

import java.io.File;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.zsh.demo.repository.behavior.Delete;

/**
 * 普通文件删除的实现.
 * 
 * @author zhangshihao
 *
 */
public class GenericDeleteImpl implements Delete {
	/**
	 * 加载日志类.
	 */
	private static Logger LOGGER = LoggerFactory.getLogger(GenericDeleteImpl.class);
	/**
	 * 目标目录.
	 */
	private File destinationDirectory;

	public GenericDeleteImpl(File destinationDirectory) {
		this.destinationDirectory = destinationDirectory;
	}

	@Override
	public boolean deleteResource(String filename) {
		File destinationFile = new File(destinationDirectory, filename);
		if (destinationFile.exists()) {
			return destinationFile.delete();
		}
		LOGGER.warn("The resource would be removed not exist!");
		return true;
	}
}
