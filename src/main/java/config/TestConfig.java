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
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.UrlBasedViewResolver;


@Configuration
@ComponentScan({"dao","service","util","controller"})   //扫描dao层和service下的bean
@Import(DBConfig.class)
@EnableAspectJAutoProxy    //2.配置类中启动AOP的功能
public class TestConfig {
	
	
}




