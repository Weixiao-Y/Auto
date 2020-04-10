package cn.weixiao.auto.util;

import java.util.Properties;

/**
 * <b>系统常量工具类</b>
 * @author Weixiao
 * @version 1.0.0
 * @since 1.0.0
 */
public class ConstantUtil {
	private static final Properties props = new Properties();

	static {
		try {
			props.load(ConstantUtil.class.getClassLoader().getResourceAsStream("props/auto.properties"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * <b>分页信息：当前页码</b>
	 */
	public static final Integer PAGE_NUM = Integer.parseInt(props.getProperty("page.num"));

	/**
	 * <b>分页信息：每页显示数量</b>
	 */
	public static final Integer PAGE_SIZE= Integer.parseInt(props.getProperty("page.size"));
}
