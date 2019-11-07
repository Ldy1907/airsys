package service.prototype;

import java.util.List;

import entity.User;
import util.MiniPager;

/**
* 
*
* @author DanyangLi
*/
public interface IUserService {
		@MiniPager(tableName="user")
		List<User> listUser(int pageNo,int pageSize);
}
