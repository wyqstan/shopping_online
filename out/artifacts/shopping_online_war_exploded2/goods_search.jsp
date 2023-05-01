<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>

<!DOCTYPE html>
<html>
<head>
	<title>首页</title>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<link type="text/css" rel="stylesheet" href="css/bootstrap.css">
	<link type="text/css" rel="stylesheet" href="css/style.css">
	<script type="text/javascript" src="js/jquery.min.js"></script>
	<script type="text/javascript" src="js/bootstrap.min.js"></script>
	<!-- <script type="text/javascript" src="js/simpleCart.min.js"></script> -->
	<script type="text/javascript" src="layer/layer.js"></script>
	<script type="text/javascript" src="js/cart.js"></script>
</head>
<body>
	
	



	<jsp:include page="/header.jsp">
	<jsp:param value="2" name="flag"/>
	</jsp:include>

	

	
	<!--products-->
	<div class="products">	 
		<div class="container">
			<h2>搜索"${param.keyword }"的结果</h2>
					
			<div class="col-md-12 product-model-sec">
				
					
				
				<c:forEach items="${p.list }"  var="g">
				<div class="product-grid">
						<a href="http://43.139.95.90:8080/shop/goods_detail?id=${g.id}">
							<div class="more-product"><span> </span></div>						
							<div class="product-img b-link-stripe b-animate-go  thickbox">
								<img src="http://43.139.95.90:8080/shop${g.cover}" class="img-responsive" alt="${g.name }" width="240" height="240">
								<div class="b-wrapper">
									<h4 class="b-animate b-from-left  b-delay03">							
										<button>查看详情</button>
									</h4>
								</div>
							</div>
						</a>				
						<div class="product-info simpleCart_shelfItem">
							<div class="product-info-cust prt_name">
								<h4>${g.name }</h4>								
								<span class="item_price">¥ ${g.price}</span>
								<input type="button" class="item_add items" value="加入购物车" onclick="buy(${g.id})">
								<div class="clearfix"> </div>
							</div>												
						</div>
					</div>
				</c:forEach>	
				
					
				
				
					
				
				<div class="clearfix"> </div>
			</div>
			<div><div style='text-align:center;'>
<a class='btn btn-info' <c:if test="${p.pageNo ==1}">disabled</c:if><c:if test="${p.pageNo !=1}">href="http://43.139.95.90:8080/shop/goods_search?pageNo=1&keyword=${keyword}"</c:if> >首页</a>
<a class='btn btn-info' <c:if test="${p.pageNo ==1}">disabled</c:if><c:if test="${p.pageNo !=1}">href="http://43.139.95.90:8080/shop/goods_search?pageNo=${p.pageNo-1 }&keyword=${keyword}"</c:if> >上一页</a>
<h3 style='display:inline;'>[${p.pageNo }/${p.totalPage}]</h3>
<h3 style='display:inline;'>[${p.totalCount}]</h3>
<a class='btn btn-info' <c:if test="${p.totalPage==0 || p.pageNo ==p.totalPage}">disabled</c:if><c:if test="${p.pageNo !=p.totalPage}">href="http://43.139.95.90:8080/shop/goods_search?pageNo=${p.pageNo+1 }&keyword=${keyword}"</c:if> >下一页</a>
<a class='btn btn-info' <c:if test="${p.totalPage==0 || p.pageNo ==p.totalPage}">disabled</c:if><c:if test="${p.pageNo !=p.totalPage}">href="http://43.139.95.90:8080/shop/goods_search?pageNo=${p.totalPage }&keyword=${keyword}"</c:if> >尾页</a>
<input type='text' class='form-control' style='display:inline;width:60px;' value=''/><a class='btn btn-info' href='javascript:void(0);' onclick='location.href="http://43.139.95.90:8080/shop/goods_search?keyword=${keyword}&pageNo="+(this.previousSibling.value)'>GO</a>
</div>
</div>
		</div>
	</div>
	<!--//products-->	
	
	




	
	<jsp:include page="/footer.jsp"></jsp:include>

</body>
</html>