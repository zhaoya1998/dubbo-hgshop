<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en"><head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
    <meta name="generator" content="Jekyll v3.8.6">
    <title>登录</title>
  

    <!-- Bootstrap core CSS -->
	<link href="/resource/bootstrap4/css/bootstrap.css" rel="stylesheet" >
	<link href="/resource/css/floating-labels.css" rel="stylesheet" >


    <!-- Favicons -->
<!-- <link rel="apple-touch-icon" href="https://v4.bootcss.com/docs/assets/img/favicons/apple-touch-icon.png" sizes="180x180">
<link rel="icon" href="https://v4.bootcss.com/docs/assets/img/favicons/favicon-32x32.png" sizes="32x32" type="image/png">
<link rel="icon" href="https://v4.bootcss.com/docs/assets/img/favicons/favicon-16x16.png" sizes="16x16" type="image/png">
<link rel="manifest" href="https://v4.bootcss.com/docs/assets/img/favicons/manifest.json">
<link rel="mask-icon" href="https://v4.bootcss.com/docs/assets/img/favicons/safari-pinned-tab.svg" color="#563d7c">
<link rel="icon" href="https://v4.bootcss.com/docs/assets/img/favicons/favicon.ico">
 -->
 <meta name="msapplication-config" content="/docs/assets/img/favicons/browserconfig.xml">
<meta name="theme-color" content="#563d7c">


    <style>
      .bd-placeholder-img {
        font-size: 1.125rem;
        text-anchor: middle;
        -webkit-user-select: none;
        -moz-user-select: none;
        -ms-user-select: none;
        user-select: none;
      }

      @media (min-width: 768px) {
        .bd-placeholder-img-lg {
          font-size: 3.5rem;
        }
      }
    </style>
    <!-- Custom styles for this template -->
    <link href="login_files/floating-labels.css" rel="stylesheet">
  </head>
  <body>
    <form class="form-signin" action="/admin/login" method="post">
  <div class="text-center mb-4">
    <img class="mb-4" src="login_files/bootstrap-solid.svg" alt="" width="72" height="72">
    <h1 class="h3 mb-3 font-weight-normal">豪哥商城</h1>
    <p>
    	这是一个B2C商城，堪比拼多多
    </p>
  </div>

  <div class="form-label-group">
    <input type="text" id="username" name="username" class="form-control" placeholder="用户名" required="" autofocus="">
    <label for="inputEmail">用户名</label>
  </div>

  <div class="form-label-group">
    <input type="password" id="password"  name="password" class="form-control" placeholder="Password" required="">
    <label for="inputPassword">密码</label>
  </div>

  <div class="checkbox mb-3">
    <label>
      <input type="checkbox" value="remember-me"> 记住
    </label>
  </div>
  <button class="btn btn-lg btn-primary btn-block" type="submit">登录</button>
  <p class="mt-5 mb-3 text-muted text-center">© 2017-2020</p>
</form>

</body></html>