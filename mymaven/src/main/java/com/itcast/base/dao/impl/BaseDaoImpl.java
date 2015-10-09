package com.itcast.base.dao.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.itcast.base.dao.IBaseDao;

public abstract class BaseDaoImpl<T,PK> extends SqlSessionDaoSupport implements IBaseDao<T,PK>{
	
	@Resource
	public void setSqlSessionTemplate(SqlSessionFactory sqlSessionFactory) {
		super.setSqlSessionFactory(sqlSessionFactory);
	}
	
	public static final String KEY_CONNECTOR = ".";

	public static final String KEY_GET_BY_ID = "getById";

	public static final String KEY_QUERY = "query";

	public static final String KEY_DELETE = "delete";

	public static final String KEY_DELETE_BY_ID = "deleteById";

	public static final String KEY_INSERT = "insert";

	public static final String KEY_UPDATE = "update";
	
	//一个获取key的通用的方法
	public abstract String getNamespace();

	protected String sqlKey(String key) {
		return this.getNamespace().concat(KEY_CONNECTOR).concat(key);
	}
	
	/**
	 * 查询全部
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public List<T> findList(Map map) {
		return this.findList(KEY_QUERY,map);
	}

	@SuppressWarnings("rawtypes")
	@Override
	public List<T> findList(String key, Map map) {
		return this.getSqlSession().selectList(this.sqlKey(key), map);
	}
	
	/**
	 * 主键查询
	 */
	@Override
	public T getById(PK id) {
		return this.getById(KEY_GET_BY_ID, id);
	}

	@Override
	public T getById(String key, PK id) {
		return this.getSqlSession().selectOne(this.sqlKey(key), id);
	}
	
	/**
	 * 保存
	 */
	@Override
	public T save(T t) {
		return this.save(KEY_INSERT,t);
	}

	@Override
	public T save(String key, T t) {
		this.getSqlSession().insert(this.sqlKey(key), t);
		return t; 
	}
	
	/**
	 * 修改
	 */
	@Override
	public T update(T t) {
		return this.update(KEY_UPDATE, t);
	}

	@Override
	public T update(String key, T t) {
		this.getSqlSession().update(this.sqlKey(key), t);
		return t; 
	}

	/**
	 * 主键删除
	 */
	@Override
	public Integer delete(PK id) {
		return this.delete(KEY_DELETE_BY_ID, id);
	}

	@Override
	public Integer delete(String key, PK id) {
		return this.getSqlSession().delete(this.sqlKey(key), id);
	}
	
	/**
	 * 根据条件删除
	 */
	@Override
	public Integer delete(List<PK> list) {
		return this.delete(KEY_DELETE, list);
	}

	@Override
	public Integer delete(String key, List<PK> list) {
		return this.getSqlSession().delete(this.sqlKey(key),list);
	}
	
	
}
