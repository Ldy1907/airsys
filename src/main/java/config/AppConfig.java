package config;
import org.springframework.context.annotation.Bean;
/*
 * 应用配置（Spring配置）
 * 它相当于XML的替代者
 */
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.UrlBasedViewResolver;


@Configuration
@ComponentScan({"dao","service","controller"})   //扫描dao层和service下的bean
@Import(DBConfig.class)
@EnableAspectJAutoProxy    //2.配置类中启动AOP的功能
//-- @EnableWebMvc   如果继承WebMvcConfigurationSupport ，就先注释掉这个标注
public class AppConfig extends WebMvcConfigurationSupport{
	@Bean
	public UrlBasedViewResolver setupViewResolver(){
		UrlBasedViewResolver resolver = new UrlBasedViewResolver();
		resolver.setPrefix("/WEB-INF/");//位置  指定jsp文件所放的父目录（在web-inf下的是受保护的，不可以直接访问）
		resolver.setSuffix(".jsp");//jsp文件的后缀
		resolver.setViewClass(JstlView.class);
		return resolver;
	}
	
	/*
	 * 配置处理静态资源  .js  .css .jpg
	 */
	@Override
	protected void addResourceHandlers(ResourceHandlerRegistry registry){
		registry.addResourceHandler("/assets/**").addResourceLocations("/assets/");
		super.addResourceHandlers(registry);
	}
	
}




