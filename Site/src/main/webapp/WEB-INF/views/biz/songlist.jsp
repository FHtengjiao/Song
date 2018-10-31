<%--
  Created by IntelliJ IDEA.
  User: tengjiaoxie
  Date: 2018/10/29
  Time: 22:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>歌单列表</title>
    <link rel="stylesheet" href="../../../lib/bootstrap-3.3.7-dist/css/bootstrap.min.css">
    <script src="../../../lib/2.2.4/jquery-2.2.4.min.js"></script>
    <script src="../../../lib/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
    <script>
        $().ready(function () {
            $("#songList li:first").addClass("active");
            $
        });
    </script>
</head>
<body>
<div class="container">
    <div class="row">
        <div class="page-header">
            <h1>歌单列表<small>${sessionScope.username}的歌单</small></h1>
        </div>
    </div>
    <div class="row">
        <ul class="nav nav-tabs" id="songList">
            <c:forEach items="${songMap}" var="map">
            <li id = "${map.key.id}" role="presentation"><a href="#">${map.key.name}</a></li>
            </c:forEach>
            <li role="presentation"><a href="#">+新增歌单+</a></li>
        </ul>
    </div>
    <c:forEach items="${songMap}" var="map">
    <div class="row" id="${map.key.id}">
        <div class="panel panel-default">
            <div class="panel-body">
                    ${map.key.description}
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
            </tr>
            <c:forEach items="${map.value}" var="song">
            <tr>
                <td>${song.id}</td>
                <td>${song.name}</td>
                <td>${song.singer}</td>
                <td>${song.category}</td>
                <td>${song.writer}</td>
                <td>${song.language}</td>
                <td>${song.issudate}</td>
            </tr>
            </c:forEach>
        </table>
    </div>
    </c:forEach>
</div>

</body>
</html>
