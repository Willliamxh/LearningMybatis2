package com.bjp.vo;

/**
 * @Author Willam_xh
 * @Date 2021-12-12 15:17
 */
public class ViewStudent {
    private Integer id;
    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "ViewStudent{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
