<%--
  Created by IntelliJ IDEA.
  User: ZhangSong
  Date: 2016/12/26
  Time: 20:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>jstl页面测试</title>
</head>
<body>
<c:choose>
    <c:when test="${is_share == '1'}">不显示推荐新闻</c:when>
    <c:otherwise>显示</c:otherwise>
</c:choose>
</body>
</html>
