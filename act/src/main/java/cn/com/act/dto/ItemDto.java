package cn.com.act.dto;

import lombok.Data;

@Data
public class ItemDto {
    private String item_id;
    private String name;
    private Integer total;
    private Integer qty;
    private Integer type;
    private Integer create_time;
    private Integer modify_time;
    private String rel_id;
    private Integer rel_type;
}
