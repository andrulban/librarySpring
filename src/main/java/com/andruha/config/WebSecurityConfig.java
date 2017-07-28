package com.andruha.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by andrusha on 28.07.17.
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig  extends WebSecurityConfigurerAdapter{
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                    .antMatchers("/resources/**").permitAll()
                    .anyRequest().authenticated()
                    .and()
                .formLogin()
                    .loginPage("/login").permitAll()
//                    .loginProcessingUrl("/urlPost")
//                    .usernameParameter("us")
//                    .passwordParameter("ps")
//                    .successHandler(successHandler())
//                    .failureHandler(failureHandler())
//                    .failureUrl("/sosibo")
                    .defaultSuccessUrl("/",true)
                    .and()
                .logout().permitAll()
                    .logoutSuccessUrl("/login");

        http.csrf().disable();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .inMemoryAuthentication()
                .withUser("admin").password("password").roles("ADMIN")
                .and()
                .withUser("user").password("password").roles("USER");
    }

//    private AuthenticationFailureHandler failureHandler() {
//        return new SimpleUrlAuthenticationFailureHandler() {
//            public void onAuthenticationFailure(HttpServletRequest request,
//                                                HttpServletResponse response, AuthenticationException exception)
//                    throws IOException, ServletException {
//                response.setContentType("text/html;charset=UTF-8");
//                response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Authentication Failed. Wrong username or password or both");
//            }
//        };
//    }
//
//    private AuthenticationSuccessHandler successHandler() {
//        return new SimpleUrlAuthenticationSuccessHandler() {
//            public void onAuthenticationSuccess(HttpServletRequest request,
//                                                HttpServletResponse response, Authentication authentication)
//                    throws IOException, ServletException {
//                response.setContentType("text/html;charset=UTF-8");
//                HttpSession session = request.getSession(false);
//                session.setMaxInactiveInterval(60*180);
//                response.getWriter().println("LoginSuccessful");
//            }
//        };
//    }
}
