package online.tuanzi.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Shop {
    private int shopId;
    private int canteenId;
    private String shopName;
    @TableField(value = "`left`")
    private int left;
    private int top;
}
