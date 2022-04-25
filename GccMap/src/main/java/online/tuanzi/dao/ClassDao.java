package online.tuanzi.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import online.tuanzi.domain.Class;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface ClassDao extends BaseMapper<Class> {
}