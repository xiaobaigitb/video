<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%-- created by zhouyanchao on 2017年7月11日 下午5:04:12 --%>
<!DOCTYPE html>
<html>
<head>
    <base href="${BaseContext }">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>预约列表 - 预约管理</title>
    <link href="static/css/bootstrap.min.css" rel="stylesheet">
    <script src="static/js/bootstrap.min.js"></script>
</head>
<body>

<nav class="navbar navbar-inverse navbar-fixed-top">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar"
                    aria-expanded="false" aria-controls="navbar">
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
                <li class="active"><a href="#about">预约人管理</a></li>
                <li><a href="#contact">预约人管理</a></li>
            </ul>
        </div><!--/.nav-collapse -->
    </div>
</nav>

<div class="container">
    <div class="jumbotron">
        <h2>编辑预约人 - 预约管理</h2>
    </div>

    <form class="form-horizontal" action="admin/caller/add.do" method="post">
        <div class="form-group">
            <label for="callerName" class="col-sm-2 control-label">名字</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" name="callerName" id="callerName" placeholder="预约人姓名">
            </div>
        </div>
        <div class="form-group">
            <label for="callerTel" class="col-sm-2 control-label">电话</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" name="callerTel" id="callerTel" placeholder="预约人电话">
            </div>
        </div>

        <div class="col-sm-10">
        <select class="form-control" name="callerIntent" id="callerIntent">
        <option value="0">WEB前端</option>
        <option value="1">JAVA编程基础</option>
        <option value="2">React</option>
        <option value="2">UI</option>
        <option value="2">Python</option>
        <option value="2">PHP</option>
        </select>
        </div>

        <div class="form-group">
            <label for="callerAge" class="col-sm-2 control-label">年龄</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" name="callerAge" id="callerAge" placeholder="预约人年龄">
            </div>
        </div>

        <div class="form-group">
            <label for="callerSex" class="col-sm-2 control-label">性别</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" name="callerSex" id="callerSex" placeholder="预约人性别">
            </div>
        </div>

        <div class="form-group">
            <label for="callerClassTime" class="col-sm-2 control-label">课时</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" name="callerClassTime" id="callerClassTime" placeholder="预约人时长">
            </div>
        </div>
        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <button type="submit" class="btn  btn-primary">保存</button>
                <a href="admin/caller/index.do" class="btn btn-default">返回列表</a>
            </div>
        </div>
    </form>

</div>


</body>
</html>