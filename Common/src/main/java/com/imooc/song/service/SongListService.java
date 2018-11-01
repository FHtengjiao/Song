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

    public SongList getSongListsById(Long id) {
        SqlSession session = MyBatisUtils.getSqlSession();
        SongList songList = null;
        try {
            SongListMapper mapper = session.getMapper(SongListMapper.class);
            songList = mapper.getSongListsById(id);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return songList;
    }

    public void addSongList(SongList songList) {
        SqlSession session = MyBatisUtils.getSqlSession();
        try {
            SongListMapper mapper = session.getMapper(SongListMapper.class);
            mapper.addSongList(songList);
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public void updateSongNameInList(String songNames, Long id) {
        SqlSession session = MyBatisUtils.getSqlSession();
        try {
            SongListMapper mapper = session.getMapper(SongListMapper.class);
            mapper.updateSongNameInList(songNames, id);
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public void updateSongList(SongList songList) {
        SqlSession session = MyBatisUtils.getSqlSession();
        try {
            SongListMapper mapper = session.getMapper(SongListMapper.class);
            mapper.updateSongList(songList);
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public void deleteSongList(Long id) {
        SqlSession session = MyBatisUtils.getSqlSession();
        try {
            SongListMapper mapper = session.getMapper(SongListMapper.class);
            mapper.deleteSongList(id);
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
}
