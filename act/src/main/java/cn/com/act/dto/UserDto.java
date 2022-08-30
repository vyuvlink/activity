package cn.com.act.dto;

import lombok.Data;

@Data
public class UserDto {
    private String id;
    private String name;
    private String phone;
    private String password;
    private Integer is_admin;
}
