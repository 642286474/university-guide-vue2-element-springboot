package online.tuanzi.config;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.HashMap;
import java.util.Map;

/**
 * 定义全局配置
 */
@Component
public class GlobalConfig {
    //存储所有token，用户邮箱作为key
    public static Map<String, Object> tokens = new HashMap<>();
    //存储邮箱验证码，一个邮箱仅仅对应一个验证码
    public static Map<String, Object> emailCode = new HashMap<>();

    @PostConstruct
    public void init() {
        //系统初始化
        //加一个默认验证码
        emailCode.put("gccmap@qq.com","dsy15a");
        if (tokens.size()>=1000){//大于1000条则清除
//            tokens.replaceAll();
        }
    }

    @PreDestroy
    public void destroy() {
        //系统运行结束
    }

    @Scheduled(cron = "0 0 0/2 * * ?")
    public void testOne() {
        //每2小时执行一次清除缓存
        init();
    }
}
