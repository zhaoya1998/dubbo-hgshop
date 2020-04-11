<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    

<form id="specForm">
	<input type="hidden"  name="id" value="${brand.id}">
	
	<div class="form-group row">
	    <label  class="col-sm-2 col-form-label">规格名称：</label>
	    <div class="col-sm-10">
	      <input type="text" name="specName"  class="form-control-plaintext" 
	       value="${brand.name}">
	    </div>
	  </div>
	<div class="form-group row">
	  <button type="button" class="btn btn-success" onclick="addOption()" >添加属性</button>
	</div>
	
	 <c:forEach items="${spec.optionList}" var="option" varStatus="index">
       <div class="form-row">
		    <div class="form-group col-md-5">
		      <label>规格属性值</label>
		      <input type="text" name="optionList[${index.index}].optionName" value="${option.optionName}" class="form-control">
		    </div>
		    <div class="form-group col-md-5">
		      <label for="inputPassword4">排序</label>
		      <input type="number" name="optionList[${index.index}].orders" value="${option.orders}" class="form-control" >
		    </div>
		    <div class="form-group col-md-2">
		        <label for="inputPassword4">&nbsp;</label>
		     	<input type="button" value="删除" class="btn btn-danger" onclick="remove($(this))">
		    </div>
	   </div>
   </c:forEach> 	
</form> 
<button type="button" class="btn btn-success" onclick="commitData()" >修改</button>
   
<script>
	
	var maxIndex =  ${spec.optionList.size()}
	
	function remove(obj){
		obj.parent().parent().remove();
	} 
	
	function commitData(){
	 
	  var formData= new FormData($("#specForm")[0])
	  $.ajax({url:"/spec/update",
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
				  $("#workcontent").load('/spec/list');
				  $("#workTitle").html("规格管理");
			  }else{
				  alert(data);
			  }
			  
		  }
		})
	}
	
	function addOption(){
		var str = '<div class="form-row">' +
	    '<div class="form-group col-md-5">' +
	     ' <label>规格属性值</label>' +
	     ' <input type="text" name="optionList['+maxIndex+'].optionName" value="${option.optionName}" class="form-control">' +
	    '</div>' +
	    '<div class="form-group col-md-5">' +
	    '  <label for="inputPassword4">排序</label>' +
	    '  <input type="number" name="optionList['+maxIndex+'].orders" value="${option.orders}" class="form-control" >' +
	    '</div>' +
	    '<div class="form-group col-md-2">' +
	    '    <label for="inputPassword4">&nbsp;</label>' +
	    ' 	<input type="button" value="删除" class="btn btn-danger" onclick="remove($(this))">' +
	    '</div>' +
    '</div>' 
	    maxIndex=maxIndex+1;
      $('#specForm').append(str);
	}
	
</script>
    