<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <base href="${BaseContext}">
    <meta name="viewport" content="initial-scale=1, maximum-scale=1, user-scalable=no">
    <meta charset="utf-8">
    <meta name="renderer" content="webkit">
    <meta name="keywords" content="Web前端视频教程,Git视频教程,HTML5视频教程,UI视频教程,PHP视频教程,React视频教程,python基础教程">
    <meta name="description" content="智泷教育在线课程视频,为您提供Git,python,HTML5,UI,PHP,React教程等学科经典视频教程在线浏览学习,精细化知识点解析,深入浅出,想学不会都难,智泷教育,学习成就梦想！">
    <meta name="author" content="尚忠祥">
    <link rel="stylesheet" href="static/css/base.css">
    <link rel="stylesheet" href="static/css/profile.css">
    <link rel="icon" href="favicon.png" type="image/png">
    <title>在线公开课-智泷教育|Git|React教程|HTML5|python|UI|PHP视频教程</title>
</head>

<body>
   <jsp:include page="uheader.jsp"></jsp:include>
    <main>
        <div class="container">
            <h2>我的资料</h2>
            <div id="profile_tab">
                <ul class="profile_tab_header f_left clearfix">
                    <li><a href="front/user/profile.do">更改资料</a></li>
                    <li class="profile_tab_line">|</li>
                    <li><a href="front/user/avatar.do">更改头像</a></li>
                    <li class="profile_tab_line">|</li>
                    <li><a href="front/user/password.do">密码安全</a></li>
                </ul>
                <div class="proflle_tab_body">
                    
                    <div class="proflle_tab_workplace clearfix">
                        <div class="profile_avatar_area">
                            <c:if test="${empty user.headUrl}">
		                         <img id="avatar" src="static/img/avatar_lg.png" alt="">
		                      </c:if>
		                      
		                      <c:if test="${not empty user.headUrl}">
		                         <img id="avatar" width="200px" heigth="200px" src="${user.headUrl}" alt="">
		                      </c:if>
                            <p>
                            <c:if test="${not empty user.nickName}">
						          <span>${user.nickName}</span>
						    </c:if>
						    <c:if test="${empty user.nickName}">
						          <span>${user.email }</span>
						    </c:if> 
                                                                          欢迎回来！</p>
                        </div>
                        <ul class="profile_ifo_area">
                            <li><span class="dd">昵&#x3000;称：</span>${user.nickName}</li>
                            <li><span class="dd">性&#x3000;别：</span>
                                <c:if test="${user.sex==2}">
                                    		女
                                </c:if>
                                <c:if test="${user.sex==1}">
                                    		男
                                </c:if> 
                             </li>
                            <li><span class="dd">生&#x3000;日：</span><fmt:formatDate value="${user.birthday}" pattern="YYYY-MM-dd"></fmt:formatDate></li>
                            <li><span class="dd">邮&#x3000;箱：</span>${user.email}</li>
                            <li><span class="dd">所在地：</span>${user.province}-${user.city }</li>
                            
                        </ul>
                    </div>
                </div>
            </div>
        </div>
    </main>
    <footer>
        <div class="container">
            <ul>
                <li><img src="static/img/footer_logo.png" alt="" id="foot_logo"></li>
                <li>版权所有：鱼丸里头没有鱼&#x3000;&#x3000;&#x3000;&copy;&nbsp;www.251145912@qq.com</li>
                <li><img src="static/img/微信公众号.png" alt="" id="wxgzh"></li>
            </ul>
        </div>
    </footer>
</body>
</html>