package com.liumt.springbootdemo;

import com.liumt.springbootdemo.config.DruidDataSourceConfig;
import com.liumt.springbootdemo.listener.MyApplicationStartedEventListener;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import(DruidDataSourceConfig.class)
public class SpringbootDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootDemoApplication.class, args);

//		SpringApplication app = new SpringApplication(SpringbootDemoApplication.class);
//		app.addListeners(new MyApplicationStartedEventListener());
//		app.run();
	}

}
