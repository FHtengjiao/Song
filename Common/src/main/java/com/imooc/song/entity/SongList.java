package com.imooc.song.entity;

public class SongList {
    private Long id;
    private String name;
    private String songName;
    private String creator;
    private String description;

    public SongList() {
    }

    public SongList(String name, String creator, String description) {
        this.name = name;
        this.creator = creator;
        this.description = description;
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

    public String getSongName() {
        return songName;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "SongList{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", songName='" + songName + '\'' +
                ", creator='" + creator + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
