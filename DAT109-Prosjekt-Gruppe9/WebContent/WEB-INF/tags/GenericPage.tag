<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ tag description="Template for design på alle sider" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>

         
<!DOCTYPE html>

<html>
	<head>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
	
		<title>EXPO ${expo.year}</title>
	
		<link rel="stylesheet" type="text/css" href="styles/style.css">
	</head>
	<body>
		<t:Header />
		<jsp:doBody />
	</body>


</html>
