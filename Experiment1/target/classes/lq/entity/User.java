package lq.entity;

import lombok.Data;

@Data
public class User {
    private Long id;
    private String username;
    private String password;
    private String email;
    private Integer age;

    private IdCard card_id;
    private Role roles;
}