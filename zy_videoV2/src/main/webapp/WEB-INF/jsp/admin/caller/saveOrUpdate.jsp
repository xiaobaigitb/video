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
    <jsp:param value="caller" name="fromJsp"/>
</jsp:include>
<div class="container">
    <div class="jumbotron">
        <h2>编辑预约人 - 预约管理</h2>
    </div>

    <form class="form-horizontal" action="admin/caller/saveOrUpdate.do" method="post">
        <c:if test="${not empty caller }">
            <input type="hidden" name="id" value="${caller.id }" }>
        </c:if>
        <div class="form-group">
            <label for="callerName" class="col-sm-2 control-label">名字</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" name="visitorName" id="callerName"
                       value="${caller.visitorName }"
                       placeholder="预约人姓名">
            </div>
        </div>
        <div class="form-group">
            <label for="callerTel" class="col-sm-2 control-label">电话</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" name="tel" id="callerTel" value="${caller.tel }"
                       placeholder="预约人电话">
            </div>
        </div>
        <div class="form-group">
            <label for="callerIntent" class="col-sm-2 control-label">课程类别</label>
            <div class="col-sm-10">
                <select class="form-control" name="intent" id="callerIntent">
                    <option value="WEB前端">WEB前端</option>
                    <option value="JAVA编程基础">JAVA编程基础</option>
                    <option value="React">React</option>
                    <option value="UI">UI</option>
                    <option value="Python">Python</option>
                    <option value="PHP">PHP</option>
                </select>
            </div>
        </div>

        <div class="form-group">
            <label for="callerAge" class="col-sm-2 control-label">年龄</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" name="age" id="callerAge" value="${caller.age}"
                       placeholder="年龄">
            </div>
        </div>

        <div class="form-group">
            <label for="callerSex" class="col-sm-2 control-label">性别</label>
            <div class="col-sm-10">
                <%--<textarea class="form-control" id="loginPwd" name="loginPwd" rows="3">${admin.loginPwd}</textarea>--%>
                <input type="text" class="form-control" name="sex" id="callerSex" value="${caller.sex}"
                       placeholder="性别">
            </div>
        </div>

        <div class="form-group">
            <label for="callerClassTime" class="col-sm-2 control-label">课时</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" name="classTime"
                       id="callerClassTime" value="${caller.classTime}" placeholder="预约人时长">
            </div>
        </div>
        <div class="form-group">
            <label for="callerAlreadyTime" class="col-sm-2 control-label">课时</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" name="alreadyTime"
                       id="callerAlreadyTime" value="${caller.alreadyTime}" placeholder="预约人已学时长">
            </div>
        </div>
        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <button type="submit" class="btn  btn-primary">保存</button>
                <a href="admin/caller/index.do" class="btn btn-default">返回列表</a>
            </div>
        </div>
    </form>

</div>


</body>
</html>