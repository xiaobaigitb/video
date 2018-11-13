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

 <nav class="navbar navbar-inverse navbar-fixed-top">
      <div class="container">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="#">视频管理系统</a>
        </div>
        <div id="navbar" class="collapse navbar-collapse">
          <ul class="nav navbar-nav">
            <li><a href="#">视频管理</a></li>
            <li class="active"><a href="#about">主讲人管理</a></li>
            <li><a href="#contact">课程管理</a></li>
          </ul>
        </div><!--/.nav-collapse -->
      </div>
    </nav>

	<div class="container">
		<div class="jumbotron">
  			<h2>编辑主讲人 - 主讲人管理</h2>
		</div>
		
<form class="form-horizontal" action="admin/speaker/add.do" method="post">
  <div class="form-group">
    <label for="speakerName" class="col-sm-2 control-label">名字</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" name="speakerName" id="speakerName" placeholder="主讲人姓名">
    </div>
  </div>
  <div class="form-group">
    <label for="speakerJob" class="col-sm-2 control-label">职业</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" name="speakerJob" id="speakerJob" placeholder="主讲人职业">
    </div>
  </div>
  <div class="form-group">
    <label for="speakerHeadUrl" class="col-sm-2 control-label">头像图片</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" name="speakerHeadUrl" id="speakerHeadUrl" placeholder="主讲人头像地址，网络图片">
    </div>
  </div>
  <div class="form-group">
    <label for="speakerDescr" class="col-sm-2 control-label">简介</label>
    <div class="col-sm-10">
      <textarea class="form-control" name="speakerDescr" id="speakerDescr" rows="3"></textarea>
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