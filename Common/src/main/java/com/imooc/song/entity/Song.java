package com.imooc.song.entity;

import java.util.Date;

public class Song {
    private Long id;
    private String name;
    private String singer;
    private String category;
    private String writer;
    private String language;
    private Date issueDate;

    public Song() {

    }

    public Song(Long id, String name, String singer, String category, String writer, String language, Date issueDate) {
        this.id = id;
        this.name = name;
        this.singer = singer;
        this.category = category;
        this.writer = writer;
        this.language = language;
        this.issueDate = issueDate;
    }

    public Song(String name, String singer, String category, String writer, String language, Date issueDate) {
        this.name = name;
        this.singer = singer;
        this.category = category;
        this.writer = writer;
        this.language = language;
        this.issueDate = issueDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public Date getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(Date issueDate) {
        this.issueDate = issueDate;
    }

    @Override
    public String toString() {
        return "Song{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", singer='" + singer + '\'' +
                ", category='" + category + '\'' +
                ", writer='" + writer + '\'' +
                ", language='" + language + '\'' +
                ", issueDate='" + issueDate + '\'' +
                '}';
    }
}
