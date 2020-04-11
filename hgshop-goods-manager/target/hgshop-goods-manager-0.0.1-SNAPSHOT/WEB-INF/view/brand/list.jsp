<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>        
<div>
	<!-- 放按钮 -->
</div>  
<div>
	<table class="table">
		<tr>
			<th>id</th>
			<th>名称</th>
			<th>型号</th>
			<th>flag</th>
			<th>操作</th>
		</tr>
		<c:forEach items="${pageInfo.list}" var="brand">
			<tr>
			<td>${brand.id}</td>
			<td>${brand.name}</td>
			<td>${brand.firstChar}</td>
			<td>${brand.deletedFlag}</td>
			<td>
				<button type="button" class="btn btn-success" onclick="toModify(${brand.id})">修改</button>
				<button type="button" class="btn btn-danger">删除</button>
				
			</td>
			</tr>
		</c:forEach>
		<tr>
		 <td colspan="10">
		 当前页${ pageInfo.pageNum}/${pageInfo.pages} 共${pageInfo.total}个品牌
		
		 
		 </td>
		</tr>
	</table>
</div>  
<script>
	function toModify(id){
		$("#workcontent").load("/brand/toupdate?id="+id);
		$("#workTitle").html("品牌修改");
	}
</script>