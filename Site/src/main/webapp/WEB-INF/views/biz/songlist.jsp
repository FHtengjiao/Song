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
            <li role="presentation"><a href="${pageContext.request.contextPath}/Song/songListAddPrompt.do">+新增歌单+</a></li>
        </ul>
    </div>
    <c:forEach items="${songMap}" var="map" varStatus="status">
    <div class="row" id="list_${status.index}">
        <div class="panel panel-default">
            <div class="panel-body">
                    ${map.key.description}
                        <a href="${pageContext.request.contextPath}/Song/editSongListPrompt.do?listId=${map.key.id}" class="btn btn-primary btn-sm pull-right" role="button">编辑此歌单</a>
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
                <td><a href="${pageContext.request.contextPath}/Song/removeSongFromList.do?songId=${song.id}" class="btn btn-primary btn-sm" role="button">移出歌单</a></td>
            </tr>
            </c:forEach>
            <tr>
                <td colspan="8"><a href="${pageContext.request.contextPath}/Song/addSongsToListPrompt.do?listId=${map.key.id}" class="btn btn-primary btn-lg center-block" role="button">添加歌曲</a></td>
            </tr>
        </table>
    </div>
    </c:forEach>
</div>

</body>
</html>
