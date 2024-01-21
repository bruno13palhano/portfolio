package com.bruno13palhano;

import java.util.List;

public class Profile {
    private Integer id;
    private String name;
    private String imageUrl;
    private String description;
    private String email;
    private String cellphoneNumber;
    private List<String> socialMedia;

    public Profile() {

    }

    public Profile(Integer id, String name, String imageUrl, String description, String email, String cellphoneNumber,
                   List<String> socialMedia) {
        this.id = id;
        this.name = name;
        this.imageUrl = imageUrl;
        this.description = description;
        this.email = email;
        this.cellphoneNumber = cellphoneNumber;
        this.socialMedia = socialMedia;
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

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCellphoneNumber() {
        return cellphoneNumber;
    }

    public void setCellphoneNumber(String cellphoneNumber) {
        this.cellphoneNumber = cellphoneNumber;
    }

    public List<String> getSocialMedia() {
        return socialMedia;
    }

    public void setSocialMedia(List<String> socialMedia) {
        this.socialMedia = socialMedia;
    }
}