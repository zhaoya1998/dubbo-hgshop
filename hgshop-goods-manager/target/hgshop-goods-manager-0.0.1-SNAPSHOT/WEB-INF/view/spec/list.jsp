<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>        
<div>
	
 <label>输入名称：</label> <input id="queryName" value="${name}" type="text">	
 <button type="button" class="btn btn-success" onclick="query(0)">搜索</button>
 &nbsp;&nbsp;&nbsp;
 <button type="button" class="btn btn-danger" onclick="delBatch()">批量删除</button> 
 
 <button type="button" class="btn btn-danger" onclick="toAdd()">添加</button> 
	
</div>  
<div>
	<table class="table">
		<tr>
			<th>id <input type="checkbox" id="ids" onchange="selAll()"> </th>
			<th>名称</th>
			<th>选项数据</th>
			<th>操作</th>
		</tr>
		<c:forEach items="${pageInfo.list}" var="spec">
			<tr>
			<td>${spec.id}  <input type="checkbox" value="${spec.id}" name="id"> </td>
			<td>${spec.specName}</td>
			<td> <c:forEach items="${spec.optionList}" var="option">
				${option.optionName} &nbsp;&nbsp; 
			</c:forEach> </td>
			<td>
				<button type="button" class="btn btn-success" onclick="toModify(${spec.id})">修改</button>
				<button type="button" class="btn btn-danger" onclick="del(${spec.id})">删除</button>
			</td>
			</tr>
		</c:forEach>
		<tr> <td colspan="4">
			<nav aria-label="...">
				  <ul class="pagination">
				    <li class="page-item ">
				      <a class="page-link" href="javascript:query(1)" tabindex="-1" >首页</a>
				    </li>
				    <c:forEach begin="1"  end="${pageInfo.pages}" var="page">
				    	<!-- 显示非当前 -->
				    	<c:if test="${page!=pageInfo.pageNum}">
				    		<li class="page-item"><a class="page-link" href="javascript:query(${page})">${page}</a></li>
				    	</c:if>
				    	<!-- 显示当前页码 -->
				    	<c:if test="${page==pageInfo.pageNum}">
				    		<li class="page-item active" aria-current="page">
				      			<a class="page-link" href="#">${page}<span class="sr-only">(current)</span></a>
				    		</li>
				    	</c:if>
				    </c:forEach>
				    
				    
				      
				    <li class="page-item">
				      <a class="page-link" href="javascript:query(${pageInfo.pages})">尾页</a>
				    </li>
				  </ul>
				</nav>
		</td></tr>
	</table>
</div>  
<script>
	function toModify(id){
		$("#workcontent").load("/spec/toupdate?id="+id);
		$("#workTitle").html("规格修改");
	}
	
	/**
	page 显示的页码
	*/
	function query(page){
		$("#workcontent").load("/spec/list?page="+page + "&name=" + $("#queryName").val());
	}
	
	function selAll(){
		$("[name=id]").each(function(){
			$(this).prop("checked",$("#ids").prop("checked"))
		})
	}
	
	// 单个删除
	function del(id){
		
		var result=confirm("确认删除该条数据么？")
		if(!result)
			return;
		
		var delIds = new Array();
		delIds.push(id)
		$.post('/spec/delBatch',{ids:delIds},function(data){
			if(data=="success"){
				//删除成功
				alert("删除成功")
				//刷新页面
				query(1);
			}else{
				alert("删除失败")
			}
		})
	
	}
	
	function delBatch(){
		//被删除的id
		var delIds = new Array();
		$("[name=id]:checked").each(function(){
			delIds.push($(this).val());
		}
		)
		if(delIds.length<=0){
			alert("没有选择数据");
			return
		}
		var result=confirm("确认删除这些数据么？")
		if(!result)
			return;
		
		$.post('/spec/delBatch',{ids:delIds},function(data){
			if(data=="success"){
				//删除成功
				alert("删除成功")
				//刷新页面
				query(1);
			}else{
				alert("删除失败")
			}
		})
		
	}
	
	function toAdd(){
		$("#workcontent").load("/spec/toadd");
		$("#workTitle").html("添加规格");
	}
	
	
</script>