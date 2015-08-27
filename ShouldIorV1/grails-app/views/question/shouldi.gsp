<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">
    

    <title>ShouldI.fm</title>

    <!-- Bootstrap core CSS -->
      <link rel="stylesheet" type="text/css" href="<g:resource dir='css' file='bootstrap.css'/>">
      <link rel="stylesheet" type="text/css" href="<g:resource dir='css' file='buttons.css'/>">

	<link rel='stylesheet' href='https://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css'>
     <link rel="stylesheet" type="text/css" href="<g:resource dir='css' file='awesome-bootstrap-checkbox.css'/>">

			
	   <!-- facebook login -->
	<g:javascript src="facebookLogin.js" />
	
		
    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
	
  </head>


  <body style = "  ">
  
<div id="fb-root"></div>
<script>(function(d, s, id) {
  var js, fjs = d.getElementsByTagName(s)[0];
  if (d.getElementById(id)) return;
  js = d.createElement(s); js.id = id;
  js.src = "//connect.facebook.net/en_US/sdk.js#xfbml=1&version=v2.4&appId=1625511597708023";
  fjs.parentNode.insertBefore(js, fjs);
}(document, 'script', 'facebook-jssdk'));</script>
  
  	<g:if test="${session.name}">
	  	<input id = "sessionCheck" type="hidden" name="sess" value="true">
	</g:if>
	<g:else>
		  <input id = "sessionCheck" type="hidden" name="sess" value="false">
	</g:else>
		
	<input id = "percentDiffHidden" type="hidden" name="perdif" value="${percentDiff}">
	<input id = "voted" type="hidden" name="voted" value="${voted}">


	<input id = "answerOneVote" type="hidden" name="perdif" value="${answerOneVote}">
	<input id = "answerTwoVote" type="hidden" name="perdif" value="${answerTwoVote}">
	<input id = "answerTheeVote" type="hidden" name="perdif" value="${answerThreeVote}">
	<input id = "answerFourVote" type="hidden" name="perdif" value="${answerFourVote}">
	


    <nav class="navbar navbar-inverse navbar-fixed-top" style = "">
      <div class="container">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <img  onClick = "share()"src="${resource(dir:'images',file:'logo.png')}"   class="navbar-brand"/>
        </div>
        <div id="navbar" class="collapse navbar-collapse">
          <ul class="nav navbar-nav">
            <li><a href="#">My Home</a></li>
			<li><a href="#">Hot Questions</a></li>
          </ul>

		<g:if test="${session.name}">
       	 <ul class="nav navbar-nav navbar-right">
        <li><a id = "facebookLoginMenu" href = "#"  onClick = "loginFacebook()">Welcome ${session.name}</a></li>
		</ul>
		<ul class="nav navbar-nav navbar-right">
        <li><a id = "createAccount" href = "#"   onClick = "logoutFaceBook()">Logout</a></li>
		</ul>
</g:if>
<g:else>
  	 <ul class="nav navbar-nav navbar-right">
        <li><a id = "facebookLoginMenu" href = "#"  onClick = "loginFacebook()">Log in with <span href="#about" style = "padding-left: 4px;" class='fa fa-facebook-official'></span> </a></li>
		</ul>
		<ul class="nav navbar-nav navbar-right">
        <li><a id = "createAccount" href = "#"   onClick = "login()">Sign Up/Login</a></li>
		</ul>
</g:else>
		
		
        </div><!--/.nav-collapse -->
      </div>
    </nav>

    <div class="container" style = "padding-top: 77px; max-width: 875px;">
	

		<div  class="jumbotron" style=" background-color: #FFFFFF; margin: 0px; padding: 0px; box-shadow:0 0 10px rgba(0, 0, 0, 0.15);  height: 100%;   display: block; width: 100%; ">

	<!-- QUESTION -->	
			<g:each in="${question}">
			
					

		<input id = "questionID" type="hidden" name="country" value="${it.questionID}">	
	
	<div style ="display: block; width: 100%; padding-bottom: -5px; " >

	
		<!-- MAIN -->	
	<div  style="display: block;  padding: 10px;  border-bottom: solid 1px; border-color: #f3f3f3;  margin: auto;  ">
				<!-- PROFILE INFORMATION -->	
				<div style = "display: inline-block; width: 68px; padding-left: 5px;">
				<img  style = "width: 100%;   display: inline-block; border-top-right-radius: 6px; border-top-left-radius: 5px;" src = "../../User/getProfileImage/${it.userID}"  />			
				</div> 	
				<div style = "display: inline-block; padding-bottom:0px; margin-right: 4px; margin-left: 4px; vertical-align: top;  ">
				<span style = "margin-left: 1px; color: #5C5C5C; display: block; font-size: 15px;"><b>Nicolas Melia</b></span>
				<span style = "margin-left: 1px; color: #5C5C5C; margin-top: -2px;  display: block; font-size: 15px;">Followers: 234 <span style = 'text-align: left; color: #545252;  padding-left: 2px; display: inline-block;' class='fa fa-plus'></span></span>
				<span style = "margin-left: 1px; color: #5C5C5C; margin-top: -2px; display: block; font-size: 15px;">Reached: 34k People</span>
		</div>
		</div> 
		<!-- PROFILE INFORMATION -->	
		
			
	<div style = " display: block; height: 50px; ">
	
			<span style = 'text-align: left; font-size: 18px; color: #4A4A4A; padding-left: 12px; padding-top:6px; display: inline-block;'>
			<span id = "diffPercent"style = "color: #61B7FE; font-size: 18px;"></span>
			<span style = "color: #8D8D8D;">Yes</span></span>
			

			<div style = "padding-bottom: -10px; float:right; display: inline-block; vertical-align: top;">
			
			<div  onClick = "test()" style = "text-align: left; width: 70px; background-color: #61B7FE; padding: 2px; padding-left: 4px; color: #ffffff; font-size: 12px; margin-right: 8px; margin-top:9px; ">
			<div style = "margin: auto; padding: 0px; margin: 0px;"><span style = ' ' class='fa fa-facebook'></span> Share</div>
			</div>
			
			</div>
			
			<div style = "padding-bottom: -10px; float:right; display: inline-block; vertical-align: top;">
			
			<div  onClick = "test()" style = "text-align: left; width: 70px; background-color: #61B7FE; padding: 2px; padding-left: 4px; color: #ffffff; font-size: 12px; margin-right: 8px; margin-top:9px; ">
			<div style = "margin: auto; padding: 0px; margin: 0px;"><span style = ' ' class='fa fa-star'></span> Favorite</div>
			</div>
			
			</div>
			
	</div>
		
		<span style = 'text-align: center; margin: center; margin-top: 0px; padding: 0px 8px 0 8px; color: #545252; font-size: 20px; display: block;' >${it.questionTitle}</span>
		
		<hr style = "margin-top: 8px; width: 85%; margin-bottom: 0px; padding-top: 0px;">		 	
				 					 	
		<div id = "ee" style = "margin-bottom: 30px; padding: 15px;  margin: auto; margin-top: 20px;  width: 50%; min-width: 290px; max-width: 330px; mag-height: 100px; background-color: #F4FAFF; display: block;" >
			 <img id="singleImg" src = "../getAnswerOneImageById/${it.questionID}"  style ="display: block;  width: 95%;  height: 80%; margin: auto;" alt="UhOh! We cant seem to load the image." />
		</div>
		
	
		 <div style = "padding: 15px; width: 98%; max-height: 300px; margin:auto; padding-top: 18px; overflow-y: auto;  display: block;">
				${raw(it.question)} 
		 </div>


<table style="width: 100%; overflow:none; margin-top: 10px; padding:0px; border-top: 1px solid #E1E1E1;">
		
  <tr style = "width: 50%;display:none;">
  <td style = " width: 50%; text-align: center;  padding: 10px; border-right: 1px solid #E1E1E1; " >
	<img  src = "sampImg.jpg" style = "width: 55%; min-width: 150px;  "/>
	</td>
	
  <td style = "width: 50%; text-align: center; padding: 10px;   " >
	<img  src = "sampImg.jpg" style = "width: 55%; min-width: 150px; "/>	
	</td>
  </tr>
  
    <tr style = "width: 100%; ">
  <td  onClick = "questionVote('ONE')" class="picAnswer1"  style = "width: 50%; text-align: center; border-right: 1px solid #E1E1E1;  " >
	<p style = "padding:5px; width: 100%; display:block; margin: auto; bottom: 0px; text-align: center; font-size: 19px;  color: #61B7FE; ">Yes <span id = "AnswerOneCount" style = "color: #8D8D8D;">(${it.answerOneVotes})</span></p>
	</td>	
	
  <td onClick = "questionVote('TWO')"  class="picAnswer2"  style = " width: 50%; text-align: center; " >
	<p style = "padding:5px;  width: 100%; display:block; margin: auto; bottom: 0px; text-align: center; font-size: 19px;  color: #61B7FE; ">No <span id = "AnswerTwoCount"  style = "color: #8D8D8D;">(${it.answerTwoVotes})</span></p>
	</td>	
  </tr>
  
 </table>	
	</div>

	</div>
	

	<!-- QUESTION -->	
		</g:each>


	<!-- MAIN -->	


		<!-- NEXT Q -->	
		<div  class="jumbotron next" style="overflow: auto;  text-align: center; display: block; box-shadow:0 0 10px rgba(0, 0, 0, 0.10); height: 44px; margin: auto; max-width: 875px; padding-left: 0px; padding-right: 0px; padding-top: 11px; padding-bottom: 0px;  margin-bottom: 12px; margin-top: 12px; ">
		<span class = "" style = "margin: auto; width: 100px; color: #888888; font-size: 17px;">More Questions<span style = "color: #9D9D9D; margin-left: 8px;" class = "fa fa-refresh"> </span></span>
		</div>
		<!-- NEXT Q -->	

	


	
	<!-- COMMENT BOX -->	
		<div  class="jumbotron" style="overflow: auto;  display: block; box-shadow:0 0 10px rgba(0, 0, 0, 0.15); min-height: 100px; margin: auto; min-width: 200px;  max-width: 875px; padding: 0px 10px 0px 10px;  margin-bottom: 50px; background-color: #FFFFFF;  ">
			
			
			<div class="fb-comments" data-href="http://localhost:8080/ShouldIorV1/Question/shouldi/${questionID}" data-numposts="5"></div>

		</div>
		<!-- COMMENT BOX -->	
						</div>


		

  <!-- LOGIN Modal -->
  <div class="modal fade" id="noLogin" role="dialog">
    <div class="modal-dialog">
    
      <!-- Modal content-->
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <h4 class="modal-title"><span href="#about" style = "padding-left: 4px;" class='fa fa-exclamation-circle'> </span>Not logged in</h4>
        </div>
        <div class="modal-body">
          <p>Please login to post a comment</p>
		  <button style = "" type="button" class="btn btn-default" data-dismiss="modal">Login</button>
		  <button style = "" type="button" class="btn btn-default" data-dismiss="modal">Login with Facebook</button>

        </div>
        <div class="modal-footer">
          <button style = "" type="button" class="btn btn-default" data-dismiss="modal">Close</button>
        </div>
      </div>
      
    </div>
  </div>
    <!-- LOGIN Modal -->
	
	
	
	  <!-- LOGIN Modal -->
  <div class="modal fade" id="noVote" role="dialog">
    <div class="modal-dialog">
    
      <!-- Modal content-->
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <h4 class="modal-title"><span href="#about" style = "padding-left: 4px;" class='fa fa-exclamation-circle'> </span> Can't do that...</h4>
        </div>
        <div class="modal-body">
          <p>You can't vote twice. Sorry!</p>
        </div>
        <div class="modal-footer">
          <button style = "" type="button" class="btn btn-default" data-dismiss="modal">Close</button>
        </div>
      </div>
      
    </div>
  </div>
    <!-- LOGIN Modal -->
	
</div><!-- /.container -->


	<footer class="footer" style= " width: 90%;">
      <div class="container">
        <p class="text-muted">&copy; ShouldIOr, Developed by NightSkyCode LLC</p>
      </div>
    </footer>
			
			
    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
    <g:javascript src="dataAccess.js" />
    
    <script src="<g:resource dir="js" file="bootstrap.min.js" />"></script>


	<script>
	$(document).ready(function() {
		$("#diffPercent").text($("#percentDiffHidden").val() + "%")

		FB.ui({
  method: 'share',
  display: 'dialog',
  href: 'https://developers.facebook.com/docs/',
}, function(response){});
		
		
		//if ($("#voted").val() == "true") {
			//$("#AnswerOneCount").css("display","inline-block")
			//$("#AnswerTwoCount").css("display","inline-block")
		//}
		
	});
	
	function postComment() {
		 getStuff();
	  if (checkFaceBookLogin()) {
	  alert("conected");
		} else {
		$('#noLogin').modal('show');
		}
	}

	function login() {
		  alert("conected");
	}


	function test() {
		FB.ui({
			  method: 'feed',
			  display: 'iframe',
			  app_id: '1625511597708023',
			  link: 'https://developers.facebook.com/docs/',
			  caption: 'How are you doing',
			  description: 'Hello Hello Hello Hello Hello Hello Hello Hello Hello Hello Hello Hello Hello Hello Hello Hello Hello Hello Hello Hello Hello Hello Hello Hello',
			  picture: 'https://upload.wikimedia.org/wikipedia/commons/9/95/Burning_Yellow_Sunset.jpg',
			}, function(response){});
		}
		

	
	</script>
  </body>
</html>