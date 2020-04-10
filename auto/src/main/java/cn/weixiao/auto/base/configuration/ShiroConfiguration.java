package cn.weixiao.auto.base.configuration;

import cn.weixiao.auto.util.security.ShiroDBRealm;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * <b>Shiro 配置类</b>
 * @author Weixiao
 * @version 1.0.0
 * @since 1.0.0
 */
@Configuration
public class ShiroConfiguration {
	// 配置当需要登录的时候，所采取的登录认证业务流程
	@Bean
	public ShiroDBRealm shiroDBRealm() {
		return new ShiroDBRealm();
	}

	@Bean
	public DefaultWebSecurityManager securityManager() {
		// 创建对应的 Shiro 核心对象 SecurityManager
		DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
		// 设置当需要登录认证的时候，使用自定义的 ShiroDBRealm 进行
		securityManager.setRealm(shiroDBRealm());
		return securityManager;
	}

	@Bean
	// 配置认证的规则
	public ShiroFilterFactoryBean shiroFilter(SecurityManager securityManager) {
		// 创建过滤器对象
		ShiroFilterFactoryBean shiroFilter = new ShiroFilterFactoryBean();
		// 配置 Shiro 的核心对象 SecurityManager
		shiroFilter.setSecurityManager(securityManager);
		// 当发现请求为登录的时候，需要跳转到登录界面，配置登录的重定向地址
		shiroFilter.setLoginUrl("/user/login");
		// 当登录成功之后，如果之前没有确定的请求地址，那么设定默认的登录跳转地址
		shiroFilter.setSuccessUrl("/");

		// 配置哪些请求需要登录，哪些请求不需要登录
		// 配置使用 Map 集合来完成，不过需要注意的时，Shiro 在匹配的时候，从上到下的顺序进行匹配
		Map<String, String> filterChainDefinitionMap = new LinkedHashMap<String, String>();

		// 配置不需要登录的请求
		// 静态资源
		filterChainDefinitionMap.put("/css/*", "anon");
		filterChainDefinitionMap.put("/js/*", "anon");
		filterChainDefinitionMap.put("/img/*", "anon");
		filterChainDefinitionMap.put("/fontawsome/*", "anon");

		// 配置退出规则
		filterChainDefinitionMap.put("/user/logout", "logout");

		// 配置需要进行登录的规则
		filterChainDefinitionMap.put("/**", "authc");

		shiroFilter.setFilterChainDefinitionMap(filterChainDefinitionMap);

		return shiroFilter;
	}
}
