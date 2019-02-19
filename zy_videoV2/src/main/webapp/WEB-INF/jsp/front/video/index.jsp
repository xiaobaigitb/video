<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>

<head>
    <base href="${BaseContext}">
    <meta name="viewport" content="initial-scale=1, maximum-scale=1, user-scalable=no">
    <meta charset="utf-8">
    <meta name="renderer" content="webkit">
    <meta name="keywords" content="Web前端视频教程,Git视频教程,HTML5视频教程,UI视频教程,PHP视频教程,React视频教程,python基础教程">
    <meta name="description" content="智泷教育在线课程视频,为您提供Git,python,HTML5,UI,PHP,React教程等学科经典视频教程在线浏览学习,精细化知识点解析,深入浅出,想学不会都难,智泷教育,学习成就梦想！">
    <%@include file="../include/style.html"%>
    <link href="static/css/video-js.css" rel="stylesheet" type="text/css">
    <title>在线公开课-智泷教育|Git入门|React教程|HTML5|python|UI|PHP视频教程</title>

</head>

<body class="w100">
<jsp:include page="../include/header.jsp"></jsp:include>

    <%--<div id="detail"></div>--%>

<div>
    <!--面包屑导航-->
    <div class="container mian-nav">公开课 / ${subject.subjectName}</div>
    <input type="hidden" id="videoId" value="${videoId}">
    <div id="content">
    </div>
</div>
    
    <%@include file="../include/footer.jsp"%>

    <%@include file="../include/script.html"%>
    <script src="static/js/video.js"></script>
    <script>
        $(function () {
        	var id = $('#videoId').val();
           $('#content').load('front/video/videoData.do?videoId='+id);
           
           //播放量统计,不需要返回结果处理
           $.get('front/video/state.do?videoId='+id);
		});
    </script>
</body>

</html>
