package lq.vo;

import lombok.Data;
import lq.entity.IdCard;

@Data
public class UserVo {
    private IdCard card_id;
    private Long RoleId;
    private String role_desc;
    private String role_name;
    private String code;
    private Integer age;
    private String email;
    private String password;
    private String username;
    private Long id;

}
