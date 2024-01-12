package com.bruno13palhano;

import java.util.List;

public class Profile {
    private Integer id;
    private String name;
    private String description;
    private String email;
    private String cellphoneNumber;
    private List<String> socialMedias;

    public Profile() {

    }

    public Profile(Integer id, String name, String description, String email, String cellphoneNumber,
                   List<String> socialMedias) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.email = email;
        this.cellphoneNumber = cellphoneNumber;
        this.socialMedias = socialMedias;
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

    public List<String> getSocialMedias() {
        return socialMedias;
    }

    public void setSocialMedias(List<String> socialMedias) {
        this.socialMedias = socialMedias;
    }
}