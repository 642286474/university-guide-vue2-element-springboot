package online.tuanzi.config;

import online.tuanzi.advice.LoginInterceptor;
import online.tuanzi.advice.UserLoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class LoginConfig implements WebMvcConfigurer {

    /**
     * 注册拦截器
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
//        //注册拦截除了登录注册请求之外所有请求的拦截器
//        InterceptorRegistration userLoginRegistration = registry.addInterceptor(new UserLoginInterceptor());
//        userLoginRegistration.addPathPatterns("/**");//拦截所有路径
//        userLoginRegistration.excludePathPatterns("/users/**");//添加不拦截路径
//        userLoginRegistration.excludePathPatterns("/dist/**");//添加不拦截路径，静态文件

        //注册拦截登录注册请求的拦截器
//        InterceptorRegistration loginRegistration = registry.addInterceptor(new LoginInterceptor());
//        loginRegistration.addPathPatterns("/users/register","/users/login");//只拦截注册登录请求
    }
}
