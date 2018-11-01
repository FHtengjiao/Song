package com.imooc.song.mapper;

import com.imooc.song.entity.SongList;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface SongListMapper {
    @Select("SELECT id,name,songname songName,creator,description From songlist")
    List<SongList> getSongLists();

    @Select("SELECT id,name,songname songName,creator,description From songlist WHERE creator = #{creator}")
    List<SongList> getSongListsByCreator(@Param("creator") String creator);

    @Select("SELECT id,name,songname songName,creator,description From songlist WHERE id = #{id}")
    SongList getSongListsById(@Param("id") Long id);

    @Insert("INSERT songlist(name,creator,description) VALUES(#{songList.name},#{songList.creator},#{songList.description})")
    void addSongList(@Param("songList") SongList songList);

    @Update("UPDATE songlist SET songname = #{songNames} WHERE id = #{id}")
    void updateSongNameInList(@Param("songNames") String songNames, @Param("id") Long id);

    @Update("UPDATE songlist SET name = #{songList.name},description=#{songList.description} WHERE id = #{songList.id}")
    void updateSongList(@Param("songList") SongList songList);

    @Delete("DELETE FROM songlist WHERE id = #{id}")
    void deleteSongList(@Param("id") Long id);
}
