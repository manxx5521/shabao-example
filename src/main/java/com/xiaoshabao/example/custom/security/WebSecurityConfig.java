package com.xiaoshabao.example.custom.security;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
/**
 * 开启Servlet过滤器验证
 */
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{
	
	/**
	 * 授权
	 */
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable()
			.authorizeRequests()
				.antMatchers("/resources/**", "/signup", "/about").permitAll()//指定了任何用户都可以访问的多个网址格式
				.antMatchers("/admin/**").hasRole("ADMIN")//以"/admin/"开头的网址将仅限于拥有角色"ROLE_ADMIN"的用户,由于我们调用了`hasRole`方法，因此我们不需要指定"ROLE_"前缀。
				.antMatchers("/db/**").access("hasRole('ADMIN') and hasRole('DBA')") //任何以"/db/"开头的网址都需要用户同时拥有"ROLE_ADMIN"和"ROLE_DBA"。 您会注意到，由于我们使用的是`hasRole`表达式，因此无需指定"ROLE_"前缀。
				.antMatchers("/security/index").authenticated()//访问需要 登录
//				.anyRequest().authenticated()//任何尚未匹配的网址只要求用户进行身份验证
				.and()
			.formLogin()
				.loginPage("/security/login")//登录页面
				.successHandler(new LoginAuthenticationHandler())//登录之后处理
				.failureHandler(new LoginAuthenticationHandler())//登录失败后处理
				.permitAll()//授予所有用户（即未经身份验证的用户）访问我们的登录页面
				.and()
			.logout()
				.logoutUrl("/security/logout")//注销的URL（默认为`/logout`）
				.logoutSuccessUrl("/security/login?logout") //注销后重定向到的URL。 默认值是`/login?logout`
//				.logoutSuccessHandler(logoutSuccessHandler)//指定一个自定义`LogoutSuccessHandler`。 如果指定，则`logoutSuccessUrl()被忽略
				.invalidateHttpSession(true)//注销时是否使`HttpSession`无效
//				.addLogoutHandler(logoutHandler)//添加一个`LogoutHandler。 SecurityContextLogoutHandler`默认添加为最后一个`LogoutHandler
//				.deleteCookies(cookieNamesToClear)//注销成功时删除的cookies的名称。 这是明确添加`CookieClearingLogoutHandler`的快捷方式
				.permitAll();
	}
	
	// 配置认证管理器
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// 通过实现userDetailsService接口类重写loadUserByUsername()方法返回UserDetails进行密码匹配
		auth.userDetailsService(springDataUserDetailsService()).passwordEncoder(passwordEncoder());
	}
	
	/**
	 * 自定义登录验证类
	 * @return
	 */
	@Bean
	public UserDetailsService springDataUserDetailsService() {
	    return new MyUserDetailsService();
	}
	
	/**
	 * 使用密码管理器
	 */
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
	    return new BCryptPasswordEncoder();
	}

}
