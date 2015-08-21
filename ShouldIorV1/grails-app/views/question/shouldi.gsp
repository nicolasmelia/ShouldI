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
	<g:javascript src="dataRequest.js" />
	
		
    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
	
  </head>


  <body style = "  ">
  
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
	


    <nav class="navbar navbar-inverse navbar-fixed-top">
      <div class="container">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <img src="${resource(dir:'images',file:'logo.png')}"   class="navbar-brand"/>
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

    <div class="container" style = "padding-top: 80px; max-width: 875px;">
	

		
		<div  class="jumbotron" style=" background-color: #FFFFFF; margin: 0px; padding: 0px; box-shadow:0 0 10px rgba(0, 0, 0, 0.15);  height: 100%;   display: block; width: 100%; ">





	<!-- QUESTION -->	
			<g:each in="${question}">
		<input id = "questionID" type="hidden" name="country" value="${it.questionID}">
			
	
	
	
	
	
	
	
	
	<div style ="display: block; width: 100%; padding-bottom: -5px; " >

		
		
				 			
		
		
			
	
		<!-- MAIN -->	
	<div  style="display: block;  padding-top:10px; padding-bottom: 12px;  border-bottom: solid 1px;  margin: auto;  ">
				<!-- PROFILE INFORMATION -->	
				<div style = "display: inline-block; width: 68px; padding-left: 5px;">
				<img style = 'width: 100%;  display: inline-block; border-top-right-radius: 6px; border-top-left-radius: 5px; ' src="${resource(dir:'images',file:'blankAv.png')}"  />			
				</div> 	
				<div style = "display: inline-block; padding-bottom:0px; margin-right: 4px; margin-left: 4px; vertical-align: top;  ">
				<span style = "margin-left: 1px; color: #5C5C5C; display: block; font-size: 18px;"><b>Nicolas Melia</b></span>
				<span style = "margin-left: 1px; color: #5C5C5C; margin-top: -2px;  display: block; font-size: 15px;">Followers: 349</span>
				<span style = "margin-left: 1px; color: #5C5C5C; margin-top: -2px; display: block; font-size: 15px;">Reached: 34k People</span>
		</div>
		</div> 
		<!-- PROFILE INFORMATION -->	
		
			
	<div style = " display: block; height: 50px;">
	
			<span style = 'text-align: left; font-size: 18px; color: #4A4A4A; padding-left: 12px; padding-top:10px; display: inline-block;'>
			<span id = "diffPercent"style = "color: #61B7FE; font-size: 18px;"></span>
			<span style = "color: #8D8D8D;">Yes</span></span>
			
			<div style = "padding-bottom: -10px; margin-bottom: -10px; float:right; display: inline-block;">
			<span style = 'text-align: left; color: #545252; font-size: 21px; padding-right: 15px; padding-top:10px; display: inline-block;' class='fa fa-share-alt-square'></span>		
			</div>
			
			<div style = "padding-bottom: -10px; float:right; display: inline-block; vertical-align: top;">
			<span style = 'text-align: left; color: #545252; font-size: 21px; padding-right: 13px; padding-top:10px; display: inline-block;' class='fa fa-star'></span>
			</div>
			
			<div style = "padding-bottom: -5px; float:right;  display: inline-block; vertical-align: top; ">
			<span style = 'text-align: left; color: #545252; font-size: 18px; padding-right: 13px; padding-top:10px; display: inline-block;' >Follow</span>
			</div>
			
	</div>
		
		
		
		
		
		
					<span style = 'text-align: center; margin: center; margin-top: 10px; padding: 0px 8px 0 8px; color: #545252; font-size: 20px; display: block;' >${it.questionTitle}</span>
		
		
		
			<hr style = "margin-top: 8px; width: 85%; margin-bottom: 8px; padding-top: 0px;">
				 					 	
				 	
				 					 	
		<div id = "ee" style = "margin-bottom: 30px; padding: 15px;  margin: auto; margin-top: 10px;  width: 50%; min-width: 290px; max-width: 330px; mag-height: 100px; background-color: #F4FAFF; display: block;" >
			 <img id="singleImg" src = "/ShouldIorV1/question/getAnswerOneImageById/${it.questionID}"  style ="display: block;  width: 95%;  height: 80%; margin: auto;" alt="UhOh! We cant seem to load the image." />
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
	<p style = "padding:5px; width: 100%; display:block; margin: auto; bottom: 0px; text-align: center; font-size: 19px;  color: #61B7FE; ">Yes <span id = "AnswerOneCount" style = "color: #8D8D8D; display:none;">(${it.answerOneVotes})</span></p>
	</td>	
	
  <td onClick = "questionVote('TWO')"  class="picAnswer2"  style = " width: 50%; text-align: center; " >
	<p style = "padding:5px;  width: 100%; display:block; margin: auto; bottom: 0px; text-align: center; font-size: 19px;  color: #61B7FE; ">No <span id = "AnswerTwoCount"  style = "color: #8D8D8D; display:none;">(${it.answerTwoVotes})</span></p>
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
		<div  class="jumbotron" style="overflow: auto;  display: block; box-shadow:0 0 10px rgba(0, 0, 0, 0.15); min-height: 100px; margin: auto; min-width: 200px;  max-width: 875px; padding-left: 0px; padding-right: 0px; padding-top: 0px; padding-bottom: 0px;  margin-bottom: 50px; background-color: #FFFFFF;  ">
			
			<p style = "padding-left: 15px; margin-bottom: -10px;  padding-top: 15px; font-size: 18px;" class = "fa fa-comments" > Comments (7) </p>
			<hr style = "margin-top: 8px; margin-bottom: 8px; padding-top: 0px;">
			<div style = " width: 100%;  display: block; overflow-y: auto; overflow-x: hidden; padding: 0px;  max-height: 340px;  ">
			
			
		<!-- MESSAGE ROW BEGIN -->	
		<div class="comment">
		  <div class="left" style = 'float: left; width: 100px;'>
			<img style = 'text-align: center; width: 90%; padding-top:8px; padding-left: 18px;'  src = "blankAv.png" />
			<p style = "padding:0px; margin: auto; color: green; text-align: center; font-size: 16px;"></p>
		  </div>
		  <div style = 'margin-left:100px; margin-bottom: 4px;'>  
			<p style = "padding: 4px 9px 4px 4px; font-size: 15px; margin-bottom: 5px;" >
			<span style = "margin-right: 4px;"><b>Nicolas Melia</b></span>
			<span style = "margin-right: 4px;">11/10/1989</span><br>
			Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor.
			</p>
			
			<div style = "padding-bottom: 10px; ">
			<span style = 'text-align: left; font-size: 15px; padding-left: 5px; padding-top:0px; display: inline-block;'><b>34</b></span>
			<span style = 'text-align: left; font-size: 15px; padding-left: 6px; padding-top:0px; display: inline-block;' class='fa fa-chevron-up'></span>
			<span style = 'text-align: left; font-size: 15px; padding-left: 6px; padding-top:0px; display: inline-block;' class='fa fa-chevron-down'></span>
						<span style = 'text-align: left; font-size: 15px; padding-left: 6px; padding-top:0px; display: inline-block;' ><a href = "#">34 Replys</a></span>

			</div>
			
		  </div>
		  
		  <!-- Reply BOX -->	
		  <div id = "replyBox"style = "display:none; margin-top: 10px;">
		 <div class="commentReplies" style = "margin-left: 100px;">
		 		
		  <!-- MESSAGE reply -->	
				<blockquote style = "padding: 0px; ">

		  <div  style = "width: 70px; display: inline-block; float: left;">
			<img style = 'text-align: center; width: 100%; padding-top:8px; padding-left: 10px; padding-right: 0px;' src = "blankAv.png" />
		  </div>
		  <div  style = "margin-left:80px;">  
			<p style = "padding: 4px 9px 4px 4px; font-size: 14px; margin-bottom: 0px;" >
			<span style = "margin-right: 4px;"><b>Nicolas Melia</b></span>
			<span style = "margin-right: 4px;">11/10/1989</span><br>
			Yeah right no one belives in this this is  ajoke	
			</p>
			
			<div style = "padding-bottom: 10px; ">
			<span style = 'text-align: left; font-size: 15px; padding-left: 5px; padding-top:0px; display: inline-block;'><b>34</b></span>
			<span style = 'text-align: left; font-size: 15px; padding-left: 6px; padding-top:0px; display: inline-block;' class='fa fa-chevron-up'></span>
			<span style = 'text-align: left; font-size: 15px; padding-left: 6px; padding-top:0px; display: inline-block;' class='fa fa-chevron-down'></span>
			</div>
			
		  </div>
		  		 </blockquote>
				 		  <!-- MESSAGE reply -->	
				 		  <button type="button" style = "display: block; height: 30px; padding: 4px; width: 100px;   margin-bottom: 10px;" class="btn btn-default">Load More</button>
		</div>	
		  </div>
		  <!-- Reply BOX -->	
 
		</div>		 
		<hr style =" padding: 11px 0px 0px 0px; margin: 0px; width: 90%; margin: auto;">
		<!-- MESSAGE ROW END -->
		
						
			</div>
			
	<div class="form-group" style = "padding-left: 16px; padding-right: 16px; padding-top: 2px; vertical-align:top;  height: 140px; ">		
		<textarea type="text" style = "resize: none; height: 90px;" class="form-control" id="exampleInputPassword1" placeholder="Leave a comment"></textarea>
		<button type="button" style = "margin-top: 10px; display: inline-block;" class="btn btn-default">Comment</button>

		<div class="checkbox" style = "display: inline-block; padding-top: 0px; height: 10px; vertical-align:bottom;  " >
		  <label style = "vertical-align: bottom; margin-top: 0px; margin-left: 5px; " >
			<input type="checkbox" value="">
			Anonymous Comment
		  </label>
		</div>
					
	</div>


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
    <g:javascript src="shouldIVote.js" />
    
    <script src="<g:resource dir="js" file="bootstrap.min.js" />"></script>


	<script>
	$(document).ready(function() {
		$("#diffPercent").text($("#percentDiffHidden").val() + "%")

		if ($("#voted").val() == "true") {
			$("#AnswerOneCount").css("display","inline-block")
			$("#AnswerTwoCount").css("display","inline-block")
		}
		
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
			
		

	
	</script>
  </body>
</html>