package cn.com.act.po;

import lombok.Data;

@Data
public class ActivityPo {
    private Long id;
    private String name;
    private Integer state;
    private Integer start_time;
    private Integer end_time;
    private Long context_id;
    private String context;
    private Long scene_id;
    private String scene;
    private String cover;
}
