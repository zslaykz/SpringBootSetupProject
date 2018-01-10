package ua.com.owu.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.util.matcher.AndRequestMatcher;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
@ComponentScan("ua.com.owu.*")
public class SecurityConfig extends WebSecurityConfigurerAdapter{


    @Autowired
    private UserDetailsService userDetailsService;


    @Bean
    public DaoAuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(userDetailsService);
        return provider;
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/adm/**").access("hasRole('ADMIN')")
                .antMatchers("/user/**").access("hasRole('USER')")
                .and()
                .formLogin().loginPage("/login")
                .usernameParameter("username")
                .passwordParameter("password")
                .and()
                .logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout"));
    }
}
