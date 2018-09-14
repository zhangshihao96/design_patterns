package com.zsh.demo.repository.behavior;

/**
 * 删除资源的统一接口.
 * 
 * @author zhangshihao
 *
 */
public interface Delete {

	/**
	 * 删除资源的接口.
	 * 
	 * @param filename
	 *            需要删除的资源名称.
	 * @return boolean 是否成功删除
	 */
	boolean deleteResource(String filename);
}
