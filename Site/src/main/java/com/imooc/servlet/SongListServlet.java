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
import java.util.*;

@WebServlet(name = "SongListServlet", urlPatterns = {
        "/SongList/list.do",
        "/SongList/songListAddPrompt.do",
        "/SongList/songListAdd.do",
        "/SongList/addSongsToListPrompt.do",
        "/SongList/addSongsToList.do",
        "/SongList/editSongListPrompt.do",
        "/SongList/editSongList.do",
        "/SongList/removeSongFromList.do",
        "/SongList/deleteSongList.do"
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
        if ("/SongList/list.do".equals(request.getServletPath())) {
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
        } else if ("/SongList/songListAddPrompt.do".equals(request.getServletPath())) {
            request.getRequestDispatcher("/WEB-INF/views/biz/addSongList.jsp").forward(request, response);
        } else if ("/SongList/songListAdd.do".equals(request.getServletPath())) {
            String name = request.getParameter("name");
            String description = request.getParameter("description");

            if (StringUtils.isNotEmptyString(name) && StringUtils.isNotEmptyString(description)) {
                    SongList songList = new SongList(name, (String)request.getSession().getAttribute("username"), description);
                    songListService.addSongList(songList);
                    request.getRequestDispatcher("/SongList/list.do").forward(request, response);
            } else {
                request.getRequestDispatcher("/SongList/songListAddPrompt.do").forward(request, response);
            }
        } else if ("/SongList/addSongsToListPrompt.do".equals(request.getServletPath())) {
            String listId = request.getParameter("listId");
            request.setAttribute("listId", listId);
            List<Song> allSongs = songService.getSongs();
            request.setAttribute("allSongs", allSongs);
            request.getRequestDispatcher("/WEB-INF/views/biz/addSongToList.jsp").forward(request, response);
        } else if ("/SongList/addSongsToList.do".equals(request.getServletPath())) {
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
            request.getRequestDispatcher("/SongList/list.do").forward(request, response);
        } else if ("/SongList/editSongListPrompt.do".equals(request.getServletPath())) {
            String id = request.getParameter("listId");
            SongList songList = songListService.getSongListsById(Long.parseLong(id));
            request.setAttribute("songList", songList);
            request.getRequestDispatcher("/WEB-INF/views/biz/editSongList.jsp").forward(request, response);
        } else if ("/SongList/editSongList.do".equals(request.getServletPath())) {
            String id = request.getParameter("id");
            String name = request.getParameter("name");
            String description = request.getParameter("description");

            if (StringUtils.isNotEmptyString(name) && StringUtils.isNotEmptyString(description)) {
                SongList songList = new SongList(Long.parseLong(id), name, (String)request.getSession().getAttribute("username"), description);
                songListService.updateSongList(songList);
                request.getRequestDispatcher("/SongList/list.do").forward(request, response);
            } else {
                request.getRequestDispatcher("/SongList/editSongListPrompt.do?listId="+id).forward(request, response);
            }
        } else if ("/SongList/deleteSongList.do".equals(request.getServletPath())) {
            String id = request.getParameter("listId");
            songListService.deleteSongList(Long.parseLong(id));
            request.getRequestDispatcher("/SongList/list.do").forward(request, response);
        } else if ("/SongList/removeSongFromList.do".equals(request.getServletPath())) {
            String songName = request.getParameter("songName");
            String id = request.getParameter("listId");

            String songNames = songListService.getSongListsById(Long.parseLong(id)).getSongName();

            if (songNames.contains(songName)) {
                songNames = songNames.replace("," + songName, "").replace(songName + ",", "").replace(songName, "");
                songListService.updateSongNameInList(songNames, Long.parseLong(id));
            }

            request.getRequestDispatcher("/SongList/list.do").forward(request, response);
        }
    }
}
