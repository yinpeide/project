/**
 * 
 */
package com.itcast.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.itcast.base.service.impl.BaseServiceImpl;
import com.itcast.dao.PersonDao;
import com.itcast.entity.Person;
import com.itcast.service.PersonService;

/**
 * @author 尹培德
 * @time 2015年7月29日上午9:19:08
 */
@Service("personService")
public class PersonServiceImpl extends BaseServiceImpl<Person,Integer> implements PersonService{
	@Resource(name="personDao")
	private PersonDao personDao;

}
