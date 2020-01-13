<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>商品展示</title>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/showItem.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
	<div style="padding: 15px; background-color: #FFFFFF">
		<div class="layui-from-item">
			<div class="layui-inline">
				<div class="layui-input-inline">
					<input type="text" class="layui-input" placeholder="请输入商品名称"
						id="title" name="title">
				</div>

			</div>
			<div class="layui-inline">
				<input type="text" class="layui-input" placeholder="请选择商品分类"
					id="selectCid" name="cId"> <input type="hidden" id="cId" />
			</div>
			<div class="layui-inline">
				<select name="price" id="price" class="layui-input">
					<option value=''>选择价格区间</option>
					<option value='0'>0-10000</option>
					<option value='10000'>10000-50000</option>
					<option value='50000'>>50000</option>
				</select>
			</div>

			<button class="layui-btn layui-btn-radius" id="search" type="button"
				lay-filter="tbItem_submit">
				<li class="layui-icon">&#xe615 搜索</li>
			</button>
		</div>
		<table class="layui-hide" id="showItemPage" lay-filter="itemToolbars"></table>
		<div class="layui-btn-container" style="display: none;"
			id="toolbarDemo">
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
	</div>
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