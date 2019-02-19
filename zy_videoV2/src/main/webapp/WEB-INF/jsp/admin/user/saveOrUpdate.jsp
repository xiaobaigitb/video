<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <base href="${BaseContext }">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>管理员列表 - 后台用户管理</title>
    <link href="static/css/bootstrap.min.css" rel="stylesheet">
    <script src="static/js/bootstrap.min.js"></script>
</head>
<body>

<jsp:include page="../header.jsp">
    <jsp:param value="user" name="fromJsp"/>
</jsp:include>
<div class="container">
    <div class="jumbotron">
        <h2>添加用户 - 用户管理</h2>
    </div>
    <form class="form-horizontal" action="admin/user/saveOrUpdate.do" method="post">
        <c:if test="${not empty user }">
            <input type="hidden" name="id" value="${user.id }" }>
        </c:if>
        <div class="form-group">
            <label for="loginName" class="col-sm-2 control-label">用户名</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" name="nickName" id="loginName" value="${user.nickName}"
                       placeholder="用户名">
            </div>
        </div>
        <div class="form-group">
            <label for="loginSex" class="col-sm-2 control-label">性别</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" name="sex" id="loginSex" value="${user.sex}"
                       placeholder="1 =='男'，2=='女'">
            </div>
        </div>
        <div class="form-group">
            <label for="loginEmail" class="col-sm-2 control-label">email</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" name="email" id="loginEmail" value="${user.email}"
                       placeholder="email">
            </div>
        </div>
        <div class="form-group">
            <label for="loginPwd" class="col-sm-2 control-label">密码</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" name="password" id="loginPwd" value="${user.password}"
                       placeholder="密码">
            </div>
        </div>
        <div class="form-group">
            <label for="loginCity" class="col-sm-2 control-label">城市</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" name="city" id="loginCity" value="${user.city}"
                       placeholder="城市">
            </div>
        </div>
        <div class="form-group">
            <label for="role" class="col-sm-2 control-label">所属权限</label>
            <div class="col-sm-10">
                <select name="roleId" id="role" class="form-control">
                    <option value="0">请选择所属权限</option>
                    <c:forEach items="${roles }" var="rol">
                        <option
                                <c:if test="${rol.id==user.roleId }">selected</c:if>
                                value="${rol.id }">${rol.roleName }</option>
                    </c:forEach>
                </select>
            </div>
        </div>
        <div class="form-group">
            <label for="speakerId" class="col-sm-2 control-label">所属课程</label>
            <div class="col-sm-10">
                <select name="subjectId" id="speakerId" class="form-control">
                    <option value="0">请选择所属课程</option>
                    <c:forEach items="${subjects }" var="sub">
                        <option
                                <c:if test="${sub.id==user.subjectId }">selected</c:if>
                                value="${sub.id }">${sub.subjectName }</option>
                    </c:forEach>
                </select>
            </div>
        </div>
        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <button type="submit" class="btn  btn-primary">保存</button>
                <a href="admin/user/index.do" class="btn btn-default">返回列表</a>
            </div>
        </div>
    </form>

</div>


</body>
</html>