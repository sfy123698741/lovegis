package com.lovegis.service;

import javax.annotation.Resource;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.lovegis.pojo.SourceOne;
import com.lovegis.util.Util;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({
    "classpath:applicationContext-dao.xml",
	"classpath:applicationContext-service.xml",
	"classpath:applicationContext-transaction.xml",
})

public class SourceServieTest {
	@Resource SourceServie source;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Test
	public void testGetSourceOneList() {
		//Util.logger.debug(source.sort("1", "sortByTime", "猜拳").get(0)+"哒哒哒");
		SourceOne sourceOne= (SourceOne) source.sort("1", "sortByTime", "%").get(0);
		Util.logger.debug(sourceOne.getName()+"哒哒哒");
	//	Util.logger.debug(source.getSourceOneList().get(1)+"llllll");
	}

}
