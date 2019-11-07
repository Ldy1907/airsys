package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;

import entity.Account;
import service.prototype.IAccountService;

/**
* 
*  账户管理Controller类
* @author DanyangLi
*/

@Controller     //--@Component
public class AccountController {
		
    @Autowired
    private IAccountService actService;
	
	
	    @RequestMapping("/user")
		@ResponseBody
	public String  getUser(){
				return "hello world";
	}
	    
	
	    @RequestMapping("/user1/{id}")
		@ResponseBody
		public String  getUser1(@PathVariable("id") int id){
			   Account act = actService.searchAccount(id);
	         	return JSON.toJSONString(act);
		}
	    @RequestMapping("/deleteUser/{id}")
		@ResponseBody
		public String  deleteUser(@PathVariable("id") int id){
			  
	         	return "delete success....";
		}
	    @RequestMapping("/updateUser/{id}")
		@ResponseBody
		public String  updateUser(@PathVariable("id") int id){
			  
	         	return "update success....";
		}
	    
	    
	    /*
	     * 返回的是页面，并且能给页面传递数据
	     */
	    @RequestMapping("/users")
	    public ModelAndView getUsers(){
	    	
	    	ModelAndView mv = new ModelAndView("list");
	    	List<Account> acts = actService.listPaged(1, 100);
	   // 	System.out.println(acts);
	    	mv.addObject("acts", acts);
	    	return mv;
	    }
	    
}
