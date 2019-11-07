package service.prototype;

import java.util.List;

import entity.Account;
import util.MiniPager;
import util.Pager;

/**
* 
*    业务类的接口
* @author DanyangLi
*/
public interface IAccountService {
	void transfer(Account from,Account to,double money);
	
	@MiniPager(tableName = "account")
	 Account searchAccount(int id);
	
	List<Account> listAccounts(int pageNo,int pageSize);
	
	@MiniPager(tableName = "account")
	 List<Account> listPaged(int pageNo,int pageSize);
	
}
