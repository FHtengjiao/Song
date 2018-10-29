<%--
  Created by IntelliJ IDEA.
  User: tengjiaoxie
  Date: 2018/10/29
  Time: 22:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>歌单列表</title>
    <link rel="stylesheet" href="../../../lib/bootstrap-3.3.7-dist/css/bootstrap.min.css">
    <script src="../../../lib/2.2.4/jquery-2.2.4.min.js"></script>
    <script src="../../../lib/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">
    <div class="row">
        <div class="page-header">
            <h1>歌单列表<small>${sessionScope.username}的歌单</small></h1>
        </div>
    </div>
    <div class="row">
        <ul class="nav nav-tabs">
            <li role="presentation" class="active"><a href="#">Home</a></li>
            <li role="presentation"><a href="#">Profile</a></li>
            <li role="presentation"><a href="#">Messages</a></li>
            <li role="presentation"><a href="#">+新增歌单+</a></li>
        </ul>
    </div>
    <div class="row">
        <table class="table table-striped table-bordered table-hover">
            <tr>
                <th>编号</th>
                <th></th>
                <th></th>
                <th></th>
                <th></th>
                <th></th>
                <th></th>
                <th></th>
            </tr>
        </table>
    </div>
</div>

</body>
</html>
