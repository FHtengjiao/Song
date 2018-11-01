package com.imooc.servlet;

import com.imooc.song.common.StringUtils;
import com.imooc.song.entity.Song;
import com.imooc.song.service.SongListService;
import com.imooc.song.service.SongService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@WebServlet(name = "SongServlet", urlPatterns = {
        "/Song/allSongs.do",
        "/Song/songAddPrompt.do",
        "/Song/addSong.do",
        "/Song/editSongPrompt.do",
        "/Song/editSong.do",
        "/Song/deleteSong.do"
})
public class SongServlet extends HttpServlet {
    private SongListService songListService;

    private SongService songService;

    @Override
    public void init() throws ServletException {
        songListService = new SongListService();
        songService = new SongService();
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if ("/Song/allSongs.do".equals(request.getServletPath())) {
            String page = request.getParameter("page");
            int pageNo = 1;
            if (StringUtils.isNotEmptyString(page)) {
                pageNo = Integer.parseInt(page);
            }
            List<Song> songs = songService.getSongsBySize((pageNo - 1) * 5, 5);
            int count = songService.getCount();
            int totalPage = count % 5 == 0 ? count / 5 : count / 5 + 1;
            request.setAttribute("page", pageNo);
            request.setAttribute("totalPage", totalPage);
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
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
                    Date issueTime = sdf.parse(issueDate);
                    Song song = new Song(songName, singer, category, writer, language, issueTime);
                    songService.addSong(song);
                    request.getRequestDispatcher("/Song/allSongs.do").forward(request, response);
                } catch (Exception e) {
                    request.getRequestDispatcher("/Song/songAddPrompt.do").forward(request, response);
                }
            } else {
                request.getRequestDispatcher("/Song/songAddPrompt.do").forward(request, response);
            }
        } else if ("/Song/editSongPrompt.do".equals(request.getServletPath())) {
            String id = request.getParameter("songId");
            Song song = songService.getSongById(Long.parseLong(id));
            request.setAttribute("song", song);
            request.getRequestDispatcher("/WEB-INF/views/biz/editSong.jsp").forward(request, response);
        } else if ("/Song/editSong.do".equals(request.getServletPath())) {
            String id = request.getParameter("songId");
            String songName = request.getParameter("songname");
            String singer = request.getParameter("singer");
            String writer = request.getParameter("writer");
            String category = request.getParameter("category");
            String language = request.getParameter("language");
            String issueDate = request.getParameter("issuedate");

            if (StringUtils.isNotEmptyString(songName) && StringUtils.isNotEmptyString(singer)
                    && StringUtils.isNotEmptyString(category) && StringUtils.isNotEmptyString(writer)
                    && StringUtils.isNotEmptyString(language) && StringUtils.isNotEmptyString(issueDate)) {
                try {
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
                    Date issueTime = sdf.parse(issueDate);
                    Song song = new Song(Long.parseLong(id), songName, singer, category, writer, language, issueTime);
                    songService.updateSong(song);
                    request.getRequestDispatcher("/Song/allSongs.do").forward(request, response);
                } catch (Exception e) {
                    request.getRequestDispatcher("/Song/editSongPrompt.do?songId="+id).forward(request, response);
                }
            } else {
                request.getRequestDispatcher("/Song/editSongPrompt.do?songId="+id).forward(request, response);
            }
        } else if ("/Song/deleteSong.do".equals(request.getServletPath())) {
            String id = request.getParameter("songId");
            songService.deleteSong(Long.parseLong(id));
            request.getRequestDispatcher("/Song/allSongs.do").forward(request, response);
        }
    }

    @Override
    public void destroy() {
        super.destroy();
    }
}
