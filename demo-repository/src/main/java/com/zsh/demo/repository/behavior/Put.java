package com.zsh.demo.repository.behavior;

import java.io.IOException;

import org.springframework.core.io.Resource;
/**
 * 上传资源统一接口.
 * @author zhangshihao
 *
 */
public interface Put {

	/**
	 * 上传资源的接口.
	 * 
	 * @param resource
	 *            上传的资源
	 * @param filename
	 *            上传后的文件名
	 * @throws IOException
	 *             e
	 * @return upload path
	 */
	String uploadResource(Resource resource, String filename) throws IOException;
}
