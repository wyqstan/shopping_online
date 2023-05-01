<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
    <title>登录状态管理</title>
    <meta charset="utf-8"/>
    <link rel="stylesheet" href="css/bootstrap.css"/>
</head>
<body>
<div class="container-fluid">




    <jsp:include page="/admin/header.jsp"></jsp:include>

    <c:if test="${!empty msg }">
        <div class="alert alert-success">${msg }</div>
    </c:if>
    <c:if test="${!empty failMsg }">
        <div class="alert alert-danger">${failMsg }</div>
    </c:if>
    <br>

    <table class="table table-bordered table-hover">

        <tr>
            <th width="5%">用户名</th>
            <th width="10%">IP</th>
            <th width="10%">操作时间</th>
            <th width="10%">操作状态</th>
        </tr>

        <c:forEach items="${p.list}" var="u">
            <tr>
                <td><p>${u.username }</p></td>
                <td><p>${u.ip }</p></td>
                <td><p>${u.time }</p></td>
                <td><p>${u.status }</p></td>
            </tr>

        </c:forEach>


    </table>

    <br>

    <jsp:include page="/page.jsp">

        <jsp:param value="/admin/IP_list" name="url"/>
    </jsp:include>
    <br>
</div>
</body>
</html>