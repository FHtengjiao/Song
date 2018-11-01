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

    public void addSong(Song song) {
        SqlSession session = MyBatisUtils.getSqlSession();
        try {
            SongMapper mapper = session.getMapper(SongMapper.class);
            mapper.addSong(song);
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public Song getSongById(Long id) {
        SqlSession session = MyBatisUtils.getSqlSession();
        Song song = null;
        try {
            SongMapper mapper = session.getMapper(SongMapper.class);
            song = mapper.getSongById(id);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return song;
    }

    public void updateSong(Song song) {
        SqlSession session = MyBatisUtils.getSqlSession();
        try {
            SongMapper mapper = session.getMapper(SongMapper.class);
            mapper.updateSong(song);
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public void deleteSong(Long id) {
        SqlSession session = MyBatisUtils.getSqlSession();
        try {
            SongMapper mapper = session.getMapper(SongMapper.class);
            mapper.deleteSong(id);
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public List<Song> getSongsBySize(Integer skip, Integer size) {
        SqlSession session = MyBatisUtils.getSqlSession();
        List<Song> songs = new ArrayList<>();
        try {
            SongMapper mapper = session.getMapper(SongMapper.class);
            songs = mapper.getSongsBySize(skip, size);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return songs;
    }

    public int getCount() {
        SqlSession session = MyBatisUtils.getSqlSession();
        int count = 0;
        try {
            SongMapper mapper = session.getMapper(SongMapper.class);
            count = mapper.getCount();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return count;
    }

    public List<Song> getSongsByNamesAndSize(List<String> names, Integer skip, Integer size) {
        SqlSession session = MyBatisUtils.getSqlSession();
        List<Song> songs = new ArrayList<>();
        try {
            SongMapper mapper = session.getMapper(SongMapper.class);
            songs = mapper.getSongsByNamesAndSize(names, skip, size);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return songs;
    }
}
