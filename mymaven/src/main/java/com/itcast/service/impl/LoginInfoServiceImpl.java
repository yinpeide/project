package com.itcast.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.itcast.base.service.impl.BaseServiceImpl;
import com.itcast.dao.LoginInfoDao;
import com.itcast.entity.LoginInfo;
import com.itcast.service.LoginInfoService;

@Service("loginInfoService")
public class LoginInfoServiceImpl extends BaseServiceImpl<LoginInfo, Integer> implements LoginInfoService{
	
	@Resource(name="loginInfoDao")
	private LoginInfoDao loginInfoDao;
}
