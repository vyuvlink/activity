package cn.com.act.po;

import lombok.Data;

@Data
public class ItemPo {
    private Long id;
    private Long item_id;
    private String name;
    private Integer total;
    private Integer qty;
    private Integer type;
    private Integer create_time;
    private Integer modify_time;
    private Long rel_id;
    private Integer rel_type;
}
