<!DOCTYPE html>
<html lang="en">
   <head>
      <meta charset="utf-8">
      <meta http-equiv="X-UA-Compatible" content="IE=edge">
      <meta name="viewport" content="width=device-width, initial-scale=1">
      <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
      <meta name="description" content="">
      <meta name="author" content="">
      <link rel="icon" href="../../favicon.ico">
      <title>Starter Template for Bootstrap</title>
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
      <script src="
      <g:resource dir="js/typedJS" file="typed.min.js" />
      "></script>
       <g:javascript src="dataAccess.js" />  
      <script src="
      <g:resource dir="js/typeaheadJS" file="typeahead.jquery.min.js" />
      "></script>
      <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
      <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
      <![endif]-->
   </head>
    
   <input id = "category" type="hidden" value="${category}">
   
   <body style = "margin-bottom: 20px; min-width: 320px;  ">
   
     <input id = "facebookLoginLink" type="hidden" name="perdif" value="${createLink(controller: 'Authentication', action: 'loginFaceBook')}">
   
   <g:if test="${session.name}">
      <input id = "sessionCheck" type="hidden"  value="true">
   </g:if>
   <g:else>
      <input id = "sessionCheck" type="hidden"  value="false">
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
      
   
   <div class="container" style = "max-width: 825px; margin-top: 70px; ">

   <div style = "width: 100%; ">
   
	  <div  id = "trendingSelect" onClick = "loadQuestionURL('${createLink(controller: 'shouldI', action: 'category', params: [category: 'Trending'])}')" class = "flatMenuItem"   style= " margin-left: 5px; height: 26px; display:inline-block;">
	  	<span  class = "flatMenuItemText"  style = " font-size: 16px;" >Trending</span>
	  </div>
	  
	  <div  id = "recentSelect"  onClick = "loadQuestionURL('${createLink(controller: 'shouldI', action: 'category', params: [category: 'Recent'])}')" class = "flatMenuItem" style= " margin-left: 5px; height: 26px;  display:inline-block;" >
	  	<span   class = "flatMenuItemText"  style = " font-size: 16px;" >Recent</span>
	  </div>
	  
	 <div  class = "flatMenuItem" style= " margin-left: 5px; display:inline-block; border-bottom: 0px solid #79cce5;  " >
	  	
	  	     <div class=" dropdown">
                  <div class="dropdown-toggle" type="button" style = "width: 100%; height: 26px; background-color: rgb(0,0,0, 0);" data-toggle="dropdown">
	  
	  	  <div  id = "categorySelect" class = "flatMenuItem" style= " margin-left: 5px; height: 26px;  display:inline-block;" >
	  		<span   class = "flatMenuItemText"  style = " font-size: 16px;" >Categories <span class="caret"></span></span>
	  	</div>
	            
                  </div>
                  <ul class="dropdown-menu" style = "width: 100%; ">
                     <g:each in="${categories}">
                      <li><a href="${createLink(controller: 'shouldI', action: 'category', params: [category: it.category])}">${it.category}</a></li>
					</g:each>
                        
                  </ul>

         </div>
	  	
	  </div>
  
  <div style = "display: block;"> 
  	
  	
  	
  	
  	
  	
  </div>

      <div  class="contentContainer">
      	  	
    
    <div style = "width: 100%; padding: 8px; border-bottom: solid 1px; border-color:#b2b2b2;   text-align: center;">
     <span style = "color:#61B7FE; margin: auto; font-size: 18px;" ><b>${category}</b></span>
     
         <g:if test="${categorySort != 'None'}">
       	<div class=" dropdown">
                  <div class="dropdown-toggle" type="button" style = "width: 100%; height: 26px; background-color: rgb(0,0,0, 0);" data-toggle="dropdown">
	  	  <div  id = "categorySelect" class = "flatMenuItem" style= " margin-left: 5px; height: 26px;  display:inline-block;" >
	  		 <span   class = "flatMenuItemText"  style = " font-size: 14px;" >Sorted by ${categorySort} <span class="caret"></span></span>
	  	</div>     
              </div>
                  <ul class="dropdown-menu" style = "width: 100%; ">
                      <li><a href="${createLink(controller: 'shouldI', action: 'category', params: [categorySort: 'Trending', category: category])}">Trending</a></li>
                      <li><a href="${createLink(controller: 'shouldI', action: 'category', params: [categorySort: 'Recent', category: category])}">Recent</a></li>            
                  </ul>
         </div>
     </g:if>
     
     
      </div>   

      <div class = "scrollCon" style = "height: 450px; " > 
      
      	 <g:if test="${questions.isEmpty()}">
		     <p style =  "display: block; color: #d3d3d3; font-size: 15px;  margin: auto; margin-top: 10px; width: 100%; text-align: center;">Nothing to show here...</p>
		</g:if>
       
         <g:each in="${questions}">
            <table class = "longViewTable" onmouseover="glow(this)" onmouseout="unGlow(this)"  onClick = "loadQuestionURL('${createLink(controller: 'Question', action: 'shouldi', params: [id: it.questionID])}')" >
               <tr class = 'imgTR'>
                  <td class = 'imgTD'>
                     <g:if test="${it.answerOneImage}">
                        <img  class = "SmallViewImg" src = "${createLink(controller: 'Question', action: 'getAnswerImageById', params: [id: it.questionID, imgNum: '1', thumb: 'True'])}" />	
                     </g:if>
                     <g:else>
                        <img  class = "SmallViewImg"  src="${resource(dir:'images',file:'noImg.png')}"  />	
                     </g:else>
                  </td>
                  <td style = "width: 100%; height:1px; ">
                     <table style=" height: 100%; ">
                        <tr  style = "vertical-align: top;" >
                           <td style = "height: 100%;  ">
                              <span style = "display: block;  font-size: 16px;" >${it.userName}</span> 
                              <span style = "display:block; font-size: 16px;  color: #6A6A6A; word-wrap: break-word;" >${it.questionTitle}</span> 
                           </td>
                        </tr>
                        <tr  style = "vertical-align: bottom;" >
                           <td style = "text-align: top;  height: 100%; ">
                              <span class = "fa fa-line-chart" style = "color: #5BC0DE;  margin-right: 3px;" ></span>${it.totalVotes}
                              <span class = "fa fa-eye" style = "color: #5BC0DE; margin-right: 3px; margin-left: 10px;"  > </span>${it.totalViews} 
                           </td>
                        </tr>
                     </table>
                  </td>
                  <hr style = "padding: 0px; margin: 0px;"/>
               </tr>
            </table>
         </g:each>
                     </div>
                 
           <div style = "border-top: solid 1px #b2b2b2;  width: 100%;">  
      		<div class="btn-group" style = "margin: 10px 0px 10px 10px;    " >
                 <g:link  action="category"  params="[offset: offset, up: 'false', category: category, categorySort: categorySort]"  style = "padding-top: 2px; padding-bottom: 2px;" class="btn btn-default">
                   		  <span class="fa fa-angle-double-left"></span> Back 
                </g:link>

                 <g:link  action="category"  params="[offset: offset, up: 'true', category: category, categorySort: categorySort]" style = "padding-top: 2px; padding-bottom: 2px;" class="btn btn-default">
                   		   Next <span class="fa fa-angle-double-right"></span>
                </g:link>
            </div> 
              
        </div>      
            
      </div>
      
      		<footer class="footer" style = "margin-top: 10px;  width: 100%;" >
      <div class="container" style = "width: 100%; text-align: left; padding: 0px; ">
      <span style = "font-size: 15px; color: #79cce5;"><a style = "color: #79cce5;"  href = "${createLink(controller: 'ShouldI', action: 'privacyPolicy')}"  >Privacy Policy</a> | </span>
      <span style = "font-size: 15px; color: #79cce5;"><a style = "color: #79cce5;" href = "${createLink(controller: 'ShouldI', action: 'help')}"  >How To</a> | </span>
      <span style = "font-size: 15px; color: #79cce5;"><a style = "color: #79cce5;" href = "${createLink(controller: 'ShouldI', action: 'aboutPollaris')}">Pollaris LLC</a></span>   
      </div>   
  	  </footer>

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
   
      </div>
   <!-- LOGIN Modal -->
   <script>

   $( document ).ready(function() {
	   setItemSelected();
	});
	
      function showNoLogin() {
      	$('#noLogin').modal('show'); 
      }
      
      
      function glow(id) {
      $(id).css("background-color","#F7FBFF");
      }
         
      function unGlow(id) {
      $(id).css("background-color","");
      }
      
      function loadQuestionURL(url) {
      	window.location.href = url;
      }

      function setItemSelected() {
		var category = $("#category").val();
		console.log(category);
          if (category == "Trending") {
        	 $("#trendingSelect").css("border-bottom", "2px solid #36a4ff");
          } else if (category == "Recent") {
           	$("#recentSelect").css("border-bottom", "2px solid #36a4ff");
          } else {
           	$("#categorySelect").css("border-bottom", "2px solid #36a4ff");
        }
      }
      	 
      
   </script>
   </body>
</html>