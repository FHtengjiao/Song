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
            <h1>编辑歌曲</h1>
        </div>
    </div>
    <div class="row">
        <form class="form-horizontal" action="${pageContext.request.contextPath}/Song/editSong.do" method="post">
            <input type="hidden" value="${song.id}" name="songId">
            <div class="form-group">
                <label for="songname" class="col-lg-2 control-label">歌曲名</label>
                <div class="col-lg-6">
                    <input type="text" class="form-control" id="songName" name="songname" value="${song.name}" placeholder="请输入歌曲名">
                </div>
            </div>
            <div class="form-group">
                <label for="singer" class="col-lg-2 control-label">歌手</label>
                <div class="col-lg-6">
                    <input type="text" class="form-control" id="singer" name="singer" value="${song.singer}" placeholder="请输入歌手">
                </div>
            </div>
            <div class="form-group">
                <label for="category" class="col-lg-2 control-label">类别</label>
                <div class="col-lg-6">
                    <input type="text" class="form-control" id="category" name="category" value="${song.category}" placeholder="请输入类别">
                </div>
            </div>
            <div class="form-group">
                <label for="writer" class="col-lg-2 control-label">作词</label>
                <div class="col-lg-6">
                    <input type="text" class="form-control" id="writer" name="writer" value="${song.writer}" placeholder="请输入作词">
                </div>
            </div>
            <div class="form-group">
                <label for="language" class="col-lg-2 control-label">语言</label>
                <div class="col-lg-6">
                    <input type="text" class="form-control" id="language" name="language" value="${song.language}" placeholder="请输入语言">
                </div>
            </div>
            <div class="form-group">
                <label for="issuedate" class="col-lg-2 control-label">发行日期</label>
                <div class="col-lg-6">
                    <input type="text" class="form-control" id="issuedate" name="issuedate" value="<fmt:formatDate value="${song.issueDate}" pattern="yyyyMMdd"/>"  placeholder="请输入发行日期">
                </div>
            </div>
            <div class="form-group">
                <div class="col-lg-offset-4 col-lg-1">
                    <button type="submit" class="btn btn-primary">提交</button>
                </div>
                <div class="col-lg-1">
                    <button type="reset" class="btn btn-primary">取消</button>
                </div>
            </div>
        </form>
    </div>
</div>
</body>
</html>
