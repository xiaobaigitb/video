<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%-- created by zhouyanchao on 2017年7月27日 下午3:06:27 --%>    


<!-- 分页显示 -->
<nav aria-label="Page navigation">
  <ul class="pagination">
   <c:if test="${pageInfo.pageNum==1 }">
	    <li class="disabled">
	      <a href="#" aria-label="Previous" onclick="return false;"><span aria-hidden="true">&laquo;</span></a>
	    </li>
    </c:if>
    <c:if test="${pageInfo.pageNum>1 }">
	    <li>
	      <a href="javascript:void(0);" aria-label="Previous" onclick="queryPage(${pageInfo.pageNum-1});"><span aria-hidden="true">&laquo;</span></a>
	    </li>
    </c:if>
    
    <c:forEach begin="1" end="${pageInfo.pageNums }" step="1" var="i">
    	 <c:if test="${pageInfo.pageNum==i }"> 
    		<li class="active"><a href="javascript:void(0);">${i }</a></li>
    	</c:if> 
    	 <c:if test="${pageInfo.pageNum!=i }"> 
    		<li><a href="javascript:void(0);" onclick="queryPage(${i})">${i }</a></li>
    	</c:if> 
    	
    </c:forEach>
        
     <c:if test="${pageInfo.pageNum==pageInfo.pageNums }">
	    <li class="disabled">
	      <a href="javascript:void(0);" aria-label="Next"><span aria-hidden="true">&raquo;</span></a>
	    </li>
    </c:if>
    <c:if test="${pageInfo.pageNum!=pageInfo.pageNums }">
	    <li>
	      <a href="javascript:void(0);" onclick="queryPage(${pageInfo.pageNum+1})" aria-label="Next"><span aria-hidden="true">&raquo;</span></a>
	    </li>
    </c:if>
  </ul>
</nav>
	