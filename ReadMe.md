分页框架:
	PageHelper   目前市面上很流行

我们也可以自己写分页框架    可以一键生成一个模块的所有代码
	MyPager
	
分页更加简单，我们做到不需要程序员写一行，就很好的实现分页效果
需求:
	程序员
	class UserDao{
		public List<User> findAll(){}
	}
	框架能够自动分页
		标注和AOP ： 写标注和切面来实现这个框架
	目标：
		就是让程序员只关注自己该做的事情，若想分页的话就加几个简单标注就行
 	          线程池的技术
 	

==============================
 
 	day06 spring
 	
 2.MiniPager框架
  	100元买个服务器(香港、美国)
 	MiniPager
 3.目标
 （1）使用标注来实现分页
 （2）解放程序员编写重复的分页代码
 （3）纯的Dao代码
 
 实现：
 	分析：以结果为导向去分析，或者以程序员用例来分析
 			
编写步骤
	1).编写自定义标注
		@MiniPager:至少应该有个表名的属性
	2).编写切面(核心框架代码就在切面中)
		a.要在配置类AppConfig中启动AOP的功能
			@EnableAspectJAutoProxy  
			@ComponentScan({"dao","service","util"})  注意还应该加入util包 因为分页切面在util包下面，需要切面注入
 		b.编写自定义分页切面
 			PagerAspect类
 				@Aspect
				@Component
 		c.编写自定义切面中的切点
 		    //--检测service包及子包下的所有方法
 			@Pointcut("execution(* service..*(..))")  
			public void selfPointcut(){}
 		d.自定义通知(AroundAdvice)
 			@Around("selfPointcut")
			public List aroundAdvice(ProceedingJoinPoint jp){
				System.out.println("hello pager");
				return null;
			}
 	
 		   测试：只要是调用service包下的类的方法，都应该输出hello pager的方法
 		e.编写通知体里面的核心代码(实现通用分页的核心代码)
 			i.只有在加入@MiniPager标注的方法上实现拦截功能
 				思路:拿到被调用的方法对象Method对象，然后判断该方法上有没有@MiniPager标注
 				若有就加入切面功能，否则不加
 				
 			
总结：
 	MiniPager标注
  	Pager类 
  	PagerAspect类	
  使用的技术：
  	spring IOC/AOP 反射技术 标注技术	 面向对象的编程思想
 	
 	
 	
		
		