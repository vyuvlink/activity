package cn.com.act.common.enums;

public enum ActivityStateEnum {
    TO_BE_RELEASED(1, "待发布"),
    NOT_STARTED(2, "未开始"),
    IN_PROGRESS(3, "进行中"),
    SUSPENDED(4, "已下架"),
    FINISHED(5, "已结束");

    private Integer code;
    private String name;

    ActivityStateEnum(Integer code, String name) {
        this.code = code;
        this.name = name;
    }

    public Integer getCode() {
        return code;
    }

    public String getName() {
        return name;
    }
}
