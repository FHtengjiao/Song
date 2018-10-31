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
            <h1>添加歌曲<small></small></h1>
        </div>
    </div>
    <div class="row">
        <form role="form" action="${pageContext.request.contextPath}/Song/addSongsToList.do" method="post">
            <input type="hidden" name="listId" value="${listId}">
            <div class="form-group">
                <c:forEach var="song" items="${allSongs}">
                <label class="checkbox-inline input-lg">
                    <input type="checkbox" name="selectSongs"  value="${song.name}">${song.name}
                </label>
                </c:forEach>
            </div>
            <div class="form-group">
                <div class="col-lg-offset-4 col-lg-1">
                    <button type="submit" class="btn btn-primary">提交</button>
                </div>
                <div class="col-lg-1">
                    <button type="reset" class="btn btn-warning">取消</button>
                </div>
            </div>
        </form>
    </div>
</div>
</body>
</html>
