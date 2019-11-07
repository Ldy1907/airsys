package dao.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import config.TestConfig;
import dao.prototype.IAccountDao;
import entity.Account;

/*
 * dao  spring单元测试
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={TestConfig.class})
public class TestAccountDao {
	@Autowired
	private IAccountDao actDao;
	
	@Test
	public void testFindById(){
		Account act = actDao.find(10);
		System.out.println(act);
	}
	
	@Test
	public void testAddOrUpdate(){
		Account act = new Account("linda",10000);
	//	act.setId(10);
		actDao.saveorupdate(act);
	}
	
	@Test
	public void testFindAll(){
		List<Account> act = actDao.findAll();
		for(Account a:act){
			System.out.println(a);
		}

	}
	
	@Test 
	public void testDelete(){
		Account act = new Account();
		actDao.delete(2);
	}
	
	
	
	
	
}
