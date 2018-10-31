package com.imooc.song.service;

import com.imooc.song.common.MyBatisUtils;
import com.imooc.song.entity.SongList;
import com.imooc.song.mapper.SongListMapper;
import org.apache.ibatis.session.SqlSession;

import java.util.ArrayList;
import java.util.List;

public class SongListService {

    public List<SongList> getSongLists() {
        SqlSession session = MyBatisUtils.getSqlSession();
        List<SongList> songLists = new ArrayList<>();
        try {
            SongListMapper mapper = session.getMapper(SongListMapper.class);
            songLists = mapper.getSongLists();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return songLists;
    }

    public List<SongList> getSongListsByCreator(String creator) {
        SqlSession session = MyBatisUtils.getSqlSession();
        List<SongList> songLists = new ArrayList<>();
        try {
            SongListMapper mapper = session.getMapper(SongListMapper.class);
            songLists = mapper.getSongListsByCreator(creator);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return songLists;
    }
}
