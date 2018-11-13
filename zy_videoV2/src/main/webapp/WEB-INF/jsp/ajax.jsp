<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- created by zhouyanchao on 2017年7月21日 下午3:06:22 --%>    
<!DOCTYPE html>
<html>
<head>
<base href="${BaseContext }"> 
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<input type="button" value="获取ajax数据" onclick="ajaxData();">
<input type="button" value="load获取ajax数据" onclick="loadData();">
<div id="data"></div>


<script type="text/javascript" src="static/js/jquery-1.12.4.min.js"></script>
<script type="text/javascript">
	function ajaxData(){
		var result="";
		$.get('ajax/load.do',function(data){
			$('#data').html(data);
		},'html');
		console.log('after ajax  2');
	}
	
	function loadData(){
		$('#data').load('ajax/load.do');
		
	}
</script>
</body>
</html>