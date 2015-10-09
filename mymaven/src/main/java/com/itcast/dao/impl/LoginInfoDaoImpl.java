package com.itcast.dao.impl;

import org.springframework.stereotype.Repository;

import com.itcast.base.dao.impl.BaseDaoImpl;
import com.itcast.dao.LoginInfoDao;
import com.itcast.entity.LoginInfo;

@Repository("loginInfoDao")
public class LoginInfoDaoImpl extends BaseDaoImpl<LoginInfo, Integer> implements LoginInfoDao{
	private static final String NAME_SPACE = LoginInfo.class.getName();
	 
	@Override
	public String getNamespace() {
		return NAME_SPACE;
	}
}
