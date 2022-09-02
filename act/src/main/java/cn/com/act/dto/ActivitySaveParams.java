package cn.com.act.dto;

import lombok.Data;

@Data
public class ActivitySaveParams {
    private Long id;
    private String name;
    private Long scheme_id;
    private Integer start_time;
    private Integer end_time;
    private String context;
}
