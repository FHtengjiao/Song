package com.imooc.servlet;

import com.imooc.song.entity.Song;
import com.imooc.song.entity.SongList;
import com.imooc.song.service.SongListService;
import com.imooc.song.service.SongService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet(name = "SongListServlet", urlPatterns = "/Song/list.do")
public class SongListServlet extends HttpServlet {

    private SongListService songListService;

    private SongService songService;

    @Override
    public void init() throws ServletException {
        songListService = new SongListService();
        songService = new SongService();
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if ("/Song/list.do".equals(request.getServletPath())) {
            Map<SongList,List<Song>> map = new HashMap<>();
            List<SongList> songLists = songListService.getSongListsByCreator((String)request.getSession().getAttribute("username"));
            for (SongList songList:
                 songLists) {
                List<String> songNames = Arrays.asList(songList.getSongName().split(","));
                map.put(songList, songService.getSongsByNames(songNames));
            }
            request.setAttribute("songMap", map);

            request.getRequestDispatcher("/WEB-INF/views/biz/songlist.jsp").forward(request, response);
        }
    }
}
