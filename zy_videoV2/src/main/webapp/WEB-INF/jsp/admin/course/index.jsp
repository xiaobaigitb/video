<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <base href="${BaseContext }">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>课程列表 - 课程管理</title>
    <link href="static/css/bootstrap.min.css" rel="stylesheet">
    <link href="static/css/jquery-confirm.min.css" rel="stylesheet">
    <script src="static/js/bootstrap.min.js"></script>
    <script src="static/js/jquery-1.12.4.min.js"></script>
    <script src="static/js/jquery-confirm.min.js"></script>
</head>
<body>

<!-- 引入公用的导航信息 -->
<jsp:include page="../header.jsp">
    <jsp:param value="course" name="fromJsp"/>
</jsp:include>

<div class="container">
    <div class="jumbotron">
        <h2>课程列表 - 课程管理</h2>
    </div>
    <div class="row"><a href="admin/course/add.do" class="btn btn-primary">添加课程</a></div>
    <table class="table table-hover">
        <thead>
        <tr>
            <th>序号</th>
            <th>标题</th>
            <th>学科</th>
            <th>简介</th>
            <th>编辑</th>
            <th>删除</th>
        </tr>
        </thead>
        <tbody>
        <c:if test="${not empty pageInfo }">
        <c:forEach items="${pageInfo.results }" var="co" varStatus="i">
            <tr>
                <td>${i.index+1 }</td>
                <td>${co.courseName }</td>
                <td>${co.subjectName }</td>
                <td>${co.courseDescr }</td>
                <td><a href="admin/course/edit.do?id=${co.id }"><span class="glyphicon glyphicon-edit"
                                                                      aria-hidden="true"></span></a></td>
                <td><a href="#" onclick="return deleteInfo(${co.id});"><span class="glyphicon glyphicon-trash"
                                                                             aria-hidden="true"></span></a></td>
            </tr>
        </c:forEach>
        </c:if>

        <c:if test="${empty pageInfo }">
            <tr>
                <td>当前查询结果为空!</td>
            </tr>
        </c:if>
        </tbody>
    </table>
    <jsp:include page="../page.jsp"></jsp:include>
</div>

<form id="pageForm" action="admin/caller/index.do" method="post">
    <input type="hidden" name="pageNum" value="${pageNum }" id="queryPage">
</form>

<%--<script src="static/js/jquery-1.12.4.min.js"></script>--%>
<script type="text/javascript">
    //翻页提交
    function queryPage(page) {
        $('#queryPage').val(page);
        $('#pageForm').submit();
    }

</script>

<script>
    //删除数据操作
    function deleteInfo(id) {
        //admin/video/delete.do
        $.confirm({
            title: '删除确认提示',
            content: '确定要删除id为' + id + '的数据吗？',
            type: 'orange',
            buttons: {
                confirm: {
                    text: '删除',
                    btnClass: 'btn-primary',
                    action: function () {
                        //根据id发送删除请求ajax
                        $.get('admin/course/delete.do', {id: id}, function (data) {
                            if (data.success) {
                                //成功，刷新页面
                                $.alert({
                                    content: '删除数据成功',
                                    onAction: function () {
                                        location.reload();
                                    }
                                });

                                //location.href='';
                            } else {
                                $.alert(data.message);
                            }

                        }, 'json');


                    }
                },
                cancel: function () {
                    //取消删除，自动关闭弹窗，不做其他操作

                }
            }
        });

        return false;
    }
</script>

</body>
</html>