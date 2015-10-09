package com.itcast.web.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.itcast.entity.Person;
import com.itcast.util.JsonUtils;

@Controller
public class FormController extends BaseController {
	
	@RequestMapping("form/basic.action")
	public String basicform(Person person,Model model,@RequestParam("params") String values ){
		Map<String, Object> map =  JsonUtils.toMap(values);
		System.out.println(map);
		System.out.println(person.toString());
		model.addAttribute("message", person);
		return "getData.jsp";
	};
}
