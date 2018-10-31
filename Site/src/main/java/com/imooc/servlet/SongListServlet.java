package com.imooc.servlet;

import com.imooc.song.common.StringUtils;
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
import java.text.SimpleDateFormat;
import java.util.*;

@WebServlet(name = "SongListServlet", urlPatterns = {
        "/Song/list.do",
        "/Song/allSongs.do",
        "/Song/songAddPrompt.do",
        "/Song/addSong.do",
        "/Song/songListAddPrompt.do",
        "/Song/songListAdd.do",
        "/Song/addSongsToListPrompt.do",
        "/Song/addSongsToList.do"
})
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
            Map<SongList,List<Song>> map = new LinkedHashMap<>();
            List<SongList> songLists = songListService.getSongListsByCreator((String)request.getSession().getAttribute("username"));
            for (SongList songList:
                 songLists) {
                if (songList.getSongName() != null) {
                    List<String> songNames = Arrays.asList(songList.getSongName().split(","));
                    map.put(songList, songService.getSongsByNames(songNames));
                } else {
                    map.put(songList, null);
                }

            }
            request.setAttribute("songMap", map);
            request.getRequestDispatcher("/WEB-INF/views/biz/songlist.jsp").forward(request, response);
        } else if ("/Song/allSongs.do".equals(request.getServletPath())) {
            List<Song> songs = songService.getSongs();
            request.setAttribute("songs", songs);
            request.getRequestDispatcher("/WEB-INF/views/biz/songs.jsp").forward(request, response);
        } else if ("/Song/songAddPrompt.do".equals(request.getServletPath())) {
            request.getRequestDispatcher("/WEB-INF/views/biz/addSong.jsp").forward(request, response);
        } else if ("/Song/addSong.do".equals(request.getServletPath())) {
            String songName = request.getParameter("songname");
            String singer = request.getParameter("singer");
            String category = request.getParameter("category");
            String writer = request.getParameter("writer");
            String language = request.getParameter("language");
            String issueDate = request.getParameter("issuedate");

            if (StringUtils.isNotEmptyString(songName) && StringUtils.isNotEmptyString(singer)
                    && StringUtils.isNotEmptyString(category) && StringUtils.isNotEmptyString(writer)
                    && StringUtils.isNotEmptyString(language) && StringUtils.isNotEmptyString(issueDate)) {
                try {
                    SimpleDateFormat sdf =  new SimpleDateFormat("yyyyMMdd");
                    Date issueTime = sdf.parse(issueDate);
                    Song song = new Song(songName, singer, category, writer, language, issueTime);
                    songService.addSong(song);
                    request.getRequestDispatcher("/Song/allSongs.do").forward(request, response);
                } catch (Exception e) {
                    request.getRequestDispatcher("/Song/songAddPrompt.do").forward(request, response);
                }
            }
            else{
                request.getRequestDispatcher("/Song/songAddPrompt.do").forward(request, response);
            }
        } else if ("/Song/songListAddPrompt.do".equals(request.getServletPath())) {
            request.getRequestDispatcher("/WEB-INF/views/biz/addSongList.jsp").forward(request, response);
        } else if ("/Song/songListAdd.do".equals(request.getServletPath())) {
            String name = request.getParameter("name");
            String description = request.getParameter("description");

            if (StringUtils.isNotEmptyString(name) && StringUtils.isNotEmptyString(description)) {
                    SongList songList = new SongList(name, (String)request.getSession().getAttribute("username"), description);
                    songListService.addSongList(songList);
                    request.getRequestDispatcher("/Song/list.do").forward(request, response);
            } else {
                request.getRequestDispatcher("/Song/songListAddPrompt.do").forward(request, response);
            }
        } else if ("/Song/addSongsToListPrompt.do".equals(request.getServletPath())) {
            String listId = request.getParameter("listId");
            request.setAttribute("listId", listId);
            List<Song> allSongs = songService.getSongs();
            request.setAttribute("allSongs", allSongs);
            request.getRequestDispatcher("/WEB-INF/views/biz/addSongToList.jsp").forward(request, response);
        } else if ("/Song/addSongsToList.do".equals(request.getServletPath())) {
            String listId = request.getParameter("listId");
            SongList songList = songListService.getSongListsById(Long.parseLong(listId));
            StringBuilder sb = new StringBuilder();
            if (songList.getSongName() != null) {
                sb.append(songList.getSongName());
            }
            String[] selectSongs = request.getParameterValues("selectSongs");
            for (String song : selectSongs) {
                if (sb.indexOf(song) == -1) {
                    if (sb.length() != 0) {
                        sb.append(",").append(song);
                    } else {
                        sb.append(song);
                    }
                }
            }
            songListService.updateSongNameInList(sb.toString(), songList.getId());
            request.getRequestDispatcher("/Song/list.do").forward(request, response);
        }
    }
}
