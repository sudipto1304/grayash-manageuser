package com.grayash.manage.user;

import java.util.concurrent.Executor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import com.grayash.security.EnableGrayashSecurity;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
//@EnableAuditActivity(serviceName="MANAGE-USER")
@EnableGrayashSecurity
@EnableAsync
@EnableFeignClients
public class GrayashManageUserApplication extends SpringBootServletInitializer{

	public static void main(String[] args) {
		SpringApplication.run(GrayashManageUserApplication.class, args);
	}
	
	@Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(GrayashManageUserApplication.class);
    }
	
	 @Bean
	    public Docket api() {
	        return new Docket(DocumentationType.SWAGGER_2)
	                .useDefaultResponseMessages(false)
	                .select()
	                .apis( RequestHandlerSelectors.basePackage( "com.grayash.manage.user" ) )
	                .paths(PathSelectors.any())
	                .build();
	    }


	    @Bean
	    public Executor asyncExecutor() {
	        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
	        executor.setCorePoolSize(5);
	        executor.setMaxPoolSize(10);
	        executor.setQueueCapacity(500);
	        executor.setThreadNamePrefix("PoolCarThread-");
	        executor.initialize();
	        return executor;
	    }

}

