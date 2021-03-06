<%@ page language="java" contentType="text/html; charset=utf-8" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>

	<head>

		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">

		<title>后台登录</title>
		<link rel="shortcut icon" href="favicon.ico">
		<link href="css/bootstrap.min14ed.css?v=3.3.6" rel="stylesheet">
		<link href="css/font-awesome.min93e3.css" rel="stylesheet">
		<link href="css/animate.min.css" rel="stylesheet">
		<link href="css/style.min862f.css" rel="stylesheet">

		<script src="js/jquery.min.js"></script>
		<script src="js/bootstrap.min.js"></script>
		<!--[if lt IE 9]>
    <meta http-equiv="refresh" content="0;ie.html" />
    <![endif]-->
		<script>
			if(window.top !== window.self) {
				window.top.location = window.location;
			}
		</script>
	</head>

	<body class="gray-bg">

		<div class="middle-box text-center loginscreen  animated fadeInDown">
			<div>
				<div>

					<h1 class="logo-name">BG</h1>

				</div>
				<h3>欢迎使用博客系统</h3>

				<form class="m-t" role="form" action="AdminServlet.do" method="post">
					<input type="hidden" name="action" value="login">
					<div class="form-group">
						<input type="text" name="userName" class="form-control" placeholder="用户名" required="">
					</div>
					<div class="form-group">
						<input type="password" name="pwd" class="form-control" placeholder="密码" required="">
					</div>
					<button type="submit" class="btn btn-primary block full-width m-b">登 录</button>

					<p class="text-muted text-center">
						<a href="#"><small>忘记密码了？</small></a> |
						<a href="#">注册一个新账号</a>
					</p>

				</form>
			</div>
		</div>

	</body>

</html>