package online.tuanzi.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import online.tuanzi.domain.SportsField;
import online.tuanzi.domain.TeachingBuilding;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
@Mapper
public interface SportsFieldDao extends BaseMapper<SportsField> {
    /**
     * SELECT sports_field_name,sports_field_floor,sports_field_usertype
     * FROM sports_field
     * WHERE sports_field_id=1
     */
    @Select("SELECT sports_field_name,sports_field_floor,sports_field_usertype\n" +
            "FROM sports_field\n" +
            "WHERE sports_field_id = #{id}")
    List<Map<String, Object>> findDetailData(int id);
}
