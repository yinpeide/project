package com.itcast.dao.impl;

import org.springframework.stereotype.Repository;

import com.itcast.base.dao.impl.BaseDaoImpl;
import com.itcast.dao.PersonDao;
import com.itcast.entity.Person;

/**
 * @author 尹培德
 * @time 2015年7月28日下午9:16:12
 */
@Repository("personDao")
public class PersonDaoImpl extends BaseDaoImpl<Person,Integer> implements PersonDao{

	private static final String NAME_SPACE = Person.class.getName();
	 
	@Override
	public String getNamespace() {
		return NAME_SPACE;
	}

	
}
