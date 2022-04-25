package online.tuanzi.controller;

import online.tuanzi.config.GlobalConfig;
import online.tuanzi.domain.User;
import online.tuanzi.service.UserService;
import online.tuanzi.util.EmailUtil;
import org.apache.commons.mail.EmailException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 登录功能，传入邮箱，密码和验证码，返回token，用户名，用户头像
     *
     */
    @PostMapping("/register")
    @CrossOrigin
    public Map<String, Object> login(@RequestBody Map<String,String> map, HttpServletRequest request) throws EmailException {
        String email = map.get("email");
        String pass = map.get("pass");
        String code = map.get("code");
        //校验邮箱验证码
        if ("".equals(code)||!code.equals(GlobalConfig.emailCode.get(email))){
            return null;
        }
        //通过验证使得验证码失效，只使用一次
//        GlobalConfig.emailCode.remove(email);

        HttpSession session = request.getSession();
        //封装对象
        User user = new User();
        Map<String, Object> loginUserMap = new HashMap<>();
        user.setEmail(email);
        user.setPassword(pass);
//        System.out.println(",,,,"+userService);
        //判断是否是默认用户、密码和校验码的情况
        if ("gccmap@qq.com".equals(email)&&"gccmap@qq.com".equals(pass)){
            loginUserMap.put("user_name", "gcc_admin");
            loginUserMap.put("user_img", "https://bkimg.cdn.bcebos.com/pic/f2deb48f8c5494eef01fdf1bbbbcf7fe9925bc31d0d5?x-bce-process=image/watermark,image_d2F0ZXIvYmFpa2U5Mg==,g_7,xp_5,yp_5/format,f_auto");//TODO 只有头像路径，后期使用再获取头像
            //判断是否存在token，没有则创建
            if (session.getAttribute("token") == null) {
                session.setAttribute("token", request.getHeader("User-Agent"));
            }
            //注册全局token
            GlobalConfig.tokens.put("gcc_admin", session.getAttribute("token"));
            loginUserMap.put("token", session.getAttribute("token"));
            return loginUserMap;
        }
        //查询数据库
        User loginUser = userService.findEmailAndPassword(user);
        //TODO 封装返回数据，后期使用实体类接收
        if (loginUser != null) {
            loginUserMap.put("user_name", loginUser.getUserName());
            loginUserMap.put("user_img", loginUser.getProfilePhotoPath());//TODO 只有头像路径，后期使用再获取头像
            //判断是否存在token，没有则创建
            if (session.getAttribute("token") == null) {
                session.setAttribute("token", request.getHeader("User-Agent"));
            }
            //注册全局token
            GlobalConfig.tokens.put(loginUser.getUserName(), session.getAttribute("token"));
            loginUserMap.put("token", session.getAttribute("token"));
        }
        return loginUserMap;
    }

    //图片验证码
    @PostMapping("/sendemail")
    @CrossOrigin
    public String imageCode(@RequestBody Map<String,String> map) throws EmailException {
//        response.setHeader("Access-Control-Allow-Origin","*");
        String email = map.get("email");
        System.out.println("发送了请求"+map.get("email"));
        String code = EmailUtil.sendEmailCode("tuanziatclannad@qq.com", email);
        GlobalConfig.emailCode.put(email, code);
//        System.out.println("发送了请求"+request.getContentType());
        return code;
//        return EmailUtil.sendEmailCode("tuanziatclannad@qq.com","tuanziatclannad@qq.com");
//        return EmailUtil.sendEmailCode("tuanziatclannad@qq.com","atnibamaitay@foxmail.com");
//        return null;
    }

    //注册
    @PostMapping("/login")
    @CrossOrigin
    public void register(@RequestBody Map<String,String> map) {
        String email = map.get("email");
        String pass = map.get("pass");
        String checkPass = map.get("checkPass");
        String code = map.get("code");

        //边界校验
        if ("".equals(email)||"".equals(pass)||"".equals(checkPass)||!pass.equals(checkPass)){
            return;
        }
        //验证码校验
        if ("".equals(code)||!code.equals(GlobalConfig.emailCode.get(email))){
            return;
        }
        //通过验证使得验证码失效
        GlobalConfig.emailCode.remove(email);
        //封装对象
        User user = new User();
        user.setEmail(email);
        user.setPassword(pass);
        try{
//            userService.save(user);
            userService.saveEmailAndPassword(user);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    //邮箱注册验证（发送请求到邮箱进行注册）

    //重置密码（发送请求到邮箱进行密码重置）


}
