package com.zsh.demo.repository.behavior;

import java.io.IOException;

import org.springframework.core.io.Resource;

/**
 * 获取资源的统一接口.
 * 
 * @author zhangshihao
 *
 */
public interface Get {

	/**
	 * 获取资源的接口.
	 * 
	 * @param filename
	 *            需要获取的文件名
	 * @return resource 所需资源
	 * @throws IOException
	 *             e
	 */
	Resource getResource(String filename) throws IOException;
}
