<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
<div>
	
 <label>输入名称：</label> <input id="queryName" value="${name}" type="text">	
 <button type="button" class="btn btn-success" onclick="query(0)">搜索</button>
 &nbsp;&nbsp;&nbsp;
 <button type="button" class="btn btn-danger" onclick="delBatch()">批量删除</button> 
 
	
</div>  
<div>
	<table class="table">
		<tr>
			<th>id <input type="checkbox" id="ids" onchange="selAll()"> </th>
		    <th>商品名称</th>
		    <th>标题</th>
		    <th>卖点</th>
		    <th>价格</th>
		    <th>市价</th>
		    <th>成本</th>
		    <th>库存</th>
		    <th>分类</th>
		    <th>品牌</th>
		    <th>更新时间</th>
		    <th>图片</th>
			<th>操作</th>
		</tr>
		<c:forEach items="${pageInfo.list}" var="sku">
			<tr>
			<td>${sku.id}  <input type="checkbox" value="${sku.id}" name="id"> </td>
			<td>${sku.spu.goodsName}</td>
			<td>${sku.title}</td>
			<td>${sku.sellPoint}</td>
			<td>${sku.price}</td>
			<td>${sku.marketPrice}</td>
			<td>${sku.costPrice}</td>
			<td>${sku.stockCount}</td>
			<td>${sku.spu.category.name}</td>
			<td>${sku.spu.brand.name}</td>
			<td><fmt:formatDate value="${sku.updateTime}" pattern="yyyy-MM-dd hh:mm"/></td>
			<td><img src="/pic/${sku.image}" width="50px" height="px"/></td>
			<td>
				<button type="button" class="btn btn-success" onclick="toModify(${sku.id})">修改</button>
				<button type="button" class="btn btn-danger" onclick="del(${sku.id})">删除</button>
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
		$("#workcontent").load("/sku/toupdate?skuId="+id);
		$("#workTitle").html("商品修改");
	}
	
	/**
	page 显示的页码
	*/
	function query(page){
		$("#workcontent").load("/sku/list?page="+page + "&name=" + $("#queryName").val());
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
		$("#workcontent").load("/spu/toadd");
		$("#workTitle").html("商品添加");
	}
	
	
</script>