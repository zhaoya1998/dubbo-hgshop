<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html lang="en"><head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
    <meta name="generator" content="Jekyll v3.8.6">
    <title>豪哥商城</title>
<link href="/resource/bootstrap4/css/bootstrap.css" rel="stylesheet" >
<script type="text/javascript" src="/resource/jquery/jquery-3.4.1.js"> </script>

<style type="text/css">
	
	.selectedDiv {
		border: solid 2px red;
	}
	
	.noselectedDiv {
		border: solid 2px blue;
	}
	
</style>
<title>商品详情-"${spu.caption}"</title>
</head>
<body>
	<div class="container" style="margin-top:100px">
		<div class="row">
		<div class="col-md-6">
			<div>
				<img width="400px" height="400px" src="/pic/${spu.smallPic}">
			</div>
			<div>
				${spu.goodsName}
			</div>
		</div>
		<div class="col-md-6" style="margin-top:40px">
			<!-- 显示sku -->
			<c:forEach items="${skuList}" var="sku">
				<div style="margin-top:10px" class="sku" >
					<input type="hidden" value="${sku.id}">
					<c:forEach items="${sku.specOptionList}" var="option">
						${option.specName}:${option.optionName} &nbsp;&nbsp;
					</c:forEach>
				</div>	
			</c:forEach>
			<div style="margin-top:30px"  >
			<input type="number" id="buyNum" >  <button type="button" class="btn  btn-danger btn-lg" onclick="addCart()">加入购物车</button>
			</div>
		</div>
	</div>
		
	</div>
	<script type="text/javascript">
		$(".sku").click(function(){
			//alert('tt')	
			$(".sku").each(function(){
				//alert('ff')
				$(this).removeClass("selectedDiv");
				$(this).addClass("noselectedDiv");
			})
			
			$(this).removeClass("noselectedDiv");
			$(this).addClass("selectedDiv");
			
			// 获取sku的id
		})
		
	 function addCart(){
			//获取被选中的sku id
			var skuId = $(".selectedDiv").children().val();
			var buyNum = $("#buyNum").val()
			
			$.post('/user/addCart',{skuId:skuId,num:buyNum},function(data){
				alert(data);
			})
		}	
	</script>
</body>
</html>