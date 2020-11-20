package com.example.listdrakor.models;

public class Drama {
    private String title;
    private String deskripsi;
    private int thumbnail;
    private String studio;
    private String rating;
    private String streamingLink;
    private int coverPhoto;

    public Drama(String title, int thumbnail, int coverPhoto) {
        this.title = title;
        this.thumbnail = thumbnail;
        this.coverPhoto = coverPhoto;
    }

    public Drama(String title, int thumbnail) {
        this.title = title;
        this.thumbnail = thumbnail;
    }

    public Drama(String title, String deskripsi, int thumbnail, String studio, String rating, String streamingLink) {
        this.title = title;
        this.deskripsi = deskripsi;
        this.thumbnail = thumbnail;
        this.studio = studio;
        this.rating = rating;
        this.streamingLink = streamingLink;
    }

    public int getCoverPhoto() {
        return coverPhoto;
    }

    public void setCoverPhoto(int coverPhoto) {
        this.coverPhoto = coverPhoto;
    }

    public String getTitle() {
        return title;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public int getThumbnail() {
        return thumbnail;
    }

    public String getStudio() {
        return studio;
    }

    public String getRating() {
        return rating;
    }

    public String getStreamingLink() {
        return streamingLink;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    public void setThumbnail(int thumbnail) {
        this.thumbnail = thumbnail;
    }

    public void setStudio(String studio) {
        this.studio = studio;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public void setStreamingLink(String streamingLink) {
        this.streamingLink = streamingLink;
    }
}
