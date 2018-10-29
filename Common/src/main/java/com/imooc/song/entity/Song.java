package com.imooc.song.entity;

public class Song {
    private Long id;
    private String name;
    private String singer;
    private String category;
    private String writer;
    private String language;
    private String issudate;

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

    public String getIssudate() {
        return issudate;
    }

    public void setIssudate(String issudate) {
        this.issudate = issudate;
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
                ", issudate='" + issudate + '\'' +
                '}';
    }
}
