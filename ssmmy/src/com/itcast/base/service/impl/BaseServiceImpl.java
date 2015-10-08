package com.itcast.base.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import com.itcast.base.dao.IBaseDao;
import com.itcast.base.service.IBaseService;

@SuppressWarnings({ "rawtypes", "unchecked" })
public class BaseServiceImpl<T,PK> implements IBaseService<T,PK>{

	
	@Resource
	private IBaseDao baseDao;
	
	@Override
	public T save(T t) {
		return (T) baseDao.save(t);
	}

	
	@Override
	public T getById(PK id) {
		return (T) baseDao.getById(id);
	}

	@Override
	public T update(T t) {
		return (T) baseDao.update(t);
	}

	@Override
	public Integer delete(List<PK> list) {
		return baseDao.delete(list);
	}

	@Override
	public Integer delete(PK id){
		return baseDao.delete(id);
	}
	
	@Override
	public List<T> findList(Map<String, Object> map) {
		return baseDao.findList(map);
	}

}
