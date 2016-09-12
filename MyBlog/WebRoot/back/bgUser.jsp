<%@ page language="java" contentType="text/html; charset=utf-8"
	import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title></title>
		<link href="../css/bootstrap.min14ed.css?v=3.3.6" rel="stylesheet">
		<link href="../css/font-awesome.min93e3.css?v=4.4.0" rel="stylesheet">
		<link href="../css/animate.min.css" rel="stylesheet">
		<link href="../css/style.min862f.css?v=4.1.0" rel="stylesheet">
		<link href="../css/plugins/bootstrap-table/bootstrap-table.min.css">
		
	</head>
	<body>
		<div id="toolbar" class="btn-group">
            <button id="btn_add" type="button" class="btn btn-default">
                <span class="glyphicon glyphicon-plus" aria-hidden="true"></span>新增
            </button>
            <button id="btn_edit" type="button" class="btn btn-default">
                <span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>修改
            </button>
            <button id="btn_delete" type="button" class="btn btn-default">
                <span class="glyphicon glyphicon-remove" aria-hidden="true"></span>删除
            </button>
        </div>
        <table id="tbAdmin" class="table table-hover">
        <thead>
								<tr>
									<th data-checkbox="true">全选</th>
									<th data-field="adminId" data-sortable="true">编号</th>
									<th data-field="adminName">姓名</th>
									<th data-field="adminTel">联系电话</th>
									<th data-field="adminEmail">邮箱</th>
									<th data-field="adminPic">头像地址</th>
									<th data-field="adminIsDel">状态</th>
									<th class="col-xs-2" data-field="action"
										data-formatter="actionFormatter" data-events="actionEvents">操作</th>
								</tr>
							</thead>
        
        </table>
	
	
	
	
	<script src="../js/jquery.min.js"></script>
	<script src="../js/bootstrap.min.js"></script>
	<script src="../js/plugins/bootstrap-table/bootstrap-table.min.js"></script>
	<script src="../js/plugins/bootstrap-table/bootstrap-table-mobile.min.js"></script>
	<script src="../js/plugins/bootstrap-table/locale/bootstrap-table-zh-CN.min.js"></script>
	<script src="../js/content.min.js?v=1.0.0"></script>
	<script type="text/javascript">
	$(function () {

	    //1.初始化Table
	    var oTable = new TableInit();
	    oTable.Init();

	    //2.初始化Button的点击事件
	    //var oButtonInit = new ButtonInit();
	   // oButtonInit.Init();

	});


	var TableInit = function () {
	    var oTableInit = new Object();
	    //初始化Table
	    oTableInit.Init = function () {
	        $('#tbAdmin').bootstrapTable({
	            url: '../AdminServlet.do?action=getList',         //请求后台的URL（*）
	            method: 'get',                      //请求方式（*）
	            toolbar: '#toolbar',                //工具按钮用哪个容器
	            striped: true,                      //是否显示行间隔色
	            cache: false,                       //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
	            pagination: true,                   //是否显示分页（*）
	            sortable: false,                     //是否启用排序
	            sortOrder: "asc",                   //排序方式
	            queryParams: oTableInit.queryParams,//传递参数（*）
	            sidePagination: "server",           //分页方式：client客户端分页，server服务端分页（*）
	            pageNumber:1,                       //初始化加载第一页，默认第一页
	            pageSize: 10,                       //每页的记录行数（*）
	            pageList: [10, 25, 50, 100],        //可供选择的每页的行数（*）
	            search: true,                       //是否显示表格搜索，此搜索是客户端搜索，不会进服务端，所以，个人感觉意义不大
	            strictSearch: true,
	            showColumns: true,                  //是否显示所有的列
	            showRefresh: true,                  //是否显示刷新按钮
	            minimumCountColumns: 2,             //最少允许的列数
	            clickToSelect: true,                //是否启用点击选中行
	            height: 500,                        //行高，如果没有设置height属性，表格自动根据记录条数觉得表格高度
	            uniqueId: "adminId",                //每一行的唯一标识，一般为主键列
	            showToggle:true,                    //是否显示详细视图和列表视图的切换按钮
	            cardView: false,                    //是否显示详细视图
	            detailView: false,                   //是否显示父子表
	            
	        });
	    };

	    //得到查询的参数
	    oTableInit.queryParams = function (params) {
	        var temp = {   //这里的键的名字和控制器的变量名必须一直，这边改动，控制器也需要改成一样的
	            limit: params.limit,   //页面大小
	            offset: params.offset,  //页码
	        };
	        return temp;
	    };
	    return oTableInit;
	};
	
	
	
	
	</script>
	
	</body>
</html>
