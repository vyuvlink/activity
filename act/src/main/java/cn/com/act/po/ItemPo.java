package cn.com.act.po;

import java.util.StringJoiner;

public class ItemPo {
    private Long id;
    private String name;
    private Integer total;
    private Integer qty;
    private Integer type;
    private Integer create_time;
    private Integer modify_time;
    private Long rel_id;
    private Integer rel_type;

    @Override
    public String toString() {
        return new StringJoiner(", ", ItemPo.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("name='" + name + "'")
                .add("total=" + total)
                .add("qty=" + qty)
                .add("type=" + type)
                .add("create_time=" + create_time)
                .add("modify_time=" + modify_time)
                .add("rel_id=" + rel_id)
                .add("rel_type=" + rel_type)
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

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Integer getQty() {
        return qty;
    }

    public void setQty(Integer qty) {
        this.qty = qty;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Integer create_time) {
        this.create_time = create_time;
    }

    public Integer getModify_time() {
        return modify_time;
    }

    public void setModify_time(Integer modify_time) {
        this.modify_time = modify_time;
    }

    public Long getRel_id() {
        return rel_id;
    }

    public void setRel_id(Long rel_id) {
        this.rel_id = rel_id;
    }

    public Integer getRel_type() {
        return rel_type;
    }

    public void setRel_type(Integer rel_type) {
        this.rel_type = rel_type;
    }
}
