package com.itcast.web.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.itcast.entity.Person;
import com.itcast.util.JsonUtils;

@Controller
public class FormController {

	
	@InitBinder
	//此方法用于日期的转换，如果未加，当页面日期格式转换错误，将报400错误，实际是因为此方法
	public void initBinder(WebDataBinder binder) {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		dateFormat.setLenient(true);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
	}
	
	@RequestMapping("form/basic.action")
	public String basicform(Person person,Model model,@RequestParam("params") String values ){
		Map<String, Object> map =  JsonUtils.toMap(values);
		System.out.println(map);
		System.out.println(person.toString());
		model.addAttribute("message", person);
		return "getData.jsp";
	};
}
