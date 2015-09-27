<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">
    
	 <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
  
    <!-- Bootstrap core CSS -->
      <link rel="stylesheet" type="text/css" href="<g:resource dir='css' file='bootstrap.css'/>">
      <link rel="stylesheet" type="text/css" href="<g:resource dir='css' file='buttons.css'/>">
      <link rel="stylesheet" type="text/css" href="<g:resource dir='css' file='awesome-bootstrap-checkbox.css'/>">
	   
	 <!-- Bootstrap core JS -->
	<script src="<g:resource dir="js" file="bootstrap.min.js" />"></script>
			
	 <!-- facebook login -->
	<g:javascript src="facebookLogin.js" />
	<g:javascript src="dataRequest.js" />
	

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
                      <li><a href = "${createLink(controller: 'ShouldI', action: 'category', params: [category: 'Trending'])}" ><span class= 'fa fa-book'></span><span style = "padding-left: 6px;" >Browse Categories</span></a></li>
                  </g:if>
                  <g:else>
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
                           <li><a  onClick = "logoutFaceBook()" href="#"><span class= 'fa fa-sign-out'></span><span style = "padding-left: 5px;" >Log Out</span></a></li>
                        </ul>
                     </li>
                  </ul>
               </g:if>
               <g:else>
                  <ul class="nav navbar-nav navbar-right">
                     <li><a id = "facebookLoginMenu" href = "#"  style = ""  onClick = "loginFacebook()">Log in with <span href="#about" style = "padding-left: 4px; color:#5BC0DE;" class='fa fa-facebook-official'></span> </a></li>
                  </ul>
                  <ul class="nav navbar-nav navbar-right">
                  </ul>
               </g:else>
            </div>
            <!--/.nav-collapse -->
         </div>
      </nav>

    <div class="container" style = "max-width: 725px; ">
		
	<div style = "width: 100%; margin-top: 60px; margin-bottom: 8px;   ">
   
	  <div  id = "trendingSelect" onClick = "loadQuestionURL('${createLink(controller: 'Question', action: 'askShouldI', params: [category: 'Trending'])}')" class = "flatMenuItem"   style= " margin-left: 5px; display:inline-block; border-bottom: 2px solid #79cce5; ">
	  	<span   class = "flatMenuItemText"  style = " font-size: 19px;" >Yes/No</span>
	  </div>
	  
	  <div  id = "recentSelect"  onClick = "loadQuestionURL('${createLink(controller: 'Question', action: 'askShouldICustom', params: [category: 'Recent'])}')" class = "flatMenuItem" style= " margin-left: 5px; display:inline-block; border-bottom: 0px solid #79cce5; " >
	  	<span   class = "flatMenuItemText"  style = " font-size: 19px;" >Custom</span>
	  </div>
	  	
	  	
	  </div>
		<!-- Question form -->	
		<div  class="jumbotron" style="overflow: none;  display: block; box-shadow:0 0 10px rgba(0, 0, 0, 0.15); min-height: 100px; margin: auto; min-width: 200px;  padding-left: 0px; padding-right: 0px; padding-top: 0px; padding-bottom: 1px;  margin-bottom: 20px; background-color: #FDFDFD;  ">
			
	

	<div class="form-group" style = "padding-left: 16px;  display:block; padding-right: 16px; padding-top: 1px; ">		

		<div id = "errorAlert"class="alert alert-danger" role="alert" style = " display: none; margin-top: 10px; padding: 6px;" >
		 <span id = 'errorMessage' ></span>
		</div>
		
			<div id = "imgContainer" style = "margin-top: 22px; margin-bottom: -10px; padding: 6px; background-color: #EAEAEA; display: none;" >
		<span onclick = "resetFormElement1()" style = 'text-align: right;  right: 0px; float: right;  color: #d9534f; font-size: 20px; padding-right: 0px; padding-top:0px; display: inline-block;' class = 'fa fa-minus-square' ></span>
		 <img id="image1" src="#" style ="display: none; margin: auto; width: 50%; max-width: 200px;" alt="Error displaying image (Image will still upload)" />
		</div>
			                                              
	<div id="wysihtml5-toolbar" style="display: none;  margin-top: 10px; ">
		<div class="btn-group">
						
				<a  data-wysihtml5-command="bold" style = "padding-top: 2px; padding-bottom: 2px;"  class="btn btn-default">
                    <i  style = "color: #5BC0DE;"  class="fa fa-bold"></i>
                </a>
							
				<a data-wysihtml5-command="italic" style = "padding-top: 2px; padding-bottom: 2px;" class="btn btn-default">
                    <i  style = "color: #5BC0DE;"  class="fa fa-italic"></i>
                </a>
				
            </div>
			
			<div class="btn-group">
                <a data-wysihtml5-command="insertUnorderedList" style = "padding-top: 2px; padding-bottom: 2px;" class="btn btn-default">
                    <i   style = "color: #5BC0DE;"  class="fa fa-list-ul"></i>
                </a>
                <a data-wysihtml5-command="insertOrderedList" style = "padding-top: 2px; padding-bottom: 2px;" class="btn btn-default">
                    <i  style = "color: #5BC0DE;"  class="fa fa-list-ol"></i>
                </a>
            </div>

</div>

	 <g:form controller="Question" action="postShouldI" enctype="multipart/form-data" >
	<input id = 'title' type="text" name = "title" style = "width: 100%;  margin-top: 8px; " class="form-control"  placeholder="Title">

	<textarea type="text" name = "question" style = "resize: none; height: 170px; margin-top: 8px; " class="form-control" id="wysihtml5-textarea" placeholder="Ask away..."></textarea>

	<select name = "category" class="form-control" style = "margin-top: 6px; margin-bottom: 6px; ">
	    <option value="one">No Category</option>
	    <option value="two">Two</option>
	    <option value="three">Three</option>
	    <option value="four">Four</option>
	    <option value="five">Five</option>
	    	    <option value="two">Two</option>
	    <option value="three">Three</option>
	    <option value="four">Four</option>
	    <option value="five">Five</option>
	</select>

		<div id = "errorAlertNoLogin"class="alert alert-info" role="alert" style = " display: none; margin-top: 7px; padding: 6px; margin-bottom: 7px; " >
		 <span id = 'errorMessage' >
		Disabling logins to vote will mark this question as <b>private</b>. <a href = "${createLink(controller: 'ShouldI', action: 'help')}" ><span style = "" >Learn More</span></a></li>	 
		</span>
		</div>
		
		<div class="checkbox checkbox-danger"  style = "display: block; margin-top: 0px; margin-left: 2px;" >
		    <input type="checkbox"  name = "anonymous"  id="anonymousCheckbox"/>
    <label  for="anonymousCheckbox">
        Post as anonymous
    </label>
		</div> 
		
<div class="checkbox checkbox-default"  style = "display: block; margin-top: 0px; margin-left: 2px;" >
		    <input type="checkbox"  name = "loginToVote"  id="noLoginCheckbox" checked/>
    <label  for="noLoginCheckbox">
        Require login to vote
    </label>
		</div> 
		
	<div style = "display: block; width: 100%" >
	<g:actionSubmit  onclick="return validate()" value = "Ask"  action = "postShouldI" style = "margin-top: 1px; width: 100px; display: inline-block;" class="btn btn-default"/>
		<span class="btn btn-default btn-file">
			<span class = "fa fa-picture-o"></span> Add Photo  <input id = "imageUpload" name = 'image1' type="file" accept="image/*">
		</span>
	</div>
			</g:form>
	
	</div>
	


		</div>
		<!-- Question Form -->	

		
    </div><!-- /.container -->


    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
  
    
    <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.3.14/angular.min.js"></script>
    
	 <script src="<g:resource dir="js/tagsJS" file="bootstrap-tagsinput-angular.js" />"></script>
	 <script src="<g:resource dir="js/tagsJS" file="bootstrap-tagsinput.js" />"></script>
     <link rel="stylesheet" type="text/css" href="<g:resource dir='js/tagsJS' file='bootstrap-tagsinput.css'/>">
	
	<script>
	var editor;
	$('#tagsInput1').tagsinput({
	  maxChars: 10
	});
	
	$( document ).ready(function() {
		  $('.single').css('border-bottom', ' solid 2px #5BC0DE');

		 editor = new wysihtml5.Editor("wysihtml5-textarea", { // id of textarea element
			  toolbar:      "wysihtml5-toolbar", // id of toolbar element
			  parserRules:  wysihtml5ParserRules // defined in parser rules set 
			});


	$("#noLoginCheckbox").click(function() {
	  if (this.checked) {
		  $('#errorAlertNoLogin').slideUp(800);	  
	  } else {
		  $('#errorAlertNoLogin').slideDown(800);	  
	  }

	});

	$(function() {
		$('.custom').hover( function(){
        $('.single').css('background-color', '#FFFFFF');
		$('.single').css('border-bottom', ' solid 2px #d3d3d3');

		},
	   function(){
		  $('.single').css('border-bottom', ' solid 2px #5BC0DE');
		  $('.single').css('background-color', '#F7FBFF');
		   });
		});
});
	
	function readImg(input) {
		if (input.files && input.files[0]) {
			var reader = new FileReader();

			reader.onload = function (e) {
				$('#image1').attr('src', e.target.result);
				$('#imgContainer').css("display", "block");
				$('#image1').css("display", "block");
			}

			reader.readAsDataURL(input.files[0]);
		}
	}

	$("#imageUpload").change(function(){
		errors = [];
		
		 if (this.files[0].size <= 2000000) {	
			$("#imgError").css('display', 'none');
			readImg(this);
		 } else {
			$("#imgError").css('display', 'none');
			errors.push("Images must be under 2mb.");
			
			$("#errorMessage").html("");
			for (i = 0; i < errors.length; i++) { 
				$("#errorMessage").append("*" + errors[i] + "<br/>");		
			}		
			//$("#errorMessage").html(errors);
			
			$("#errorAlert").slideDown("800");
			
			resetFormElement1();
		}
	});
		
		// Removes file from photo input 1
	function resetFormElement1() {
	var control = $('#imageUpload');
	control.replaceWith(control = control.clone(true));
	//$('#image1').fadeOut(1000);
	$('#imgContainer').fadeOut(800);
	}	

	var errors = [];
	function validate() {
	var errorMessage;
	var hasErrors = false;
	var title = $("#title").val();
	var question = $("#wysihtml5-textarea").val(); 
	
	$("#errorAlert").css("display", "none");
	errors = [];
	
		if (title == "" || title.length < 5 || title.length > 55) {
			hasErrors = true;
			errors.push("Please enter a valid title.");
		} 

		if (question == "" || question.length < 10) {
			hasErrors = true;
			errors.push("Please enter a valid question.");
		} 

		if (question.length > 3000) {
			hasErrors = true;
			errors.push("Question is too long.");
		} 

		if (hasErrors) {
			$("#errorMessage").html("");
			for (i = 0; i < errors.length; i++) { 
				$("#errorMessage").append("*" + errors[i] + "<br/>");		
			}		
			//$("#errorMessage").html(errors);
			
			$("#errorAlert").slideDown("800");
			return false;
		} else {
		// Validate success
			return true; 
		}	
	}

    function loadQuestionURL(url) {
      	window.location.href = url;
      }

	
	</script>
	
	
	
	
	
	
	
	
	
	
	
	
  </body>
</html>
