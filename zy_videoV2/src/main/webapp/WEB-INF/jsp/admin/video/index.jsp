<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<base href="${BaseContext }">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>视频列表 - 视频管理</title>
<link href="static/css/bootstrap.min.css" rel="stylesheet">
<link href="static/css/jquery-confirm.min.css" rel="stylesheet">
</head>
<body>
	<!-- 引入公用的导航信息 -->
	<jsp:include page="../header.jsp">
		<jsp:param value="video" name="fromJsp"/>
	</jsp:include>
	<%-- <%@include file="" %> --%>

	<div class="container">
		<div class="jumbotron">
  			<h2>视频列表 - 视频管理</h2>
		</div>
		<div class="row">
		<a href="admin/video/add.do" class="btn btn-primary">添加视频</a>
		<button class="btn btn-primary" type="button" onclick="batchDelete();">
		  批量删除 <span class="badge" id="countSpan">0</span>
		</button>
		<div style="float: right;">
			<form class="form-inline" action="admin/video/index.do" method="post">
			  <div class="form-group">
			    <input type="text" class="form-control" name="queryName"  value="${query.queryName }" placeholder="视频标题">
			  </div>
			   <div class="form-group">
			    <select name="speakerId"  class="form-control">
			    	<option value="0">请选择主讲人</option>
			    	<c:forEach items="${speakers }" var="sp">
			    		<option <c:if test="${query.speakerId==sp.id }">selected</c:if> value="${sp.id }">${sp.speakerName }</option>
			    	</c:forEach>
			    </select>
			  </div>
			  
			  <div class="form-group">
			    <select name="courseId" class="form-control">
			    	<option value="0">请选择课程</option>
			    	<c:forEach items="${courses }" var="c">
			    		<option  <c:if test="${query.courseId==c.id }">selected</c:if>  value="${c.id }">${c.courseName }</option>
			    	</c:forEach>
			    </select>
			  </div>
			  
			  <button type="submit" class="btn btn-primary">查询</button>
			</form>
		</div>
		</div>
		<form action="admin/video/batchDelete.do" name="deleteForm" method="get">
		<table class="table table-hover">
 			<thead>
 				<tr>
 					<th><input type="checkbox" id="checkAll" onclick="checkAll();"></th>
 					<th>序号</th>
 					<th>名称</th>
 					<th>介绍</th>
 					<th>讲师</th>
 					<th>课程</th>
 					<th>时长(秒 )</th>
 					<th>播放次数</th>
 					<th>编辑</th>
 					<th>删除</th>
 				</tr>
 			</thead>
 			<tbody>
 				<c:if test="${not empty results }">
 					<c:forEach items="${results }" var="sp" varStatus="i">
		 				<tr>
		 					<td><input type="checkbox" name="checkid" value="${sp.id }" onclick="countCheck();"> </td>
		 					<td>${i.index+1 }</td>
		 					<td>${sp.videoTitle }</td>
		 					<td>${sp.videoDescr }</td>
		 					<td>${sp.speakerName }</td>
		 					<td>${sp.courseName }</td>
		 					<td>${sp.videoLength}</td>
		 					<td>${sp.videoPlayTimes }</td>
		 					<td><a href="admin/video/edit.do?id=${sp.id }"><span class="glyphicon glyphicon-edit" aria-hidden="true"></span></a></td>
		 					<td><a href="#" onclick="return deleteInfo(${sp.id});"><span class="glyphicon glyphicon-trash" aria-hidden="true"></span></a></td>
		 				</tr>
	 				</c:forEach>
 				</c:if>
 				<c:if test="${empty results }">
 					<tr><td>当前查询结果为空!</td></tr>
 				</c:if>
 				
 				
 			</tbody>
		</table>
	</form>
	</div>

<script src="static/js/jquery-1.12.4.min.js"></script>
<script src="static/js/jquery-confirm.min.js"></script>
<script>
	//全选
	function checkAll(){
		var ca = document.getElementById('checkAll');
		console.log("是否选中："+ca.checked);
		var check = ca.checked;
		//根据全选复选框的状态，来操作上边三个复选框的状态
		var checkboxes = document.getElementsByName('checkid');
		for(var i=0;i<checkboxes.length;i++){
			var c = checkboxes[i];//当前遍历到的checkbox
			if(check){
				//如果是全部选中的状态，则把当前遍历的check选中
				c.checked=true;
			}else{
				//如果是不选的状态，则把当前遍历的check非选中
				c.checked=false;
			}	
		}
		//在修改全选的状态之后调用计数
		countCheck();
	}
	
	//计数功能，计算有多少复选框选中了
	function countCheck(){
		console.log('...count');
		var count=0;
		//遍历复选框，对选中的进行计数
		var checkboxes = document.getElementsByName('checkid');
		for(var i=0;i<checkboxes.length;i++){
			var c = checkboxes[i];//当前遍历到的checkbox
			if(c.checked){
				count++;
			}
		}
		//把计数更新到按钮徽章上
		var span = document.getElementById('countSpan');
		span.innerHTML=count;
		
	}
	//批量删除操作
	function batchDelete(){
		var count=0;
		var checkboxes = document.getElementsByName('checkid');
		for(var i=0;i<checkboxes.length;i++){
			var c = checkboxes[i];//当前遍历到的checkbox
			if(c.checked){
				count++;
			}
		}
		
		//判断count是否大于0，如果大于0，可以提交，等于0，提示先选择
		if(count>0){
			//getElementById获取表单
			//获取表单的方法
			var form = document.forms['deleteForm'];
			//提交表单
			form.submit();
		}else{
			alert('请先选择要删除的信息!');
		}
		
	}
	
	//删除数据操作
	function deleteInfo(id){
		//admin/video/delete.do	
		$.confirm({
			title:'删除确认提示',
			content:'确定要删除id为'+id+'的数据吗？',
			type:'orange',
			buttons:{
				confirm:{
					text:'删除',
					btnClass:'btn-primary',
					action:function(){
						//根据id发送删除请求ajax
						$.get('admin/video/delete.do',{id:id},function(data){
							if(data.success){
								//成功，刷新页面
								$.alert({
									content:'删除数据成功',
									onAction:function(){
										location.reload();
									}
								});
								
								//location.href='';
							}else{
								$.alert(data.message);
							}
							
						},'json');
						
						
					}
				},
				cancel:function(){
					//取消删除，自动关闭弹窗，不做其他操作
					
				}
			}
		});	
		
		return false;
	}
	
</script>


</body>
</html>