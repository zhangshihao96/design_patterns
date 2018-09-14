package com.zsh.demo.repository;

import java.io.File;

import com.zsh.demo.repository.behavior.impl.GenericDeleteImpl;
import com.zsh.demo.repository.behavior.impl.GenericGetImpl;
import com.zsh.demo.repository.behavior.impl.GenericLsImpl;
import com.zsh.demo.repository.behavior.impl.GenericPutImpl;

/**
 * 一般文件操作的实体类.
 * 
 * @author zhangshihao
 *
 */
public class GenericResourceRepository extends Repository {

	public GenericResourceRepository(File destination) {
		this.operationDirectory = destination;
		this.ls = new GenericLsImpl(destination);
		this.get = new GenericGetImpl(destination);
		this.put = new GenericPutImpl(destination);
		this.delete = new GenericDeleteImpl(destination);
	}

	@Override
	public String getDirectory() {
		return ((File) operationDirectory).getPath();
	}

}
