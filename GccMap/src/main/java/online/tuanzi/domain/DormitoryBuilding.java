package online.tuanzi.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class DormitoryBuilding {
    private int dormitoryBuildingId;//
    private String dormitoryBuildingName;//
    private int dormitoryBuildingHeight;//
    private String dormitoryBuildingType;//
    @TableField(value = "`left`")
    private String left;//
    private String top;//
}
