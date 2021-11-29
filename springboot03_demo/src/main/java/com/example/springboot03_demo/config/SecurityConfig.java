package com.example.springboot03_demo.config;

import com.example.springboot03_demo.Dao.UserDao;
import com.example.springboot03_demo.Service.MyUserService;
import com.example.springboot03_demo.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


/**
 * WebSecurityConfigurerAdapter共有三个configure方法。
 *      configure(WebSecurity) 通过重载，配置Spring Security的Filter链
 *      configure(HttpSecurity) 通过重载，配置如何通过拦截器保护请求
 *      configure(AuthenticationManagerBuilder) 通过重载，配置user-detail服务
 */
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsService userDetailsService;
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService);
    }

    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

}
