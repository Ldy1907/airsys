package service.test;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import config.AppConfig;
import config.TestConfig;
import entity.Account;
import service.prototype.IAccountService;
import util.Pager;

/**
* 
*
* @author DanyangLi
*/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={TestConfig.class})
public class AccountServiceTest {
   @Autowired
   private IAccountService actServict;
   
   @Test
   public void testServiceAccount(){
	   Account act = actServict.searchAccount(14);
	   System.out.println(act);
   }
   
   
   @Test
   public void testPagedList(){
	 Pager<Account> pager = (Pager<Account>) actServict.listPaged(1, 100);
	   for(Account act : pager.getData()){
		   System.out.println(act);
	   }
	   System.out.println("共有"+pager.getTotal()+"页");
   }
	
}
