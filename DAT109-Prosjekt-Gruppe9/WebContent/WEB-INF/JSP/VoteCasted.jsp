<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>EXPO ${expo.year}</title>
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<link rel="stylesheet" type="text/css" href="styles/style.css">
	</head>
	<body>
		<div id="header">
			<div id="headerLeft">
				<a href="http://www.hvl.no"><img id="hvlLogo" src="img/hvl_logo_2.png"></a>
			</div>
			<div id="headerRight">
				<img id="expoLogoImg" src="img/expo_logo_2.png">
			</div>
		</div>
		
		<div id="mid">
			<div id="midText">
				<p>
					Takk for din stemme på ${stand.standName}!
				</p>
			</div>
		</div>
	</body>
</html>