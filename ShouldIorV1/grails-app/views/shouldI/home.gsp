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
      <script src="<g:resource dir="js/typedJS" file="typed.min.js" />"></script>
      <script src="
      <g:resource dir="js/typeaheadJS" file="typeahead.jquery.min.js" />
      "></script>
      
            <script src="<g:resource dir="js/chart" file="Chart.min.js" />"></script>
      
      
      <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
      <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
      <![endif]-->
   </head>
   <body style = "background-color: #F6F6F6!important; background-image:url('${resource(dir: "images", file: "wall1.jpg")}'); margin-bottom: 20px; background-size: cover;  background-attachment: fixed; min-width: 320px;  ">
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
      
   
   <div class="container" style = "max-width: 825px; margin-top: 70px;">

					
            	<div style = "text-align: center; width: 100%; margin-top: 10px;  margin-bottom: 20px; " >
					<img style = "width:50%; vertical-align: top;  display:  block;  margin: auto;  padding:0px; min-width: 285px; " src="${resource(dir:'images',file:'logoDark.png')}"   />				
				</div>
   
   
   <div class = 'favsharButtion' style = " font-size: 25px;  display: block; width: 100%; text-align: left; margin-top: -5px; margin-bottom: -5px;">
     
  	 <g:if test="${session.name}">
      <a  style = "color: #79cce5;  margin:0px; padding: 0px;" href = "${createLink(controller: 'Question', action: 'askShouldI')}"  > <span class= 'fa fa-pencil-square-o'> 
     </g:if>
     <g:else>
      <a  style = "color: #79cce5;  margin:0px; padding: 0px;" href = '#' onClick = "showNoLogin()"> <span class= 'fa fa-pencil-square-o'> 
     </g:else>
     
      <span class = "element"  ></span>
      </span> 
      </a> 
   </div>
   
      
   <div style = "width: 100%; ">
      <div  class="contentContainer">
         <div class="contentContainerTitle">
            <p class = "fa fa-paper-plane-o" ><span> Whats New</span> </p>
         </div>
         
         <div style = "padding: 15px;">
         
            <h3 style = "text-align: left; color: #6A6A6A; margin:0px;">
             ${messageTitle} 
            </h3>
            
            <p style = "font-size: 15px; width: 100%; margin-top: 10px; text-align: left;">
               ${raw(messageText)}	
            </p>
            
            
            <div>
            </div>
         </div>
      </div>
   
   <div style = "width: 100%; ">
      <div  class="contentContainer">
         <div class="contentContainerTitle">
            <p  style = "color: #E73116;" class = "fa  fa-fire" > <span>Trending</span> </p>
         </div>
                     <div class = "scrollCon" style = "height: 310px; " >  
         <g:each in="${trendingQuestions}">
            <table class = "longViewTable" onmouseover="glow(this)" onmouseout="unGlow(this)"  onClick = "loadQuestionURL('${createLink(controller: 'Question', action: 'shouldi', params: [id: it.questionID])}')" >
               <tr class = 'imgTR'>
                  <td class = 'imgTD'>
                     <g:if test="${it.answerOneImage}">
                        <img  class = "SmallViewImg" src = "${createLink(controller: 'Question', action: 'getAnswerImageById', params: [id: it.questionID, imgNum: '1'])}" />	
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
            </div>
      
   </div>

      
      <div style = "width: 100%; ">
         <div  class="contentContainer">
            <div class="contentContainerTitle">
               <p class = "fa  fa-random" > <span>Randomly Awesome</span> </p>
            </div>
            <div class = "scrollCon">
               <g:each in="${randomQuestions}">
                  <div style = "overflow: hidden; text-align: center; " onmouseover="glow(this)" onmouseout="unGlow(this)"  onClick = "loadQuestionURL('${createLink(controller: 'Question', action: 'shouldi', params: [id: it.questionID])}')"  class="col-xs-6 col-md-4">
                     <div  class="row" style = "cursor: default; ">
                        <g:if test="${it.answerOneImage}">
                           <img class = "bigViewImg"  src = "${createLink(controller: 'Question', action: 'getAnswerImageById', params: [id: it.questionID, imgNum: '1'])}" />	
                        </g:if>
                        <g:else>
                           <img  class = "bigViewImg" src="${resource(dir:'images',file:'noImg.png')}"  />	
                        </g:else>
                        <div class = "questionTitle" >${it.questionTitle}</div>
                     </div>
                  </div>
               </g:each>
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
   
   				 <div  class="contentContainer" style = "text-align: center; width: 100%; padding : 10px; background-color: rgba(0,0,0, 0.5);" >
	            	  <div style = "width: 35%;  display: block; min-width: 250px;  margin:10px; padding :0px;  vertical-align: top;  display:inline-block;  ">			
						<canvas id="chart-area" style = "width: 50%; display: block; margin:0px; padding :0px;  " />
					</div>
					
					<p style = " display: block; margin-top: 8px;color:#f3f3f3;  font-size: 19px;">
						<span  style = "color:#46BFBD;"  class = "fa fa-line-chart"></span> 
						<span style = "color:#79cce5; font-size: 21px;" ><b>Yes</b></span> <b>vs.</b> 
						<span style = "color:#F7464A; font-size: 21px; " ><b>No</b></span> this month
					</p>

			
			            </div>
   
   
      				 <div  class="contentContainer" style = "text-align: center; width: 100%; padding : 10px; background-color: rgba(0,0,0, 0.5);" >

						<span style = "color:#79cce5; font-size: 15px;" ><b>Background image submitted by <a>Community</a></b></span>
			
			            </div>

        <footer class="footer" style = "margin-top: 10px; width: 100%;" >
      <div class="container" style = "width: 100%; text-align: left; padding: 0px; ">
      <span style = "font-size: 15px; color: #79cce5;"><a style = "color: #79cce5;" href = "">Privacy Policy</a> | </span>
            <span style = "font-size: 15px; color: #79cce5;"><a style = "color: #79cce5;" href = "">How To</a> | </span>
      <span style = "font-size: 15px; color: #79cce5;"><a style = "color: #79cce5;" href = "">About</a></span>   
      </div>   
  	  </footer>
      
   
      </div>
      
            <input id = "yesCount" type="hidden" name="country" value="${yesCount}">
            <input id = "noCount" type="hidden" name="country" value="${noCount}">
      
</div>
      
	<script>
   
	   $( document ).ready(function() {
		  preparePieChart($("#yesCount").val(), $("#noCount").val());
		});
	  
      function glow(id) {
    	  $(id).css("background-color","#F7FBFF");
      }
         
      function unGlow(id) {
     	 $(id).css("background-color","");
      }
      
      function loadQuestionURL(url) {
      	window.location.href = url;
      }
      	 
       $(function(){
             $(".element").typed({
                 strings: ["^1000 Start a Poll"],
                 typeSpeed: 90,
      		cursorChar: "|",			  
      		backDelay: 500,
      		callback: function(){
      			// $(".typed-cursor").css("display","none");
      			}
             });
         });


       function preparePieChart(value1, value2) {
     		var pieData = [
     	   					{
     	   						value: value1,
     	   						color: "#46BFBD",
     	   						highlight: "#5AD3D1",
     	   						label: "Yes"
     	   					},
     	   					{
     	   						value: value2,
     	   						color:"#F7464A",
     	   						highlight: "#FF5A5E",
     	   						label: "No"
     	   					}
     	   				];
     			
		var ctx = document.getElementById("chart-area").getContext("2d");
		window.myPie = new Chart(ctx).Pie(pieData,  {
		responsive : true
		});
      }

   </script>
   </body>
</html>