<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: zhouyc
  Date: 2017/6/30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>

<header>
	<div class="container top_bar clearfix">
		<img src="static/img/logo.png" alt="IT">
		<div id="tele">
			<span>4444-5555-666</span>
			<span>0371-88888888</span>
		</div>
	</div>
	<menu>
		<div class="container clearfix">
			<ul class="clearfix f_left">
				<li><a href="index.do">首页</a></li>
				<li class="menu_active"><a href="front/user/index.do">个人中心</a></li>
			</ul>
			<div id="user_bar">
				<a href="front/user/index.action">
					<c:if test="${empty sessionScope._front_user.headUrl}">
						<img id="avatar" src="static/img/avatar_lg.png" alt="">
					</c:if>

					<c:if test="${not empty sessionScope._front_user.headUrl}">
						<img id="avatar" src="${user.headUrl}" alt="">
					</c:if>

				</a>
				<a href="front/user/logout.do" id="lay_out">退出</a>
			</div>
		</div>
	</menu>
</header>
