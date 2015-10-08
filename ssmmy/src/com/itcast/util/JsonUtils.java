/**
 *ade
 *2015年8月4日
 * 
 */
package com.itcast.util;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author 尹培德
 * @time 2015年8月4日下午10:52:23
 */
public class JsonUtils {
	
	/**
	 * json串转换为Map对象
	 * @return
	 */
	public static Map<String,Object> toMap(String values){
		ObjectMapper mapper = new ObjectMapper();
		Map<String, Object> results = new HashMap<String, Object>();
		try {
			@SuppressWarnings("unchecked")
			Map<String, Object> tmps = mapper.readValue(values, Map.class);
			// 清除值为空的参数
			for (Entry<String, Object> en : tmps.entrySet()) {
				if (!StringUtils.isEmpty(en.getValue())) {
					results.put(en.getKey(), en.getValue());
				}
			}
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return results;
	}
	
	/**
	 * json转换为entity
	 * @param json
	 * @param entity
	 * @return
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static Object toEntity(String json,Class entity){
		ObjectMapper mapper = new ObjectMapper();
		Object result=null;
		try {
			result= mapper.readValue(json, entity);
		} catch (JsonParseException e) {
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	/**
	 * 对象---->json字符串
	 * @param o
	 * @return
	 */
	public static String toJson(Object o){
		ObjectMapper objectMapper = new ObjectMapper();
		String json = "";
		try {
			json = objectMapper.writeValueAsString(o);
		} catch (JsonGenerationException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return json;
	};
	
	/**
	 * map-->json字符串
	 * @param map
	 * @return
	 */
	public static String toJson(Map<String,Object> map){
		ObjectMapper objectMapper = new ObjectMapper();
		String json = "";
		try {
			json = objectMapper.writeValueAsString(map);
		} catch (JsonGenerationException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return json;
	}

	/**
	 * 将实体对象的属性转为key-value的键值对
	 * 
	 * @param entity
	 * @return
	 */
	public static Map<String, Object> entityToMap(Object entity) {
		return toMap(toJson(entity));
	}
	
}
