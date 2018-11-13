/*
	这里放置前台功能通用的一些js方法
	主要有：登录窗口的切换、注册窗口的切换、登录功能(ajax)、注册功能(ajax)
*/

$(function(){
	
	//显示登录窗口
	$('#login_open').click(function(){
		$('#loginDiv').removeClass('hidden');
	});
	//显示注册窗口
	$('#reg_open').click(function(){
		$('#regDiv').removeClass('hidden');
	});
	//隐藏登录窗口
	$('#login_close').click(function(){
		$('#loginDiv').addClass('hidden');
	});
	//隐藏注册窗口
	$('#reg_close').click(function(){
		$('#regDiv').addClass('hidden');
	});
	
	//登录请求的处理
	$('#loginForm').validate({
		submitHandler:function(form){
			//ajax提交登录信息，并且返回登录结果
//			var email = $('#loginEmail').val();
//			var pwd = $('#loginPassword').val();
			console.log($('#loginForm').serialize());
			//使用ajax的post方法提交登录信息
			$.post('front/user/login.do',$('#loginForm').serialize(),function(result){
				console.log(result);
				if(result.success){
					//登录成功,刷新页面
					location.reload();
				}else{
					alert(result.message);
				}
			},'json');
			
		},
		rules:{//写校验规则的
			email:{
				required:true,
				email:true,
				minlength:3
			},
			password:{
				required:true,
				minlength:3
			}
		},
		messages:{//写提示信息的
			email:"登录名称必须是已注册邮箱",
			password:'密码是必须填写的，3-30个字符'
		}
	});	
	
	
	//注册请求的处理
	$('#regForm').validate({
		submitHandler:function(form){
			//ajax提交注册信息，并且返回注册结果
			console.log($('#regForm').serialize());
			//使用ajax的post方法提交注册信息
			$.post('front/user/regist.do',$('#regForm').serialize(),function(result){
				console.log(result);
				if(result.success){
					//注册成功,刷新页面
					location.reload();
				}else{
					alert(result.message);
				}
			},'json');
			
		},
		rules:{//写校验规则的
			email:{
				required:true,
				email:true,
				minlength:3
			},
			password:{
				required:true,
				minlength:3
			},
			pswAgain:{
				required:true,
				equalTo:'#regPsw'
			}
		},
		messages:{//写提示信息的
			email:"注册账户必须是邮箱",
			password:'密码是必须填写的，3-30个字符',
			pswAgain:'两次密码必须输入一致'
		}
	});	
	
	
});