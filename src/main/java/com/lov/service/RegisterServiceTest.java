package com.lov.service;

import static org.junit.Assert.fail;

import javax.annotation.Resource;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.lovegis.util.Util;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({
    "classpath:applicationContext-dao.xml",
	"classpath:applicationContext-service.xml",
	"classpath:applicationContext-transaction.xml",
})

public class RegisterServiceTest {
	@Resource RegisterService registerService;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Test
	public void testAddUser() {
		fail("Not yet implemented");
	}

	@Test
	public void testJudgeEmail() {
		Util.logger.debug(registerService.judgeEmail("找不到的account"));	
	}

	@Test
	public void testJudgeNickName() {
		Util.logger.debug(registerService.judgeNickName("找不到的nickname"));	
	}

}
