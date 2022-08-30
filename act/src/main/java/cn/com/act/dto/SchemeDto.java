package cn.com.act.dto;

import cn.com.act.po.SchemePo;
import lombok.Data;

@Data
public class SchemeDto extends SchemePo {
    public String getStrScheme_id() {
        return this.getScheme_id().toString();
    }
}
