package cn.com.act.dto;

import cn.com.act.po.SchemePo;
import lombok.Data;

import java.util.List;

@Data
public class ActivityDto {
    private String id;
    private String name;
    private String scheme_id;
    private Integer state;
    private Integer start_time;
    private Integer end_time;
    private String context;
    private String scene;
    private List<SchemePo> scheme_list;
}
