package cn.com.act.dto;

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
    private String context_id;
    private String scene;
    private String scene_id;
    private String cover;
    private List<SchemeDto> scheme_list;
    private List<ItemDto> item_list;
}
