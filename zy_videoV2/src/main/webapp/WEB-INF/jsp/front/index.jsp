<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>

<head>
    <base href="${BaseContext}">
    <meta name="viewport" content="initial-scale=1, maximum-scale=1, user-scalable=no">
    <meta charset="utf-8">
    <meta name="renderer" content="webkit">
    <meta name="keywords" content="Web前端视频教程,Git视频教程,HTML5视频教程,UI视频教程,PHP视频教程,React视频教程,python基础教程">
    <meta name="description"
          content="智泷教育在线课程视频,为您提供Git,python,HTML5,UI,PHP,React教程等学科经典视频教程在线浏览学习,精细化知识点解析,深入浅出,想学不会都难,智泷教育,学习成就梦想！">
    <%@include file="./include/style.html" %>
    <title>在线公开课-智泷教育|Git|React教程|HTML5|python|UI|PHP视频教程</title>

</head>

<body class="w100">
<jsp:include page="./include/header.jsp"></jsp:include>

<!--banner图-->
<div class="banner index-banner"></div>

<!--模块化课程-->
<div class="course">
    <div class="container">
        <p class="title">模块化课程，从入门到精通，大神并不遥远</p>
        <div class="course-info">
            <table cellspacing="10">
                <tr>
                    <td colspan="2">
                        <a href="front/course/index.do?subjectId=1">
                            <img src="static/img/html5.jpg" alt="" class="image scale" draggable="false">
                            <div class="headline">
                                <span>Web前端教程</span>
                                <img src="static/img/arrow.png" alt="">
                            </div>
                        </a>
                    </td>
                    <td>
                        <!--上线时修改id-->
                        <a href="front/course/index.do?subjectId=6">
                            <img src="static/img/ui.jpg" alt="" class="image scale" draggable="false">
                            <div class="headline">
                                <span>UI设计教程</span>
                                <img src="static/img/arrow.png" alt="">
                            </div>
                        </a>
                    </td>
                    <td rowspan="2" class="one_three">
                        <a href="front/course/index.do?subjectId=2">
                            <img src="static/img/java.jpg" alt="" class="image scale" draggable="false">
                            <div class="headline">
                                <span>java基础</span>
                                <img src="static/img/arrow.png" alt="">
                            </div>
                        </a>
                    </td>
                </tr>
                <tr>
                    <td>
                        <a href="front/course/index.do?subjectId=3">
                            <img src="static/img/bigdata.jpg" alt="" class="image scale" draggable="false">
                            <div class="headline">
                                <span>React教程</span>
                                <img src="static/img/arrow.png" alt="">
                            </div>
                        </a>
                    </td>
                    <td colspan="2">
                        <a href="front/course/index.do?subjectId=10">
                            <img src="static/img/python.jpg" alt="" class="image scale" draggable="false">
                            <div class="headline">
                                <span>Python教程</span>
                                <img src="static/img/arrow.png" alt="">
                            </div>
                        </a>
                    </td>
                </tr>
                <tr>
                    <td colspan="2">
                        <a href="front/course/index.do?subjectId=11">
                            <img src="static/img/php.jpg" alt="" class="image scale" draggable="false">
                            <div class="headline">
                                <span>PHP教程</span>
                                <img src="static/img/arrow.png" alt="">
                            </div>
                        </a>
                    </td>
                    <td colspan="2" class="three_two">
                        <img src="static/img/qidai.jpg" alt="" class="image" draggable="false">
                        <div class="headline">
                            更多课程，敬请期待...
                        </div>
                    </td>
                </tr>
            </table>
            <!--马上试听-->
            <a onclick="pyRegisterCvt()" target="_blank"
               href="http://wpa.qq.com/msgrd?v=3&uin=251145912&site=qq&menu=yes">
                <div class="audition">高级课程</div>
            </a>
        </div>
    </div>
</div>

<!--报名表单-->
<div class="form_area">
    <div class="container">
        <p class="title"><b>这个世界上可以选择的很多，可以改变命运的选择很少<br/>你现在准备好向梦想出发了吗？</b></p>
    </div>
</div>

<div class="course">
    <div class="container">
        <div class="course-info">
            <div class="audition"><a href='<c:url value="/front/register.do" ></c:url> '>立即预约</a></div>
            </a>
        </div>
    </div>
</div>
<%@include file="include/footer.jsp" %>

<%@include file="./include/script.html" %>


</body>

</html>
