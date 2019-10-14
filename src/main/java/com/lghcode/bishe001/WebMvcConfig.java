package com.lghcode.bishe001;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class WebMvcConfig extends WebMvcConfigurerAdapter {

	@Bean(initMethod="init")
	public ChuanKouClient chuanKouClient() {
		return new ChuanKouClient();
	}

}
