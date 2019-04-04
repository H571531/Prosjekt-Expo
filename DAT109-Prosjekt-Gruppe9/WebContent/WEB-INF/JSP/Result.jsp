<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>



<t:GenericPage customTitle="Resultatliste">
	

	<div id="mid">
		<div id="midUpper">
		<a href="ResultServlet?fulllist">Se liste over alle stands</a>
		</div>
 			<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
 			<script type="text/javascript">
			
 			// Load the Visualization API and the corechart package.
 			  google.charts.load('current', {'packages':['corechart', 'bar']});

 			  // Set a callback to run when the Google Visualization API is loaded.
 			  google.charts.setOnLoadCallback(drawTopStandsChart);
 			  google.charts.setOnLoadCallback(drawInstitutesChart);
 			  google.charts.setOnLoadCallback(drawInstitutesWeightedChart);


 			  // Callback that creates and populates a data table,
 			  // instantiates the pie chart, passes in the data and
 			  // draws it.
 			  function drawTopStandsChart() {

 			    // Create the data table.
  			    var data = new google.visualization.DataTable();
			   
 			    data.addColumn('string','Stand');
 			    data.addColumn('number','Stemmer');
			   
 			    data.addRows([
   			    	<c:forEach items="${toplist}" var="result">
  			    		['${result.stand.standName}', ${result.totalPoints}],
 			    		
  			    	</c:forEach>
  			    ]);	
				
			    
			    
 			    // Set chart options
 			    var options = {
 			    		title:'Top 5 Stands',
 			    		colors: ['#004357'],
 						width:500,
 						height:400,
 						legend:'none'
                    };

			    // Instantiate and draw our chart, passing in some options.
 			    var chart = new google.visualization.ColumnChart(document.getElementById('top5StandsChartDiv'));
 			    chart.draw(data, options);
 			  }
 			  
 			  function drawInstitutesChart(){
 				  var data = new google.visualization.DataTable();
 				  
 				  data.addColumn('string', 'Institutt');
 				  data.addColumn('number', 'Stemmer');
 				  
 				  data.addRows([
 					  <c:forEach items="${institutesPointTotal}" var="result">
 					  	['${result.key}', ${result.value}],
 					  </c:forEach>
 				  ]);
 				  
 				  var options = {
 						  title:'Stemmer per institutt',
 						  colors: ['#004357'],
 						  width:600,
 						  height:500,
 						  legend:'none'
 				  };
 				  var chart = new google.visualization.ColumnChart(document.getElementById('instituteChartDiv'));
 				  chart.draw(data, options);
 			  }
 			  
 			 function drawInstitutesWeightedChart(){
				  var data = new google.visualization.DataTable();
				  
				  data.addColumn('string', 'Institutt');
				  data.addColumn('number', 'Stemmer/Stands');
				  
				  data.addRows([
					  <c:forEach items="${institutesPointWeightedByStands}" var="result">
					  	['${result.key}', ${result.value}],
					  </c:forEach>
				  ]);
				  
				  var options = {
						  title:'Stemmer per institutt, fordelt på antall stands',
						  colors: ['#004357'],
						  width:600,
						  height:500,
						  legend:'none'
				  };
				  var chart = new google.visualization.ColumnChart(document.getElementById('instituteWeightedChartDiv'));
				  chart.draw(data, options);
			  }
 			  </script>
			  
 		<div id="midUpper">
	 		<h3>PUBLIKUMSFAVORITT: </h3>
	 		
	 		<div class="gold">
	 			<p><c:out value="${topStand.standName}" /></p>
	 			<p>Forfattere: <c:out value="${topStand.authors}" /></p>
	 			<p>Antall stemmer: ${topStand.numberOfVotes}</p>
	 		</div>
	 		<hr>
	 		<div id="top5StandsChartDiv" class="gCharts"></div>
	 		<div id="instituteChartDiv" class="gCharts"></div>
	 		<div id="instituteWeightedChartDiv" class="gCharts"></div>
 		</div>
		
	    <div id="midText">
		
	   		
	         <hr>
	        <h3>Topp 5 Stands per institutt</h3>
				<%--@elvariable id="institute" type="no.hvl.dat109.expo.statistics.InstituteResult"--%>
			<c:forEach items="${institutes}" var="institute">
				<p><strong><c:out value="${institute.institute.institutename}" /></strong></p>
				<c:forEach items="${institute.getTopStandsTotalPoints(5)}" var="result">
					<p><c:out value="${result.stand.standName}" /> :
					<fmt:formatNumber type="number" maxFractionDigits="2" value="${result.totalPoints}"/>
					</p>
				</c:forEach>
				<hr>
			</c:forEach>
	        
	
	        <a href="StartServlet">Startside</a>
	    </div>
	</div>
	
</t:GenericPage>
	