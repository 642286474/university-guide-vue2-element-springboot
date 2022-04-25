package online.tuanzi.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Dormitory {
    private int dormitoryId;//宿舍id
    private int dormitory_buildingId;//宿舍楼id
    private String dormitoryName;//宿舍名（号）
}
