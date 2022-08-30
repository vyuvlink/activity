package cn.com.act.po;

import lombok.Data;

@Data
public class UserPo {
    private Long id;
    private String name;
    private String phone;
    private String password;
    private Integer is_admin;
}
