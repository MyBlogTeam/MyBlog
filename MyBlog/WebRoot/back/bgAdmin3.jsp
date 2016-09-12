<%@ page language="java" contentType="text/html; charset=utf-8"
	import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>


<head>

<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">


<title>管理员管理</title>

<link rel="shortcut icon" href="favicon.ico">
<link href="../css/bootstrap.min14ed.css?v=3.3.6" rel="stylesheet">
<link href="../css/font-awesome.min93e3.css?v=4.4.0" rel="stylesheet">
<link href="../css/plugins/bootstrap-table/bootstrap-table.min.css" rel="stylesheet">
<link href="../css/animate.min.css" rel="stylesheet">
<link href="../css/style.min862f.css?v=4.1.0" rel="stylesheet">


</head>

<body class="gray-bg">

	<div class="row wrapper border-bottom  white-bg page-heading">
		<div class="col-sm-4">
			<ol class="breadcrumb">
				<li><a href="index-2.html">用户管理</a></li>
				<li><strong>管理员管理</strong></li>
			</ol>
		</div>
		<div class="col-sm-8"></div>
	</div>

	<div class="wrapper wrapper-content">
		<div class="row">
			<div class="col-sm-12">
				<!--页面内容-->
				<div class="ibox float-e-margins">
				
					<div class="ibox-title">
                        <h5>管理员管理</h5>
                        <div class="ibox-tools">
                            <a class="collapse-link">
                                <i class="fa fa-chevron-up"></i>
                            </a>
                            <a class="dropdown-toggle" data-toggle="dropdown" href="table_basic.html#">
                                <i class="fa fa-wrench"></i>
                            </a>
                            <ul class="dropdown-menu dropdown-user">
                                <li><a href="table_basic.html#">选项1</a>
                                </li>
                                <li><a href="table_basic.html#">选项2</a>
                                </li>
                            </ul>
                            <a class="close-link">
                                <i class="fa fa-times"></i>
                            </a>
                        </div>
                    </div>
					<div class="ibox-content">
						<table class="table table-bordered">
							<thead>
								<tr>
									<th><input type="checkbox" />全选</th>
									<th>编号</th>
									<th>姓名</th>
									<th>联系电话</th>
									<th>邮箱</th>
									<th>头像</th>
									<th>状态</th>
									<th>操作</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${adminList}" var="admin">
									<tr>
										<td><input type="checkbox" /></td>
										<td>${admin.adminId}</td>
										<td>${admin.adminName}</td>
										<td>${admin.adminTel}</td>
										<td>${admin.adminEmail}</td>
										<td>${admin.adminPic}</td>
										<td>${admin.adminIsDel}</td>
										<td>
											<a href=#>详情</a>
											<a href=#>添加</a> 
											<a href=#>修改</a>
											<a href=#>删除</a>
										</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
				</div>
			</div>
		</div>
	</div>
	
	<script src="../js/jquery.min.js?v=2.1.4"></script>
    <script src="../js/bootstrap.min.js?v=3.3.6"></script>
    <script src="../js/content.min.js?v=1.0.0"></script>
    <script src="../js/plugins/bootstrap-table/bootstrap-table.min.js"></script>
    <script src="../js/plugins/bootstrap-table/bootstrap-table-mobile.min.js"></script>
    <script src="../js/plugins/bootstrap-table/locale/bootstrap-table-zh-CN.min.js"></script>
    <script src="../js/demo/bootstrap-table-demo.min.js"></script>
</body>

</html>
