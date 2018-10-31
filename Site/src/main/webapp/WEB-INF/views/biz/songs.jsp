<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/10/31
  Time: 12:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>
    <link rel="stylesheet" href="../../../lib/bootstrap-3.3.7-dist/css/bootstrap.min.css">
    <script src="../../../lib/2.2.4/jquery-2.2.4.min.js"></script>
    <script src="../../../lib/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
    <title>曲库</title>
</head>
<body>
<div class="container">
    <div class="row">
        <div class="page-header">
            <h1>歌曲库
                <a href="${pageContext.request.contextPath}/Song/list.do" class="btn btn-primary btn-lg pull-right" role="button">返回我的歌单</a>
            </h1>
        </div>
    </div>
    <div class="row">
        <div class="btn-group" role="group" aria-label="...">
            <a href="${pageContext.request.contextPath}/Song/songAddPrompt.do" class="btn btn-primary btn-lg" role="button">新增歌曲</a>
        </div>
    </div>

    <div class="clearfix" style="margin-bottom: 10px;"></div>

    <div class="row">
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
            <c:forEach items="${songs}" var="song">
                <tr>
                    <td>${song.id}</td>
                    <td>${song.name}</td>
                    <td>${song.singer}</td>
                    <td>${song.category}</td>
                    <td>${song.writer}</td>
                    <td>${song.language}</td>
                    <td><fmt:formatDate type="date" value="${song.issueDate}" pattern="yyyy-MM-dd"/></td>
                    <td>
                        <div class="btn-group" role="group" aria-label="...">
                            <a href="${pageContext.request.contextPath}/Song/editSong.do" class="btn btn-primary btn-sm" role="button">编辑</a>
                            <a href="${pageContext.request.contextPath}/Song/deleteSong.do" class="btn btn-primary btn-sm" role="button">删除</a>
                        </div>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>
</div>
</body>
</html>
