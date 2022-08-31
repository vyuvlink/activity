package cn.com.act.dto;

import lombok.Data;

@Data
public class ActivityQueryParams {
    private String name;
    private Integer state;
    private Integer page;
    private Integer page_size;
}
