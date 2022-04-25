package online.tuanzi.advice;

import online.tuanzi.config.GlobalConfig;
import online.tuanzi.domain.User;
import org.omg.CORBA.UserException;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 拦截除了登录注册请求之外的所有请求
 */
public class UserLoginInterceptor implements HandlerInterceptor {
//    //存储所有token，用户邮箱作为key
//    Map<String, String> tokens = new HashMap<>();

    /**
     * 请求处理之前调用（Controller方法调用之前），检查token和用户是否存在
     * @return 返回false表示将不会继续执行后续操作
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();
        String token = (String) session.getAttribute("token");//获取token
        User user = (User) session.getAttribute("user");//获取User
        //判断当前session中是否存在对应的User和token
        if (token != null && user != null && !token.equals(GlobalConfig.tokens.get(user.getEmail()))) {
            System.out.println("继续");
            //存在，继续操作
            return true;
        }
        //不存在，中断操作
        System.out.println("中断");
        System.out.println(request.getRequestURL());
//        session.setAttribute("user","mm");
        return false;
    }
//
//    /**
//     * 请求完成之后
//     */
//    @Override
//    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
//        HttpSession session = request.getSession();
//        Object token = session.getAttribute("token");//获取token
//        User user = (User) session.getAttribute("user");//获取User
//        //判断当前session中是否存在对应的User和token
//        if (token != null && user != null && tokens.get(user.getEmail()) != null) {
//            System.out.println("继续");
//            //存在，继续操作
//        }
//        //不存在，中断操作
//        System.out.println("中断");
////        session.setAttribute("user","mm");
//    }
}
