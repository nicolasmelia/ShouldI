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
      <title>ShouldI.fm - Help</title>
       <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
      
    
	 <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
  
    <!-- Bootstrap core CSS -->
      <link rel="stylesheet" type="text/css" href="<g:resource dir='css' file='bootstrap.css'/>">
      <link rel="stylesheet" type="text/css" href="<g:resource dir='css' file='buttons.css'/>">
      <link rel="stylesheet" type="text/css" href="<g:resource dir='css' file='awesome-bootstrap-checkbox.css'/>">
	   
	 <!-- Bootstrap core JS -->
	<script src="<g:resource dir="js" file="bootstrap.min.js" />"></script>
			
	 <!-- facebook login -->
	<g:javascript src="facebookLogin.js" />
	 <g:javascript src="dataAccess.js" />
	

    <!-- Just for debugging purposes. Don't actually copy these 2 lines! -->
    <!--[if lt IE 9]><script src="../../assets/js/ie8-responsive-file-warning.js"></script><![endif]-->
    <script src="bootstrap-3.3.5/assets/js/ie-emulation-modes-warning.js"></script>

	<!-- font-awesome -->]
	<link rel='stylesheet' href='https://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css'>


	<!-- wysihtml5 -->
	<script src="<g:resource dir="js/wysihtml5" file="advanced.js" />"></script>
	<script src="<g:resource dir="js/wysihtml5" file="wysihtml5-0.3.0.min.js" />"></script>

	
	

	
    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
  </head>
  


  <body style = "background-color: #f4f4f4; min-width: 330px; ">
  
      <input id = "facebookLoginLink" type="hidden" name="perdif" value="${createLink(controller: 'Authentication', action: 'loginFaceBook')}">

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
                  <li><a href = "${createLink(controller: 'Question', action: 'askShouldIQuick')}" ><span class= 'fa fa-pencil-square-o'></span><span style = "padding-left: 6px;" >Ask</span></a></li>
                  <li><a href = "${createLink(controller: 'ShouldI', action: 'category', params: [category: 'Trending'])}" ><span class= 'fa fa-book'></span><span style = "padding-left: 6px;" >Browse Categories</span></a></li>
               </g:if>
               <g:else>
                  <li><a href = "${createLink(controller: 'Question', action: 'askShouldIQuick')}" ><span class= 'fa fa-pencil-square-o'></span><span style = "padding-left: 6px;" >Ask</span></a></li>
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

    <div class="container" style = "max-width: 725px; ">
		
	<!-- Question form -->	
		<div  class="jumbotron" style="overflow: none;  display: block; box-shadow:0 0 10px rgba(0, 0, 0, 0.15); min-height: 100px; margin: auto; min-width: 200px; margin-top: 65px;  max-width: 755px; padding: 8px; margin-bottom: 20px; background-color: #FDFDFD;  ">
			<h2  style = "color: #6f6f6f; width: 100%; text-align: center; margin: auto; padding: 15px; ">How To ShouldI.<i>fm</i></h2>
			<div>
			
			<div class = "well" style = "display: block; width: 98%; margin: auto;">
				<b><span style = "color: #337ab7">What is ShouldI.fm?</span></b> <br>
				ShouldI.fm is a place where you can ask the world questions and get honest answers. 
			</div>
			
			<a onClick = "displayHelpText('#creatingPoll')" style = "cursor: pointer; display: block; margin: 10px 3px 10px 3px; font-size: 18px;  ">Creating a Poll</a>
			<div  id = "creatingPoll" class="well" style = "display: none;">
				Login with your favorite social networking site.
				Click on "Ask" located in the navigation bar
				then select the type of poll you would like to ask:
				
				<h4 style = "color: #989898; margin: 3px; margin-top: 10px; font-size: 17px;  ">Yes/No</h4>
				<ul style = "margin: 0px; ">
				<li>Options for your poll default to "Yes" or "No".</li>
				<li>You can upload one image with this type of poll.</li>
				</ul>

				<h4 style = "color: #989898; margin: 3px; margin-top: 7px; font-size: 17px;  ">Custom</h4>
				<ul style = "margin: 0px; ">
				<li>Custom polls allow you to create your own options. (Up to 4)</li>
				<li>You can upload four images. One image per option.</li>
				</ul>
				
				<br/>
				<span style = "color: #3a9c3a;" >Tip:</span> Select a category to increase your polls searchability.
			</div>
			
			<a onClick = "displayHelpText('#privatePoll')" style = "display: block; cursor: pointer;  margin: 10px 3px 10px 3px; font-size: 18px;  ">Anonymouse/Private Polls</a>
			<div   id = "privatePoll" class="well" style = "display: none; margin-left: 5px;">
				<h4 style = "color: #989898; margin: 3px; margin-top: 0px; font-size: 17px;  ">Anonymous</h4>
				<ul style = "margin: 0px; ">
				<li><span class = "fa fa-user-secret"></span> Anonymouse polls keep your identity a secret.</li>
				<li>When you post as anonymouse your questions can still trend.</li>
				<li><span style = "color: #3a9c3a;" >Tip:</span> Anonymouse polls allow you to gather results on questions you may otherwise not ask.</li>
				</ul>
				
				<h4 style = "color: #989898; margin: 3px; margin-top: 13px; font-size: 17px;  ">Private</h4>
				<ul style = "margin: 0px; ">
				<li>Private polls <b>do not</b> require login to vote.</li>
				<li>If you uncheck <b>"Requre Login To Vote"</b> when posting a poll, this will mark it as private.</li>
				<li>Only people you share your question with will see it.</li>
				<li>Private polls do not appear in search results or trend.</li>
				<li><span style = "color: #3a9c3a;" >Tip:</span> Private polls make is easy to ask your friends and family questions.</li>
				<li><span style = "color: #C61531;" >Warn:</span> Private polls can yield unreliable results as anyone can vote without logging in. This can allow multiple votes from the same person.</li>
				</ul>
			</div>
			
			<a onClick = "displayHelpText('#notifications')" style = "display: block; cursor: pointer;  margin: 10px 3px 10px 3px; font-size: 18px;  ">Notifications</a>
			<div id = "notifications"  class = "well" style = "display: none;">
				Notifications allow you to check recent votes on your polls made by others.
				Once logged in you can view notifications by clicking the bell <span class = "fa fa-bell" ></span> in the navigation bar or going to your profile and selecting <b>"My Notifications"</b>.
			</div>
			
			<a  onClick = "displayHelpText('#voting')" style = "display: block; cursor: pointer; margin: 10px 3px 10px 3px; font-size: 18px;  ">Voting</a>
			<div   id = "voting" class = "well" style = "display: none;">
				<ul style = "margin: 0px; ">
				<li>Polls that require login to vote will only allow you to vote once.</li>
				<li>Private polls <b>do not</b> require login to vote and will display a <i>blue</i> banner notifying other users this.</li>
				<li><span style = "color: #3a9c3a;" >Tip:</span> If logged in you will see a <i>"check"</i> next to your selected option when revisiting a poll you voted on.</li>
				</ul>
				
				<div style = "padding: 3px; margin: 0px; margin-top: 10px;  " class="alert alert-info" role="alert">
				  *Learn more about private polls and voting in the <i>"Anonymouse/Private Polls"</i> section of this page.
				</div>
				
			</div>
			
			<a  onClick = "displayHelpText('#sharing')" style = "display: block; cursor: pointer;  margin: 10px 3px 10px 3px; font-size: 18px;  ">Sharing</a>
			<div  id = "sharing" class = "well" style = "display: none;">

				<h4 style = "color: #989898; margin-bottom: 3px; margin-top: 10px; font-size: 17px;  ">Share to Facebook</h4>
				Sharing is easy. Simply click the "Facebook" share button located on the right side of a polls page. You can also share your 
				polls unique link by clicking  <b>"Display Link"</b> located in the <i>blue</i> banner of your own poll. 
				
				<h4 style = "color: #989898; margin-bottom: 3px; margin-top: 13px; font-size: 17px;  ">Share Anywhere</h4>
				 You can share a poll to any social network by copying the link in your browsers navigation bar. 
				All polls are given a unique id, this makes it possible to copy and paste the link to a poll anywhere you like!
			</div>
			
			<a  onClick = "displayHelpText('#browsingQuestions')" style = "display: block;  cursor: pointer; margin: 10px 3px 10px 3px; font-size: 18px;  ">Browsing Questions</a>
			<div id = "browsingQuestions" class = "well" style = "display: none;">
				Browse through hundreds of awesome polls by clicking <b>"Browse Categories"</b> in the navigation bar. You can browse recent, trending, or even specific poll categories that you find interesting.
			</div>
			

			</div>
		
		</div>
		
      <footer class="footer" style = "margin-top: -14px;  width: 100%;" >
      <div class="container" style = "width: 100%; text-align: left; padding: 0px; ">
      <span style = "font-size: 13px; color: #79cce5;"><a style = "color: #79cce5;"  href = "${createLink(controller: 'ShouldI', action: 'privacyPolicy')}"  >Privacy Policy</a> | </span>
      <span style = "font-size: 13px; color: #79cce5;"><a style = "color: #79cce5;" href = "${createLink(controller: 'ShouldI', action: 'help')}"  >How To</a> | </span>
      <span style = "font-size: 13px; color: #79cce5;"><a style = "color: #79cce5;" href = "${createLink(controller: 'ShouldI', action: 'aboutPollaris')}">Pollaris LLC</a></span>   
      </div>   
  	  </footer>
		
    </div><!-- /.container -->

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
               <p>Please login to start a poll. Choose a network below to login with</p>
               <button onClick = "loginFacebook('${createLink(controller: 'Authentication', action: 'loginFaceBook')}')" style = "" type="button" class="btn btn-default" data-dismiss="modal">Facebook <span class = "fa fa-facebook"></span></button>
               <button  onClick = "loginReddit('${createLink(controller: 'Authentication', action: 'loginReddit')}')"style = "" type="button" class="btn btn-default" data-dismiss="modal">Reddit <span class = "fa fa-reddit"></span></button>

            </div>
            <div class="modal-footer">
               <button style = "" type="button" class="btn btn-default" data-dismiss="modal">Close</button>
            </div>
         </div>
      </div>
   </div>

    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
  
    
    <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.3.14/angular.min.js"></script>
    
	 <script src="<g:resource dir="js/tagsJS" file="bootstrap-tagsinput-angular.js" />"></script>
	 <script src="<g:resource dir="js/tagsJS" file="bootstrap-tagsinput.js" />"></script>
     <link rel="stylesheet" type="text/css" href="<g:resource dir='js/tagsJS' file='bootstrap-tagsinput.css'/>">
	
	<script>

	$( document ).ready(function() {
 
	});


	function displayHelpText(id) {
		if (!$(id).is(':visible')) {
			// Help text for ID is hidden, display it
			$(id).slideDown();
		} else {
			// Hide the help text
			$(id).slideUp();
		}
	}
	
	</script>
	
	
	
	
	
	
	
	
	
	
	
	
  </body>
</html>
