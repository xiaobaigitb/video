<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- created by zhouyanchao on 2017年7月11日 --%>    
<!DOCTYPE html>
<html>
<head>
<base href="${BaseContext }"> 
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>后台登录页面</title>
<link href="static/css/bootstrap.min.css" rel="stylesheet">
<!-- <script src="static/js/bootstrap.min.js"></script> -->
  <style>
    * {
      margin: 0;
      padding: 0;
    }

    body {
      background: url(/static/img/63.jpg) no-repeat center center fixed;
      -webkit-background-size: cover;
      -moz-background-size: cover;
      -o-background-size: cover;
      background-size: cover;
    }

  </style>
<style type="text/css">
	.login_form{
		margin-top: 20%;
	}
</style>

</head>
<body>

<div class="container">
<div class="col-lg-4 col-lg-offset-4 login_form">
<div class="row"><img src="static/img/logo.png"></div>
<form class="form-horizontal" action="admin/login.do" method="post" id="loginForm">
  <div class="form-group has-success">
    <div class="col-sm-10">
      <input type="text" class="form-control  input-lg" name="loginName" id="loginName" placeholder="用户名">
    </div>
  </div>
  <div class="form-group has-success">
    <div class="col-sm-10">
      <input type="password" class="form-control input-lg" name="loginPwd" id="loginPwd" placeholder="登录密码">
    </div>
  </div>
 
  <div class="form-group">
    <div class="col-xs-10">
      <button type="submit" class="btn btn-success col-xs-12">登录</button>
    </div>
  </div>
</form>
<div>${message}</div>
</div>
</div>

<!-- jquery必须放在第一个加载 -->
<script type="text/javascript" src="static/js/jquery-1.12.4.min.js"></script>
<script type="text/javascript" src="static/js/jquery.validate.min.js"></script>
<script type="text/javascript">
	$(document).ready(function(){
		//js的方式进行校验
		$('#loginForm').validate({
			rules:{//写校验规则的
				loginName:{//loginName是input的name属性，不是id
					required:true,
					minlength:3
				},
				loginPwd:{
					required:true,
					minlength:5,
					maxlength:10
				}
			},
			messages:{//写提示信息的
				loginName:{//loginName是input的name属性，不是id
					required:'用户名是必须的',
					minlength:'用户名最少3个字符'
				},
				loginPwd:'密码是必须填写的，至少5个字符，最多10个字符'
				//如果不需要给每个校验规则都写提示信息，就只写一个字符串
				 /*{
					required:'密码是必须填写的',
					minlength:'密码最少5个字符',
					maxlength:'密码最多10个字符'
				}*/
			}
		});	
	});
	
</script>

</body>
</html>