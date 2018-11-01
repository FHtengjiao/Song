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
    <script>
        $().ready(function () {
            let pageNo = "<%=request.getAttribute("page")%>";
            console.log(pageNo);
            $("li[id="+pageNo+"]").addClass("active");
        });
    </script>
    <title>曲库</title>
</head>
<body>
<div class="container">
    <div class="row">
        <div class="page-header">
            <h1>歌曲库
                <a href="${pageContext.request.contextPath}/SongList/list.do" class="btn btn-primary btn-lg pull-right" role="button">返回我的歌单</a>
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
                            <a href="${pageContext.request.contextPath}/Song/editSongPrompt.do?songId=${song.id}" class="btn btn-primary btn-sm" role="button">编辑</a>
                            <a href="${pageContext.request.contextPath}/Song/deleteSong.do?songId=${song.id}" class="btn btn-primary btn-sm" role="button">删除</a>
                        </div>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>
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
