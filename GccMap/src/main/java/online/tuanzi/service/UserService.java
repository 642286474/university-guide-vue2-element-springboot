package online.tuanzi.service;

import com.baomidou.mybatisplus.extension.service.IService;
import online.tuanzi.domain.User;

import java.util.List;

public interface UserService extends IService<User> {
    List<User> selectById(User user);

    User findEmailAndPassword(User user);

    void saveEmailAndPassword(User user);
}
