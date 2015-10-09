package com.itcast.base.dao;

import java.util.List;
import java.util.Map;

/**
 * 
 * @author 尹培德
 * @time 2015年7月29日下午2:12:51
 */
public interface IBaseDao <T,PK>{
	
	/**
	 * 查询方法
	 * @param map
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public List<T> findList(Map map);
	@SuppressWarnings("rawtypes")
	public List<T> findList(String key,Map map);
	/**
	 * 根据主键查询
	 * @param id
	 * @return
	 */
	public T getById(PK id);
	public T getById(String key,PK id);
	/**
	 * 插入
	 * @param t
	 * @return
	 */
	public T save(T t);
	public T save(String key,T t);
	/**
	 * 修改
	 * @param map
	 * @return
	 */
	public T update(T t);
	public T update(String key,T t);
	/**
	 * 根据主键删除
	 * @param id
	 * @return
	 */
	public Integer delete(PK id);
	public Integer delete(String key,PK id);
	
	
	/**
	 * 批量删除
	 * @param map
	 * @return
	 */
	public Integer delete(List<PK> list);
	public Integer delete(String key,List<PK> list);
	
	
}
