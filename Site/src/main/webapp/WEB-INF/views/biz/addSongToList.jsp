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
        <form class="form-horizontal" action="${pageContext.request.contextPath}/Song/songListAdd.do" method="post">
            <div class="form-group">
                <label for="name" class="col-lg-2 control-label">歌单名</label>
                <div class="col-lg-6">
                    <input type="text" class="form-control" id="name" name="name" placeholder="请输入歌单名">
                </div>
            </div>
            <div class="form-group">
                <label for="description" class="col-lg-2 control-label">描述</label>
                <div class="col-lg-6">
                    <input type="text" class="form-control" id="description" name="description" placeholder="请输入描述">
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
