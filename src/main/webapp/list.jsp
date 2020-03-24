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
<script type="text/javascript">
	
	$(function(){
		$("#qx").toggle(function(){
			$("[name='gid']").attr("checked",true);
		},function(){
			$("[name='gid']").attr("checked",false);
		})
		
	})
</script>
<script type="text/javascript">
	function deleteAll(id){
		
		if(confirm("确定要删除吗?")){
		
			var ids = "";
			if(id == undefined){
				 ids = $("[name='gid']:checked").map(function(){
					return $(this).val();
				}).get().join(",");
			}else{
				ids = id;
			}
			
			$.post("deleteGoods",{"ids":ids},function(data){
				if(data){
					alert("删除成功!");
					location.href="http://localhost:8080/list";
				}else{
					alert('删除失败');
				}
			})
			
		} 
		
	}
</script>
</head>
<body>
	
	<a href="toadd"><input type="button" value="添加"></a>
		<input type="button" value="批删" onclick="deleteAll()">
	<table>
		<tr>
			<td>
				<input type="checkbox" id="qx">
			</td>
			<td>编号</td>
			<td>商品名称</td>
			<td>英文名称</td>
			<td>品牌</td>
			<td>种类</td>
			<td>尺寸</td>
			<td>单价</td>
			<td>数量</td>
			<td>标签</td>
			<td>图片</td>
			<td>操作</td>
		</tr>
		
	<c:forEach items="${page.list }" var="g">
		<tr>
			<td>
				<input type="checkbox" value="${g.gid }" name="gid">
			</td>
			<td>${g.gid }</td>
			<td>${g.cname }</td>
			<td>${g.ename }</td>
			<td>${g.bname }</td>
			<td>${g.kname }</td>
			<td>${g.size }</td>
			<td>${g.price }</td>
			<td>${g.num }</td>
			<td>${g.label }</td>
			<td>
				<img alt="xxx" src="lookImg?path=${g.priurl }" width="70px" height="55px">
			</td>
			<td>
				<a href="toupdate?gid=${g.gid }"><input type="button" value="修改"></a>
				<input type="button" value="删除" onclick="deleteAll('${g.gid}')">
			</td>
		</tr>
	</c:forEach>
	
	<tr>
		<td colspan="15">
			<a href="?pageNum=1">首页</a>
			<a href="?pageNum=${page.pageNum-1 < 1?page.pageNum:page.pageNum-1 }">上一页</a>
			<a href="?pageNum=${page.pageNum+1 > page.pages ?page.pageNum:page.pageNum+1 }">下一页</a>
			<a href="?pageNum=${page.pages }">尾页</a>
		</td>
	</tr>
	
	</table>

</body>
</html>