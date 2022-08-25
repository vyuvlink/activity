package cn.com.act.po;

import java.util.StringJoiner;

public class UserPo {
    private Long id;
    private String name;
    private String phone;
    private String password;
    private Integer is_admin;

    @Override
    public String toString() {
        return new StringJoiner(", ", UserPo.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("name='" + name + "'")
                .add("phone='" + phone + "'")
                .add("password='" + password + "'")
                .add("is_admin=" + is_admin)
                .toString();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getIs_admin() {
        return is_admin;
    }

    public void setIs_admin(Integer is_admin) {
        this.is_admin = is_admin;
    }
}
