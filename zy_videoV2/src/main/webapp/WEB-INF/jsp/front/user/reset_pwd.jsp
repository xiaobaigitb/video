<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <base href="${BaseContext}">
    <meta name="viewport" content="initial-scale=1, maximum-scale=1, user-scalable=no">
    <meta charset="utf-8">
    <meta name="renderer" content="webkit">
    <meta name="keywords" content="Web前端视频教程,Git视频教程,HTML5视频教程,UI视频教程,PHP视频教程,React视频教程,python基础教程">
    <meta name="description" content="智泷教育在线课程视频,为您提供Git,python,HTML5,UI,PHP,React教程等学科经典视频教程在线浏览学习,精细化知识点解析,深入浅出,想学不会都难,智泷教育,学习成就梦想！">
    <link rel="stylesheet" href="static/css/base.css">
    <link rel="stylesheet" href="static/css/forget_password.css">
    <link rel="icon" href="favicon.png" type="image/png">
    <title>在线公开课-智泷教育|Git入门|React教程|HTML5|python|UI|PHP视频教程</title>
    
</head>

<body>
    <header>
        <div class="container">
            <img src="static/img/logo.png" alt="IT">
        </div>
    </header>
    <main>
        <div class="container">
            <form class="ma" action="resetpwd.do" method="post">
               <input type="hidden" name="email" value="${email}"/>
                <input type="hidden" name="captcha" value="${captcha}"/>
                <div class="form_header">
                    <div class="form_title">
                        <h2>重置密码</h2>
                    </div>
                    
                </div>
                <div class="form_body">
                    <input type="password" placeholder="请输入新密码" id="password" name="password">
                    <input type="password" style="width:100%" placeholder="再次输入新密码" id="password02" name="pwdAgain">
                    <input type="submit" style="margin:0px;width:100%" value="提交">
                </div>
                
            </form>
        </div>
    </main>
</body>

</html>