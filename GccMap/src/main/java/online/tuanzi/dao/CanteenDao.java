package online.tuanzi.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import online.tuanzi.domain.Canteen;
import online.tuanzi.domain.TeachingBuilding;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
@Mapper
public interface CanteenDao extends BaseMapper<Canteen> {
    /**
     * SELECT canteen.canteen_name,shop.shop_name
     * FROM canteen, shop
     * WHERE canteen.canteen_id = shop.canteen_id
     * AND canteen.canteen_id = 3
     */
    @Select("SELECT canteen.canteen_name,shop.shop_name\n" +
            "FROM canteen, shop\n" +
            "WHERE canteen.canteen_id = shop.canteen_id\n" +
            "AND canteen.canteen_id = #{id}")
    List<Map<String, Object>> findDetailData(int id);
}
