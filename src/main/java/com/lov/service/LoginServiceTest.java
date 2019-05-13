package com.lov.service;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

import javax.annotation.Resource;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.heygis.beans.User;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({
    "classpath:applicationContext-dao.xml",
	"classpath:applicationContext-service.xml",
	"classpath:applicationContext-transaction.xml",
})

public class LoginServiceTest {
	@Resource LoginService loginService;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Test
	public void testLogin() throws NoSuchAlgorithmException, UnsupportedEncodingException {
		System.out.println(loginService.login("1234", "gdyb21LQTcIANtvYMT7QVQ=="));
	}
	@Test
	public void testGetUser() throws Exception {
		System.out.println(loginService.getUser("1234").getQQ());
	}
	@Test
	public void testAddUser() throws Exception {
		User user = new User("sfyCeShi","hhh", "史丰原测试员", "男");
		loginService.addUser(user);
	}
}
