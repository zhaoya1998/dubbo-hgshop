<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 

<link href="/resource/bootstrap-treeview/css/bootstrap-treeview.css" rel="stylesheet" >
<script type="text/javascript" src="/resource/bootstrap-treeview/js/bootstrap-treeview.js"> </script>
<!-- sku的添加 -->
<div class="container">
	<div class="container">
	<form action="" id="skuForm">
		<input type="hidden" name="spuId" value="${spu.id}">
		<div class="form-group row">
		    <label  class="col-sm-2 col-form-label">商品名称</label>
		    <div class="col-sm-10">
		      <input type="text" disabled="disabled"  value="${spu.goodsName}" class="form-control" >
		    </div>
		 </div>
		 <div class="form-group row">
		    <label  class="col-sm-2 col-form-label">标题</label>
		    <div class="col-sm-10">
		      <input type="text" name="title" class="form-control" >
		    </div>
		 </div>
		  <div class="form-group row">
		    <label  class="col-sm-2 col-form-label">卖点</label>
		    <div class="col-sm-10">
		      <input type="text" name="sellPoint" class="form-control" >
		    </div>
		 </div>
		  <div class="form-group row">
		    <label  class="col-sm-2 col-form-label">价格</label>
		    <div class="col-sm-10">
		      <input type="text" name="price" class="form-control" >
		    </div>
		 </div>
		  <div class="form-group row">
		    <label  class="col-sm-2 col-form-label">大图</label>
		    <div class="col-sm-10">
		    	<input type="file" class="form-control-file" id="image" name="imageFile">
		    </div>
		 </div>
		  <div class="form-group row">
		    <label  class="col-sm-2 col-form-label">小图</label>
		    <div class="col-sm-10">
		    	<input type="file" class="form-control-file" id="file" name="cartFile">
		    </div>
		 </div>
		
		 <div class="form-group row" id="specs">
		    <label  class="col-sm-2 col-form-label">规格管理</label>
		     <div class="col-sm-10">
		    	<input type="button" value="添加属性"  onclick="addSpec()"> 
		    </div>
		   
		 
		 </div>
		 
		  <div class="form-group row">
		    <label  class="col-sm-2 col-form-label"></label>
		    <div class="col-sm-10">
		    	<input type="button" value="提交数据" onclick="commitData()">
		    </div>
		 </div>
		 
	 </form>
	 </div>
	 <div hidden="true" id="oneSepec">
	 	<div class="row col-md-12" style="height: 30px">
	 		<div class="col-md-2">
	 		</div>
		    <div class="col-md-2">
		      <select name="specId"  onchange="specChange(this)">
		      	<c:forEach items="${specList}" var="spec">
		      		<option value="${spec.id}">${spec.specName}</option>
		      	</c:forEach>
		      </select>
		    </div>
		    <div class="col-md-2">
		       <select name="optionId"></select>
		    </div>
		     <div class="col-md-2">
		      	 <button type="button" class="btn-small btn-danger" onclick="removeOption($(this))">移除</button> 
		    </div>
		 </div>
	 </div>
</div>

<script>
	function addSpec(){
	//	alert($("#oneSepec").html())
		$("#specs").append($("#oneSepec").html())
		
	}
	/**
	  当规格的下拉框发生改变的时候 对应的下拉框右侧是属性值列表应该发生改变
	*/
	function specChange(specObj){
		var sId = $(specObj).val();
		//alert(sId)
		$.post('/spec/getOptions',{specId:sId},function(data){
			//找到他的对应的右侧下拉框
			
			var childs = $(specObj).parent().next().children();
			//转换成jQuery对象
			var optionSelect = $(childs[0]);
			optionSelect.empty();
			for(i=0;i<data.length;i++){
				optionSelect.append("<option value='"+data[i].id+"'> "+
						 data[i].optionName+" </option> ")
			}	
		},"json");
		
	}
	
	function removeOption(btnObj){
		btnObj.parent().parent().remove();
	}
	
	function commitData(){
		
		 var formData= new FormData($("#skuForm")[0])
		  $.ajax({url:"/sku/add",
			//  dataType:"json",
			  data:formData,
			  // 让jQuery 不要再提交数据之前进行处理
			  processData : false,
			  // 提交的数据不能加消息头
			  contentType : false,
			  // 提交的方式 
			  type:"post",
			  // 成功后的回调函数
			  success:function(data){
				  //提交成功以后，要书信页面
				  if(data=="success"){
					  alert('成功')
					  $("#workcontent").load('/sku/list');
					  $("#workTitle").html("商品管理");
				  }else{
					  alert(data);
				  }
				  
			  }
			})
			
	}

</script>
		 