package online.tuanzi.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserIdentity {
    /**
     * user_identity_id
     * user_id
     * user_sex
     * user_realname
     * user_school
     * user_college
     * user_specialty
     * user_student_id
     * user_class
     */
    private int userIdentityId;     //用户身份信息id
    private int userId;             //用户id
    private String userSex;         //性别
    private String userRealName;    //用户真实姓名
    private String userSchool;      //学校
    private String userCollege;     //学院
    private String userSpecialty;   //专业
    private int userStudentId;      //学号
    private String userClass;       //班级
}
