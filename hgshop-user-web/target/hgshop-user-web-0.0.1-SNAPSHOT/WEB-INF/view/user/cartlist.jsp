<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
<div>

 &nbsp;&nbsp;&nbsp;
 <button type="button" class="btn btn-danger" onclick="delBatch()">批量删除</button> 
 
 
 	
</div>  
<div>
	<table class="table">
		<tr>
			<th>id <input type="checkbox" id="ids" onchange="selAll()"> </th>
		    <th>标题</th>
		    <th>价格</th>
		    <th>购买数量</th>
		    <th>总价</th>
			<th>操作</th>
		</tr>
		<c:forEach items="${listCart}" var="cart">
			<tr>
			<td>${cart.id}  <input type="checkbox" value="${cart.id}" name="id"> </td>
			<td>${cart.sku.title}</td>
			<td>${cart.sku.price}</td>
			<td>${cart.pnum}</td>
			<td>${cart.sku.price * cart.pnum}</td>
			<td>
				<button type="button" class="btn btn-danger" onclick="del(${sku.id})">删除</button>
			</td>
			</tr>
		</c:forEach>
	</table>
	<div>
	
	<label>配货地址：</label>
	<input type="text" size="200" id="address">	
	
	&nbsp;&nbsp;&nbsp;
 	<br/><button type="button" class="btn btn-danger" onclick="creatOrder()">下订单</button> 
 
	</div>
	
</div>  
<script>
	
	
	
	
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
		$.post('/user/delCart',{ids:delIds},function(data){
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
		
		$.post('/user/delCart',{ids:delIds},function(data){
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
	
	function creatOrder(){
		
		//被生成订单的数据的id，也就是cart的id 的数组
		var delIds = new Array();
		$("[name=id]:checked").each(function(){
			delIds.push($(this).val());
		}
		)
		if(delIds.length<=0){
			alert("没有选择数据");
			return
		}
		var result=confirm("确认生成订单么？")
		if(!result)
			return;
		
		// 输入配货地址。
		var address=$("#address").val(); 
		console.log(delIds);
		$.post('/user/createOrder',{address:address,ids:delIds},function(data){
			if(data=="success"){
				//删除成功
				alert("生成订单成功")
				//跳转到订单的列表页面
				//
				$("#workcontent").load("/user/listorders");
				$("#workTitle").html("订单管理");
			}else{
				alert("生成订单失败")
			}
		})
		
	}
	
</script>