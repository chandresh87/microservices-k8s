package com.person;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.web.client.RestTemplate;

import com.person.config.DBConfig;
import com.person.config.FiltersConfig;
import com.person.config.RedisConfig;
import com.person.dto.client.OrganizationFeignClient;

@ComponentScan(value = { "com.person.mapper", "com.person.controller", "com.person.repository", "com.person.config",
		"com.person.service","com.person.hystrix", " com.person.remote.jms","com.person.dto.client","com.person.filter"

})
@SpringBootApplication
@RefreshScope
@EnableDiscoveryClient
@EnableScheduling
@EnableFeignClients(clients = OrganizationFeignClient.class)
@EnableHystrix
@EnableResourceServer
@Import({ DBConfig.class,RedisConfig.class,FiltersConfig.class})
@RibbonClient(name = "organizationservice")
public class PersonMicroServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(PersonMicroServiceApplication.class, args);
	}
	
	 	@LoadBalanced
	    @Bean
	    RestTemplate restTemplate() {
	        return new RestTemplate();
	    }
}
