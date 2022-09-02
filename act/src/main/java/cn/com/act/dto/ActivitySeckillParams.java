package cn.com.act.dto;

import lombok.Data;

@Data
public class ActivitySeckillParams {
    private Long order_id;
    private Long user_id;
    private Long item_id;
    private Long rel_id;
    private Integer create_time;
}
