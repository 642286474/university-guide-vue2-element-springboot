package online.tuanzi.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class SportsField {
    private int sportsFieldId;             //体育场id
    private String sportsFieldName;           //所在楼层
    private int sportsFieldFloor;          //体育场名字
    private String sportsFieldUsertype;       //使用者类型
    @TableField(value = "`left`")
    private int left;                      //left坐标
    private int top;                       //top坐标
}
