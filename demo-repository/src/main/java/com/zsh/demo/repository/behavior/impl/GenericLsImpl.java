package com.zsh.demo.repository.behavior.impl;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.zsh.demo.repository.behavior.Ls;
import com.zsh.demo.repository.exception.TransferGenericResourceException;
/**
 * 普通文件查询的实现.
 * @author zhangshihao
 *
 */
public class GenericLsImpl implements Ls{
	/**
	 * 加载日志类.
	 */
	private static Logger LOGGER = LoggerFactory.getLogger(GenericLsImpl.class);
	/**
	 * 目标目录.
	 */
	private File destinationDirectory;

	public GenericLsImpl (File destinationDirectory) {
		this.destinationDirectory = destinationDirectory;
	}
	
	@Override
	public List<String> listFile() throws IOException {
		if (destinationDirectory.exists()) {
			File[] files = destinationDirectory.listFiles();
			List<String> list = new ArrayList<String>();
			for (File file : files) {
				list.add(file.getName());
			}
			return list;
		} else {
			LOGGER.error("target folder not exist!");
			throw new TransferGenericResourceException("target folder not exist!");
		}
	}
}
