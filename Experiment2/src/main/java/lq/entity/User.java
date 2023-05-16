package lq.entity;

import jakarta.validation.constraints.*;
import lombok.Data;
import org.hibernate.validator.constraints.Range;

import java.util.Date;

@Data
public class User {
//    private Long id;
//    @NotBlank(message = "用户名不能为空")
//    @Size(min = 5,max = 10,message = "用户名长度必须在2-10个字符之间")
//    private String username;
//    //三种以上不同类型字符
//    //^(?![A-Za-z]+$)(?![A-Z\d]+$)(?![A-Z\W]+$)(?![a-z\d]+$)(?![a-z\W]+$)(?![\d\W]+$)\S{6,}$
//    @Pattern(regexp = "(?=.*\\d)(?=.*[A-Z])(?=.*[a-z])(?=.*[^a-zA-Z0-9]). {6,32}",message = "密码必须满足密码复杂度")
//    @NotBlank
//    private String password;
//    @Range(min = 1,max = 120,message = "年龄必须在1-120之间")
//    private Integer age;
//    @Email
//    private String email;

    private Long id;
    @NotBlank(message = "用户名不能为空")
    @Size(min = 4,max = 30,message = "用户名长度必须在4-30之间")
    @Pattern(regexp = "^[a-zA-Z0-9]+$", message = "用户名只能包含字母和数字")
    private String username;

    @NotBlank(message = "密码不能为空")
    @Size(min = 6, message = "密码长度至少为6")
    @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z]).*$", message = "密码必须包含大小写和数字")
    private String password;

    @Min(value = 1, message = "年龄必须在1-100之间")
    @Max(value = 100, message = "年龄必须在1-100之间")
    private Integer age;

    @Email(message = "邮箱格式不正确")
    private String email;
    private IdCard idCard;
    private Role role;
    private UserRole userRole;
}

