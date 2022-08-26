package cn.com.act.po;

import java.util.StringJoiner;

public class ActivityPo {
    private Long id;
    private String name;
    private Long scheme_id;
    private Integer state;
    private Integer start_time;
    private Integer end_time;
    private Long context_id;
    private String context;
    private Long scene_id;
    private String scene;
    private Integer type;
    private Long rel_id;
    private String cover;

    @Override
    public String toString() {
        return new StringJoiner(", ", ActivityPo.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("name='" + name + "'")
                .add("scheme_id=" + scheme_id)
                .add("state=" + state)
                .add("start_time=" + start_time)
                .add("end_time=" + end_time)
                .add("context_id=" + context_id)
                .add("context='" + context + "'")
                .add("scene_id=" + scene_id)
                .add("scene='" + scene + "'")
                .add("type=" + type)
                .add("rel_id=" + rel_id)
                .add("cover='" + cover + "'")
                .toString();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getScheme_id() {
        return scheme_id;
    }

    public void setScheme_id(Long scheme_id) {
        this.scheme_id = scheme_id;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Integer getStart_time() {
        return start_time;
    }

    public void setStart_time(Integer start_time) {
        this.start_time = start_time;
    }

    public Integer getEnd_time() {
        return end_time;
    }

    public void setEnd_time(Integer end_time) {
        this.end_time = end_time;
    }

    public Long getContext_id() {
        return context_id;
    }

    public void setContext_id(Long context_id) {
        this.context_id = context_id;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public Long getScene_id() {
        return scene_id;
    }

    public void setScene_id(Long scene_id) {
        this.scene_id = scene_id;
    }

    public String getScene() {
        return scene;
    }

    public void setScene(String scene) {
        this.scene = scene;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Long getRel_id() {
        return rel_id;
    }

    public void setRel_id(Long rel_id) {
        this.rel_id = rel_id;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }
}
