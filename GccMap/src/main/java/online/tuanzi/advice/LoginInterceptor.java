package online.tuanzi.advice;

import org.omg.CORBA.UserException;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * 拦截用户发送登录或注册请求后的数据
 */
public class LoginInterceptor implements HandlerInterceptor {
    /**
     * 在注册和登录请求处理完之后，判断是否成功获取到用户的各种信息，获取成功则设置token，设置session
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
//        HttpSession session = request.getSession();
//        ModelMap modelMap = modelAndView.getModelMap();
//        Object userName = modelMap.getAttribute("userName");
//        //判断是否存在user模型
//        if (userName!=null){
//            //判断是否存在token
//            if(session.getAttribute("token")==null){
//                session.setAttribute("token",request.getHeader("User-Agent"));
////                session.setMaxInactiveInterval();//设置最大生命周期
//            }
//            modelMap.addAttribute("token",session.getAttribute("token"));
//        }
    }
}
