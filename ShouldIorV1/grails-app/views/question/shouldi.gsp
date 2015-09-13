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
   <body style = " margin-bottom: 20px;  ">
      <div id="fb-root"></div>
      <script>(function(d, s, id) {
         var js, fjs = d.getElementsByTagName(s)[0];
         if (d.getElementById(id)) return;
         js = d.createElement(s); js.id = id;
         js.src = "//connect.facebook.net/en_US/sdk.js#xfbml=1&version=v2.4&appId=1625511597708023";
         fjs.parentNode.insertBefore(js, fjs);
         }(document, 'script', 'facebook-jssdk'));
      </script>
      <g:if test="${session.name}">
         <input id = "sessionCheck" type="hidden" name="sess" value="true">
      </g:if>
      <g:else>
         <input id = "sessionCheck" type="hidden" name="sess" value="false">
      </g:else>
      <input id = "percentDiffHidden" type="hidden" name="perdif" value="${percentDiff}">
      <input id = "vote" type="hidden" name="voted" value="${vote}"> 

   
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
                     <li><a href="#"><span class= 'fa fa-bell-o'></span><span style = "padding-left: 6px;" >0</span></a></a></li>
                     <li><a href = "${createLink(controller: 'Question', action: 'askShouldI')}" ><span class= 'fa fa-pencil-square-o'></span><span style = "padding-left: 6px;" >Ask</span></a></li>
                      <li><a href = "${createLink(controller: 'ShouldI', action: 'category', params: [cat: 'trending'])}" ><span class= 'fa fa-line-chart'></span><span style = "padding-left: 6px;" >Trending</span></a></li>
                  </g:if>
                  <g:else>
                     <li><a href="#"  onClick = "showNoLogin()" ><span class= 'fa fa-pencil-square-o'></span><span style = "padding-left: 6px;" >Ask</span></a></li>
                     <li><a href="#"><span class= 'fa fa-line-chart'></span><span style = "padding-left: 6px;" >Trending</span></a></li>
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
                           <li><a href = "${createLink(controller: 'User', action: 'myProfile')}"><span class= 'fa fa-leaf'></span><span style = "padding-left: 5px;" >My Profile</span></a></li>                           
                           <li><a href = "${createLink(controller: 'ShouldI', action: 'category', params: [cat: 'trending'])}" ><span class= 'fa fa-globe'></span><span style = "padding-left: 5px;" >Categories</span></a></li>
                           <li><a href = "${createLink(controller: 'Question', action: 'askShouldI')}" ><span class= 'fa fa-pencil-square-o'></span><span style = "padding-left: 6px;" >Ask</span></a></li>
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
      
      <div class="container" style = "padding-top: 65px; max-width: 825px;">
      
      <div  class="contentContainer">
      

            <!-- QUESTION -->	
            <g:each in="${question}">
              <input id = "totalVotes" type="hidden" value="${it.totalVotes}">
                    <input id = "answerOneVotes" type="hidden"  value="${it.answerOneVotes}">
				      <input id = "answerTwoVotes" type="hidden"  value="${it.answerTwoVotes}">
				      <input id = "answerThreeVotes" type="hidden"  value="${it.answerThreeVotes}">
				      <input id = "answerFourVotes" type="hidden" value="${it.answerFourVotes}">
				            
               <input id = "questionID" type="hidden" name="country" value="${it.questionID}">	
               <div style ="display: block; width: 100%; padding-bottom: -5px; " >
                  <!-- MAIN -->	
                  <div  style="display: block;  padding: 10px;  border-bottom: solid 1px; border-color: #f3f3f3;  margin: auto;  ">
                     <!-- PROFILE INFORMATION -->	
                     <div style = "display: inline-block; width: 68px; padding-left: 5px;">
                        <img  style = "width: 100%;   display: inline-block; border-top-right-radius: 6px; border-top-left-radius: 5px;"  src = "${createLink(controller: 'User', action: 'getProfileImage', params: [id: it.userID])}"   />			
                     </div>
                     <div style = "display: inline-block; padding-bottom:0px; margin-right: 4px; margin-left: 4px; vertical-align: top;  ">
                        <span style = "margin-left: 1px; color: #5C5C5C; display: block; font-size: 15px;"><b>Nicolas Melia</b></span>
                        <span style = "margin-left: 1px; color: #5C5C5C; margin-top: -2px;  display: block; font-size: 15px;">Followers: 234 <span style = 'text-align: left; color: #545252;  padding-left: 2px; display: inline-block;' class='fa fa-plus'></span></span>
                        <span style = "margin-left: 1px; color: #5C5C5C; margin-top: -2px; display: block; font-size: 15px;">Reached: 34k People</span>
                     </div>
                  </div>
                  <!-- PROFILE INFORMATION -->	
                  
                    <g:if test="${thisUserPost == true}">
                        <div class="alert alert-info" role="alert" style = "margin: 10px 10px 0px 10px; text-align: left; background-color: rgba(41,153,255,0.05);">
						 This is your question. <a style = "cursor: default;" onclick = "share()"><b>Share</b></a> or copy this pages <a onClick = "displayPageLink()" style = "cursor: default;"><b>link</b></a></br>
						 <span id = "pageLink" style = "display: none; color: #8D8D8D; word-break: break-all;"><u>www.ShouldI.fm/Question/${it.questionID}</u></span>
						</div>
					</g:if>
						
                  <div style = " display: block; height: 50px; ">
                     <span style = 'text-align: left; font-size: 18px; color: #4A4A4A; padding-left: 12px; padding-top:6px; display: inline-block;'>
                  
                      <span  id = "" style = "color: #8D8D8D; font-size: 14px; ">Votes: ${it.totalVotes}</span>             

                     
                     </span>
                     <div style = "padding-bottom: -10px; float:right; display: inline-block; vertical-align: top;">
                        <div  class = 'favsharButtion' onClick = "share()" style = " cursor: default; text-align: center; width: 65px; padding: 2px; padding-left: 2px; color: #4DAEFF; font-size: 13px; margin-right: 7px; margin-top:9px; ">
                           <div style = "margin: auto; padding: 0px; margin: 0px;"><span style = ' ' class='fa fa-facebook'></span> Share</div>
                        </div>
                     </div>
                     <div class = 'favsharButtion' style = "padding-bottom: -10px; float:right; display: inline-block; vertical-align: top;">
                        <div  onClick = "test()" style = "cursor: default; text-align: center; width: 70px; padding: 2px; padding-left: 0px; color: #4DAEFF; font-size: 13px; margin-right: 0px; margin-top:9px; ">
                           <div style = "margin: auto; padding: 0px; margin: 0px;"><span style = ' ' class='fa fa-star'></span> Favorite</div>
                        </div>
                     </div>
                  </div>
                  <span id = "titleText" style = 'text-align: center; margin: center; margin-top: 0px; padding: 0px 8px 0 8px; color: #545252; font-size: 20px; display: block;' >${it.questionTitle}</span>
                  <hr style = "margin-top: 8px; width: 85%; margin-bottom: 0px; padding-top: 0px;">
               
                  <g:if test="${it.custom.toString().equals('false')}">
                  		<g:if test="${it.answerOneImage}">
	                  <div id = "ee" style = "margin-bottom: 30px; padding: 15px;  margin: auto; margin-top: 20px;  width: 50%; min-width: 290px; max-width: 330px; mag-height: 100px; background-color: #F4FAFF; display: block;" >
	                     <img id="singleImg" src = "${createLink(controller: 'Question', action: 'getAnswerImageById', params: [id: it.questionID, imgNum: '1'])}"   style ="display: block;  width: 95%;  height: 80%; margin: auto;" alt="UhOh! We cant seem to load the image." />
	                  </div>
                	  </g:if>
                  </g:if>
                  
                  
                  <div style = "padding: 15px; width: 98%; max-height: 300px; margin:auto; padding-top: 18px;   display: block;">
                   <div style = "margin: 0px; padding: 0px; width: 100%;" id = "questiontText">
                     ${raw(it.question)}		           
                    </div>
                     
                  </div>
                  
                  

                  
                  <div  id = "voteWarn" style = "width: 100%; text-align: center; color: #61B7FE; display:none;  ">  
                     <span class = "fa fa-check"></span> You have already voted on this question.
                  </div>


						<div style = "width: 100%; text-align: left; padding-left: 15px;  " >
						
						                  
              
                      <span id = "diffPercent"style = "color: #61B7FE; font-size: 14px;"></span>
                      <span id = "topAnswer" style = "color: #8D8D8D; font-size: 14px;">${topAnswer}</span>       
                     

						 </div>

                 <table style="width: 100%; overflow:none; margin-top: 5px; padding:0px; border-top: 1px solid #E1E1E1;">

				<g:if test="${it.custom.toString().equals('true')}">
				  <tr style = "height: 100%; width: 50%; margin-top: 5px; ">		  
				  <td id = "img1"  onClick = "questionVote('1')" style = "height: 100%; width: 50%; text-align: center; border-right: solid 1px #F0F0E1;  " >
						<g:if test="${it.answerOneImage}">
							<img  src = "${createLink(controller: 'Question', action: 'getAnswerImageById', params: [id: it.questionID, imgNum: '1'])}"  style = "width: 55%; padding: 10px 4px 10px 4px; min-width: 150px; "/>
						</g:if>
						<g:elseif test="${hasQuestionImage.toString().equals('true')}">
							<img  src="${resource(dir:'images',file:'noImg.png')}" style = "width: 55%; padding: 10px 4px 10px 4px; min-width: 150px; "/>
						</g:elseif>	
					</td>
					
				  <td id = "img2" onClick = "questionVote('2')" style = "height: 100%; width: 50%; text-align: center;" >
						<g:if test="${it.answerTwoImage}">
							<img  src = "${createLink(controller: 'Question', action: 'getAnswerImageById', params: [id: it.questionID, imgNum: '2'])}"  style = "width: 55%; padding: 10px 4px 10px 4px; min-width: 150px; "/>
						</g:if>
						<g:elseif test="${hasQuestionImage.toString().equals('true')}">						
							<img  src="${resource(dir:'images',file:'noImg.png')}" style = "width: 55%; padding: 10px 4px 10px 4px; min-width: 150px; "/>
						</g:elseif>	
					</td>
				  </tr>
				  </g:if>			  
				<g:if test="${it.custom.toString().equals('false')}">
                     <tr style = "width: 100%; ">
                        <td  id = "ans1"  onClick = "questionVote('1')"  class="answerContainer"  style = "border-right: solid 1px #E1E1E1;"   >
                           <div style = " width: 100%; display:block; margin: auto; bottom: 0px; text-align: center; font-size: 19px;  color: #61B7FE; ">
                         <div id = "per1" style = "top: 0px; left: 0px;  display: none; height: 100%; position: absolute;  background-color: rgba(41,153,255,0.15); "></div>  
							<span id = "option1Check" style = "display: none;" class = "fa fa-check">        
                              </span> Yes <span id = "Answer1Count" style = "color: #8D8D8D;">
                              (${it.answerOneVotes})
                              </span>       
                           </div>
                        </td>
                        <td id = "ans2"  onClick = "questionVote('2')"  class="answerContainer " >
                           <div style = " width: 100%; display:block; margin: auto; bottom: 0px; text-align: center; font-size: 19px;  color: #61B7FE; ">
                         <div id = "per2" style = "top: 0px; left: 0px;  display: none; height: 100%; position: absolute;  background-color: rgba(41,153,255,0.15); "></div>                                  
                            <span id = "option2Check"  style = "display: none;" class = "fa fa-check">
                              </span> No <span id = "Answer2Count"  style = "color: #8D8D8D;">
                              (${it.answerTwoVotes})
                              </span>
                           </div>
                        </td>
                     </tr>
                 </g:if>
                 <g:else>
                     <tr style = "width: 100%; ">                                                                            
                     
                        <td  id = "ans1"  onClick = "questionVote('1')"   class="answerContainer" style = "border-right: solid 1px #E1E1E1;"   >                         
                           <div style = " width: 100%; display:block; margin: auto; bottom: 0px; text-align: center; font-size: 19px;  color: #61B7FE; ">
                            <div id = "per1" style = "top: 0px; left: 0px;  display: none; height: 100%; position: absolute;  background-color: rgba(41,153,255,0.15); "></div>   
                              <span id = "option1Check" style = "display: none;" class = "fa fa-check"> 
                              </span> ${it.answerOne} <span id = "Answer1Count" style = "color: #8D8D8D;">           
	                              	(${it.answerOneVotes})
                              </span>           
                           </div>
                           
                        </td>
                        <td  id = "ans2" onClick = "questionVote('2')"  class="answerContainer"  >
                           <div style = " width: 100%; display:block; margin: auto; bottom: 0px; text-align: center; font-size: 19px;  color: #61B7FE; ">
                         <div id = "per2" style = "top: 0px; left: 0px;  display: none; height: 100%; position: absolute;  background-color: rgba(41,153,255,0.15); "></div>  
                            <span id = "option2Check"  style = "display: none;" class = "fa fa-check">
                              </span> ${it.answerTwo} <span id = "Answer2Count"  style = "color: #8D8D8D;">
                              			(${it.answerTwoVotes})
                              </span>
                           </div>
                        </td>
                     </tr>
                 </g:else>         
                  </table>
                              
                  
                     <table style="width: 100%; overflow:none; margin-top: 0px; padding:0px; border-top: 1px solid #E1E1E1;">
				  <tr style = "height: 100%; width: 50%; margin-top: 5px; ">		  
				  
				 <g:if test="${it.answerThree}">
				  <td id = "img3" onClick = "questionVote('3')" style = "height: 100%; width: 50%; text-align: center;  " >
						<g:if test="${it.answerThreeImage}">
							<img  src = "${createLink(controller: 'Question', action: 'getAnswerImageById', params: [id: it.questionID, imgNum: '3'])}"  style = "width: 55%; max-width: 250px; padding: 10px 4px 10px 4px; min-width: 150px; "/>
						</g:if>
						<g:elseif test="${hasQuestionImage.toString().equals('true')}">
							<img  src="${resource(dir:'images',file:'noImg.png')}" style = "width: 55%; padding: 10px 4px 10px 4px; min-width: 150px; "/>
						</g:elseif>	
					</td>
					</g:if>
					
				 <g:if test="${it.answerFour}">
				  <td id = "img4" onClick = "questionVote('4')" style = "height: 100%; width: 50%; text-align: center; border-left: solid 1px #F0F0E1; " >
						<g:if test="${it.answerFourImage}">
							<img  src = "${createLink(controller: 'Question', action: 'getAnswerImageById', params: [id: it.questionID, imgNum: '4'])}"  style = "width: 55%; padding: 10px 4px 10px 4px; min-width: 150px; "/>
						</g:if> 
						<g:elseif test="${hasQuestionImage.toString().equals('true')}">
							<img  src="${resource(dir:'images',file:'noImg.png')}" style = "width: 55%; padding: 10px 4px 10px 4px; min-width: 150px; "/>
						</g:elseif>			
					</td>
				</g:if>
				
				  </tr>
			
                     <tr style = "width: 100%; ">
                     	<g:if test="${it.answerThree}">
                        <td  id = "ans3" onClick = "questionVote('3')" class="answerContainer"  style = "border-right: solid 1px #E1E1E1;"  >
  							<div style = " width: 100%; display:block; margin: auto; bottom: 0px; text-align: center; font-size: 19px;  color: #61B7FE; ">
                         <div id = "per3" style = "top: 0px; left: 0px;  display: none; height: 100%; position: absolute;  background-color: rgba(41,153,255,0.15); "></div>                             
                            <span id = "option3Check" style = "display: none;" class = "fa fa-check"> 
                              </span> ${it.answerThree} <span id = "Answer3Count" style = "color: #8D8D8D;">
                           		   (${it.answerThreeVotes})
                              </span>
                           </div>
                        </td>
                        </g:if>
                        
                        <g:if test="${it.answerFour}">         
                        <td id = "ans4" onClick = "questionVote('4')"   class="answerContainer"  " >
                           <div style = " width: 100%; display:block; margin: auto; bottom: 0px; text-align: center; font-size: 19px;  color: #61B7FE; ">
                         <div id = "per4" style = "top: 0px; left: 0px;  display: none; height: 100%; position: absolute;  background-color: rgba(41,153,255,0.15); "></div>                               
                            <span id = "option4Check"  style = "display: none;" class = "fa fa-check">
                              </span> ${it.answerFour} <span id = "Answer4Count"  style = "color: #8D8D8D;">
                          		    (${it.answerFourVotes})
                              </span>
                           </div>
                        
                        </td>
                        </g:if>
                     </tr>
                  </table>

         
               </div>
                        </g:each>
                        
         </div>
         <!-- QUESTION -->	
         <!-- MAIN -->	
          
      <div style = "width: 100%; ">
         <div  class="contentContainer">
            <div class="contentContainerTitle">
               <p class = "fa  fa-random" > <span>Randomly Awesome</span> </p>
            </div>
            <div class = "scrollCon">
               <g:each in="${questionArray}">
                  <div style = "overflow: hidden; text-align: center; " onmouseover="glow(this)" onmouseout="unGlow(this)"  onClick = "loadQuestionURL('${it.questionID}')"  class="col-xs-6 col-md-4">
                     <div  class="row" style = "cursor: default; ">
                        <g:if test="${it.answerOneImage}">
                           <img class = "bigViewImg"  src = "${createLink(controller: 'Question', action: 'getAnswerImageById', params: [id: it.questionID, imgNum: '1'])}"  />	
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

                        
                                   
         <!-- COMMENT BOX -->	
      <div  class="contentContainer">
            <div class="fb-comments" data-href="http://localhost:8080/ShouldIorV1/Question/shouldi/${questionID}" data-numposts="5"></div>
         </div>       
         <!-- COMMENT BOX -->	
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
         $(document).ready(function() {
         	// Show item that has been voted on already by logged in user
         	       		$("#option" + $("#vote").val()  + "Check").css("display","inline-block");
         		
        	 	// Show servers calculated question diff
      		   	$("#diffPercent").text($("#percentDiffHidden").val() + "%");

      		   	if (!$("#percentDiffHidden").val() == "0") {
    			  displayMiniGraphs($("#totalVotes").val(), $("#answerOneVotes").val(),$("#answerTwoVotes").val(),$("#answerThreeVotes").val(),$("#answerFourVotes").val());
      		   	}
      		   	
         	if ($("#vote").val() != "NONE") {
         	} else {
         		// Nothing for now
         	}
         	
         });
           
         function glow(id) {
        	 $(id).css("background-color","#F7FBFF");	 
         }
            
         function unGlow(id) {
       	  $(id).css("background-color","");
         }
         
         function loadQuestionURL(url) {
         	window.location.href = "/ShouldIorV1/Question/shouldi/" + url;
         }
         
         function displayPageLink() {
        	 $("#pageLink").slideDown("1000");
         }
         
         function share() {
             var link = $(location).attr('href');
             var description = $("#questionText").html();
			 var caption = $("#titleText").html();
             
         	FB.ui({
         		  method: 'feed',
         		  display: 'iframe',
         		  app_id: '1625511597708023',
         		  link: link,
         		  caption: caption,
         		  description: description,
         		  picture: 'https://upload.wikimedia.org/wikipedia/commons/9/95/Burning_Yellow_Sunset.jpg',
         		}, function(response){});
         	}

      	function displayMiniGraphs(totalVotes, ans1, ans2, ans3, ans4) {

				var ans1per = (ans1 / totalVotes * 100);
				var ans2per = (ans2 / totalVotes * 100);


				$("#per1").width(ans1per + '%');
				$("#per2").width(ans2per + '%');
				
			    $("#per1" ).show('slide', {direction: 'left'}, 2000);
			    $("#per2" ).show('slide', {direction: 'left'}, 2000);
				
				if (ans3 != null) {
					var ans3per = (ans3 / totalVotes * 100);
					$("#per3").width(ans3per + '%');
				    $("#per3" ).show('slide', {direction: 'left'}, 2000);	
				}

				if (ans4 != null) {
					var ans4per = (ans4 / totalVotes * 100);
					$("#per4").width(ans4per + '%');
				    $("#per4" ).show('slide', {direction: 'left'}, 2000);
					
				}

          	}
         
    
         
      </script>
   </body>
</html>