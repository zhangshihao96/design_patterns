package com.zsh.demo.repository;

import java.io.IOException;
import java.util.List;

import org.springframework.core.io.Resource;

import com.zsh.demo.repository.behavior.Delete;
import com.zsh.demo.repository.behavior.Get;
import com.zsh.demo.repository.behavior.Ls;
import com.zsh.demo.repository.behavior.Put;

/**
 * 抽象仓储。
 * 
 * 拥有查询、下载、上传、删除四个基本行为。
 * 
 * 所有能够真正做资源操作的仓储都将继承此类。
 * 
 * @author zhangshihao
 *
 */
public abstract class Repository {
	/**
	 * 查询.
	 */
	protected Ls ls;
	/**
	 * 获取.
	 */
	protected Get get;
	/**
	 * 上传.
	 */
	protected Put put;
	/**
	 * 删除.
	 */
	protected Delete delete;
	/**
	 * 该仓储可操作的目录.
	 */
	protected Object operationDirectory;

	/**
	 * 获取实际仓储操作的目录.
	 * 
	 * @return directory path
	 */
	public abstract String getDirectory();

	/**
	 * 查询目录.
	 * 
	 * @return 文件名列表
	 * @throws IOException
	 *             e
	 */
	public List<String> ls() throws IOException {
		return ls.listFile();
	}

	/**
	 * 获取资源.
	 * 
	 * @param filename
	 *            文件名
	 * @return 所需资源
	 * @throws IOException
	 *             e
	 */
	public Resource get(String filename) throws IOException {
		return get.getResource(filename);
	}

	/**
	 * 上传资源.
	 * 
	 * @param resource
	 *            上传资源
	 * @param rename
	 *            上传后的文件名
	 * @return String 
	 *            上传后的存放路径
	 * @throws IOException
	 *             e
	 */
	public String put(Resource resource, String rename) throws IOException {
		return put.uploadResource(resource, rename);
	}

	/**
	 * 删除资源.
	 * 
	 * @param filename
	 *            文件名
	 * @return boolean
	 */
	public boolean rm(String filename) {
		return delete.deleteResource(filename);
	}

}
