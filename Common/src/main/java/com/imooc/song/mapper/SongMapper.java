package com.imooc.song.mapper;

import com.imooc.song.entity.Song;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface SongMapper {

    @Select("SELECT * FROM song")
    List<Song> getSongs();

    @Select("<script> "
            + "SELECT * FROM song WHERE name IN "
            + "<foreach item='item' index='index' collection='names' open='(' separator=',' close=')'>"
            + "#{item}"
            + "</foreach>"
            + "</script>")
    List<Song> getSongsByNames(@Param("names") List<String> names);

    @Select("<script> "
            + "SELECT * FROM song WHERE name IN "
            + "<foreach item='item' index='index' collection='names' open='(' separator=',' close=')'>"
            + "#{item} LIMIT #{skip}, #{size}"
            + "</foreach>"
            + "</script>")
    List<Song> getSongsByNamesAndSize(@Param("names") List<String> names, @Param("skip") Integer skip, @Param("size") Integer size);


    @Insert("INSERT song(name,singer,category,writer,language,issuedate) " +
            "VALUES(#{song.name}, #{song.singer}, #{song.category}, #{song.writer}, #{song.language}, #{song.issueDate})")
    void addSong(@Param("song") Song song);

    @Select("SELECT * FROM song WHERE id = #{id}")
    Song getSongById(@Param("id") Long id);

    @Update("UPDATE song SET name=#{song.name}, singer=#{song.singer}," +
            " category=#{song.category}, writer=#{song.writer}," +
            " language=#{song.language}, issuedate=#{song.issueDate} WHERE id=#{song.id}")
    void updateSong(@Param("song") Song song);

    @Delete("DELETE FROM song WHERE id=#{id}")
    void deleteSong(@Param("id") Long id);

    @Select("SELECT * FROM song LIMIT #{skip}, #{size}")
    List<Song> getSongsBySize(@Param("skip") Integer skip, @Param("size") Integer size);

    @Select("SELECT COUNT(*) FROM song")
    int getCount();
}
