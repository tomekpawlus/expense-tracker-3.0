package com.tmpw.expenseTracker3.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tmpw.expenseTracker3.security.JasonObjectAuthenticationFilter;
import com.tmpw.expenseTracker3.security.JwtAuthorizationFilter;
import com.tmpw.expenseTracker3.security.RestAuthenticationFailureHandler;
import com.tmpw.expenseTracker3.security.RestAuthenticationSuccessHandler;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.authentication.HttpStatusEntryPoint;

@Configuration
@EnableWebSecurity(debug = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final ObjectMapper objectMapper;
    private final RestAuthenticationSuccessHandler successHandler;
    private final RestAuthenticationFailureHandler failureHandler;
    private final String secret;
    private UserDetailsManager userDetailsManager;

    public SecurityConfig(ObjectMapper objectMapper, RestAuthenticationSuccessHandler successHandler,
                          RestAuthenticationFailureHandler failureHandler, @Value("${jwt.secret}") String secret) {
        this.objectMapper = objectMapper;
        this.successHandler = successHandler;
        this.failureHandler = failureHandler;
        this.secret = secret;
    }

    private static final String[] AUTH_LIST = {
            // -- swagger ui
            "/swagger-resources/**",
            "/swagger-ui/index.html",
            "/swagger-ui.html",
            "/swagger-ui/**",
            "/v3/api-docs",
            "/v2/api-docs",
            "/webjars/**",
            "/login"};

    @Override
    protected void configure(AuthenticationManagerBuilder builder) throws Exception {
        builder.inMemoryAuthentication()
                .withUser("user")
                .password("{noop}password")
                .roles("USER");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http
                .authorizeRequests().antMatchers(AUTH_LIST).permitAll()
                .anyRequest().authenticated()
                .and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .addFilter(authenticationFilter())
                .addFilter(new JwtAuthorizationFilter(authenticationManager(),userDetailsService(),secret))
                .exceptionHandling()
                .authenticationEntryPoint(new HttpStatusEntryPoint(HttpStatus.UNAUTHORIZED));

    }

    public JasonObjectAuthenticationFilter authenticationFilter() throws Exception {
        JasonObjectAuthenticationFilter authenticationFilter = new JasonObjectAuthenticationFilter(objectMapper);
        authenticationFilter.setAuthenticationSuccessHandler(successHandler);
        authenticationFilter.setAuthenticationFailureHandler(failureHandler);
        authenticationFilter.setAuthenticationManager(super.authenticationManager());
        return authenticationFilter;
    }

}
