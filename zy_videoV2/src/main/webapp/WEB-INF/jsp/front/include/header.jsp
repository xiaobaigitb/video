<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html; charset=UTF-8" language="java" %>

<header>
    <div class="container">
        <span>欢迎来到IT培训的黄埔军校——智泷教育！</span>


        <c:if test="${not empty _front_user}">
            <div id="userBlock" style="float:right">
                <a href="front/user/logout.do">退出</a>
                <a href="front/user/index.do" id="account">${sessionScope._front_user.email }</a>
            </div>
        </c:if>
        <c:if test="${empty _front_user}">
            <div id="regBlock" style="float:right">
                <a href="javascript:;" id="reg_open"><img src="static/img/we.png">注册</a>
                <a href="javascript:;" id="login_open"><img src="static/img/we.png">登录</a>
                    <%--<a href="javascript:;" id="vip_open"><img src="static/img/we.png">开通VIP</a>--%>
            </div>
        </c:if>
        <%--https://w.url.cn/s/Axllwhs--%>
        <a href='<c:url value="/front/user/vipIndex.do" ></c:url> '>开通VIP</a>
        <%--<a href="javascript:;" id="vip_open"><img src="static/img/we.png">开通VIP</a>--%>
        <a onclick="JavaScript:addFavorite2('https://blog.csdn.net/qq_38617531','智泷培训网站')"><img src="static/img/sc.png" draggable="false">加入收藏</a>
        <a target="_blank" href="admin/login.do"><img src="static/img/we.png" draggable="false">后台管理</a>
        <a class="color_e4"><img src="static/img/phone.png" draggable="false"> 0371-1234567890&#x3000;&#x3000;4444-5555-6666</a>
    </div>
<script>
    function addFavorite2(sURL, sTitle) {
        try {
            window.external.addFavorite(sURL, sTitle);
        }
        catch (e) {
            try {
                window.sidebar.addPanel(sTitle, sURL, "");
            }
            catch (e) {
                alert("加入收藏失败，请使用Ctrl+D进行添加");
            }
        }
    }
</script>

</header>
