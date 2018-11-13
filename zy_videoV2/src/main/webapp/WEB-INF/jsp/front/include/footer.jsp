<%@ page language="java" pageEncoding="UTF-8"%>
<!--页脚-->
<footer>
	<ul>
		<li>
			<img src="static/img/footer_logo.png" alt="" draggable="false">
		</li>
		<li class="mt25">
			<h3>智泷各校区地址</h3>
			<ul>
				<li>总部地址<br>中国-智泷</li>
				<li>郑州校区一<br>中国-ETL</li>
				<li>美国分校<br>美国-FBI&#X3000;联系人：L老师 12345678901</li>
			</ul>
		</li>
		<li class="mt25">
			<h3>联系我们</h3>
			<ul id="foo_icon">
				<li>中国-郑州</li>
				<li>e-mail:251145912@qq.com</li>
				<li>电话:4444-5555-6666 0371-88888888</li>
				<li class="erwei">
					<br>
					<div>
						<img class="weixin" src="static/img/微信公众号.png" alt="" draggable="false">
						<img class="weibo" src="static/img/微博公众号.png" alt="" draggable="false">
					</div>
				</li>
			</ul>
		</li>
	</ul>
	<div class="record">版权所有：鱼丸里头没有鱼&#x3000;&#x3000;&copy;&nbsp;www.251145912@qq.com</div>
</footer>


<!--登录注册弹出框-->
<div class="mask hidden" id="loginDiv">
	<div class="mask_content">
		<div class="mask_content_header">
			<img src="static/img/logo.png" alt="" class="ma">
		</div>
		<div class="mask_content_body">
			<form id="loginForm" action="front/user/login.do" method="post">
				<h3>快速登录</h3>
				<input type="email" id="loginEmail" placeholder="请输入邮箱" name="email">
				<input type="password" id="loginPassword" placeholder="请输入密码" name="password">
				<div id="forget">
					<a href="forgetpwd.do">忘记密码？</a>
				</div>
				<input type="submit" value="登&#x3000;录">
			</form>
		</div>
		<div class="mask_content_footer">
			<span id="login_close">关&#x3000;闭</span>
		</div>
	</div>
</div>
<div class="mask hidden" id="regDiv">
	<div class="mask_content">
		<div class="mask_content_header">
			<img src="static/img/logo.png" alt="" class="ma">
		</div>
		<div class="mask_content_body">
			<form id="regForm" action="front/user/regist.do" method="post">
				<h3>新用户注册</h3>
				<input type="email" id="regEmail" placeholder="请输入邮箱" name="email">
				<input type="password" id="regPsw" placeholder="请输入密码" name="password">
				<input type="password" id="regPswAgain" placeholder="请再次输入密码" name="pswAgain">
				<!-- <div id="yzm" class="form-inline">
					<input type="text" name="yzm" style="width: 45%; display: inline-block;">
					<div id="v_container" style="width: 45%;height: 40px;float:right;"></div>
				</div> -->
				<input type="submit" value="注&#x3000;册">
			</form>
		</div>
		<div class="mask_content_footer">
			<span id="reg_close">关&#x3000;闭</span>
		</div>
	</div>
</div>
