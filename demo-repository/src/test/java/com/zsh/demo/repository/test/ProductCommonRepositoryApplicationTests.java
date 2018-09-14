package com.zsh.demo.repository.test;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.zsh.demo.repository.Repository;
import com.zsh.demo.repository.config.SFTPConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { SFTPConfig.class })
public class ProductCommonRepositoryApplicationTests {

	@Autowired
	@Qualifier("sftpRepository")
	private Repository repository;

	@Test
	public void sftpGetTest() throws IOException {
		Resource re = repository.get("CNMVTM2018052309414649801389.xml");
		System.out.println("----"+repository.getDirectory());
		File file = new File("C:\\New folder\\aaa.xml");
		FileUtils.copyInputStreamToFile(re.getInputStream(), file);
	}

	@Test
	public void sftpPutTest() throws IOException {
		File file = new File("C:\\New folder\\bbb.xml");
		Resource re = new FileSystemResource(file);
		repository.put(re, "ccc.xml");
	}
	
	@Test
	public void sftpRmTest() throws IOException {
		repository.rm("bbb.xml");
	}
	
	@Test
	public void sftpLsTest() throws IOException {
		repository.ls();
	}

}
