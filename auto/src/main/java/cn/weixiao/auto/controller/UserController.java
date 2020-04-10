package cn.weixiao.auto.controller;

import cn.weixiao.auto.base.controller.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * <b>西铜用户控制层</b>
 * @author Weixiao
 * @version 1.0.0
 * @since 1.0.0
 */
@Controller("userController")
@RequestMapping("/user")
public class UserController extends BaseController {

	/**
	 * <b>转发到登录界面</b>
	 * @return
	 * @throws Exception
	 */
	@GetMapping(value = "/login")
	public String forwardLoginPage() throws Exception {
		return "user/user_login";
	}
}
