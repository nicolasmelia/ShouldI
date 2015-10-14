<!DOCTYPE html>
<html lang="en">
   <head>
      <meta charset="utf-8">
      <meta http-equiv="X-UA-Compatible" content="IE=edge">
      <meta name="viewport" content="width=device-width, initial-scale=1">
     
      <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
      <meta name="description" content="ShouldI.fm is a place where you can ask the world questions and get honest answers. Start a poll, it's free and easy!">
      <meta name="author" content="ShouldI.fm">
      <link rel="shortcut icon" href="${resource(dir:'images',file:'logoBrowser.png')}">
      <title>ShouldI.fm - Login</title>
       <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
     
      <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
      <!-- Bootstrap core CSS -->
      <link rel="stylesheet" type="text/css" href="<g:resource dir='css' file='bootstrap.css'/>">
      <link rel="stylesheet" type="text/css" href="<g:resource dir='css' file='buttons.css'/>">
      <link rel="stylesheet" type="text/css" href="<g:resource dir='css' file='customBoot.css'/>">
      <link rel="stylesheet" type="text/css" href="<g:resource dir='css' file='awesome-bootstrap-checkbox.css'/>">
      <!-- Bootstrap core JS -->
      <script src="<g:resource dir="js" file="bootstrap.min.js" />"></script>
      <!-- facebook login -->
      <g:javascript src="facebookLogin.js" />
      <g:javascript src="dataAccess.js" />
      <!-- font-awesome -->
      <link rel='stylesheet' href='https://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css'>
      <link rel="stylesheet" type="text/css" href="<g:resource dir='css' file='typehead-searchBar.css'/>">

            
      <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
      <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
      <![endif]-->
   </head>
   <body style = "background-color: #F6F6F6!important; background-image:url('${resource(dir: "images", file: "wall1.jpg")}'); margin-bottom: 20px; background-size: cover;  background-attachment: fixed; min-width: 320px;  ">
   <g:if test="${session.name}">
      <input id = "sessionCheck" type="hidden" name="country" value="true">
   </g:if>
   <g:else>
      <input id = "sessionCheck" type="hidden" name="country" value="false">
   </g:else>
   
 <nav class="navbar navbar-inverse navbar-fixed-top" >
         <div class="container">
            <div class="navbar-header">
               <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
               <span class="sr-only">Toggle navigation</span>
               <span class="icon-bar"></span>
               <span class="icon-bar"></span>
               <span class="icon-bar"></span>
               </button>
               <a href = "${createLink(controller: 'ShouldI', action: 'home')}" ><img src="${resource(dir:'images',file:'logo.png')}"   class="navbar-brand"/></a>
            </div>
            <div id="navbar" class="collapse navbar-collapse">
               <ul class="nav navbar-nav">
                  <g:if test="${session.name}">
                     <li><a href="${createLink(controller: 'User', action: 'myProfile', params: [category: 'My Notifications'])}"><span class= 'fa fa-bell-o'></span><span style = "padding-left: 6px;" >${notifyCount}</span></a></li>
                     <li><a href = "${createLink(controller: 'Question', action: 'askShouldI')}" ><span class= 'fa fa-pencil-square-o'></span><span style = "padding-left: 6px;" >Ask</span></a></li>
                      <li><a href = "${createLink(controller: 'ShouldI', action: 'category', params: [category: 'Trending'])}" ><span class= 'fa fa-book'></span><span style = "padding-left: 6px;" >Browse Categories</span></a></li>
                  </g:if>
                  <g:else>
                     <li><a href="#"  onClick = "showNoLogin()" ><span class= 'fa fa-pencil-square-o'></span><span style = "padding-left: 6px;" >Ask</span></a></li>
                      <li><a href = "${createLink(controller: 'ShouldI', action: 'category', params: [category: 'Trending'])}" ><span class= 'fa fa-book'></span><span style = "padding-left: 6px;" >Browse Categories</span></a></li>
                  </g:else>
               </ul>
               <g:if test="${session.name}">
                  <ul class="nav navbar-nav navbar-right" style = "padding: -10px;" >
                     <li class="dropdown" style = "">
                        <a href="#" style = "" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">
                        <img style = "display:inline-block; width: 25px; height: 25px; margin-right: 4px; margin-top: -25px;  margin-bottom: -25px;" src = "${createLink(controller: 'User', action: 'getProfileImage', params: [id: session.userID])}" />			
                        ${session.name}
                        <span class="fa fa-caret-down"></span></a>
                        <ul class="dropdown-menu">
                           <li><a href = "${createLink(controller: 'User', action: 'myProfile', params: [category: 'My Questions'])}"><span class= 'fa  fa-user'></span><span style = "padding-left: 5px;" >My Profile</span></a></li>                           
                 		    <li><a href = "${createLink(controller: 'ShouldI', action: 'home')}" ><span class= 'fa fa-home'></span><span style = "padding-left: 6px;" >Home</span></a></li>                         
                            <li><a href = "${createLink(controller: 'ShouldI', action: 'help')}" ><span class= 'fa fa-info-circle'></span><span style = "padding-left: 6px;" >Help</span></a></li>
                           <li role="separator" class="divider"></li>
                           <li><a  onClick = "logout('${createLink(controller: 'ShouldI', action: 'home')}', '${createLink(controller: 'Authentication', action: 'logout')}' )" href="#"><span class= 'fa fa-sign-out'></span><span style = "padding-left: 5px;" >Log Out</span></a></li>
                        </ul>
                     </li>
                  </ul>
               </g:if>
               <g:else>
                  <ul class="nav navbar-nav navbar-right">
                     <li><a id = "facebookLoginMenu" href = "#"  style = ""  onClick = "loginFacebook('${createLink(controller: 'Authentication', action: 'loginFaceBook')}')">Login with <span href="#about" style = "padding-left: 4px; color:#5BC0DE;" class='fa fa-facebook-official'></span> </a></li>
                  </ul>
                  <ul class="nav navbar-nav navbar-right">
                      <li><a id = "facebookLoginMenu" href = "#"  style = "" onClick = "showNoLogin()" >Login/Signup</a></li>
                  </ul>
               </g:else>
            </div>
            <!--/.nav-collapse -->
         </div>
      </nav>
      

    <div class="container">
    
            	<div style = "text-align: center; width: 100%;  margin-top: 80px;  margin-bottom: 20px; " >
					<img style = "width:40%; vertical-align: top;  display:  block;  margin: auto;  padding:0px; min-width: 285px; " src="${resource(dir:'images',file:'logoDark.png')}"   />				
				</div>
				
      <g:form controller="Authentication" action="loginRedditAttempt" enctype="multipart/form-data" class="form-signin" style = "max-width: 300px; margin: auto;">
        
        
        <h2 class="form-signin-heading" style = "color: #FFFFFF;     text-shadow: 2px 2px #5e5e5e; ">sign in with <span class = "fa fa-reddit"></span></h2>
       
                     <g:if test="${Success == false}">
                        <div id = "alert" class="alert alert-danger" role="alert" style = "margin: 10px 0px 10px 0px; padding: 8px; text-align: left; ">   
	                  <p  id  = 'alertText' style = " margin: 0px; display: block;">
	                  	<span class = " fa  fa-thumbs-o-down"></span> Login unsuccessful. Please try again.
	                  </p> 
						</div>
					</g:if>
					<g:else>
					   <div id = "alert" class="alert alert-danger" role="alert" style = "display: none; margin: 10px 0px 10px 0px; padding: 8px; text-align: left; ">   
	                  <p id = 'alertText' style = " margin: 0px; display: block;">
	                  	
	                  </p> 
						</div>
					</g:else>
       
        <label for="inputEmail" class="sr-only"  >Username</label>
        <input id = "username"  name = "username" type="text" id="inputEmail" class="form-control" placeholder="Username" required autofocus>
        <label for="inputPassword" class="sr-only" >Password</label>
        <input style ="margin-top: 3px;" id = "password"  name = "password" type="password" id="inputPassword" class="form-control" placeholder="Password" required>
        <g:actionSubmit value = "Login"   onclick="return validate()"   type="submit" action = "loginRedditAttempt" style = "margin-top: 5px; width: 100%; "  class="btn btn-primary"/>
      </g:form>

    </div> <!-- /container -->

        <footer class="footer"style="position:fixed;bottom:8px; left: 8px; height:auto;margin-top:40px;width:100%;text-align:center" >
      <div class="container" style = "width: 100%; text-align: left; padding: 0px; ">
      <span style = "font-size: 13px; color: #79cce5;"><a style = "color: #79cce5;"  href = "${createLink(controller: 'ShouldI', action: 'privacyPolicy')}"  >Privacy Policy</a> | </span>
      <span style = "font-size: 13px; color: #79cce5;"><a style = "color: #79cce5;" href = "${createLink(controller: 'ShouldI', action: 'help')}"  >How To</a> | </span>
      <span style = "font-size: 13px; color: #79cce5;"><a style = "color: #79cce5;" href = "${createLink(controller: 'ShouldI', action: 'aboutPollaris')}">Pollaris LLC</a></span>    
      </div>   
  	  </footer>
  	  
  	  
  	           <!-- Loading Modal -->
         <div class="modal fade" id="loadingSpinner" role="dialog"  data-backdrop="static" data-keyboard="false">
            <div class="modal-dialog">
               <!-- Modal content-->
               <div class="modal-content">
                  <div class="modal-header">
                     <h4 class="modal-title"><span href="#about" style = "padding-left: 4px;" class='fa fa-hourglass'> </span> Logging you in...</h4>
                  </div>
                  <div class="modal-body">
                     <div style = "width: 100%; text-align: center;">
                        <span style = "color: #61B7FE; font-size: 60px;" class="fa fa-spinner fa-pulse"></span>
                        <p id = "loadingText" style = "  margin: auto;  margin-top: 15px;width: 80%;"></p>
                     </div>
                  </div>
               </div>
            </div>
         </div>
         
  	     <!-- LOGIN Modal -->
   <div class="modal fade" id="noLogin" role="dialog">
      <div class="modal-dialog">
         <!-- Modal content-->
         <div class="modal-content">
            <div class="modal-header">
               <button type="button" class="close" data-dismiss="modal">&times;</button>
               <h4 class="modal-title"><span href="#about" style = "padding-left: 4px;" class='fa fa-sign-in'> </span> Easy Login</h4>
            </div>
            <div class="modal-body">
               <p>Please login. Choose a network below to login with:</p>
               <button onClick = "loginFacebook('${createLink(controller: 'Authentication', action: 'loginFaceBook')}')" style = "" type="button" class="btn btn-default" data-dismiss="modal">Facebook <span class = "fa fa-facebook"></span></button>
               <button  onClick = "loginReddit('${createLink(controller: 'Authentication', action: 'loginReddit')}')"style = "" type="button" class="btn btn-default" data-dismiss="modal">Reddit <span class = "fa fa-reddit"></span></button>

            </div>
            <div class="modal-footer">
               <button style = "" type="button" class="btn btn-default" data-dismiss="modal">Close</button>
            </div>
         </div>
      </div>
   </div>
      
		<script>

		function validate() {
			var password = $("#password").val()
			var username = $("#username").val()
			if (password != "" && username != "") {
				displayLoadingSpinner();
				return true
			} else {
				$('#alert').slideDown();
				$('#alertText').html('<span class = "fa fa-thumbs-o-down"></span> Please enter valid credentials.');
				return false		
			}
		}	

		  function displayLoadingSpinner(){
		         $('#loadingSpinner').modal('show'); 
		         var saying = ["The last time I tried this the monkey didn't survive. Let's hope it works better this time.", 
		         "My other load screen is much faster. You should try that one instead.", 
		         "My other load screen is much faster. You should try that one instead.", 
		         "The bits are breeding.",
		         "Don't think of purple hippos.",
		         "at least you're not on hold...",
		         "Hum something loud while others stare.",
		         "QUIET! I'm trying to think here!"];
		         
		         $("#loadingText").text(saying[Math.floor(Math.random() * saying.length) + 0  ]);
		         
		         }

		</script>
   

  </body>
</html>
