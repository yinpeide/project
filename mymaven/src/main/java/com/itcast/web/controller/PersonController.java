/**
 * 
 */
package com.itcast.web.controller;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
@RequestMapping("/person")
public class PersonController extends BaseController{
		
	
		@Resource(name="personService")
		private PersonService personService;
		
		/**
		 * 查询所有
		 * @param model
		 * @return
		 */
		@RequestMapping("list.action")
		public String list(Model model){
			List<Person> list = personService.findList(null);
			model.addAttribute("personList", list);
			return "person/personList";
		}
		
		/**
		 * 跳转到新增队友页面
		 * @param model
		 * @return
		 */
		@RequestMapping("toadd.action")
		public String toAdd(Model model){
			return "person/personCreate";
		}
		
		/**
		 * 新增队友
		 * @param id
		 * @param userName
		 * @param userAge
		 * @param remark
		 * @return
		 */
		@RequestMapping("add.action")
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
		@RequestMapping("toupdate.action")
		public String toUpdate(Integer id,Model model){
			Person p = personService.getById(id);
			model.addAttribute("person", p);
			return "person/personUpdate";
		}
		/**
		 * 修改队友
		 * @param p
		 * @return
		 * @throws IOException 
		 */
		@RequestMapping("update.action")
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
		@RequestMapping("deletebyid.action")
		public String deleteById(Integer id){
			personService.delete(id);
			return "redirect:/person/list.action";
		}
		
		/**
		 * 批量删除
		 * @param ids
		 * @return
		 */
		@RequestMapping("delete.action")
		public String delete(@RequestParam("id") List<Integer> ids){
			personService.delete(ids);
			return "redirect:/person/list.action";
		}
		
		
		
}
