package config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;

import com.alibaba.druid.pool.DruidDataSource;

/*
 * 数据库配置
 * 	1.配置信息
 * 	2.数据源 DataSource Bean
 */
@Configuration
@PropertySource("classpath:jdbc.properties")
public class DBConfig {
	     
	   //1.配置信息
	     @Value("${jdbc.driverClassName}")
			private String driver;
	     @Value("${jdbc.url}")
			private String url;
	     @Value("${jdbc.username}")
			private String username;
	     @Value("${jdbc.password}")
			private String password;

       //2.数据源 DataSource Bean
      //建立数据源访问数据库
	     @Bean(name="dataSource")
	     public DataSource createDateSource(){
	    	 DruidDataSource ds = new DruidDataSource();
	    	 ds.setDriverClassName(driver);
	    	 ds.setUrl(url);
	    	 ds.setUsername(username);
	    	 ds.setPassword(password);
			return ds;
	     }

	     //3.JdbcTemplate技术 是spring和jdbc技术的整合
	     @Bean(name="jdbcTemplate")
	     public JdbcTemplate createJdbcTemplate(DataSource ds){
	    	 return new JdbcTemplate(ds);
	     }


}
