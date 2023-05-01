<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>


<nav class="navbar navbar-default" role="navigation">
		<div class="container-fluid">
			<div class="navbar-header">
				<a class="navbar-brand" href="http://43.139.95.90:8080/shop/admin/admin_index.jsp">蛋糕店后台</a>
			</div>
			<div>
				<ul class="nav navbar-nav">
					<li ><a href="http://43.139.95.90:8080/shop/admin/order_list?pageNo=1&status=0">订单管理</a></li>
					<li ><a href="http://43.139.95.90:8080/shop/admin/user_list">客户管理</a></li>
					<li ><a href="http://43.139.95.90:8080/shop/admin/goods_list">商品管理</a></li>
					<li ><a href="http://43.139.95.90:8080/shop/admin/type_list">类目管理</a></li>
					<li ><a href="http://43.139.95.90:8080/shop/admin/IP_list">登录状态管理</a></li>
					<li><a href="http://43.139.95.90:8080/shop/user_logout">退出</a></li>
				</ul>
			</div>
		</div>
	</nav>