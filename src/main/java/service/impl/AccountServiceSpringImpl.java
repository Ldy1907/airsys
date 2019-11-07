package service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.prototype.IAccountDao;
import entity.Account;
import service.prototype.IAccountService;

/**
* 
* 业务类的实现 实现接口
* @author DanyangLi
*/
@Service("accountServiceSpringImpl")    //和component一样
public class AccountServiceSpringImpl  implements IAccountService{

	@Autowired
	private IAccountDao actDao;
	
	//转账
	@Override //涉及到事务 Spring 声明式的Transaction处理（AOP动态代理模式的应用）
	public void transfer(Account from, Account to, double money) {
		
		
			
	}

	//根据id查账号
	@Override
	public Account searchAccount(int id) {
		return actDao.find(id);
	}

	//分页查询
	@Override
	public List<Account> listAccounts(int pageNo, int pageSize) {
		return null;
	}

	//分页查询
	@Override
	public List<Account> listPaged(int pageNo, int pageSize) {
		return actDao.find((pageNo-1)*pageSize, pageSize);
	}
    
}
