<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<link href="/resource/bootstrap4/css/bootstrap.css" rel="stylesheet" >

<div>
	<table class="table">
		<tr>
			<th>用户名</th>
			<th>当前金额</th>
			<th>级别</th>
			<th>总价</th>
			<th>操作</th>
		</tr>
		<c:forEach items="${list}" var="g">
			<tr>
				<td>${g.name}</td>
				<td>${g.price}</td>
				<td>${g.level}</td>
				<td>${g.sum}</td>
				<td>
						<button type="button" class="btn btn-danger" onclick="creatOrder()">下订单</button>
				</td>
			</tr>
		</c:forEach>
	</table>

</div>
<script type="text/javascript">
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