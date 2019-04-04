<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ tag description="Template for design på alle sider" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ attribute name="customTitle" required="true" %>
         
<!DOCTYPE html>

<html>
	<head>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		
		<title>
			${customTitle}
		</title>
		<link rel='shortcut icon' type='image/x-icon' href='favicon.png' />
		<link rel="stylesheet" type="text/css" href="styles/style.css?v=5">
	</head>
	<body>
		<t:Header />
		<jsp:doBody />
	</body>


</html>
