package online.tuanzi.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Canteen {
    private int canteenId;//
    private String canteenName;//
    @TableField(value = "`left`")
    private int left;//
    private int top;//
}
