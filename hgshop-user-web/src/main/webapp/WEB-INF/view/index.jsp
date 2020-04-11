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
<link href="/resource/bootstrap-treeview/css/bootstrap-treeview.css" rel="stylesheet" >
<script type="text/javascript" src="/resource/bootstrap-treeview/js/bootstrap-treeview.js"> </script>



</head>
<body>
  <input type="hidden" id="catId" value="${catId}">
 <nav class="navbar navbar-expand-lg navbar-light bg-light">
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarTogglerDemo03" aria-controls="navbarTogglerDemo03" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>
  <a class="navbar-brand" href="#">豪哥商城</a>

  <div class="collapse navbar-collapse" id="navbarTogglerDemo03">
    <ul class="navbar-nav mr-auto mt-2 mt-lg-0">
      <li class="nav-item active">
        <a class="nav-link" href="#">首页 <span class="sr-only">(current)</span></a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="#">登录</a>
      </li>
    </ul>
    <form class="form-inline my-2 my-lg-0" action="/search">
      <input class="form-control mr-sm-2" type="search"  name="key" placeholder="Search" aria-label="Search">
      <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
    </form>
  </div>
</nav>
<div class="container-fluid">
	<div class="row"> 
		<div class="col-md-3">
			<div id="catTree"></div>
		</div>
		<div class="col-md-8">
			<div class="row">
				<c:forEach items="${pageInfo.list}" var="spu">
					<div class="col-md-3" style="margin-top:30px" >
						<div>
						 <a target="_blank" href="/goods/detail?id=${spu.id}"> <img src="/pic/${spu.smallPic}" width="120px" height="120px"> 
						 </a>
						 </div>
						<div>${spu.caption}</div>
					</div>
				</c:forEach>
			</div>
			
		</div>
	</div>
	 <nav aria-label="Page navigation example" style="margin-top:50px">
	  <ul class="pagination justify-content-center">
	    <li class="page-item ">
	      <a class="page-link" href="#" tabindex="-1"  onclick="goPage(1)">首页</a>
	    </li>
	    <c:forEach begin="1" end="${pageInfo.pages}" var="page">
	      <li class="page-item"><a class="page-link" href="#" onclick="goPage(${page})">${page}</a></li>
	   </c:forEach>
	    <li class="page-item">
	      <a class="page-link" href="#"   onclick="goPage(${pageInfo.pages})">尾页</a>
	    </li>
	  </ul>
	</nav>
</div>
<!-- 底部的条 -->
<div class="pos-f-t">
  
  <nav class="navbar navbar-dark bg-dark fixed-bottom">
           <font color="#ffffff">版权</font>
  </nav>
</div>
</body>
<script type="text/javascript">

function initTree() {
	//发送ajax获取树需要的数据
//	alert($.ajaxSettings.async=true)
	$.post("/treeData", {},
			function(treeData) {
				//初始化添加的时候分类的树
				$("#catTree").treeview({
					data : treeData,
					levels : 2,
					onNodeSelected : function(event, node) {
						if (node.nodes.length==0) {
							//如果是末级分类，则根据末级分类 查询
							//$("#add_spu_categmoory").val(node.text);
							//$("#add_spu_category_id").val(node.id);
							query(node.id,1)
							
						}
					}
				});

			}, "json");
}
initTree();



/**
 * 查询  分类id ，页码
 */
function query(catId,page){
	location.href="/index?page="+page+"&catId="+catId;
}

/**
 *  
   分页
 * page 要跳转的页码
 */
function goPage(page){
	var catId = $("#catId").val();
	console.log("cat id is " + catId)
	query(catId,page)
}
</script>
</html>