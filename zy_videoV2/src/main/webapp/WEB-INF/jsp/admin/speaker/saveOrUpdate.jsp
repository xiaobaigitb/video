<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%-- created by zhouyanchao on 2017年7月11日 下午5:04:12 --%>    
<!DOCTYPE html>
<html>
<head>
<base href="${BaseContext }">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>主讲人列表 -主讲人管理</title>
<link href="static/css/bootstrap.min.css" rel="stylesheet">
<script src="static/js/bootstrap.min.js"></script>
</head>
<body>
<jsp:include page="../header.jsp">
		<jsp:param value="speaker" name="fromJsp"/>
	</jsp:include> 
	<div class="container">
		<div class="jumbotron">
  			<h2>编辑主讲人 - 主讲人管理</h2>
		</div>
		
<form class="form-horizontal" action="admin/speaker/saveOrUpdate.do" method="post">
	<c:if test="${not empty speaker }">
		<input type="hidden" name="id" value="${speaker.id }">
	</c:if>
  <div class="form-group">
    <label for="speakerName" class="col-sm-2 control-label">名字</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" name="speakerName" id="speakerName" value="${speaker.speakerName }" placeholder="主讲人姓名">
    </div>
  </div>
  <div class="form-group">
    <label for="speakerJob" class="col-sm-2 control-label">职业</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" name="speakerJob" id="speakerJob" value="${speaker.speakerJob }" placeholder="主讲人职业">
    </div>
  </div>
  <div class="form-group">
    <label for="speakerHeadUrl" class="col-sm-2 control-label">头像图片</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" name="speakerHeadUrl" id="speakerHeadUrl" value="${speaker.speakerHeadUrl }" placeholder="主讲人头像地址，网络图片">
    </div>
  </div>
  <div class="form-group">
    <label for="speakerDescr" class="col-sm-2 control-label">简介</label>
    <div class="col-sm-10">
      <textarea class="form-control" name="speakerDescr" id="speakerDescr" rows="3">${speaker.speakerName }</textarea>
    </div>
  </div>
  <div class="form-group">
    <div class="col-sm-offset-2 col-sm-10">
      <button type="submit" class="btn  btn-primary">保存</button>
      <a href="admin/speaker/index.do" class="btn btn-default">返回列表</a>
    </div>
  </div>
</form>
	
	</div>


</body>
</html>