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
               <a href = "shouldI" ><img onClick = "h" src="${resource(dir:'images',file:'logo.png')}"   class="navbar-brand"/></a>
            </div>
            <div id="navbar" class="collapse navbar-collapse">
               <ul class="nav navbar-nav">
                  <g:if test="${session.name}">
                     <li><a href="#"><span class= 'fa fa-bell-o'></span><span style = "padding-left: 6px;" >0</span></a></a></li>
                     <li><a href="#"><span class= 'fa fa-pencil-square-o'></span><span style = "padding-left: 6px;" >Ask</span></a></a></li>
                     <li><a href="#"><span class= 'fa fa-line-chart'></span><span style = "padding-left: 6px;" >Trending</span></a></a></li>
                  </g:if>
                  <g:else>
                     <li><a href="#"  onClick = "showNoLogin()" ><span class= 'fa fa-pencil-square-o'></span><span style = "padding-left: 6px;" >Ask</span></a></a></li>
                     <li><a href="#"><span class= 'fa fa-line-chart'></span><span style = "padding-left: 6px;" >Trending</span></a></a></li>
                  </g:else>
               </ul>
               <g:if test="${session.name}">
                  <ul class="nav navbar-nav navbar-right" style = "padding: -10px;" >
                     <li class="dropdown" style = "">
                        <a href="#" style = "" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">
                        <img style = "display:inline-block; width: 25px; height: 25px; margin-right: 4px; margin-top: -25px;  margin-bottom: -25px;" src = "User/getProfileImage/${session.userID}" />			
                        ${session.name}
                        <span class="fa fa-caret-down"></span></a>
                        <ul class="dropdown-menu">
                           <li><a href="#"><span class= 'fa fa-home'><span style = "padding-left: 5px;" >Home</span></a></li>
                           <li><a href="#"><span class= 'fa fa-leaf'><span style = "padding-left: 5px;" >My Profile</span></a></li>
                           <li><a href="#"><span class= 'fa fa-question-circle'><span style = "padding-left: 5px;" >Search</span></a></li>
                           <li role="separator" class="divider"></li>
                           <li><a  onClick = "logoutFaceBook()" href="#"><span class= 'fa fa-sign-out'><span style = "padding-left: 5px;" >Log Out</span></a></li>
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
       
		<!-- COMMENT BOX -->	
    <div class="container">


		<!-- Question form -->	
		<div  class="jumbotron" style="overflow: none;  display: block; box-shadow:0 0 10px rgba(0, 0, 0, 0.15); min-height: 100px; margin: auto; min-width: 200px; margin-top: 60px;  max-width: 725px; padding-left: 0px; padding-right: 0px; padding-top: 0px; padding-bottom: 1px;  margin-bottom: 20px; background-color: #FDFDFD;  ">
			
		<div style = " margin-bottom:10px; padding-bottom: 10px; display:block; width: 100%; ">
		<div  class="custom" onClick = "openYesNo()" style=" border-top-left-radius: 8px; vertical-align: bottom;  text-align: bottom; border-top: 1px solid #E1E1E1;  margin-top: 0px;  width: 50%; float: left; margin-right:-1px; padding: 2px; vertical-align: bottom; display: inline-block;">
		<p style = "padding:0px; font-size: 19px; margin: auto; color: #5BC0DE; text-align: center;">Yes/No<span style = "color: #8D8D8D; font-size: 18px;"></span></p>
		</div> 
	
		<div onClick = "openCustom()" class="single" style=" border-top-right-radius: 8px; border-top: 1px solid #E1E1E1;  border-left: 1px solid #E1E1E1;  margin-top: 0px;  width: 50%;margin-right:-1px;   float: right; padding: 2px; vertical-align: bottom; display: inline-block;">
		<p style = "padding:0px; font-size: 19px; margin: auto; color: #5BC0DE; text-align: center;">Custom<span style = "color: #8D8D8D; font-size: 18px; "> </span></p>
		</div> 
		</div>	

	<div class="form-group" style = "padding-left: 16px;  display:block; padding-right: 16px; padding-top: 25px; ">		

		<div id = "errorAlert"class="alert alert-danger" role="alert" style = " display: none; padding: 6px; margin-bottom: 10px;" >
		 <span id = 'errorMessage' ></span>
		</div>
			      
	                                              
	<div id="wysihtml5-toolbar" style="display: none;  margin-top: 0px; ">

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

	 <g:form controller="Question" action="postShouldICutom" enctype="multipart/form-data" >
	<input type="text" id="title" name = "title" style = "width: 100%;  margin-top: 8px; " class="form-control" placeholder="Title">

	<textarea type="text" name = "question" style = "resize: none; height: 170px; margin-top: 8px; " class="form-control" id="wysihtml5-textarea" placeholder="Should I, or..."></textarea>

	
		<div style = "padding-left: 18px;  border-radius: 5px; padding-right: 18px; padding-top: 8px; margin-top: 10px;  padding-bottom: 1px; margin-bottom: 5px;   background-color: #F9F9F9; ">		


	<div  id = "option1Div" style = "display: block;">
		<div class="form-group" style = "margin-top: 12px; " >
		<label style = "color: #5BC0DE;" ><b>Option 1</b></label>
		<div id = "imgContainer1" style = "margin-top: 4px; margin-bottom: 9px; padding: 6px; background-color: #EAEAEA; display: none;" >
		<span onClick = "removePhoto('imgContainer1', 'imageUpload1')" style = 'text-align: right;  right: 0px; float: right; font-color: #606060; font-size: 20px; padding-right: 0px; padding-top:0px; display: inline-block;' class='fa fa-share-alt-square'></span>
		<img id="image1" src="#" style ="display: none; margin: auto; width: 50%" alt="Error displaying image (Image will still upload)" />
		</div>
		<input name = "answerOne" type="text" style = "width: 100%;" class="form-control" id="option1" placeholder="Ex. Yes, Black, Fast">
		<span class="btn btn-default btn-file" style =" margin-top: 10px; height: 25px; padding: 4px; font-size: 12px;">
			<span class = "fa fa-picture-o"></span> Add Image <input id = "imageUpload1" name = 'image1' type="file">
		</span>
		</div>
	</div>

	<div id = "option2Div" style = "display: block;">
		<div class="form-group" style = "margin-top: 12px; " >
		<label style = "color: #5BC0DE;" ><b>Option 2</b></label>
		<div id = "imgContainer2" style = "margin-top: 4px; margin-bottom: 9px; padding: 6px; background-color: #EAEAEA; display: none;" >
		<span onClick = "removePhoto('imgContainer2', 'imageUpload2')" style = 'text-align: right;  right: 0px; float: right;  font-color: #606060; font-size: 20px; padding-right: 0px; padding-top:0px; display: inline-block;' class='fa fa-share-alt-square'></span>
		<img id="image2" src="#" style ="display: none; margin: auto; width: 50%" alt="Error displaying image (Image will still upload)" />
		</div>
		<input  name = "answerTwo" type="text" style = "width: 100%;" class="form-control" style = "" id="option2" placeholder="Ex. No, White, Slow">
		<span class="btn btn-default btn-file" style =" margin-top: 10px; height: 25px; padding: 4px; font-size: 12px;">
			<span class = "fa fa-picture-o"></span> Add Image <input id = "imageUpload2" name = 'image2' type="file">
		</span>
	  </div>
    </div>

  
	<div id = "option3Div" style = "display: none;">
    	<div class="form-group" style = "margin-top: 12px; " >
    <label  style = "color: #5BC0DE;" ><b>Option 3</b> <span  onclick = "removeOption('option3Div')" class = 'fa fa-minus-square favsharButtion'></span></label>
	<div id = "imgContainer3" style = "margin-top: 4px; margin-bottom: 9px; padding: 6px; background-color: #EAEAEA; display: none;" >
	<span  onClick = "removePhoto('imgContainer3', 'imageUpload3')" style = 'text-align: right;  right: 0px; float: right;  font-color: #606060; font-size: 20px; padding-right: 0px; padding-top:0px; display: inline-block;' class='fa fa-share-alt-square'></span>
	<img id="image3" src="#" style ="display: none; margin: auto; width: 50%" alt="Error displaying image (Image will still upload)" />
	</div>
    <input  name = "answerThree" type="text" style = "width: 100%;" class="form-control" style = "" id="option3" placeholder="Ex. No, White, Slow">
		<span class="btn btn-default btn-file" style =" margin-top: 10px; height: 25px; padding: 4px; font-size: 12px;">
			<span class = "fa fa-picture-o"></span> Add Image <input id = "imageUpload3" name = 'image3' type="file">
		</span>
  </div>
  </div>
  
  
  	<div id = "option4Div"  style = "display: none;">
    	<div class="form-group" style = "margin-top: 12px; " >
    <label  style = "color: #5BC0DE;" ><b>Option 4</b> <span onclick = "removeOption('option4Div')" class = 'fa fa-minus-square favsharButtion'></span> </label>
	<div id = "imgContainer4" style = "margin-top: 4px; margin-bottom: 9px; padding: 6px; background-color: #EAEAEA; display: none;" >
	<span class = "favsharButtion" onClick = "removePhoto('imgContainer4', 'imageUpload4')" style = 'text-align: right;  right: 0px; float: right;  font-color: #606060; font-size: 20px; padding-right: 0px; padding-top:0px; display: inline-block;' class='fa fa-share-alt-square'></span>
	<img id="image4" src="#" style ="display: none; margin: auto; width: 50%" alt="Error displaying image (Image will still upload)" />
	</div>
    <input  name = "answerFour" type="text" style = "width: 100%;" class="form-control" style = "" id="option4" placeholder="Ex. No, White, Slow">
		<span class="btn btn-default btn-file" style =" margin-top: 10px; height: 25px; padding: 4px; font-size: 12px;">
			<span class = "fa fa-picture-o"></span> Add Image <input id = "imageUpload4" name = 'image4' type="file">
		</span>
  </div>
  </div>
  
  <div class = "favsharButtion">
  	<span   id = "addOptionButtion" onClick = "addOption()" style = "cursor: default; color: #5BC0DE; margin-bottom: 5px; display:block;"> <span class = 'fa fa-plus-square'> <b>New Option</b> </span> </span>
  </div>
  
  
	</div>
	
  	<select name = "category" class="form-control" style = "margin-top: 6px; margin-bottom: 6px; padding: 5px;   ">
	    <option value="one">No Category</option>
	    <option value="two">Two</option>
	    <option value="three">Three</option>
	    <option value="four">Four</option>
	    <option value="five">Five</option>
	</select>
	
		<div id = "errorAlertNoLogin"class="alert alert-info" role="alert" style = " display: none; margin-top: 7px; padding: 6px; margin-bottom: 7px; " >
		 <span id = 'errorMessage' >
		Disabling logins to vote will will make this question <b>private</b>.
		</span>
		</div>

		<div class="checkbox checkbox-danger"  style = "display: block; margin-top: 0px; margin-left: 2px;" >
		    <input type="checkbox"  name = "anonymous" id="anonymousCheckbox"/>
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
		
		
	<g:actionSubmit  onclick="return validate()"  value = "Post"  action = "postShouldICutom" style = "margin-top: 1px; width: 100px; display: inline-block;" class="btn btn-default"/>
	
	</g:form>

		</div>

		 </div>
		 
		 
		<!-- Question Form -->	

		
    </div><!-- /.container -->


    
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
	
	 editor = new wysihtml5.Editor("wysihtml5-textarea", { // id of textarea element
	  toolbar:      "wysihtml5-toolbar", // id of toolbar element
	  parserRules:  wysihtml5ParserRules // defined in parser rules set 
	});
	

		  $('.single').css('border-bottom', ' solid 2px #5BC0DE');

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
	
	
	$("#noLoginCheckbox").click(function() {
	  if (this.checked) {
		  $('#errorAlertNoLogin').slideUp(800);	  
	  } else {
		  $('#errorAlertNoLogin').slideDown(800);	  
	  }

	});
		
	
	// ********* IMAGE BUTTON 1 *********
	function readImg(input, imageID, containerID) {
		if (input.files && input.files[0]) {
			var reader = new FileReader();
			reader.onload = function (e) {
				$('#' + imageID ).attr('src', e.target.result);
				$('#' + imageID).css("display", "block");
				$('#' + containerID).css("display", "block");
			}

			reader.readAsDataURL(input.files[0]);
		}
	}

	$("#imageUpload1").change(function(){
		if (validImageTest(this)){
			readImg(this, 'image1', 'imgContainer1');
		}
	});


	$("#imageUpload2").change(function(){
		if (validImageTest(this)){
			readImg(this, 'image2', 'imgContainer2');
		}
	});
	
	$("#imageUpload3").change(function(){
		if (validImageTest(this)){
			readImg(this, 'image3', 'imgContainer3');
		}
	});
	
	
	$("#imageUpload4").change(function(){
		if (validImageTest(this)){
			readImg(this, 'image4', 'imgContainer4');
		}
	});
	
	
	function validImageTest(imgFile) {
		errors = [];
		 if (imgFile.files[0].size <= 2000000) {	
				return true;
		 } else {
			$("#imgError").css('display', 'none');
			errors.push("Images must be under 2mb.");
			
			$("#errorMessage").html("");
			for (i = 0; i < errors.length; i++) { 
				$("#errorMessage").append("*" + errors[i] + "<br/>");		
			}		
			
			$("#errorAlert").slideDown("800");
			return false;
		}
	}
	
	
	
	//************* Remove Photos ******************

	// Removes file from photo input 1
	function removePhoto(imgContainer, button) {
	var control = $('#' + button);
	control.replaceWith(control = control.clone(true));
	//$('#image1').fadeOut(1000);
	$('#' + imgContainer).fadeOut(800);
	}	
	
	//************* ADD OPTIONS******************
	function addOption() {
		if($('#option3Div').css('display') == 'none' || $('#option4Div').css('display') == 'none' ){ 
		  if($('#option3Div').css('display') == 'none') {
		  $('#option3Div').slideDown();
		  } else {
		  $('#option4Div').slideDown();
				//$('#addOptionButtion').css('color', "#3d3d3d")
		  }
		} else { 
			alert("Max number of options added.");
		}
	}
	
	function removeOption(id) {
		if (id == 'option4Div') {
			$('#' + id).slideUp(); // Option 3 slide up
			$('#option4').val("");
			removePhoto('imgContainer4', 'imageUpload4');
		} else {
			if($('#option4Div').css('display') == 'none') {
				$('#' + id).slideUp(); // Option 3 slide up
			// Reset elements
			$('#option3').val("");		
			$('#option4').val("");
			removePhoto('imgContainer3', 'imageUpload3');
			removePhoto('imgContainer4', 'imageUpload4');
			} else {
			$('#option4Div').slideUp(); // option 4 slide up
			// Reset elements
			$('#option3').val("");		
			$('#option4').val("");
			removePhoto('imgContainer3', 'imageUpload3');
			removePhoto('imgContainer4', 'imageUpload4');
			}
	}
	
	}
		
	function openYesNo() {
		 
		window.location.href = '/ShouldIorV1/Question/askShouldI';

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
		
		// Validate Answers
		if (($('#option1Div').css('display') != 'none' && $("#option1").val() == "") || $("#option1").val().length > 40) {
			hasErrors = true;
			errors.push("Answer 1: Please enter a valid answer.");
		} 
		
		if (($('#option2Div').css('display') != 'none' && $("#option2").val() == "") || $("#option2").val().length > 40) {
			hasErrors = true;
			errors.push("Answer 2: Please enter a valid answer.");
		} 
		
		if (($('#option3Div').css('display') != 'none' && $("#option3").val() == "") || $("#option3").val().length > 40) {
			hasErrors = true;
			errors.push("Answer 3: Please enter a valid answer.");
		} 
		
		if (($('#option4Div').css('display') != 'none' && $("#option4").val() == "") || $("#option4").val().length > 40) {
			hasErrors = true;
			errors.push("Answer 4: Please enter a valid answer.");
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

	
	</script>
	
	
	
	
	
	
	
	
	
	
	
	
  </body>
</html>
