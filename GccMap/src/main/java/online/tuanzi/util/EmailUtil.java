package online.tuanzi.util;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

import java.util.Random;

/**
 * 邮箱相关工具类
 */
public class EmailUtil {
    /**
     * 发送邮箱验证码
     * @return 返回正确的验证码
     */
    public static String sendEmailCode(String from,String to) throws EmailException {
        //随机生成6位验证码
        String code = getRandomCode(6);
        Email email = new SimpleEmail();//创建实例对象
        email.setHostName("smtp.qq.com");//设置对应的SMTP服务器
        email.setSmtpPort(465);
        email.setAuthenticator(new DefaultAuthenticator("tuanziatclannad@qq.com", "wwcfzanruoprdjjh"));//设置邮箱地址和授权码
        email.setSSLOnConnect(true);
        email.setFrom(from,"tuanzi");//设置发件人及用户名（自定义）
        email.setSubject("TestMail");//设置发送主题
        email.setMsg("邮箱验证码为："+code);//设置发送内容
        email.addTo(to);//设置收件人
        email.send();//发送
        return code;
    }

    /**
     * 获取几位随机数
     * @param number
     * @return
     */
    public static String getRandomNumCode(int number) {
        String codeNum = "";
        int[] numbers = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        Random random = new Random();
        for (int i = 0; i < number; i++) {
            int next = random.nextInt(10000);//目的是产生足够随机的数，避免产生的数字重复率高的问题
//    			System.out.println(next);
            codeNum += numbers[next % 10];
        }
        System.out.println("--------");
        System.out.println(codeNum);

        return codeNum;
    }

    /**
     * 生成随机码值，包含数字、大小写字母
     * @param number 生成的随机码位数
     * @return
     */
    public static String getRandomCode(int number) {
        String codeNum = "";
        int[] code = new int[3];
        Random random = new Random();
        for (int i = 0; i < number; i++) {
            int num = random.nextInt(10) + 48;
            int uppercase = random.nextInt(26) + 65;
            int lowercase = random.nextInt(26) + 97;
            code[0] = num;
            code[1] = uppercase;
            code[2] = lowercase;
            codeNum += (char) code[random.nextInt(3)];
        }
        System.out.println(codeNum);

        return codeNum;
    }
}
