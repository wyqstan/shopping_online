<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>

<!DOCTYPE html>
<html>
<head>
<title>商品编辑</title>
<meta charset="utf-8" />
<link rel="stylesheet" href="css/bootstrap.css" />
</head>
<body>
<div class="container-fluid">
	



	<jsp:include page="/admin/header.jsp"></jsp:include>

	<br><br>
	<form class="form-horizontal" action="http://43.139.95.90:8080/shop/admin/goods_edit" method="post" enctype="multipart/form-data">
		<input type="hidden" name="id" value="${g.id }"/>
		<input type="hidden" name="cover" value="${g.cover }"/>
		<input type="hidden" name="id" value="${g.image1 }"/>
		<input type="hidden" name="id" value="${g.image2 }"/>
		<input type="hidden" name="pageNo" value="${param.pageNo }"/>
		<input type="hidden" name="type" value="${param.type }"/>
		<div class="form-group">
			<label for="input_name" class="col-sm-1 control-label">名称</label>
			<div class="col-sm-6">
				<input type="text" class="form-control" id="input_name" name="name" value="${g.name }" required="required">
			</div>
		</div>
		<div class="form-group">
			<label for="input_name" class="col-sm-1 control-label">价格</label>
			<div class="col-sm-6">
				<input type="text" class="form-control" id="input_name" name="${g.price }" value="39">
			</div>
		</div>
		<div class="form-group">
			<label for="input_name" class="col-sm-1 control-label">介绍</label>
			<div class="col-sm-6">
				<input type="text" class="form-control" id="input_name" name="intro" value="${g.intro }">
			</div>
		</div>
		<div class="form-group">
			<label for="input_name" class="col-sm-1 control-label">库存</label>
			<div class="col-sm-6">
				<input type="text" class="form-control" id="input_name" name="${g.stock }" value="10">
			</div>
		</div>
		<div class="form-group">
			<label for="input_file" class="col-sm-1 control-label">封面图片</label> 
			<div class="col-sm-6"><img src="http://43.139.95.90:8080/shop${g.cover }" width="100" height="100"/>
				<input type="file" name="cover"  id="input_file">推荐尺寸: 500 * 500
			</div>
		</div>
		<div class="form-group">
			<label for="input_file" class="col-sm-1 control-label">详情图片1</label> 
			<div class="col-sm-6"><img src="http://43.139.95.90:8080/shop${g.image1}" width="100" height="100"/>
				<input type="file" name="image1"  id="input_file">推荐尺寸: 500 * 500
			</div>
		</div>
		<div class="form-group">
			<label for="input_file" class="col-sm-1 control-label">详情图片2</label> 
			<div class="col-sm-6"><img src="http://43.139.95.90:8080/shop${g.image2}" width="100" height="100"/>
				<input type="file" name="image2"  id="input_file">推荐尺寸: 500 * 500
			</div>
		</div>
		<div class="form-group">
			<label for="select_topic" class="col-sm-1 control-label">类目</label>
			<div class="col-sm-6">
				<select class="form-control" id="select_topic" name="typeid">
					
					<c:forEach items="${typeList }" var="t">
						
							<option <c:if test="${t.id==g.type.id }">selected="selected"</c:if> value="${t.id }">${t.name }</option>
						</c:forEach>
						
				</select>
			</div>
		</div>
		<div class="form-group">
			<div class="col-sm-offset-1 col-sm-10">
				<button type="submit" class="btn btn-success">提交修改</button>
			</div>
		</div>
	</form>
</div>
</body>
</html>