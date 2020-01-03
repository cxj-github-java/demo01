<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加商品分类</title>
</head>
<body>
	<form class="layui-form">
		<!-- 提示：如果你不想用form，你可以换成div等任何一个普通元素 -->
		<div class="layui-form-item">
			<label class="layui-form-label">输入框</label>
			<div class="layui-input-block">
				<input type="text" name="" placeholder="请输入" autocomplete="off"
					class="layui-input">
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">下拉选择框</label>
			<div class="layui-input-block">
				<select name="interest" lay-filter="aihao">
					<option value="0">写作</option>
					<option value="1">阅读</option>
				</select>
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">复选框</label>
			<div class="layui-input-block">
				<input type="checkbox" name="like[write]" title="写作"> <input
					type="checkbox" name="like[read]" title="阅读">
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">开关关</label>
			<div class="layui-input-block">
				<input type="checkbox" lay-skin="switch">
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">开关开</label>
			<div class="layui-input-block">
				<input type="checkbox" checked lay-skin="switch">
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">单选框</label>
			<div class="layui-input-block">
				<input type="radio" name="sex" value="0" title="男"> <input
					type="radio" name="sex" value="1" title="女" checked>
			</div>
		</div>
		<div class="layui-form-item layui-form-text">
			<label class="layui-form-label">请填写描述</label>
			<div class="layui-input-block">
				<textarea placeholder="请输入内容" class="layui-textarea"></textarea>
			</div>
		</div>
		<div class="layui-form-item">
			<div class="layui-input-block">
				<button class="layui-btn" lay-submit lay-filter="*">立即提交</button>
				<button type="reset" class="layui-btn layui-btn-primary">重置</button>
			</div>
		</div>
		<!-- 更多表单结构排版请移步文档左侧【页面元素-表单】一项阅览 -->
	</form>
	<script src="layui.js"></script>
	<script>
layui.use('form', function(){
  var form = layui.form;
  
  //各种基于事件的操作，下面会有进一步介绍
});
</script>
</body>
</html>