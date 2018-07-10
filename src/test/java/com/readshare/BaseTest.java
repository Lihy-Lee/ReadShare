package com.readshare;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * 配置spring和Junit整合,Junit启动时加载springIOC容器
 * 
 * @author LHY
 *
 */
// 告诉Junit用什么类去跑测试单元
// 说明配置文件的路径
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "classpath:spring/spring-dao.xml", "classpath:spring/spring-service.xml" })
public class BaseTest {
	@Test
	public void test() {
		
	}

}
