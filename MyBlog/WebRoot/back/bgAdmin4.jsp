<%@ page language="java" contentType="text/html; charset=utf-8" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">


    <title>管理员管理</title>
    <meta name="keywords" content="">
    <meta name="description" content="">

    <link rel="shortcut icon" href="favicon.ico"> 
    <link href="../css/bootstrap.min14ed.css?v=3.3.6" rel="stylesheet">
    <link href="../css/font-awesome.min93e3.css?v=4.4.0" rel="stylesheet">

    <link href="../css/animate.min.css" rel="stylesheet">
    <link href="../css/style.min862f.css?v=4.1.0" rel="stylesheet">
    
    <!-- jqgrid-->
	<link href="../css/plugins/jqgrid/ui.jqgridffe4.css?0820" rel="stylesheet">
    
    <style>
			/* Additional style to fix warning dialog position */
			
			#alertmod_table_list_2 {
				top: 900px !important;
			}
		</style>

</head>

<body class="gray-bg">
	
    <div class="row wrapper border-bottom  white-bg page-heading">
        <div class="col-sm-4">
            <ol class="breadcrumb">
                <li>
                    <a href="../back/baMain.jsp">用户管理</a>
                </li>
                <li>
                    <strong>管理员管理</strong>
                </li>
            </ol>
        </div>
        <div class="col-sm-8">
        </div>
    </div>

    <div class="wrapper wrapper-content">
        <div class="row">
            <div class="col-sm-12">
            	<!--页面内容-->
                	<div class="jqGrid_wrapper">
						<table id="table_list"></table>
						<div id="pager_list"></div>
					</div>
            </div>
        </div>
    </div>
    <script src="../js/jquery.min.js?v=2.1.4"></script>
    <script src="../js/bootstrap.min.js?v=3.3.6"></script>
    <script src="../js/content.min.js?v=1.0.0"></script>
    <script type="text/javascript" src="#" charset="UTF-8"></script>
    
	<script src="../js/plugins/peity/jquery.peity.min.js"></script>
	<script src="../js/plugins/jqgrid/i18n/grid.locale-cnffe4.js?0820"></script>
	<script src="../js/plugins/jqgrid/jquery.jqGrid.minffe4.js?0820"></script>
	<script src="../js/content.min.js?v=1.0.0"></script>
    
    <script>
			$(document).ready(function() {
				$.jgrid.defaults.styleUI = "Bootstrap";
				
				$("#table_list").jqGrid({
					url:'../AdminServlet.do?action=getList',
					datatype: "json",
					mtype: "post", 
					height: 350,
					autowidth: true,
					shrinkToFit: true,
					rowNum: 10,
					rowList: [10, 20, 30],
					colNames: ["序号", "姓名", "联系电话", "电子邮箱", "头像地址", "状态"],
					colModel: [{
						name: "adminId",
						index: "adminId",
						editable: true,
						width: 60,
						sorttype: "int",
						search: true
					}, {
						name: "adminName",
						index: "adminName",
						editable: true,
						width: 90,
					}, {
						name: "adminTel",
						index: "adminTel",
						editable: true,
						width: 100
					}, {
						name: "adminEmail",
						index: "adminEmail",
						editable: true,
						width: 80,
						align: "center",
					}, {
						name: "adminPic",
						index: "adminPic",
						editable: true,
						width: 80,
						align: "left",
					}, {
						name: "adminIsDel",
						index: "adminIsDel",
						editable: true,
						width: 80,
						align: "left",
					}],
					jsonReader:{
					     total: "total",
					     records: "rows"
					},
					pager: "#pager_list",
					viewrecords: true,
					caption: "管理员管理",
					add: true,
					edit: true,
					addtext: "Add",
					edittext: "Edit",
					hidegrid: false
				});
				$("#table_list").setSelection(4, true);
				$("#table_list").jqGrid("navGrid", "#pager_list", {
					edit: true,
					add: true,
					del: true,
					search: true
				}, {
					height: 200,
					reloadAfterSubmit: true
				});
				$(window).bind("resize", function() {
					var width = $(".jqGrid_wrapper").width();
					$("#table_list").setGridWidth(width);
					$("#table_list").setGridWidth(width)
				})
			});
		</script>
</body>


</html>
