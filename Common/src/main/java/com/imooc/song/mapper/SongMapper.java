package com.imooc.song.mapper;

import com.imooc.song.entity.Song;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface SongMapper {

    @Select("SELECT * FROM song")
    List<Song> getSongs();

//    @Select("SELECT * FROM song WHERE name in ${names}")
    @Select("<script> "
            + "SELECT * FROM song WHERE name IN "
            + "<foreach item='item' index='index' collection='names' open='(' separator=',' close=')'>"
            + "#{item}"
            + "</foreach>"
            + "</script>")
    List<Song> getSongsByNames(@Param("names") List<String> names);
}
