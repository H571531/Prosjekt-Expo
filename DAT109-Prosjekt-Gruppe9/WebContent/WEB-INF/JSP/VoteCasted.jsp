<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:GenericPage>

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
</t:GenericPage>