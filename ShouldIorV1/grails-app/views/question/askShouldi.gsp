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

    <g:if test="${session.name}">
	  	<input id = "sessionCheck" type="hidden" name="country" value="true">
	</g:if>
	<g:else>
		  <input id = "sessionCheck" type="hidden" name="country" value="false">
	</g:else>
	

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
        <li><a id = "facebookLoginMenu" href = "#"  style = "color:#1980f7;"  onClick = "loginFacebook()">Log in with <span href="#about" style = "padding-left: 4px;" class='fa fa-facebook-official'></span> </a></li>
		</ul>
		<ul class="nav navbar-nav navbar-right">
        <li><a id = "createAccount" href = "#"   onClick = "login()">Sign Up/Login</a></li>
		</ul>
</g:else>
		
		
        </div><!--/.nav-collapse -->
      </div>
    </nav>

    <div class="container">

		<!-- Question form -->	
		<div  class="jumbotron" style="overflow: none;  display: block; box-shadow:0 0 10px rgba(0, 0, 0, 0.15); min-height: 100px; margin: auto; min-width: 200px; margin-top: 60px;  max-width: 600px; padding-left: 0px; padding-right: 0px; padding-top: 0px; padding-bottom: 1px;  margin-bottom: 20px; background-color: #FDFDFD;  ">
			
		<div style = " margin-bottom:10px; padding-bottom: 10px; display:block; width: 100%; ">
		<div  class="single" style=" border-top-left-radius: 8px; vertical-align: bottom;  text-align: bottom; border-top: 1px solid #E1E1E1;  margin-top: 0px;  width: 50%; float: left; margin-right:-1px; padding: 2px; vertical-align: bottom; display: inline-block;">
		<p style = "padding:0px; font-size: 19px; margin: auto; color: #5BC0DE; text-align: center;">Yes/No<span style = "color: #8D8D8D; font-size: 18px;"></span></p>
		</div> 
	
		<div onClick = "openCustom()" class="custom" style=" border-top-right-radius: 8px; border-top: 1px solid #E1E1E1;  border-left: 1px solid #E1E1E1;  margin-top: 0px;  width: 50%;margin-right:-1px;   float: right; padding: 2px; vertical-align: bottom; display: inline-block;">
		<p style = "padding:0px; font-size: 19px; margin: auto; color: #5BC0DE; text-align: center;">Custom<span style = "color: #8D8D8D; font-size: 18px; "> </span></p>
		</div> 
		</div>	

	<div class="form-group" style = "padding-left: 16px;  display:block; padding-right: 16px; padding-top: 1px; ">		
	<span  id = "postingAs" style = "margin-bottom:4px; margin-top:10px; padding-top: 15px;  display:none;" >Posting as Nicolas</span>

	<div id = "imgContainer" style = "margin-top: 22px; margin-bottom: -10px; padding: 6px; background-color: #EAEAEA; display: none;" >
		<span onclick = "resetFormElement1()" style = 'text-align: right;  right: 0px; float: right;  color: #d9534f; font-size: 20px; padding-right: 0px; padding-top:0px; display: inline-block;' class='fa fa-times'></span>
		 <img id="image1" src="#" style ="display: none; margin: auto; width: 50%; max-width: 200px;" alt="Error displaying image (Image will still upload)" />
	</div>
	
	
	                                              
	<div id="wysihtml5-toolbar" style="display: none;  margin-top: 24px; ">


        
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
	<input type="text" name = "title" style = "width: 100%;  margin-top: 8px; " class="form-control" id="title" placeholder="Title">

	<textarea type="text" name = "question" style = "resize: none; height: 170px; margin-top: 8px; " class="form-control" id="wysihtml5-textarea" placeholder="Should I, or..."></textarea>

		<div style = "padding-top: 10px; display: block;   width: 100%; "  >
		<div style = "font-color: #3d3d3d; margin-bottom: 3px;" ><b>Tags</b> <i>ie. Idea, Funny, Hair, Politics </i></div>
				<input type="text"   name = "tags"  id = "tagsInput1"  style = "width: 100%; " value="Should I" data-role="tagsinput" />
		</div>
		
		

		<div class="checkbox checkbox-danger"  style = "display: block; margin-top: 0px; margin-left: 2px;" >
		    <input type="checkbox"  name = "anonymous"  id="anonymousCheckbox"/>
    <label  for="anonymousCheckbox">
        Post as anonymous
    </label>
		</div> 
		
	<div style = "display: block; width: 100%" >
	<g:actionSubmit  value = "Post"  action = "postShouldI" style = "margin-top: 1px; width: 100px; display: inline-block;" class="btn btn-default"/>
		<span class="btn btn-default btn-file">
			Upload Photo <input id = "imageUpload" name = 'image1' type="file">
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

		
		// ADDDDDDDDDDDDDDDDDDDDD
		editor.on('load', function () {
	    var body = $('iframe').contents().find('body');

	    body.on('keydown', function (e) {
	        if (e.keyCode == 13) {
	            editor.composer.commands.exec("insertHTML", "&nbsp;");
	        }
	    })
	});
		//ADDDDDDDDDDDDDDDDDDDDD
	
	$("#anonymousCheckbox").click(function() {
	  if (this.checked) {
	  alert($('#tagsInput1').val());
	  	$("#postingAs").html("Posting as anonymous");
	  } else {
		$("#postingAs").html("Posting as Nicolas");
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
		readImg(this);
	});
	
		// Removes file from photo input 1
	function resetFormElement1() {
	var control = $('#imageUpload');
	control.replaceWith(control = control.clone(true));
	//$('#image1').fadeOut(1000);
	$('#imgContainer').fadeOut(800);
	}	


	function openCustom() {
		 
		window.location.href = '/ShouldIorV1/Question/askShouldICustom';

	}

	
	</script>
	
	
	
	
	
	
	
	
	
	
	
	
  </body>
</html>
