package online.tuanzi.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import online.tuanzi.dao.UserDao;
import online.tuanzi.domain.User;
import online.tuanzi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserServiceImpl extends ServiceImpl<UserDao, User> implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public List<User> selectById(User user) {
        return null;
    }

    @Override
    public User findEmailAndPassword(User user) {
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(user.getEmail() != null, User::getEmail, user.getEmail());
        queryWrapper.eq(user.getPassword() != null, User::getPassword, user.getPassword());
        User userOne = userDao.selectOne(queryWrapper);
        return userOne;
    }

    @Override
    public void saveEmailAndPassword(User user) {
        userDao.insertEmailAndPassword(user);
    }
}
