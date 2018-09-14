package com.zsh.demo.repository.behavior;

import java.io.IOException;
import java.util.List;

/**
 * 查询文件的统一接口.
 * 
 * @author zhangshihao
 *
 */
public interface Ls {

	/**
	 * 查询文件列表.
	 * 
	 * @return 文件名列表
	 * @throws IOException
	 *             e
	 */
	List<String> listFile() throws IOException;
}
