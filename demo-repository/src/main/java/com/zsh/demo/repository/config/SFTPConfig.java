package com.zsh.demo.repository.config;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.integration.file.remote.session.CachingSessionFactory;
import org.springframework.integration.file.remote.session.SessionFactory;
import org.springframework.integration.sftp.session.DefaultSftpSessionFactory;

import com.jcraft.jsch.ChannelSftp.LsEntry;
import com.zsh.demo.repository.Repository;
import com.zsh.demo.repository.SFTPRepository;
import com.zsh.demo.repository.gateway.SFTPTransferGateway;

/**
 * sftp功能的配置文件,若需要开启请将此文件引入spring的上下文环境中.
 * 
 * @author zhangshihao
 *
 */
@Configuration
@ImportResource(locations = { "classpath:zsh/demo/repository/int-sftp.xml" })
public class SFTPConfig {
	/**
	 * sftp主机ip.
	 */
	private String host = "192.168.88.8";
	/**
	 * sftp主机端口号.
	 */
	private String port = "22";
	/**
	 * sftp用户名.
	 */
	private String user = "zhangchong";
	/**
	 * sftp密码.
	 */
	private String privateKeyPassphrase = "zhangchongpassword";
	/**
	 * sftp私钥认证路径.
	 */
	private String privateKeyPath = "C:\\Users\\Henry\\gitHub\\design_patterns\\demo-repository\\src\\main\\resources\\zsh\\demo\\repository\\privatekey";
	/**
	 * sftp远端目录路径.
	 */
	private String sftpPath = "/home/zhangchong/";
	/**
	 * 自动装配spring integration-sftp gateway.
	 */
	@Autowired
	SFTPTransferGateway gateway;

	/**
	 * 注入sftp sessionFactroy.
	 * 
	 * @return SessionFactory
	 */
	@Bean
	@Qualifier("sftpSessionFactory")
	public SessionFactory<LsEntry> sftpSessionFactory() {
		DefaultSftpSessionFactory sessionFactory = new DefaultSftpSessionFactory();
		sessionFactory.setHost(host);
		sessionFactory.setPort(Integer.parseInt(port));
		sessionFactory.setUser(user);
		sessionFactory.setPrivateKeyPassphrase(privateKeyPassphrase);
		Resource privateKey = new FileSystemResource(new File(privateKeyPath));
		sessionFactory.setPrivateKey(privateKey);
		sessionFactory.setAllowUnknownKeys(true);
		CachingSessionFactory<LsEntry> cachingSessionFactory = new CachingSessionFactory<LsEntry>(sessionFactory, 10);
		cachingSessionFactory.setSessionWaitTimeout(1000);
		return cachingSessionFactory;
	}

	/**
	 * 注入sftpRepository
	 * 
	 * @return Repository
	 */
	@Bean
	@Qualifier("sftpRepository")
	public Repository initSFTPRepository() {
		Repository repository = new SFTPRepository(sftpPath, gateway);
		return repository;
	}

}
