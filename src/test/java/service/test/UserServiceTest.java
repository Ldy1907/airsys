package service.test;



import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import config.AppConfig;
import entity.User;
import service.prototype.IUserService;
import util.Pager;

/**
* 
*用户单元测试
* @author DanyangLi
*/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={AppConfig.class})
public class UserServiceTest {
 @Autowired
	private IUserService userService;
	
	 @Test
	 public void testPager(){
		 Pager<User> pager = (Pager<User>) userService.listUser(2, 5);
		 for(User user:pager.getData()){
			 System.out.println(user);
		 }
		 System.out.println("共有"+pager.getTotal()+"页");
	 }
}
