package cn.weixiao.auto;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * <b>车辆管理系统启动类</b>
 * @author Weixiao
 * @version 1.0.0
 * @since 1.0.0
 */
@MapperScan("cn.weixiao.auto.dao")
@SpringBootApplication
public class AutoStarter {
	public static void main(String[] args) {
		SpringApplication.run(AutoStarter.class, args);
	}
}
