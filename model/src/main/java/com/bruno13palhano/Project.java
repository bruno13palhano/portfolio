package com.bruno13palhano;

import java.util.List;

public class Project {
    private Integer id;
    private String name;
    private List<Technologies> type;
    private String description;

    public Project() {

    }

    public Project (Integer id, String name, List<Technologies> type, String description) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.description = description;
    }

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

    public List<Technologies> getType() {
        return type;
    }

    public void setType(List<Technologies> type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
