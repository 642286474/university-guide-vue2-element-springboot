package online.tuanzi.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import online.tuanzi.domain.DormitoryBuilding;
import online.tuanzi.domain.TeachingBuilding;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
@Mapper
public interface DormitoryBuildingDao extends BaseMapper<DormitoryBuilding> {
    /**
     * SELECT dormitory_building_name, dormitory_building_height,dormitory_building_type
     * FROM dormitory_building
     * WHERE dormitory_building_id=1
     */
    @Select("SELECT dormitory_building_name, dormitory_building_height,dormitory_building_type\n" +
            "FROM dormitory_building\n" +
            "WHERE dormitory_building_id = #{id}")
    List<Map<String, Object>> findDetailData(int id);
}
