package com.zsh.demo.repository;

import com.zsh.demo.repository.behavior.impl.SFTPDeleteImpl;
import com.zsh.demo.repository.behavior.impl.SFTPGetImpl;
import com.zsh.demo.repository.behavior.impl.SFTPLsImpl;
import com.zsh.demo.repository.behavior.impl.SFTPPutImpl;
import com.zsh.demo.repository.gateway.SFTPTransferGateway;

/**
 * sftp操作的实体类.
 * 
 * @author zhangshihao
 *
 */
public class SFTPRepository extends Repository {

	public SFTPRepository(String remoteDirectory, SFTPTransferGateway sftpTransferGateway) {
		this.operationDirectory = remoteDirectory;
		this.ls = new SFTPLsImpl(remoteDirectory, sftpTransferGateway);
		this.get = new SFTPGetImpl(remoteDirectory, sftpTransferGateway);
		this.put = new SFTPPutImpl(remoteDirectory, sftpTransferGateway);
		this.delete = new SFTPDeleteImpl(remoteDirectory, sftpTransferGateway);
	}

	@Override
	public String getDirectory() {
		return (String) operationDirectory;
	}

}
