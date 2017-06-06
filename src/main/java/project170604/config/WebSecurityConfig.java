package project170604.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import javax.sql.DataSource;

/**
 * Created by lyp on 2017/6/4.
 */

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{

    @Autowired
    DataSource dataSource;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {



        /*

        auth.inMemoryAuthentication().withUser("admin").password("admin").roles("ADMIN")
        .and().withUser("user").password("user").roles("USER")
        .and().withUser("dba").password("dba").roles("DBA")
        .and().withUser("su").password("su").roles("SUPER_ADMIN");

        */

        auth.jdbcAuthentication().dataSource(dataSource)
                .usersByUsernameQuery("select username,password,true from SysUser where username=?")
                .authoritiesByUsernameQuery("select username,role from SysUser where username=?");

    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

      //  http.authorizeRequests().anyRequest().permitAll();
        http.authorizeRequests()
                .antMatchers("/login","/css/**","/img/**","/js/**").permitAll()
                .and().authorizeRequests().antMatchers("/nsr").hasAnyRole("USER","SUPER_ADMIN")
                .and().authorizeRequests().antMatchers("/user").hasAnyRole("ADMIN","SUPER_ADMIN")
                .and().authorizeRequests().antMatchers("/data").hasAnyRole("DBA","SUPER_ADMIN")
                .anyRequest().authenticated().and().formLogin()
                .loginPage("/login").defaultSuccessUrl("/").permitAll().and().logout().permitAll();
    }
}
