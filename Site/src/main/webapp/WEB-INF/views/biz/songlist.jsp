<%--
  Created by IntelliJ IDEA.
  User: tengjiaoxie
  Date: 2018/10/29
  Time: 22:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>歌单列表</title>
    <link rel="stylesheet" href="../../../lib/bootstrap-3.3.7-dist/css/bootstrap.min.css">
    <script src="../../../lib/2.2.4/jquery-2.2.4.min.js"></script>
    <script src="../../../lib/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
    <script>
        $().ready(function () {
            $("#songList li[id='tag_0']").addClass("active");
            $(".row[id^='list_']").hide();
            $(".row[id='list_0']").show();

            $("#songList li[id^='tag_']").click(function () {
                    let id = $(this).attr("id").split("_")[1];
                    $("#songList li[id^='tag_']").removeClass("active");
                    $(this).addClass("active");
                    $(".row[id^='list_']").hide();
                    let list_id = "list_" + id;
                    $(".row[id=" + list_id + "]").show();
                }
            );
        });
    </script>
</head>
<body>
<div class="container">
    <div class="row">
        <div class="page-header">
            <h1>歌单列表<small>${sessionScope.username}的歌单</small>
                <a href="${pageContext.request.contextPath}/Song/allSongs.do" class="btn btn-primary btn-lg pull-right" role="button">前往曲库</a>
            </h1>
        </div>
    </div>
    <div class="row">
        <ul class="nav nav-tabs" id="songList">
            <c:forEach items="${songMap}" var="map" varStatus="status">
            <li id="tag_${status.index}" role="presentation"><a href="javascript:void(0)">${map.key.name}</a></li>
            </c:forEach>
            <li role="presentation"><a href="${pageContext.request.contextPath}/SongList/songListAddPrompt.do">+新增歌单+</a></li>
        </ul>
    </div>
    <c:forEach items="${songMap}" var="map" varStatus="status">
    <div class="row" id="list_${status.index}">
        <div class="panel panel-default">
            <div class="panel-body">
                    ${map.key.description}
                        <div class="btn-group pull-right" role="group" aria-label="...">
                            <a href="${pageContext.request.contextPath}/SongList/editSongListPrompt.do?listId=${map.key.id}" class="btn btn-primary btn-sm" role="button">编辑此歌单</a>
                            <a href="${pageContext.request.contextPath}/SongList/deleteSongList.do?listId=${map.key.id}" class="btn btn-primary btn-sm" role="button">删除</a>
                        </div>
            </div>
        </div>
        <table class="table table-striped table-bordered table-hover">
            <tr>
                <th>歌曲id</th>
                <th>歌曲名</th>
                <th>歌手</th>
                <th>类别</th>
                <th>作词</th>
                <th>语言</th>
                <th>发行日期</th>
                <th>操作</th>
            </tr>
            <c:forEach items="${map.value}" var="song">
            <tr>
                <td>${song.id}</td>
                <td>${song.name}</td>
                <td>${song.singer}</td>
                <td>${song.category}</td>
                <td>${song.writer}</td>
                <td>${song.language}</td>
                <td><fmt:formatDate type="date" value="${song.issueDate}" pattern="yyyy-MM-dd"/></td>
                <td><a href="${pageContext.request.contextPath}/SongList/removeSongFromList.do?songName=${song.name}&&listId=${map.key.id}" class="btn btn-primary btn-sm" role="button">移出歌单</a></td>
            </tr>
            </c:forEach>
            <tr>
                <td colspan="8"><a href="${pageContext.request.contextPath}/SongList/addSongsToListPrompt.do?listId=${map.key.id}" class="btn btn-primary btn-lg center-block" role="button">添加歌曲</a></td>
            </tr>
        </table>
    </div>
    </c:forEach>
    <div class="row">
        <nav aria-label="Page navigation" class="text-center">
            <ul class="pagination pagination-lg">
                <li>
                    <c:choose>
                    <c:when test="${page==1}">
                <li class="disabled">
                                <span>
                                <span aria-hidden="true">&laquo;</span>
                                </span>
                </li>
                </c:when>
                <c:otherwise>
                    <li>
                        <a href="${pageContext.request.contextPath}/Song/allSongs.do?page=${page-1}" aria-label="Previous">
                            <span aria-hidden="true">&laquo;</span>
                        </a>
                    </li>
                </c:otherwise>
                </c:choose>
                </li>
                <%
                    Integer totalPage = (Integer) request.getAttribute("totalPage");
                    for(int i=1; i<=totalPage; i++){
                %>
                <li id="<%=i%>"><a href="${pageContext.request.contextPath}/Song/allSongs.do?page=<%=i%>"><%=i%></a></li>
                <%
                    }
                %>
                <li>
                    <c:choose>
                    <c:when test="${page==totalPage}">
                <li class="disabled">
                                <span>
                                <span aria-hidden="true">&raquo;</span>
                                </span>
                </li>
                </c:when>
                <c:otherwise>
                    <li>
                        <a href="${pageContext.request.contextPath}/Song/allSongs.do?page=${page+1}" aria-label="Next">
                            <span aria-hidden="true">&raquo;</span>
                        </a>
                    </li>
                </c:otherwise>
                </c:choose>
                </li>
            </ul>
        </nav>
    </div>
</div>

</body>
</html>
