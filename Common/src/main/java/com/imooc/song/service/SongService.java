package com.imooc.song.service;

import com.imooc.song.common.MyBatisUtils;
import com.imooc.song.entity.Song;
import com.imooc.song.mapper.SongMapper;
import org.apache.ibatis.session.SqlSession;

import java.util.ArrayList;
import java.util.List;

public class SongService {

    public List<Song> getSongs() {
        SqlSession session = MyBatisUtils.getSqlSession();
        List<Song> songs = new ArrayList<>();
        try {
            SongMapper mapper = session.getMapper(SongMapper.class);
            songs = mapper.getSongs();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return songs;
    }

    public List<Song> getSongsByNames(List<String> names) {
        SqlSession session = MyBatisUtils.getSqlSession();
        List<Song> songs = new ArrayList<>();
        try {
            SongMapper mapper = session.getMapper(SongMapper.class);
            songs = mapper.getSongsByNames(names);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return songs;
    }
}
