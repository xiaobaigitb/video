<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- created by zhouyanchao on 2017年7月26日 下午3:22:26 --%>    
<!DOCTYPE html>
<html>
<head>
<base href="${BaseContext }">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>统计 - 统计分析</title>
<link href="static/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>


	<!-- 引入公用的导航信息 -->
	<jsp:include page="../header.jsp">
		<jsp:param value="state" name="fromJsp"/>
	</jsp:include>
	<div class="container">
		<div class="jumbotron">
  			<h2>统计 - 统计分析</h2>
		</div>
		<div class="row">
			<div id="container" style="min-width:400px;height:400px"></div>
		</div>
		
		<div class="row">
			<button onclick="ajaxLoadData();">ajax加载图表</button>
			<div id="ajaxContainer" style="min-width:400px;height:400px"></div>
		</div>
		
	</div>
	<script src="static/js/jquery-1.12.4.min.js"></script>
	<script src="static/js/highcharts.js"></script>
	<script>
	$(function () {
	    $('#container').highcharts({
	        chart: {
	            type: 'column'
	        },
	        title: {
	            text: '课程平均播放次数'
	        },
	        subtitle: {
	            text: '数据来源: itxiaobai.com'
	        },
	        xAxis: {
	            categories: ${xdata},
	            crosshair: true
	        },
	        yAxis: {
	            min: 0,
	            title: {
	                text: '平均播放次数(times)'
	            }
	        },
	        tooltip: {
	            headerFormat: '<span style="font-size:10px">{point.key}</span><table>',
	            pointFormat: '<tr><td style="color:{series.color};padding:0">{series.name}: </td>' +
	            '<td style="padding:0"><b>{point.y:.1f} times</b></td></tr>',
	            footerFormat: '</table>',
	            shared: true,
	            useHTML: true
	        },
	        plotOptions: {
	            column: {
	                pointPadding: 0.2,
	                borderWidth: 0
	            }
	        },
	        series: ${ydata}
	    });
	});
	
	//通过ajax加载图表数据
	function ajaxLoadData(){
		//先通过ajax加载数据，然后再调用图表方法
		$.getJSON('admin/state/ajaxdata.do',function(data){
			console.log(data);
			initChart(data.xdata,data.ydata);
		});
		
		
	}
	
	function initChart(x,y){
		 $('#ajaxContainer').highcharts({
		        chart: {
		            type: 'bar'
		        },
		        title: {
		            text: '课程平均播放次数'
		        },
		        subtitle: {
		            text: '数据来源: itxiaobai.com'
		        },
		        xAxis: {
		            categories: x,
		            crosshair: true
		        },
		        yAxis: {
		            min: 0,
		            title: {
		                text: '平均播放次数(times)'
		            }
		        },
		        tooltip: {
		            headerFormat: '<span style="font-size:10px">{point.key}</span><table>',
		            pointFormat: '<tr><td style="color:{series.color};padding:0">{series.name}: </td>' +
		            '<td style="padding:0"><b>{point.y:.1f} times</b></td></tr>',
		            footerFormat: '</table>',
		            shared: true,
		            useHTML: true
		        },
		        plotOptions: {
		            column: {
		                pointPadding: 0.2,
		                borderWidth: 0
		            }
		        },
		        series: y
		    }); 
	}
	
	
	
	
	</script>

</body>
</html>