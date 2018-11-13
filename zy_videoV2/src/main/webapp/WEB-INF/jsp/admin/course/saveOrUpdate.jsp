<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%-- created by zhouyanchao on 2017年7月11日 下午5:04:12 --%>    
<!DOCTYPE html>
<html>
<head>
<base href="${BaseContext }">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>课程添加 - 课程管理</title>
<link href="static/css/bootstrap.min.css" rel="stylesheet">
<script src="static/js/bootstrap.min.js"></script>
</head>
<body>

	<jsp:include page="../header.jsp">
		<jsp:param value="course" name="fromJsp"/>
	</jsp:include> 
	<div class="container">
		<div class="jumbotron">
  			<h2>添加课程 - 课程管理</h2>
		</div>
		
		<form class="form-horizontal" action="admin/course/saveOrUpdate.do" method="post">
		<c:if test="${not empty course }">
			<input type="hidden" name="id" value="${course.id }" }>
		</c:if>
  <div class="form-group">
    <label for="subjectId" class="col-sm-2 control-label">所属学科</label>
    <div class="col-sm-10">
      <select class="form-control" name="subjectId" id="subjectId">
		  <option value="0">选择所属学科</option>
		  <c:forEach items="${subjects}" var="su">
		  	<option value="${su.id }" <c:if test="${su.id==course.subjectId} }">selected</c:if> >${su.subjectName }</option>
		  </c:forEach>
		</select>
		    </div>
  </div>
  <div class="form-group">
    <label for="courseName" class="col-sm-2 control-label">课程标题</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" name="courseName" id="courseName" value="${course.courseName }" placeholder="课程标题">
    </div>
  </div>
  <div class="form-group">
    <label for="courseDescr" class="col-sm-2 control-label">课程简介</label>
    <div class="col-sm-10">
      <textarea class="form-control" id="courseDescr" name="courseDescr" rows="3">${course.courseDescr }</textarea>
    </div>
  </div>
  <div class="form-group">
    <div class="col-sm-offset-2 col-sm-10">
      <button type="submit" class="btn  btn-primary">保存</button>
      <a href="admin/course/index.do" class="btn btn-default">返回列表</a>
    </div>
  </div>
</form>
	
	</div>


</body>
</html>