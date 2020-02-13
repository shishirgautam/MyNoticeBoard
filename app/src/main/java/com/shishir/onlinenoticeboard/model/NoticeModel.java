package com.shishir.onlinenoticeboard.model;

public class NoticeModel {
    private String _id;
    private String title;
    private String description;

    public NoticeModel(String _id, String title, String description) {
        this._id = _id;
        this.title = title;
        this.description = description;
    }

    public NoticeModel(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public String getId() {
        return _id;
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
}
