package lq.domain;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;


/**
 * @TableName t_user
 */
@TableName(value ="t_user")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User implements Serializable {
    @ExcelProperty("用户ID")
    private Long id;
    @ExcelProperty("用户名")
    private String username;
    @ExcelIgnore
    private String password;
    @ExcelProperty("用户邮箱")
    private String email;
    @ExcelProperty("用户年龄")
    private Integer age;
    @ExcelIgnore
    private static final long serialVersionUID = 1L;
}
