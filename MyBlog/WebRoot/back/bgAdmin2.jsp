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
				var mydata = [{
					id: "1",
					invdate: "2010-05-24",
					name: "test",
					note: "note",
					tax: "10.00",
					total: "2111.00"
				}, {
					id: "2",
					invdate: "2010-05-25",
					name: "test2",
					note: "note2",
					tax: "20.00",
					total: "320.00"
				}, {
					id: "3",
					invdate: "2007-09-01",
					name: "test3",
					note: "note3",
					tax: "30.00",
					total: "430.00"
				}, {
					id: "4",
					invdate: "2007-10-04",
					name: "test",
					note: "note",
					tax: "10.00",
					total: "210.00"
				}, {
					id: "5",
					invdate: "2007-10-05",
					name: "test2",
					note: "note2",
					tax: "20.00",
					total: "320.00"
				}, {
					id: "6",
					invdate: "2007-09-06",
					name: "test3",
					note: "note3",
					tax: "30.00",
					total: "430.00"
				}, {
					id: "7",
					invdate: "2007-10-04",
					name: "test",
					note: "note",
					tax: "10.00",
					total: "210.00"
				}, {
					id: "8",
					invdate: "2007-10-03",
					name: "test2",
					note: "note2",
					amount: "300.00",
					tax: "21.00",
					total: "320.00"
				}, {
					id: "9",
					invdate: "2007-09-01",
					name: "test3",
					note: "note3",
					amount: "400.00",
					tax: "30.00",
					total: "430.00"
				}, {
					id: "11",
					invdate: "2007-10-01",
					name: "test",
					note: "note",
					amount: "200.00",
					tax: "10.00",
					total: "210.00"
				}, {
					id: "12",
					invdate: "2007-10-02",
					name: "test2",
					note: "note2",
					amount: "300.00",
					tax: "20.00",
					total: "320.00"
				}, {
					id: "13",
					invdate: "2007-09-01",
					name: "test3",
					note: "note3",
					amount: "400.00",
					tax: "30.00",
					total: "430.00"
				}, {
					id: "14",
					invdate: "2007-10-04",
					name: "test",
					note: "note",
					amount: "200.00",
					tax: "10.00",
					total: "210.00"
				}, {
					id: "15",
					invdate: "2007-10-05",
					name: "test2",
					note: "note2",
					amount: "300.00",
					tax: "20.00",
					total: "320.00"
				}, {
					id: "16",
					invdate: "2007-09-06",
					name: "test3",
					note: "note3",
					amount: "400.00",
					tax: "30.00",
					total: "430.00"
				}, {
					id: "17",
					invdate: "2007-10-04",
					name: "test",
					note: "note",
					amount: "200.00",
					tax: "10.00",
					total: "210.00"
				}, {
					id: "18",
					invdate: "2007-10-03",
					name: "test2",
					note: "note2",
					amount: "300.00",
					tax: "20.00",
					total: "320.00"
				}, {
					id: "19",
					invdate: "2007-09-01",
					name: "test3",
					note: "note3",
					amount: "400.00",
					tax: "30.00",
					total: "430.00"
				}, {
					id: "21",
					invdate: "2007-10-01",
					name: "test",
					note: "note",
					amount: "200.00",
					tax: "10.00",
					total: "210.00"
				}, {
					id: "22",
					invdate: "2007-10-02",
					name: "test2",
					note: "note2",
					amount: "300.00",
					tax: "20.00",
					total: "320.00"
				}, {
					id: "23",
					invdate: "2007-09-01",
					name: "test3",
					note: "note3",
					amount: "400.00",
					tax: "30.00",
					total: "430.00"
				}, {
					id: "24",
					invdate: "2007-10-04",
					name: "test",
					note: "note",
					amount: "200.00",
					tax: "10.00",
					total: "210.00"
				}, {
					id: "25",
					invdate: "2007-10-05",
					name: "test2",
					note: "note2",
					amount: "300.00",
					tax: "20.00",
					total: "320.00"
				}, {
					id: "26",
					invdate: "2007-09-06",
					name: "test3",
					note: "note3",
					amount: "400.00",
					tax: "30.00",
					total: "430.00"
				}, {
					id: "27",
					invdate: "2007-10-04",
					name: "test",
					note: "note",
					amount: "200.00",
					tax: "10.00",
					total: "210.00"
				}, {
					id: "28",
					invdate: "2007-10-03",
					name: "test2",
					note: "note2",
					amount: "300.00",
					tax: "20.00",
					total: "320.00"
				}, {
					id: "29",
					invdate: "2007-09-01",
					name: "test3",
					note: "note3",
					amount: "400.00",
					tax: "30.00",
					total: "430.00"
				}];
				
				$("#table_list").jqGrid({
					data: mydata,
					datatype: "local",
					height: 350,
					autowidth: true,
					shrinkToFit: true,
					rowNum: 10,
					rowList: [10, 20, 30],
					colNames: ["序号", "日期", "客户", "金额", "运费", "总额", "备注"],
					colModel: [{
						name: "id",
						index: "id",
						editable: true,
						width: 60,
						sorttype: "int",
						search: true
					}, {
						name: "invdate",
						index: "invdate",
						editable: true,
						width: 90,
						sorttype: "date",
						formatter: "date"
					}, {
						name: "name",
						index: "name",
						editable: true,
						width: 100
					}, {
						name: "amount",
						index: "amount",
						editable: true,
						width: 80,
						align: "right",
						sorttype: "float",
						formatter: "number"
					}, {
						name: "tax",
						index: "tax",
						editable: true,
						width: 80,
						align: "right",
						sorttype: "float"
					}, {
						name: "total",
						index: "total",
						editable: true,
						width: 80,
						align: "right",
						sorttype: "float"
					}, {
						name: "note",
						index: "note",
						editable: true,
						width: 100,
						sortable: false
					}],
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
