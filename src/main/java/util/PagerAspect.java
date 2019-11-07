package util;

import java.lang.reflect.Method;
import java.util.List;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

/**
* 
*  3.自定义分页切面
*  			@Aspect
				@Component
	4.自定义切点  检测service包及子包下的所有方法
			@Pointcut("execution(* service..*(..))")
	5.自定义通知
	
	
* @author DanyangLi
*/
@SuppressWarnings("serial")
@Aspect
@Component
public class PagerAspect {
		
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	//4.自定义切点
	@Pointcut("execution(* service..*(..))")
		public void selfPointcut(){}
	
	//5.自定义的通知
	@Around("selfPointcut()")
	public Object aroundAdvice(ProceedingJoinPoint jp){
		//System.out.println("hello pager");
		//6.编写通知体里面的核心代码(实现通用分页的核心代码)
		//6.1根据jp对象获取method对象
		Object o =null;
		MethodSignature signature = (MethodSignature) jp.getSignature();
		Method m = signature.getMethod();
		
		//6.2  Method对象获取是否还有@MiniPager标注
		MiniPager miniPager = m.getAnnotation(MiniPager.class);
		
		//6.3  做判断  如果没有@MiniPager标注，则执行原始的业务方法
		if(miniPager==null){
			try {
				o = jp.proceed();
			} catch (Throwable e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return o;
		}
	   //6.4  若加有@MiniPager标注，则加入分页代码
		//6.4.1获取实体类对应的总的条目数
     String tableName = miniPager.tableName();
     int totalItems = jdbcTemplate.queryForObject("select count(*) from "+tableName, Integer.class);
     //6.4.2根据页大小计算总的页数
     int pageSize = (Integer)jp.getArgs()[1];
     System.out.println("共有"+totalItems+"条数据，一页共有"+pageSize+"条数据");   
    int pageNo = (Integer) jp.getArgs()[0];
   
    //总页数=（总条目数+页大小-1）/页大小
    int totalPages = (totalItems+pageSize-1)/pageSize;
    //返回分页Pager对象
    
    if(pageNo>totalPages)pageNo=totalPages;     //如果传的参数大了，就让他等于总的数
    Pager pager = new Pager();
    try {
		List data = (List)jp.proceed(new Object[]{pageNo,pageSize});
		pager.setData(data);
		pager.setTotal(totalPages);
	} catch (Throwable e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
     return pager;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
