package cn.weixiao.auto.util.security;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import java.util.Date;

/**
 * <b>Shiro 认证域</b>
 * @author Weixiao
 * @version 1.0.0
 * @since 1.0.0
 */
public class ShiroDBRealm extends AuthorizingRealm {

	/**
	 * <b>当需要授权的时候，调用此方法</b>
	 * @param principalCollection
	 * @return
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
		return null;
	}

	/**
	 * <b>当需要认证的时候，调用此方法</b>
	 * @param authenticationToken
	 * @return
	 * @throws AuthenticationException
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken)
			throws AuthenticationException {
		System.out.println("调用ShiroDBRealm的doGetAuthenticationInfo进行登录系统。。。" + new Date());
		return null;
	}
}
