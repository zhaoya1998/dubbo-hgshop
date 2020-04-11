<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<link href="/resource/bootstrap-treeview/css/bootstrap-treeview.css" rel="stylesheet" >
<script type="text/javascript" src="/resource/bootstrap-treeview/js/bootstrap-treeview.js"> </script>


    
<div class="container">
	<div class="row">
		<div class="col-md-6">
			<div id="catTree"></div>
		</div>
		<div class="col-md-6">
			<form>
				  <input type="hidden" id="parentId" >
				  <div class="form-group row">
				  	<label  class="col-sm-2 col-form-label">父节点名</label>
				  	<input id="parentName">
				  </div>
				  <div class="form-group row">
				  	<label  class="col-sm-2 col-form-label">上级path</label>
				  	<input id="parentPath">
				  </div>
				  
				  <div class="form-group row">
				    <label  class="col-sm-2 col-form-label">节点名称</label>
				    <div class="col-sm-10">
				      <input type="text"  id="childName" value="">
				    </div>
				  </div>
				  <button type="button" class="btn btn-success" onclick="addChild()" >添加</button>
				  
			</form>
			<br style="border:2px" />
			<!-- 用于修改和删除 -->
			<form>
				  <input type="hidden" id="currentId" >
				  <div class="form-group row">
				  	<label  class="col-sm-2 col-form-label">当前节点</label>
				  	<input id="currentName">
				  </div>
				  <div class="form-group row">
				  	<label  class="col-sm-2 col-form-label">当前path</label>
				  	<input id="currentPath">
				  </div>
				  <button type="button" class="btn btn-success" onclick="update()" >修改</button>
				  <button type="button" class="btn btn-success" onclick="del()" id="btnDel" disabled="disabled" >删除</button>
				  
			</form>
			
			
		</div>
	</div>
</div>    

<script>

function initTree() {
	//发送ajax获取树需要的数据
//	alert($.ajaxSettings.async=true)
	$.post("/cat/treeData", {},
			function(treeData) {
				//初始化添加的时候分类的树
				$("#catTree").treeview({
					data : treeData,
					levels : 2,
					onNodeSelected : function(event, node) {
						//用于添加
						$("#parentId").val(node.id);
						$("#parentName").val(node.text);
						$("#parentPath").val(node.path);
						$("#childName").val("")
						
						//显示当前 用于删除或修改
						$("#currentId").val(node.id);
						$("#currentName").val(node.text);
						$("#currentPath").val(node.path);
						$("#btnDel").prop("disabled",node.nodes.length!=0)
						
						/*
						if (node.nodes.length==0) {
							alert("末级")
							$("#add_spu_categmoory").val(node.text);
							$("#add_spu_category_id").val(node.id);
							$("#addCategoryTree").hide();
						}else 
						{
							$("#parentId").val(node.id);
							$("#parentName").val(node.text);
							$("#name").val("")
							
							// 给预备修改的地方赋值
							$("#currentId").val(node.id);
							$("#currentName").val(node.text);
							$("#currentChildLenth").val(node.nodes.length)
							
						}
						*/
						
					}
				});

			}, "json");
}

initTree();

function addChild(){
	
	//$("#parentId").val(node.id);
	//$("#parentName").val(node.text);
	//$("#childName").val("")
	var path = $("#parentPath").val() +"/" +$("#childName").val();
	$.post('/cat/add',
			{parentId:$("#parentId").val(),
		     path:path, 
		     name:$("#childName").val()},
		function(data){
			if(data=="success"){
				alert("成功")
				//刷新
				initTree();
			}else{
				alert("失败")
			}
			
		}
	)
	
}

function update(){
	//修改
	$.post('/cat/update',
			{id:$("#currentId").val(),
		     path:$("#currentPath").val(), 
		     name:$("#currentName").val()},
		function(data){
			if(data=="success"){
				alert("成功")
				//刷新
				initTree();
			}else{
				alert("失败")
			}
			
		}
	)
	
}

function del(){
	if(confirm("您真的要删除这条数据么")){
		$.post('/cat/delete',
				{id:$("#currentId").val()},
			function(data){
				if(data=="success"){
					alert("成功")
					//刷新
					initTree();
				}else{
					alert("失败")
				}
				
			}
		)
		
	}
}


</script>