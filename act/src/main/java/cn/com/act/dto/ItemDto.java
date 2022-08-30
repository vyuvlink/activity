package cn.com.act.dto;

import cn.com.act.po.ItemPo;
import lombok.Data;

@Data
public class ItemDto extends ItemPo {
    public String getStrItem_id() {
        return this.getItem_id().toString();
    }
}
