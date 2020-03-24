<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="<%=request.getContextPath() %>/css/css.css" rel="stylesheet">
<script type="text/javascript" src="<%=request.getContextPath() %>/js/jquery-1.8.2.min.js"></script>
</head>
<body>
	<form action="update" method="post" enctype="multipart/form-data">
			  <input type="hidden" name="gid" value="${goods.gid }">
		商品名称:<input type="text" name="cname" value="${goods.cname }"><br><br>
		英文名称:<input type="text" name="ename" value="${goods.ename }"><br><br>
		商品品牌:<select name="bid">
					<option value="">请选择</option>
					<c:forEach items="${brandList }" var="b">
						<option value="${b.bid }" <c:if test="${goods.bid== b.bid}">selected="selected"</c:if>>${b.bname }</option>				
					</c:forEach>
			  </select><br><br>
		商品种类:<select name="kid">
					<option value="">请选择</option>
					<c:forEach items="${kindList }" var="k">
						<option value="${k.kid }" <c:if test="${goods.kid== k.kid}">selected="selected"</c:if>>${k.kname }</option>				
					</c:forEach>
			  </select><br><br>
		尺寸:<input type="text" name="size" value="${goods.size }"><br><br>
		单价(元):<input type="text" name="price" value="${goods.price }"><br><br>
		数量:<input type="text" name="num" value="${goods.num }"><br><br>
		标签:<input type="text" name="label" value="${goods.label }"><br><br>
		商品图片上传:
		<img alt="xxx" src="lookImg?path=${goods.priurl }" width="70px" height="55px">
		<input type="file" name="file"><br><br>
		<input type="submit" value="修改">
	</form>
	

</body>
</html>