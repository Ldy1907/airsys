package dao.prototype;

import java.sql.Connection;
import java.util.List;

import entity.Account;
import util.Pager;
/*
 * AccountDao
 */
public interface IAccountDao {
	  
	  //增改
	  void saveorupdate(Account act);
	  //删
	  void delete(int id);
	  //查
	  Account find(int id);
	  List<Account> findAll();

	  //分页查询  你这么返回的是数据 但是我们要做分页光数据是不够的的
	  List<Account> find(int offset,int pageSize);//要想传全部   偏移量为0  总量可以传int的最大值 Integer.MAX_VALUE
     //获取总条目数，为分页做服务的方法，因为你不清楚这个表里有多少条
	  int totalItems();
	  
}
