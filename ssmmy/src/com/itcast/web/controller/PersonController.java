/**
 * 
 */
package com.itcast.web.controller;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

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

/**
 * @author 尹培德
 * @time 2015年7月29日上午9:22:32
 */
@Controller
public class PersonController{
		
	
		@Resource(name="personService")
		private PersonService personService;
		
		@InitBinder
		//此方法用于日期的转换，如果未加，当页面日期格式转换错误，将报400错误，实际是因为此方法
		public void initBinder(WebDataBinder binder) {
			DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			dateFormat.setLenient(true);
			binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
		}
		
		/**
		 * 查询所有
		 * @param model
		 * @return
		 */
		@RequestMapping("/person/list.action")
		public String list(Model model){
			List<Person> list = personService.findList(null);
			model.addAttribute("personList", list);
			return "person/personList.jsp";
		}
		
		/**
		 * 跳转到新增队友页面
		 * @param model
		 * @return
		 */
		@RequestMapping("/person/toadd.action")
		public String toAdd(Model model){
			return "person/personCreate.jsp";
		}
		
		/**
		 * 新增队友
		 * @param id
		 * @param userName
		 * @param userAge
		 * @param remark
		 * @return
		 */
		@RequestMapping("/person/add.action")
		public String add(String userName,int userAge,String remark,Date joinDate){
			Person p = new Person();
			p.setUserName(userName);
			p.setUserAge(userAge);
			p.setRemark(remark);
			p.setJoinDate(joinDate);
			personService.save(p);
			return "redirect:/person/list.action";
		}
		
		/**
		 * 跳转到修改队友页面
		 * @param id
		 * @param model
		 * @return
		 */
		@RequestMapping("/person/toupdate.action")
		public String toUpdate(Integer id,Model model){
			Person p = personService.getById(id);
			model.addAttribute("person", p);
			return "person/personUpdate.jsp";
		}
		/**
		 * 修改队友
		 * @param p
		 * @return
		 * @throws IOException 
		 */
		@RequestMapping("/person/update.action")
		public String update(Person p,@RequestParam(required=true)MultipartFile uploadfile) throws IOException{
			//FileUtils.writeByteArrayToFile(new File("d:/b.png"), uploadfile.getBytes());
			personService.update(p);
			return "redirect:/person/list.action";
		}
		
		/**
		 * 主键删除
		 * @param id
		 * @return
		 */
		@RequestMapping("/person/deletebyid.action")
		public String deleteById(Integer id){
			personService.delete(id);
			return "redirect:/person/list.action";
		}
		
		/**
		 * 批量删除
		 * @param ids
		 * @return
		 */
		@RequestMapping("/person/delete.action")
		public String delete(@RequestParam("id") List<Integer> ids){
			personService.delete(ids);
			return "redirect:/person/list.action";
		}
		
		/**
		 * 登录
		 * @param userName
		 * @param password
		 * @return
		 */
		@RequestMapping("/login.action")
		public String login(String userName,String password,Model model,HttpSession session){
			Map<String,Object> map = new HashMap<String,Object>();
			map.put("userName", userName);
			map.put("password", password);
			List<Person> personList =  personService.findList(map);
			if(personList.size() > 0 && userName!=null && userName!="" ){
				session.setAttribute("username",userName);
				List<Person> list = personService.findList(null);
				model.addAttribute("personList", list);
				return "person/personList.jsp";
			}else{
				if(userName!="" && userName!=null){
					model.addAttribute("error", "亲爱的，您还没有权限登录系统哦");
				}
				return "login.jsp";
			}
		}
		
		
		
}
