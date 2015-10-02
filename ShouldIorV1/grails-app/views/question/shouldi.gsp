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

      <g:if test="${session.name}">
         <input id = "sessionCheck" type="hidden" name="sess" value="true">
      </g:if>
      <g:else>
         <input id = "sessionCheck" type="hidden" name="sess" value="false">
      </g:else>
      
      <input id = "facebookLoginLink" type="hidden" name="perdif" value="${createLink(controller: 'Authentication', action: 'loginFaceBook')}">
      
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
      
      <div class="container" style = "padding-top: 60px; max-width: 825px;">
      
      <div  class="contentContainer">
      

            <!-- QUESTION -->	
              <input id = "totalVotes" type="hidden" value="${question.totalVotes}">
                      <input id = "answerOneVotes" type="hidden"  value="${question.answerOneVotes}">
                      <input id = "answerTwoVotes" type="hidden"  value="${question.answerTwoVotes}">
				      <input id = "answerThreeVotes" type="hidden"  value="${question.answerThreeVotes}">
				      <input id = "answerFourVotes" type="hidden" value="${question.answerFourVotes}">
				            
               <input id = "questionID" type="hidden" name="country" value="${question.questionID}">	
               <div style ="display: block; width: 100%; padding-bottom: -5px; " >
                  <!-- MAIN -->	
                  <div  style="display: block;  padding: 10px;  border-bottom: solid 1px; border-color: #f3f3f3;  margin: auto;  ">
                     <!-- PROFILE INFORMATION -->	
                     
                     <g:if test="${question.anonymous == false}">
                         <div style = "display: inline-block; width: 68px; padding-left: 5px;">
                        <img  style = "width: 100%;   display: inline-block; border-top-right-radius: 6px; border-top-left-radius: 5px;"  src = "${createLink(controller: 'User', action: 'getProfileImage', params: [id: question.userID])}"   />			
                     </div>
                     <div style = "display: inline-block; padding-bottom:0px; margin-right: 4px; margin-left: 4px; vertical-align: top;  ">
                        <span style = "margin-left: 1px; color: #5C5C5C; display: block; font-size: 15px;"><a href = "${createLink(controller: 'User', action: 'profile', params: [id: question.userID, category : 'New Questions'])}"><b>${question.userName}</b></a></span>
                        <span style = "margin-left: 1px; color: #5C5C5C; margin-top: -2px;  display: block; font-size: 15px;">Questions: ${opQuestionCount}</span>
                        <span style = "margin-left: 1px; color: #5C5C5C; margin-top: -2px; display: block; font-size: 15px;">Reached: ${peopleReached} </span>
                     </div>
                     
                     </g:if>
                     
                     <g:else>
                     <div style = "display: inline-block; width: 68px; padding-left: 5px;">
                        <img  style = "width: 100%;   display: inline-block; border-top-right-radius: 6px; border-top-left-radius: 5px;"  src="${resource(dir:'images',file:'blankAv.png')}"   />			
                     </div>
                     <div style = "display: inline-block; padding-bottom:0px; margin-right: 4px; margin-left: 4px; vertical-align: top;  ">
                        <span style = "margin-left: 1px; color: #5C5C5C; display: block; font-size: 15px;"><b><span class = "fa fa-user-secret"></span> Anonymous</b></span>
                        <span style = "margin-left: 1px; color: #5C5C5C; margin-top: -2px;  display: block; font-size: 15px;">Questions: <span class='fa fa-question'></span></span>
                        <span style = "margin-left: 1px; color: #5C5C5C; margin-top: -2px; display: block; font-size: 15px;">Reached: <span class='fa fa-question'></span>  </span>                                                      
                     </div>
                     
                     </g:else>
                     
                  </div>
                  <!-- PROFILE INFORMATION -->	
                  
  
                     <input id = "requireLoginToVote" type="hidden" name="perdif" value="${question.requireLoginToVote}">    
                      
                    <g:if test="${thisUserPost == true || question.requireLoginToVote == false}">
                        <div class="alert alert-info" role="alert" style = "margin: 10px 10px 0px 10px; padding: 8px; text-align: left; background-color: rgba(41,153,255,0.05);">
                    
                   <g:if test="${question.requireLoginToVote == false}">
	                  <p style = " color: #407b98; margin: 0px; display: block;">
	                  	<span class = " fa  fa-thumbs-o-up"></span> Login not required to vote.
	                  </p> 
                  </g:if>
                  
                    <g:if test="${thisUserPost == true}">
                     <p style = " display: block; color: #407b98; margin: 0px;">
						<a style = "cursor: default;" onclick = "share()"><b>Share</b></a> or copy this pages <a onClick = "displayPageLink()" style = "cursor: default;"><b>link</b></a></br>
						 <span id = "pageLink" style = "display: none; color: #8D8D8D; word-break: break-all;"><u>www.ShouldI.fm/Question/${question.questionID}</u></span>
					</p>
					</g:if>
						
						</div>
					</g:if>
						

                  <div style = " display: block; height: 50px;  ">
       
                  
                     <span style = 'text-align: left; font-size: 18px; color: #4A4A4A; padding-left: 12px; padding-top:6px; display: inline-block;'>
  
                  
                     <span  id = "" style = "display: block; color: #8D8D8D; font-size: 14px; "><g:formatDate format="MM-dd-yyyy" date="${question.date}"/></span>             
                  
                      <span  id = "voteCount" style = " display: block; color: #8D8D8D; font-size: 14px; ">Votes: ${question.totalVotes}</span>             

                     
                     </span>
                     <div style = "padding-bottom: -10px; float:right; display: inline-block; vertical-align: top;">
                        <div  onClick = "share()" style = " cursor: default; text-align: center; width: 65px; padding: 2px; padding-left: 2px; color: #4DAEFF; font-size: 13px; margin-right: 7px; margin-top:9px; ">
                           <div class = 'favsharButtion' style = "margin: auto; padding: 0px; margin: 0px;"><span style = ' ' class='fa fa-facebook-square'></span> Share</div>
                        </div>
                     </div>
                     
                     <div style = "padding-bottom: -10px; float:right; display: inline-block; vertical-align: top;">
                       
                        <g:if test="${session.name}">                 
                        <div  onClick = "addToFavorites('${createLink(controller: 'Question', action: 'addToFavorites')}', '${question.questionID}')" style = "cursor: default; text-align: center; width: 70px; padding: 2px; padding-left: 0px; color: #4DAEFF; font-size: 13px; margin-right: 0px; margin-top:9px; ">				
						</g:if>
						<g:else>
                        <div    onClick = "showNoLogin()" style = "cursor: default; text-align: center; width: 70px; padding: 2px; padding-left: 0px; color: #4DAEFF; font-size: 13px; margin-right: 0px; margin-top:9px; ">
						</g:else>

                           <div class = 'favsharButtion' style = "margin: auto; padding: 0px; margin: 0px;">
                                 
                        <g:if test = "${favorite == null}">
                           <span id = "starEmpty" style = '' class='fa fa-star-o'></span>                           
                           <span id = "starFull" style = 'display:none ' class='fa fa-star'> </span>  
                           Favorite
						</g:if>
						<g:else>
                           <span id = "starEmpty" style = 'display:none' class='fa fa-star-o'></span>                           
                           <span id = "starFull" style = ' ' class='fa fa-star'> </span> 
                           Favorite
						</g:else>
						
						
                           </div>
                        </div>
                     </div>
                     
                  </div>
                  <span id = "titleText" style = 'text-align: center; margin: center; margin-top: 0px; padding: 0px 8px 0 8px; color: #545252; font-size: 20px; display: block;' >${question.questionTitle}</span>
                  <hr style = "margin-top: 8px; width: 85%; margin-bottom: 0px; padding-top: 0px;">

                  <g:if test="${question.custom.toString().equals('false')}">
                  		<g:if test="${question.answerOneImage}">
	                  <div id = "ee" style = "margin-bottom: 30px; padding: 15px;  margin: auto; margin-top: 20px;  width: 50%; min-width: 290px; max-width: 330px; mag-height: 100px; background-color: #F4FAFF; display: block;" >
	                     <img id="singleImg" src = "${createLink(controller: 'Question', action: 'getAnswerImageById', params: [id: question.questionID, imgNum: '1'])}"   style ="display: block;  width: 95%;  height: 80%; margin: auto;" alt="UhOh! We cant seem to load the image." />
	                  </div>
                	  </g:if>
                  </g:if>
                  
                  
                  <div style = "padding: 15px; width: 98%; overflow-y: hidden; margin:auto; padding-top: 18px;   display: block;">
                   <div style = "margin: 0px; padding: 0px; width: 100%;" id = "questiontText">
                     ${raw(question.question)}		           
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

				<g:if test="${question.custom.toString().equals('true')}">
				  <tr style = "height: 100%; width: 50%; margin-top: 5px; ">		  
				  <td id = "img1"  onClick = "questionVote('1')" style = "height: 100%; width: 50%; text-align: center; border-right: solid 1px #F0F0E1;  " >
						<g:if test="${question.answerOneImage}">
							<img  src = "${createLink(controller: 'Question', action: 'getAnswerImageById', params: [id: question.questionID, imgNum: '1'])}"  style = "width: 55%; padding: 10px 4px 10px 4px; min-width: 150px; "/>
						</g:if>
						<g:elseif test="${hasQuestionImage.toString().equals('true')}">
							<img  src="${resource(dir:'images',file:'noImg.png')}" style = "width: 55%; padding: 10px 4px 10px 4px; min-width: 150px; "/>
						</g:elseif>	
					</td>
					
				  <td id = "img2" onClick = "questionVote('2')" style = "height: 100%; width: 50%; text-align: center;" >
						<g:if test="${question.answerTwoImage}">
							<img  src = "${createLink(controller: 'Question', action: 'getAnswerImageById', params: [id: question.questionID, imgNum: '2'])}"  style = "width: 55%; padding: 10px 4px 10px 4px; min-width: 150px; "/>
						</g:if>
						<g:elseif test="${hasQuestionImage.toString().equals('true')}">						
							<img  src="${resource(dir:'images',file:'noImg.png')}" style = "width: 55%; padding: 10px 4px 10px 4px; min-width: 150px; "/>
						</g:elseif>	
					</td>
				  </tr>
				  </g:if>			  
				<g:if test="${question.custom.toString().equals('false')}">
                     <tr style = "width: 100%; ">
                        <td  id = "ans1"  onClick = "questionVote('1')"  class="answerContainer"  style = "border-right: solid 1px #E1E1E1;"   >
                           <div style = " width: 100%; display:block; margin: auto; bottom: 0px; text-align: center; font-size: 19px;  color: #61B7FE; ">
                         <div id = "per1" style = "top: 0px; left: 0px;  display: none; height: 100%; position: absolute;  background-color: rgba(41,153,255,0.15); "></div>  
							<span id = "option1Check" style = "display: none;" class = "fa fa-check">        
                              </span> Yes <span id = "Answer1Count" style = "color: #8D8D8D;">
                              (${question.answerOneVotes})
                              </span>       
                           </div>
                        </td>
                        <td id = "ans2"  onClick = "questionVote('2')"  class="answerContainer " >
                           <div style = " width: 100%; display:block; margin: auto; bottom: 0px; text-align: center; font-size: 19px;  color: #61B7FE; ">
                         <div id = "per2" style = "top: 0px; left: 0px;  display: none; height: 100%; position: absolute;  background-color: rgba(41,153,255,0.15); "></div>                                  
                            <span id = "option2Check"  style = "display: none;" class = "fa fa-check">
                              </span> No <span id = "Answer2Count"  style = "color: #8D8D8D;">
                              (${question.answerTwoVotes})
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
                              </span> ${question.answerOne} <span id = "Answer1Count" style = "color: #8D8D8D;">           
	                              	(${question.answerOneVotes})
                              </span>           
                           </div>
                           
                        </td>
                        <td  id = "ans2" onClick = "questionVote('2')"  class="answerContainer"  >
                           <div style = " width: 100%; display:block; margin: auto; bottom: 0px; text-align: center; font-size: 19px;  color: #61B7FE; ">
                         <div id = "per2" style = "top: 0px; left: 0px;  display: none; height: 100%; position: absolute;  background-color: rgba(41,153,255,0.15); "></div>  
                            <span id = "option2Check"  style = "display: none;" class = "fa fa-check">
                              </span> ${question.answerTwo} <span id = "Answer2Count"  style = "color: #8D8D8D;">
                              			(${question.answerTwoVotes})
                              </span>
                           </div>
                        </td>
                     </tr>
                 </g:else>         
                  </table>
                              
                  
                     <table style="width: 100%; overflow:none; margin-top: 0px; padding:0px; border-top: 1px solid #E1E1E1;">
				  <tr style = "height: 100%; width: 50%; margin-top: 5px; ">		  
				  
				 <g:if test="${question.answerThree}">
				  <td id = "img3" onClick = "questionVote('3')" style = "height: 100%; width: 50%; text-align: center;  " >
						<g:if test="${question.answerThreeImage}">
							<img  src = "${createLink(controller: 'Question', action: 'getAnswerImageById', params: [id: question.questionID, imgNum: '3'])}"  style = "width: 55%; max-width: 250px; padding: 10px 4px 10px 4px; min-width: 150px; "/>
						</g:if>
						<g:elseif test="${hasQuestionImage.toString().equals('true')}">
							<img  src="${resource(dir:'images',file:'noImg.png')}" style = "width: 55%; padding: 10px 4px 10px 4px; min-width: 150px; "/>
						</g:elseif>	
					</td>
					</g:if>
					
				 <g:if test="${question.answerFour}">
				  <td id = "img4" onClick = "questionVote('4')" style = "height: 100%; width: 50%; text-align: center; border-left: solid 1px #F0F0E1; " >
						<g:if test="${question.answerFourImage}">
							<img  src = "${createLink(controller: 'Question', action: 'getAnswerImageById', params: [id: question.questionID, imgNum: '4'])}"  style = "width: 55%; padding: 10px 4px 10px 4px; min-width: 150px; "/>
						</g:if> 
						<g:elseif test="${hasQuestionImage.toString().equals('true')}">
							<img  src="${resource(dir:'images',file:'noImg.png')}" style = "width: 55%; padding: 10px 4px 10px 4px; min-width: 150px; "/>
						</g:elseif>			
					</td>
				</g:if>
				
				  </tr>
			
                     <tr style = "width: 100%; ">
                     	<g:if test="${question.answerThree}">
                        <td  id = "ans3" onClick = "questionVote('3')" class="answerContainer"  style = "border-right: solid 1px #E1E1E1;"  >
  							<div style = " width: 100%; display:block; margin: auto; bottom: 0px; text-align: center; font-size: 19px;  color: #61B7FE; ">
                         <div id = "per3" style = "top: 0px; left: 0px;  display: none; height: 100%; position: absolute;  background-color: rgba(41,153,255,0.15); "></div>                             
                            <span id = "option3Check" style = "display: none;" class = "fa fa-check"> 
                              </span> ${question.answerThree} <span id = "Answer3Count" style = "color: #8D8D8D;">
                           		   (${question.answerThreeVotes})
                              </span>
                           </div>
                        </td>
                        </g:if>
                        
                        <g:if test="${question.answerFour}">         
                        <td id = "ans4" onClick = "questionVote('4')"   class="answerContainer"  " >
                           <div style = " width: 100%; display:block; margin: auto; bottom: 0px; text-align: center; font-size: 19px;  color: #61B7FE; ">
                         <div id = "per4" style = "top: 0px; left: 0px;  display: none; height: 100%; position: absolute;  background-color: rgba(41,153,255,0.15); "></div>                               
                            <span id = "option4Check"  style = "display: none;" class = "fa fa-check">
                              </span> ${question.answerFour} <span id = "Answer4Count"  style = "color: #8D8D8D;">
                          		    (${question.answerFourVotes})
                              </span>
                           </div>
                        
                        </td>
                        </g:if>
                     </tr>
                  </table>

         
               </div>
                        
         </div>
         <!-- QUESTION -->	
         <!-- MAIN -->	
         <div  onClick = "openNext('${createLink(controller: 'Question', action: 'nextInCat', params: [category: question.category])}')" class="contentContainer next " style="overflow: auto;  text-align: center; display: block; height: 44px;  padding-top: 11px; padding-bottom: 0px;">
		<span class = "" style = "margin: auto; width: 100px; color: #888888; font-size: 17px;">Next in 
		<span style = "color:#61B7FE;">${question.category}</span></span><span style = "color: #9D9D9D; margin-left: 8px;" class = "fa fa-chevron-right"> </span>
		</div>
          
      <div style = "width: 100%; ">
         <div  class="contentContainer">
            <div class="contentContainerTitle">
               <p class = "fa  fa-check-square-o"><span> Suggested Polls</span> </p>
            </div>
            <div class = "scrollCon">
               <g:each in="${questionPromo1}">
                  <div style = "overflow: hidden; text-align: center; " onmouseover="glow(this)" onmouseout="unGlow(this)"  onClick = "loadQuestionURL('${createLink(controller: 'Question', action: 'shouldi', params: [id: it.questionID])}')"  class="col-xs-6 col-md-4">
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
         
         
	   <footer class="footer" style = "margin-top: 10px;  width: 100%;" >
      <div class="container" style = "width: 100%; text-align: left; padding: 0px; ">
      <span style = "font-size: 13px; color: #79cce5;"><a style = "color: #79cce5;"  href = "${createLink(controller: 'ShouldI', action: 'privacyPolicy')}"  >Privacy Policy</a> | </span>
      <span style = "font-size: 13px; color: #79cce5;"><a style = "color: #79cce5;" href = "${createLink(controller: 'ShouldI', action: 'help')}"  >How To</a> | </span>
      <span style = "font-size: 13px; color: #79cce5;"><a style = "color: #79cce5;" href = "${createLink(controller: 'ShouldI', action: 'aboutPollaris')}">Pollaris LLC</a></span>   
      </div>   
  	  </footer>
  	  
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
         	window.location.href =  url;
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
         
    function openNext(url) {
    	window.location.href = url;
    }
         
      </script>
   </body>
</html>