package config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

/**
* tomcat启动的时候会检测到是否有WebApplicationInitializer接口的类
* 若检测到有这个类，就会实例化它，并调用他的onStartup方法
*
* @author DanyangLi
*/
public class WebInitalizer implements WebApplicationInitializer{

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		
		//System.out.println("start up.....");
		
		//1.构造spring容器
	AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();
	//2.spring容器加载配置
	ctx.register(AppConfig.class);
	//3.spring容器接管servletcontext应用上下文对象
	ctx.setServletContext(servletContext);
	//添加servlet（至少添加一个servlet，springmvc框架实现的入口servlet）
	ServletRegistration.Dynamic servlet = servletContext.addServlet("dispatcher", new DispatcherServlet(ctx));
	servlet.addMapping("/");
	servlet.setLoadOnStartup(1);
		
		 //你想使用spring就得有spring容器的实例
	     //你想使用springmvc，就得配置DispatcherServlet的实例
	    //还要把这两个东西放到ServletContext里，为什么呢？因为他们两都是重量级对象
		
	}

}
