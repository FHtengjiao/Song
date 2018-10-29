package com.imooc.song.mapper;

import com.imooc.song.entity.Song;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface SongMapper {

    @Select("SELECT * FROM song")
    List<Song> getSongs();
}
