package com.shishir.onlinenoticeboard.model;

public class NoticeModel {
    private String title;
    private String description;
    private String   document;
    private String image;

    public NoticeModel(String title, String description, String document, String image) {
        this.title = title;
        this.description = description;
        this.document = document;
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
