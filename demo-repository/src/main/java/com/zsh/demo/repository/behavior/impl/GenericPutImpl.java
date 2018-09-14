package com.zsh.demo.repository.behavior.impl;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;

import com.zsh.demo.repository.behavior.Put;
import com.zsh.demo.repository.exception.TransferGenericResourceException;
/**
 * 普通文件上传的实现.
 * @author zhangshihao
 *
 */
public class GenericPutImpl implements Put{
	/**
	 * 加载日志类.
	 */
	private static Logger LOGGER = LoggerFactory.getLogger(GenericPutImpl.class);
	/**
	 * 目标目录.
	 */
	private File destinationDirectory;
	
	public GenericPutImpl (File destinationDirectory) {
		this.destinationDirectory = destinationDirectory;
	}
	
	@Override
	public String uploadResource(Resource resource, String rename) throws IOException {
		if (resource == null) {
			LOGGER.error("Null resource could not be uploaded!");
			throw new TransferGenericResourceException("Null resource could not be uploaded!");
		}
		transfer(resource, rename);
		return destinationDirectory.getPath() + "/" + rename;
	}
	
	private void transfer(Resource resource, String filename) throws IOException {
		File destinationFile = null;
		if (resource instanceof InputStreamResource) {
			destinationFile = new File(destinationDirectory, filename);
			FileUtils.copyInputStreamToFile(resource.getInputStream(), destinationFile);
		} else if (resource instanceof FileSystemResource) {
			if (filename == null) {
				destinationFile = new File(destinationDirectory, resource.getFilename());
			} else {
				destinationFile = new File(destinationDirectory, filename);
			}
			FileUtils.copyFile(resource.getFile(), destinationFile);
		} else {
			LOGGER.error(resource.getClass().toString() + " This type of resource not support!");
			throw new TransferGenericResourceException(
					resource.getClass().toString() + " This type of resource not support!");
		}
	}

}
