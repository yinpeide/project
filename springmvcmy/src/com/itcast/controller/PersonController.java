package com.itcast.controller;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.itcast.entity.Person;
import com.itcast.service.PersonService;


@Controller
public class PersonController {

	/*
	 * 注入service
	 */
	@Resource
	private PersonService personService;
	
	@InitBinder
	//此方法用于日期的转换，如果未加，当页面日期格式转换错误，将报400错误，实际是因为此方法
	public void initBinder(WebDataBinder binder) {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		dateFormat.setLenient(true);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
	}
	
	/**
	 * 展示人员列表
	 * @param model
	 * @return
	 */
	@RequestMapping("/person/listAll.action")
	public String listAll(Map<String,Object> model){
		
		List<Person> personList = personService.listAll();
		
		//list最终要在页面中调用
		model.put("personList", personList); //springmvc 在转向之前就set 动作有了 我们不用管了
		
		return "person/jPersonList";
	}
	
	/**
	 * 跳转到新增页面
	 * @return
	 */
	@RequestMapping("/person/tocreate.action")
	public String toCreate(){
		return "person/jPersonCreate";
	}
	
	/**
	 * 新增
	 * @param name
	 * @param age
	 * @return
	 */
	@RequestMapping("/person/insert.action")
	public String insert(String name,Integer age,Date joinDate){
		Person p = new Person();
		p.setAge(age);
		p.setName(name);
		p.setJoinDate(joinDate);
		personService.insert(p);
		return "redirect:/person/listAll.action";
	}
	
	/**
	 * 跳转到修改页面
	 * @param id
	 * @return
	 */
	@RequestMapping("/person/toupdate.action")
	public String toupdate(Integer id,Model model){
		//跳转页面关键是传递数据到修改页面
		Person p = personService.getById(id);
		//将p传递到修改页面
		model.addAttribute("person",p);
		return "person/jPersonUpdate";
	}
	
	/**
	 * 修改页面
	 * @param id
	 * @param model
	 * @throws IOException 
	 */
	@RequestMapping("/person/update.action")
	public String update( Person p,@RequestParam(required=true)MultipartFile uploadfile) throws IOException{
		
			FileUtils.writeByteArrayToFile(new File("/Users/ade/b.png"), uploadfile.getBytes());
			
			personService.update(p);
			
			return "redirect:/person/listAll.action";
	}
	
	/**
	 * 删除单条信息
	 * @param id
	 * @return
	 */
	@RequestMapping("/person/deleteById.action")
	public String deleteById(Integer id){
		
		personService.deleteById(id);
		return "redirect:/person/listAll.action";
	}
	
	/**
	 * 批量删除
	 * @param id
	 * @return
	 */
	@RequestMapping("/person/delete.action")
	public String delete(@RequestParam("id") Integer[] ids){
		
		personService.delete(ids);
		return "redirect:/person/listAll.action";
	}
	
}
