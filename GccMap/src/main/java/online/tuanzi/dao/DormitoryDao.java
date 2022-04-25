package online.tuanzi.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import online.tuanzi.domain.Dormitory;
import online.tuanzi.domain.TeachingBuilding;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface DormitoryDao extends BaseMapper<Dormitory> {
}
