package online.tuanzi.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import online.tuanzi.domain.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface UserDao extends BaseMapper<User> {
    @Insert("insert into user (email,password) values (#{email},#{password}) ")
    void insertEmailAndPassword(User user);
}
