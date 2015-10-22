/**
 *ade
 *2015年10月22日
 * 
 */
package com.itcast.xpath.outtree;

/**
 * @author 尹培德
 * @time 2015年10月22日上午12:08:51
 */

import java.util.ArrayList;
import java.util.List;



public class Category {

	private Long id;

	private String name;

	private String description;

	private Long parentId;

	private Long sort;

	private Long createTime;

	private List<Category> children = new ArrayList<Category>();

	public List<Category> getChildren() {

		return children;

	}

	public void setChildren(List<Category> children) {

		this.children = children;

	}

	public Long getId() {

		return id;

	}

	public void setId(Long id) {

		this.id = id;

	}

	public String getName() {

		return name;

	}

	public void setName(String name) {

		this.name = name;

	}

	public String getDescription() {

		return description;

	}

	public void setDescription(String description) {

		this.description = description;

	}

	public Long getParentId() {

		return parentId;

	}

	public void setParentId(Long parentId) {

		this.parentId = parentId;

	}

	public Long getSort() {

		return sort;

	}

	public void setSort(Long sort) {

		this.sort = sort;

	}

	public Long getCreateTime() {

		return createTime;

	}

	public void setCreateTime(Long createTime) {

		this.createTime = createTime;

	}

}