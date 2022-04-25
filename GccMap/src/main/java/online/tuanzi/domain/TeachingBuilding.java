package online.tuanzi.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class TeachingBuilding {
    private int teachingBuildingId;//教学楼id
    private String teachingBuildingName;//教学楼名
    private String teachingBuildingHeight;//楼层数
    @TableField(value = "`left`")
    private int left;//left坐标
    private int top;//top坐标
}
