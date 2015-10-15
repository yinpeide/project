/**
 *ade
 *2015年10月15日
 * 
 */
package com.test.mybatis;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.itcast.entity.Person;
import com.itcast.service.PersonService;
import com.itcast.util.JsonUtils;

/**
 * @author 尹培德
 * @time 2015年10月15日下午11:18:57
 */


@RunWith(SpringJUnit4ClassRunner.class)     //表示继承了SpringJUnit4ClassRunner类  
@ContextConfiguration(locations = {"classpath:spring/applicationContext.xml"})  
public class Testmybatis {
	
	private static Logger logger = Logger.getLogger(Testmybatis.class); 
	@Resource(name="personService")
	private PersonService personService;
	
	@Test
	public void testGetPerson(){
		Integer id = 1;
		Person p = personService.getById(id);
		logger.info(JsonUtils.toJson(p));
	};
	
}
