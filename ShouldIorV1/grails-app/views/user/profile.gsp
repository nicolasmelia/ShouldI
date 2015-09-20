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
      <link rel="stylesheet" type="text/css" href="<g:resource dir='css' file='customBoot.css'/>">
      <link rel="stylesheet" type="text/css" href="<g:resource dir='css' file='buttons.css'/>">
      <link rel='stylesheet' href='https://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css'>
      <link rel="stylesheet" type="text/css" href="<g:resource dir='css' file='awesome-bootstrap-checkbox.css'/>">
      <!-- Facebook -->			
      <g:javascript src="facebookLogin.js" />
      <!-- JQUERY -->
      <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
      <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
      <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
      <![endif]-->
   </head>
   <body >
      <nav class="navbar navbar-inverse navbar-fixed-top">
         <div class="container">
            <div class="navbar-header">
               <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
               <span class="sr-only">Toggle navigation</span>
               <span class="icon-bar"></span>
               <span class="icon-bar"></span>
               <span class="icon-bar"></span>
               </button>
               <a href = "${createLink(controller:'ShouldI', action: 'home')}" ><img onClick = "h" src="${resource(dir:'images',file:'logo.png')}"   class="navbar-brand"/></a>
            </div>
            <div id="navbar" class="collapse navbar-collapse">
               <ul class="nav navbar-nav">
                  <g:if test="${session.name}">
                     <li><a href="#"><span class= 'fa fa-bell-o'></span><span style = "padding-left: 6px;" >0</span></a></a></li>
                     <li><a href="${createLink(controller:'Question', action: 'askShouldI')}"><span class= 'fa fa-pencil-square-o'></span><span style = "padding-left: 6px;" >Ask</span></a></a></li>
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
                        <img style = "display:inline-block; width: 25px; height: 25px; margin-right: 4px; margin-top: -25px;  margin-bottom: -25px;" src = "/ShouldIorV1/User/getProfileImage/${userID}" />			
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
      <div class="container" style = "max-width: 825px; margin-top: 70px; margin-bottom: 20px; " >
         <!-- QUESTION BLOCK -->	
         <div  class="contentContainer">
            <!-- PROFILE INFORMATION -->	
            <div  class="contentContainer" style = "padding: 10px 10px 0px 10px; box-shadow:0 0 0px rgba(0, 0, 0, 0.0); " >
               <span style = "margin: auto; width: 100%; text-align: center; color: #5C5C5C; display: block; font-size: 18px; margin-bottom: 0px; margin-top: 2px;"><b>${user.name}</b>
               </span>
               <hr style = "padding:0px; margin-top: 8px; margin-bottom: 14px; ">
               <div style = "display: inline-block; width: 80px; height: 80px; background-image: url('${createLink(controller: 'User', action: 'getProfileImage', params: [id: user.userID])}'); background-size: cover; background-repeat: no-repeat;   background-position: center center; padding-left: 5px;"> </div>
               <div style = "display: inline-block; padding-bottom:0px; margin-right: 4px; margin-left: 4px; vertical-align: top;  ">
                  <span style = "margin-left: 1px; color: #5C5C5C; margin-top: -2px;  display: block; font-size: 15px;">Questions: ${opQuestionCount}</span>
                  <span style = "margin-left: 1px; color: #5C5C5C; margin-top: -2px; display: block; font-size: 15px;">Reached: ${user.peopleReached} </span>
               </div>
                              	             
               	<p style =  "display: block; color: #757575; font-size: 15px;  margin: auto; margin-top: 7px; width: 100%; text-align: center;">
               	    <g:if test="${user.about != ''}">
               		    ${raw(user.about)}		           
               	    </g:if>
               	    <g:else>
               		    Apparently, this user prefers to keep an air of mystery about them.       
               	   	</g:else>
				 </p>
               
            </div>
            <!-- PROFILE INFORMATION -->	
            <div style = "width: 100%; margin: auto; text-align: center; padding-top: 0px; display:block; margin-bottom: -6px;  ">
               <div class="dropdown"  style = " width: 100%; margin: auto; display:inline-block; border-radius: 6px 6px 0px 0px;  ">
                  <button class="btn btn-default dropdown-toggle" type="button" style = " width: 100%; border-radius: 0px 0px 0px 0px; border: 0px; border-bottom: solid 1px; border-top: solid 1px;   border-color: #e3e3e3; " data-toggle="dropdown">
                  ${category} 
                  <span class="caret"></span></button>
                  <ul class="dropdown-menu" style = "width: 100%; ">
	                  <li><a href = "${createLink(controller: 'User', action: 'myProfile', params: [category: 'New Questions'])}"><span style = "padding-left: 5px;" >New Questions</span></a></li>                           
	                  <li><a href = "${createLink(controller: 'User', action: 'myProfile', params: [category: 'Top Questions'])}"><span style = "padding-left: 5px;" >Top Questions</span></a></li>                           
	               </ul>
               </div>
            </div>
            <!-- QUESTION REPLY -->
            <div  class="contentContainer" style = "box-shadow:0 0 0px rgba(0, 0, 0, 0.0);" >
               
             
              <div class = "scrollCon" style = "height: 310px; " >
       
	    <g:if test="${question.isEmpty()}">
		     <p style =  "display: block; color: #d3d3d3; font-size: 15px;  margin: auto; margin-top: 7px; width: 100%; text-align: center;">Nothing to show here...</p>
		</g:if>
               
               <g:each in="${question}">
               
               
                  <table onmouseover="glow(this)" onmouseout="unGlow(this)"  onClick = "loadQuestionURL('${it.questionID}')" style="cursor: default; width: 100%; padding: 8px 4px 8px 4px; display:block;">
                     <tr style = "display:block; max-height: 105px; width: 100%; margin-top: 0px; ">
                        <td style = "min-width: 125px;  height: 100%; text-align:center; vertical-align:top; ">
                           <g:if test="${it.answerOneImage}">
                              <img  style = "max-width:110px; max-height:100px; width: auto; height: auto; margin: auto;   padding: 0px;"    src = "${createLink(controller: 'Question', action: 'getAnswerImageById', params: [id: it.questionID, imgNum: '1'])}"/>	
                           </g:if>
                           <g:else>
                              <img  style = "max-width:110px; max-height:100px; width: auto; height: auto; margin: auto;   padding: 0px;  " src="${resource(dir:'images',file:'noImg.png')}"  />	
                           </g:else>
                        </td>
                        <td style = "width: 100%; height:1px; ">
                           <table style="width:100%;  height: 100%; ">
                              <tr  style = "vertical-align: top;" >
                                 <td style = "height: 100%; ">
                                    <span style = "display: block;  font-size: 16px;" >${it.userName}<span> 
                                    <span style = "display:block; font-size: 16px;  color: #6A6A6A; " >${it.questionTitle}</span> 
                                 </td>
                              </tr>
                              <tr  style = "vertical-align: bottom;" >
                                 <td style = "text-align: top;  height: 100%; ">
                                    <span class = "fa fa-line-chart"  style = "color: #5BC0DE; margin-right: 5px;" ></span>${it.totalVotes}
                                    <span class = "fa fa-comments" style = "color: #5BC0DE;   margin-left: 8px; margin-right: 5px; "  > </span>10k  
                                 </td>
                              </tr>
                           </table>
                        </td>
                     </tr>
                  </table>
                  <hr style = "padding: 0px; margin: 0px;"/>
               </g:each>
            </div>
            
            
			<div class="btn-group" style = "margin: 10px; " >
                 <g:link  action="profile"  params="[offset: offset, up: 'false', category: category, id: user.userID ]"  style = "padding-top: 2px; padding-bottom: 2px;" class="btn btn-default">
                   		  <span class="fa fa-angle-double-left"></span> Back 
                </g:link>

                 <g:link  action="profile"  params="[offset: offset, up: 'true', category: category, id : user.userID]" style = "padding-top: 2px; padding-bottom: 2px;" class="btn btn-default">
                   		   Next <span class="fa fa-angle-double-right"></span>
                </g:link>
            </div>    
            
            
            <!-- QUESTION REPLY -->
         </div>
      </div>
      <footer class="footer" style= " width: 90%;">
         <div class="container">
         </div>
      </footer>
      <!-- Bootstrap core JavaScript
         ================================================== -->
      <!-- Placed at the end of the document so the pages load faster -->
      <g:javascript src="dataAccess.js" />
      <script src="<g:resource dir="js" file="bootstrap.min.js" />"></script>
      <g:javascript src="buttonAnswerGlow.js" />
      <script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
      <script>
         function glow(id) {
             $(id).css("background-color","#F7FBFF");
             }
                
             function unGlow(id) {
             $(id).css("background-color","");
             }
             
             function loadQuestionURL(url) {
             	window.location.href = "/ShouldIorV1/Question/shouldi/" + url;
             }
      </script>
   </body>
</html>