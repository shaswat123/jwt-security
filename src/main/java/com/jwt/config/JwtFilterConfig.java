package com.jwt.config;

import com.jwt.filter.JwtFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JwtFilterConfig {

    @Autowired
    private JwtFilter jwtFilter;

    @Bean
    public FilterRegistrationBean<JwtFilter>filterFilterRegistrationBean(){

        FilterRegistrationBean<JwtFilter> filterFilterRegistrationBean= new FilterRegistrationBean<>();
        filterFilterRegistrationBean.setFilter(jwtFilter);
        filterFilterRegistrationBean.addUrlPatterns("/secured/*");
        return filterFilterRegistrationBean;

    }
}
