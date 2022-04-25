package online.tuanzi.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class User {
    /**
     * user_id
     * user_name
     * password
     * phone_num
     * Email
     * profile_photo_path
     * Last_offline_time
     * user_group
     */
//    @TableId(value = "id", type = IdType.AUTO)
    private int userId;                 //用户id
    private String userName;            //用户名
    private String password;            //密码
    private int phoneNum;               //手机号
    private String email;               //电子邮箱
    private String profilePhotoPath;    //头像路径
    private Timestamp LastOfflineTime;  //最后一次离线时间
    private String userGroup;           //用户组
}
