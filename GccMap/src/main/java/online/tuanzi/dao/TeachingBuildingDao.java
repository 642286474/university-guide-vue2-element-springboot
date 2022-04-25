package online.tuanzi.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import online.tuanzi.domain.TeachingBuilding;
import online.tuanzi.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
@Mapper
public interface TeachingBuildingDao extends BaseMapper<TeachingBuilding> {

    /**
     * SELECT t.teaching_building_id,t.teaching_building_name,t.teaching_building_height,class.class_name,class.class_floor,class.class_floorid
     * FROM teaching_building AS t,class
     * WHERE class.teaching_building_id = t.teaching_building_id
     * AND t.teaching_building_id = 1
     */
    @Select("SELECT class.class_name,class.class_floor,class.class_floorid\n" +
            "FROM teaching_building AS t,class\n" +
            "WHERE class.teaching_building_id = t.teaching_building_id \n" +
            "AND t.teaching_building_id = #{id}")
    List<Map<String, Object>> findDetailData(int id);
}
