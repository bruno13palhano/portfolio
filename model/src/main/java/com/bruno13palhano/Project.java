package com.bruno13palhano;

import java.util.List;

public class Project {
    private Integer id;
    private String name;
    private List<String> type;
    private String description;
    private List<String> imagesUrls;

    public Project() {

    }

    public Project (Integer id, String name, List<String> type, String description, List<String> imagesUrls) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.description = description;
        this.imagesUrls = imagesUrls;
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

    public List<String> getType() {
        return type;
    }

    public void setType(List<String> type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<String> getImagesUrls() {
        return imagesUrls;
    }

    public void setImagesUrls(List<String> imagesUrls) {
        this.imagesUrls = imagesUrls;
    }
}
