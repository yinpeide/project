package com.itcast.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.itcast.entity.Person;

/**
 * 
 * @discription
 * @author 尹培德
 * @Time 2015年7月21日下午2:44:15
 */
@Service
public class PersonService {
	
	/*
	 * 十个人信息
	 */
	private static Map<Integer,Person> map = new HashMap<Integer, Person>();
	private static Integer id = 0;
	static {
		for(int i=0;i<10;i++){
			Person p = new Person();
			p.setId(id++);
			p.setName("tom"+i);
			p.setAge(38+i);
			p.setJoinDate(new Date());
			map.put(i, p);
		}
	}
	/*
	 * 获取十个人信息
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<Person> listAll(){
		 return new ArrayList( map.values());
	}
	/*
	 * 新增人的信息
	 */
	public void insert(Person p) {
		p.setId(id++);
		map.put(p.getId(), p);
	}
	
	/*
	 * 修改人信息
	 */
	public void update(Person p){
		map.put(p.getId(), p);
	}
	
	/*
	 * 删除单条信息
	 */
	public void deleteById(Integer id){
		map.remove(id);
	}
	
	/*
	 * 批量删除
	 */
	public void delete(Integer[] ids){
		
		for(int i=0;i<ids.length;i++){
			map.remove(ids[i]);
		}
	}
	
	/*
	 * 通过id获取一个人的信息
	 */
	public Person getById(Integer id){
		return map.get(id);
	}
	
	
}
