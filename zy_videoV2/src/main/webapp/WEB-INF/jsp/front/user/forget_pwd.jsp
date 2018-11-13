<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <title>在线公开课-智泷教育|Git|React教程|HTML5|python|UI|PHP视频教程</title>

</head>

<body>
    <header>
        <div class="container">
            <img src="static/img/logo.png" alt="IT">
        </div>
    </header>
    <main>
        <div class="container">
            <form class="ma" action="forgetpwd.do" method="post" >
                <div class="form_header">
                    <div class="form_title">
                        <h2>忘记密码</h2>
                        <span>通过注册邮箱重设密码</span>
                    </div>
                    <div class="form_back">
                        <a href="index.do">返回立即登录</a>
                    </div>
                </div>
                <div class="form_body">
                    <input type="email" placeholder="请输入登录邮箱" name="email" id="email">
                    <input type="text" placeholder="请输入验证码" name="captcha"><input type="button" value="发邮件获取验证码" onclick="submitEmail();">
                    <input type="submit" value="提交">
                </div>
                <div class="form_footer">
                    <div class="FAQ">
                        <span>收不到邮件？查看</span><a href="#">常见问题</a>
                    </div>
                </div>
            </form>
        </div>
        
    </main>
<%@include file="../include/script.html"%>
    <script type="text/javascript">
		function submitEmail(){
			var email = $('#email').val();
			//改为ajax提交邮箱
			if(email!=null&&email!=''){
				$.post('sendemail.do',{email:email},function(data){
					console.log(data);
					if(data.success){
						alert('验证码已发送到邮箱，请注意查收');
					}else{
						alert('验证码发送失败：'+data.message);
					}
				},'json');
			}
		}
    </script>
</body>

</html>