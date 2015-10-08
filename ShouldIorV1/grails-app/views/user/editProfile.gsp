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
      <title>ShouldI.fm - Edit</title>
       <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
      
    
	 <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
  
    <!-- Bootstrap core CSS -->
      <link rel="stylesheet" type="text/css" href="<g:resource dir='css' file='bootstrap.css'/>">
      <link rel="stylesheet" type="text/css" href="<g:resource dir='css' file='buttons.css'/>">
      <link rel="stylesheet" type="text/css" href="<g:resource dir='css' file='awesome-bootstrap-checkbox.css'/>">
	   	<link  href="https://cdn.rawgit.com/fengyuanchen/cropper/v0.11.1/dist/cropper.min.css" rel="stylesheet">
	 <!-- Bootstrap core JS -->
	<script src="<g:resource dir="js" file="bootstrap.min.js" />"></script>
			
	 <!-- facebook login -->
	<g:javascript src="facebookLogin.js" />
	<g:javascript src="dataAccess.js" />
	<script src="https://cdn.rawgit.com/fengyuanchen/cropper/v0.11.1/dist/cropper.min.js"></script>

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
	
	      <input id = "checkUserLink" type="hidden" value="${createLink(controller: 'User', action: 'checkUserName')}">
		      <input id = "userID" type="hidden" value="${session.userID}">
	

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

		<!-- Question form -->	
		<div  class="jumbotron" style="overflow: none;  display: block; box-shadow:0 0 10px rgba(0, 0, 0, 0.15); min-height: 100px; margin: auto; min-width: 200px; margin-top: 60px;  max-width: 725px; padding-left: 0px; padding-right: 0px; padding-top: 0px; padding-bottom: 1px;  margin-bottom: 20px; background-color: #FDFDFD;  ">


		<div class="form-group" style = "padding-left: 16px;  display:block; padding-right: 16px; padding-top: 1px; ">		

		</div>

	 <g:form controller="User" action="updateProfile" enctype="multipart/form-data" >

			
			<div style = "display; block; width: 99%; margin: auto; padding: 10px; margin-top: -5px;">

			<h3 style = "margin-bottom: 10px; margin-top: 0px; width: 100%; text-align: center;  display; block; display:inline-block;">Edit Profile</h3>

			<p id = "saveWarnning"class="bg-danger" style = "display: none; font-size: 14px; padding: 4px; color: #3d3d3d; border: solid 1px; border-color: #db6565; "> <span style = "margin: 0px 3px 0px 3px;" class = "fa fa-exclamation-circle" ></span> Dont forget to save your changes by clicking the "<i>Save Changes</i>" button</p>

					<div id = "imgContainer" style = "margin-top: 0px; margin: auto; width: 100%;  margin-bottom: 9px; padding: 6px; position: relative; background-color: #EAEAEA; display: block;" >

					<div id = "imgContainer" style = "margin-top: 0px; text-align: center; margin: auto; width: 100%; max-width: 230px; margin-bottom: 9px; padding: 6px; position: relative; background-color: #EAEAEA; display: block;" >
					<img id="image1" src="${createLink(controller: 'User', action: 'getProfileImage', params: [id: session.userID])}" style ="display: block;  margin: auto; width: 100%; " alt="Image type not accepted" />
					</div>
				</div>

		<span class="btn btn-default btn-file fa fa-photo "  style = "margin-top: 2px; margin-bottom: 0px; display: inline-block;" >
			Change <input id = "imageUpload" name = 'image' type="file">
		</span>
		
		<button type="button" onClick = "resetFormElement()" style = "margin-top: 1px; display: inline-block;" class="btn btn-default fa fa-times"> Remove</button>				
			
			<hr>
			
			
		<div id = "errorAlert"class="alert alert-danger" role="alert" style = " display: none; margin-top: 0px;  padding: 6px;" >
		 <span id = 'errorMessage' ></span>
		</div>		
			
			
		<div class="form-group">
		<label for="exampleInputEmail1">Display Name</label>
			<input id = 'userNameTxt' type="text"  name = "name" class="form-control" id="exampleInputEmail1" value = "${user.name}" placeholder="Username">
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
		
					
		<textarea type="text" name = "aboutText" style = "resize: none; height: 170px; margin-top: 8px; " class="form-control" id="wysihtml5-textarea" placeholder="Change your about me...">
		${user.about}
		</textarea>



	<div style = "display: block; width: 100%; margin-top: 5px; margin-bottom: 5px; " >
		<g:actionSubmit value = "Update"  onclick="return validate()"  action = "updateProfile" style = "margin-top: 1px; width: 100px; display: inline-block;" class="btn btn-default"/>
	</div>
	
	
	
			</div>	
			
						</g:form>
		
	</div>
	


		</div>
		<!-- Question Form -->	
		
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
               <p>Please login. Choose a network below to login with</p>
               <button onClick = "loginFacebook('${createLink(controller: 'Authentication', action: 'loginFaceBook')}')" style = "" type="button" class="btn btn-default" data-dismiss="modal">Facebook <span class = "fa fa-facebook"></span></button>
               <button  onClick = "loginReddit('${createLink(controller: 'Authentication', action: 'loginReddit')}')"style = "" type="button" class="btn btn-default" data-dismiss="modal">Reddit <span class = "fa fa-reddit"></span></button>
            </div>
            <div class="modal-footer">
               <button style = "" type="button" class="btn btn-default" data-dismiss="modal">Close</button>
            </div>
         </div>
      </div>
   </div>
		
    </div><!-- /.container -->


    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
  
    
    <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.3.14/angular.min.js"></script>
    
	 <script src="<g:resource dir="js/tagsJS" file="bootstrap-tagsinput-angular.js" />"></script>
	 <script src="<g:resource dir="js/tagsJS" file="bootstrap-tagsinput.js" />"></script>
     <link rel="stylesheet" type="text/css" href="<g:resource dir='js/tagsJS' file='bootstrap-tagsinput.css'/>">

	
	<script>

	var bounds, boundx, boundy;
	var cropper;
	var allowChange = false;
	var $selector;
	
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

				$('#imgContainer > img').cropper({
				 guides: false,
				autoCrop: false,
		  aspectRatio: 1,
		  crop: function(e) {
		  var $cropper = $(e.target);
		  }
		});
		
	$selector = $("#imgContainer > img");
	$selector.cropper('disable');

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
	var name = $("#userNameTxt").val();

	
	$("#errorAlert").css("display", "none");
	errors = [];
	
		if (name == "" || name.length < 3) {
			hasErrors = true;
			errors.push("Please enter a valid username");
		} 
		
		if (name.length > 25) {
			hasErrors = true;
			errors.push("Username too long. 25 character max.");
		} 

		if (checkUserName($('#checkUserLink').val(), $('#userID').val())) {
			hasErrors = true;
			errors.push("Username taken. Try another.");
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
		
	function openCustom() {
		 
		window.location.href = '/ShouldIorV1/Question/askShouldICustom';

	}

	function readImg(input) {
	   	if (input.files && input.files[0]) {
		var reader = new FileReader();
			reader.onload = function (e) {
			$selector.cropper('enable');
			$selector.cropper('clear');
			$selector.cropper('replace', e.target.result);
			$selector.cropper('crop');
		}
}
reader.readAsDataURL(input.files[0]);
$('#saveWarnning').css("display","block");
}

$("#imageUpload").change(function(){	
	readImg(this);
});

	// Removes file from photo input 1
function resetFormElement() {
// http://stackoverflow.com/questions/2386064/how-do-i-crop-an-image-in-java 
var data = $selector.cropper('getData')
alert (data.x);
$selector.cropper('enable');
$selector.cropper('replace','blankAv.png');
$selector.cropper('disable');

var control = $('#imageUpload');
control.replaceWith(control = control.clone(true));
$('#saveWarnning').css("display","block");	
}	


	
	</script>
	
	
	
	
	
	
	
	
	
	
	
	
  </body>
</html>
