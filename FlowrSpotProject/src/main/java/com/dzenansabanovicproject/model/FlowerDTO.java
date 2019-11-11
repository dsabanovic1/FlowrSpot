package com.dzenansabanovicproject.model;

import org.springframework.web.multipart.MultipartFile;

public class FlowerDTO {

    private String description;
    private String name;
    private String url;
    private MultipartFile image;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public MultipartFile getImage() {
        return image;
    }

    public void setImage(MultipartFile image) {
        this.image = image;
    }
}
