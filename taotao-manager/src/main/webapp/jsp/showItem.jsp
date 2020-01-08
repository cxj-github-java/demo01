<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>商品展示</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
		
	
	<table class="layui-hide" id="showItemPage" lay-filter="itemToolbars"></table>
	<div class="layui-btn-container" style="display: none;"
		id="toolbarDemo">
		<div class="layui-from-item">
			<div class="layui-inline">
				<div class="layui-input-inline">
					<input type="text" class="layui-input" placeholder="请输入商品名称"
						id="title" name="title">
				</div>
			</div>
			<div class="layui-inline">
				  <select name="price" id="price">
					<option value='' selected>选择价格区间</option>
					<option value='0'>0-10000</option>
					<option value='1000'>10000-50000</option>
					<option value='5000'>>50000</option>
				  </select>
			</div>
			<div class="layui-inline">
				<input type="text" class="layui-input" placeholder="请输入商品卖点"
					id="sellPoint" name="sellPoint">
			</div>
			<button class="layui-btn " lay-event="search"
				lay-filter="tbItem_submit">
				<li class="layui-icon">&#xe615 搜索</li>
			</button>
		</div>
		
		<button class="layui-btn layui-btn-sm" lay-event="deleteItem">删除</button>
		<button class="layui-btn layui-btn-sm" lay-event="addItem">新增</button>
		<button class="layui-btn layui-btn-sm" lay-event="updateItem">修改</button>
		<button class="layui-btn layui-btn-sm" lay-event="upItem">上架</button>
		<button class="layui-btn layui-btn-sm" lay-event="downItem">下架</button>
	</div>

	<div style="display: none;" id="barDemo">
		<a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a> <a
			class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
	</div>
	<script>
		layui.use(
				'table',
				function() {
					table = layui.table;
					table.render({
										elem : '#showItemPage'//绑定哪个table表，可以用id选择器等等
										,
										url : '/item/showtbItem/'//请求服务器的url路径
										,
										toolbar : '#toolbarDemo' //开启头部工具栏，并为其绑定左侧模板
										,

										defaultToolbar : [ 'filter', { //自定义头部工具栏右侧图标。如无需自定义，去除该参数即可
											layEvent : 'LAYTABLE_TIPS',
											icon : 'layui-icon-tips'
										} ],
										title : '商品表',
										cols : [ [
												{
													type : 'checkbox',
													fixed : 'left'
												},
												{
													field : 'id',
													title : 'ID',
													width : 80,
													sort : true,
													fixed : 'left',
													totalRowText : '合计：'
												},
												{
													field : 'title',
													title : '商品标题',
													width : 70
												},
												{
													field : 'sellPoint',
													title : '卖点',
													width : 90,
													totalRow : true
												},
												{
													field : 'price',
													title : '价格',
													width : 80
												},
												{
													field : 'num',
													title : '数量',
													width : 80,
													totalRow : true
												},
												{
													field : 'barcode',
													title : '条形码',
													width : 90
												},
												{
													field : 'image',
													title : '图片路径',
													width : 100
												},
												{
													field : 'cId',
													title : '所属分类',
													width : 70
												},
												{
													field : 'status',
													title : '状态',
													width : 60,
													templet : '#titleTpl',
													sort : true
												},
												{
													field : 'created',
													title : '创建日期',
													width : 135,
													templet : '<div>{{ layui.util.toDateString(d.created, "yyyy-MM-dd HH:mm:ss")}}</div>'
												},
												{
													field : 'updated',
													title : '更新日期',
													width : 100,
													templet : '<div>{{ layui.util.toDateString(d.updated, "yyyy-MM-dd HH:mm:ss")}}</div>'
												}, {
													fixed : 'right',
													title : '操作',
													toolbar : '#barDemo',
													width : 150
												} ] ],
										page : true
									//默认开启分页
									});
							//头工具栏事件
							table.on('toolbar(itemToolbars)',
											function(obj) {
												var checkStatus = table
														.checkStatus(obj.config.id);
												switch (obj.event) {
												case 'deleteItem':
													var data = checkStatus.data;
													layer.alert(JSON
															.stringify(data));
													//发起ajax请求
													$.ajax({
																type : "POST",
																url : "/item/itemDelete",
																contentType : "application/json;charset=utf-8",
																data : JSON
																		.stringify(data),
																dataType : "json",
																success : function(
																		message) {
																	if (message.status == 200) {
																		//弹出层
																		layer
																				.alert('删除商品成功');
																		//刷新
																		table
																				.reload(
																						'showItemPage',
																						{});
																	} else {
																		layer
																				.alert(message.msg);
																	}
																}
															});
													break;
												case 'addItem':
													var data = checkStatus.data;
													layer.msg('选中了：'
															+ data.length
															+ ' 个');
													break;
												case 'updateItem':
													layer
															.msg(checkStatus.isAll ? '全选'
																	: '未全选');
													break;
												case 'upItem':
													var data = checkStatus.data;
													layer.alert(JSON
															.stringify(data));
													//发起ajax请求
													$
															.ajax({
																type : "POST",
																url : "/item/upItem",
																contentType : "application/json;charset=utf-8",
																data : JSON
																		.stringify(data),
																dataType : "json",
																success : function(
																		message) {
																	if (message.status == 200) {
																		//弹出层
																		layer
																				.alert(message.msg);
																		//刷新
																		table
																				.reload(
																						'showItemPage',
																						{});
																	} else {
																		layer
																				.alert(message.msg);
																	}
																}
															});
													break;
												case 'downItem':
													var data = checkStatus.data;
													layer.alert(JSON
															.stringify(data));
													//发起ajax请求
													$
															.ajax({
																type : "POST",
																url : "/item/downItem",
																contentType : "application/json;charset=utf-8",
																data : JSON
																		.stringify(data),
																dataType : "json",
																success : function(
																		message) {
																	if (message.status == 200) {
																		//弹出层
																		layer
																				.alert(message.msg);
																		//刷新
																		table
																				.reload(
																						'showItemPage',
																						{});
																	} else {
																		layer
																				.alert(message.msg);
																	}
																}
															});
													break;

												//自定义头工具栏右侧图标 - 提示
												case 'LAYTABLE_TIPS':
													layer
															.alert('这是工具栏右侧自定义的一个图标按钮');
													break;
												//搜索
												case 'search':
													var title = $('#title').val();
											    	  var price = $('#price').val();
											    	  var sellPoint = $('#sellPoint').val();
											    	   table.reload('showItemPage', {
											    	    url: "/item/searchtbItem"
											    	    ,where: {
											    	    	title : title,
											    	    	price:price,
											    	    	sellPoint:sellPoint
											    	    }
											    	    	
											    	    ,page: {
											    	     curr: 1
											    	    }
											    	   });
											    	  break;
												}
												;
											});
							//监听行工具事件
							table.on('tool(test)', function(obj) {
								var data = obj.data;
								//console.log(obj)
								if (obj.event === 'del') {
									layer.confirm('真的删除行么', function(index) {
										obj.del();
										layer.close(index);
									});
								} else if (obj.event === 'edit') {
									layer.prompt({
										formType : 2,
										value : data.email
									}, function(value, index) {
										obj.update({
											email : value
										});
										layer.close(index);
									});
								}
							});
						});
	</script>
	<script type="text/html" id="titleTpl">
    {{#  if(d.status ==0){ }}
        	下架 
    {{#  }  else if(d.status==1){ }}
       	上架
 	{{#  }  else if(d.status==2){ }}
       	删除
    {{#  } }}
</script>
</body>
</html>