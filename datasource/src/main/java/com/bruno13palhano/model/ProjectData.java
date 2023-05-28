package com.bruno13palhano.model;

import com.bruno13palhano.Technologies;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class ProjectData {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "type")
    private List<Technologies> type;

    @Column(name = "description")
    private String description;

    @Column(name = "images_urls")
    private List<String> imagesUrls;

    public ProjectData() {

    }

    public ProjectData(Integer id, String name, List<Technologies> type, String description, List<String> imagesUrls) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.description = description;
        this.imagesUrls = imagesUrls;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setType(List<Technologies> type) {
        this.type = type;
    }

    public List<Technologies> getType() {
        return type;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public List<String> getImagesUrls() {
        return imagesUrls;
    }

    public void setImagesUrls(List<String> imagesUrls) {
        this.imagesUrls = imagesUrls;
    }
}
