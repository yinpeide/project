package com.itcast.base.service;

import java.util.List;
import java.util.Map;

public interface IBaseService<T,PK> {
	
	T save(T t);

	T getById(PK id);

	T update(T t);

	Integer delete(List<PK> list);

	Integer delete(PK id);
	
	List<T> findList(Map<String, Object> map);
	
	
}
