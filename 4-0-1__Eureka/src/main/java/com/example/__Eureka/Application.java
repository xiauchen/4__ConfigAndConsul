package com.example.__Eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args
		);
	}
//	@EnableWebSecurity
//	class WebSecurityConfig extends WebSecurityConfigurerAdapter {
//		@Override
//		protected void configure(HttpSecurity httpSecurity) throws Exception {
//			// Spring Security 默认开启了所有 CSRF 攻击防御，需要禁用 /eureka 的防御
//			httpSecurity.csrf().ignoringAntMatchers("/eureka/**");
//
//			super.configure(httpSecurity);
//		}
//	}
//	https://www.dev996.com/spring-cloud-multi-eureka-security.html
}
