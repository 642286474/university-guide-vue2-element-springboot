package online.tuanzi.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Class {
    @TableId
    private int classId;//教室id
    private int teachingBuildingId;//教学楼id
    private String className;//教室名（示例：311 - 鸿蒙研究院）
    private int classFloor;//所在楼层
}