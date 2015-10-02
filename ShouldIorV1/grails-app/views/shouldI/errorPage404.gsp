<!DOCTYPE HTML>
<html>
	<head>
		<title>ShouldI.fm</title>
		<meta name="keywords" content="404 ERROR" />
		 <link rel="stylesheet" type="text/css" href="<g:resource dir='css' file='errorStyle.css'/>">
		
	</head>
	<body style = "	background: url(${resource(dir:'images',file:'bg1.png')});">
		<!--start-wrap--->
		<div class="wrap">
			<!---start-header---->
				<div class="header">
					<div class="logo">
						<h1><a href="${createLink(controller: 'ShouldI', action: 'home')}"><b>ShouldI.fm: 404</b></a></h1>
					</div>
				</div>
			<!---End-header---->
			<!--start-content------>
			<div class="content" style = "margin-bottom: 40px;">
				<img  src="${resource(dir:'images',file:'error-img.png')}"  title="error" />
				<p><span><label>O</label>hh.....</span>You Requested a page that is no longer There.</p>
				<a href="${createLink(controller: 'ShouldI', action: 'home')}">Back To Home</a> 				
				<a href="${createLink(controller: 'ShouldI', action: 'help')}">Help</a>		
   			</div>
			<!--End-Cotent------>
		</div>
		<!--End-wrap--->
	</body>
</html>

