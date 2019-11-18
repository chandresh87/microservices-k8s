package com.person.config;
import java.util.Collections;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.person.filter.UserContextFilter;

@Configuration
public class FiltersConfig {

  @Bean
  public FilterRegistrationBean loginRegistrationBean() {
    System.out.println("Setting up loginRegistrationBean");
    FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
    filterRegistrationBean.setFilter(new UserContextFilter());
   // filterRegistrationBean.setUrlPatterns(Collections.singletonList("/**"));
    return filterRegistrationBean;
  }

 
}