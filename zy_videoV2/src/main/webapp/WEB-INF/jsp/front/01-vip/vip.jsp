<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width,user-scalable=no,initial-scale=1.0,maximum-scale=1.0,minimum-scale=1.0">
    <title>开通vip</title>
    <link rel="stylesheet" href='<c:url value="/static/css/add.css" ></c:url> '>
</head>
<body>
<style>
    * {
        margin: 0;
        padding: 0;
    }

    body {
        background: url(/static/img/62.jpg) no-repeat center center fixed;
        -webkit-background-size: cover;
        -moz-background-size: cover;
        -o-background-size: cover;
        background-size: cover;
    }

</style>
<%--<!--背景-->--%>
<%--<div class="wel" id="background-3" >--%>
<%--<img src='<c:url value="/01-register/60.jpg" ></c:url> '>--%>
<%--</div>--%>
<%--<!--左右两边云-->--%>
<%--<div class="wel" id="box">--%>
<%--<div class="box-1 lefp"></div>--%>
<%--<div class="box-1">--%>
<%--<div class="righp"></div>--%>
<%--</div>--%>
<%--</div>--%>
<%--<!--荧光点点-->--%>
<%--<div class="wel" id="git"></div>--%>
<!--登录注册表-->
<div class="wel" id="from">
    <div class="box-2 le-1">
        <form id="iform" action="/front/user/vip.do" enctype="multipart/form-data" method="post">

            <div class="flrg">
                <h3>开通vip</h3>
                <div class="a">
                    <input type="text" class="in-1" name="email" placeholder="请输入email">
                </div>

                <div class="a">
                    <input type="radio" name="payment" value="微信">微信
                    <input type="radio" name="payment" value="支付宝">支付宝
                </div>

                <div class="a">
                    <a href='#'>2250</a>
                </div>
                <div class="a">
                    <button type="submit">开&nbsp;&nbsp;通</button>
                </div>
                <div class="a">
                    <div class="hr"></div>
                </div>
                <div class="a"><a href='<c:url value="/index.do"></c:url> '>返&nbsp;回&nbsp;首&nbsp;页</a></div>
            </div>
        </form>
    </div>

</div>
</body>
</html>