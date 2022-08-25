package cn.com.act.po;

import java.util.List;
import java.util.StringJoiner;

public class SchemePo {
    private Long id;
    private Integer type;

    @Override
    public String toString() {
        return new StringJoiner(", ", SchemePo.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("type=" + type)
                .toString();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }
}
