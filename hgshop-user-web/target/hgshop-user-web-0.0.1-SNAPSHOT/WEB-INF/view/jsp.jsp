<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="/resource/bootstrap4/css/bootstrap.css" rel="stylesheet" >
<script type="text/javascript" src="/resource/jquery/jquery-3.4.1.js"> </script>

</head>
<body>
	<script type="text/javascript">
		function getkey(){
			
			alert('准备获取key')
			$.post("getkey",{},function(data){
				alert('获取到的key shi ' + data)
			})
		}
		getkey();
	</script>	

</body>
</html>