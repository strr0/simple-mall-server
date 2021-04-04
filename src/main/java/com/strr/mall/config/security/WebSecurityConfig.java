package com.strr.mall.config.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.strr.mall.common.CommonResult;
import com.strr.mall.system.entity.User;
import com.strr.mall.system.service.AuthorityService;
import com.strr.mall.system.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.io.PrintWriter;

/**
 * Security配置
 * @author strr
 */
@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private UserService userService;
    @Autowired
    private AuthorityService authorityService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(username -> {
            User user = userService.getByUsername(username);
            if (user != null) {
                user.setAuthorityList(authorityService.listByUserId(user.getId()));
                return user;
            }
            throw new UsernameNotFoundException("User '" + username + "' not found.");
        }).passwordEncoder(new BCryptPasswordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.formLogin()
                // 登录
                .loginProcessingUrl("/security/login")
                .successHandler(((request, response, authentication) -> {
                    response.setContentType("application/json;charset=utf-8");
                    PrintWriter out = response.getWriter();
                    CommonResult commonResult = new CommonResult().withData(authentication.getPrincipal());
                    out.write(new ObjectMapper().writeValueAsString(commonResult));
                    out.flush();
                    out.close();
                }))
                .failureHandler((request, response, exception) -> {
                    response.setContentType("application/json;charset=utf-8");
                    PrintWriter out = response.getWriter();
                    CommonResult commonResult = CommonResult.FAILURE;
                    out.write(new ObjectMapper().writeValueAsString(commonResult));
                    out.flush();
                    out.close();
                })
                .permitAll()
                // 请求
                .and()
                .authorizeRequests()
                // 退出
                .and()
                .logout()
                .logoutSuccessHandler((request, response, authentication) -> {
                    response.setContentType("application/json;charset=utf-8");
                    PrintWriter out = response.getWriter();
                    CommonResult commonResult = CommonResult.SUCCESS;
                    out.write(new ObjectMapper().writeValueAsString(commonResult));
                    out.flush();
                    out.close();
                })
                .permitAll()
                // 禁用csrf
                .and()
                .csrf().disable();
    }
}
