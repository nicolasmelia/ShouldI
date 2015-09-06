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
   <body style = "  ">
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
               <a href = "/ShouldIorV1/shouldI" ><img onClick = "h" src="${resource(dir:'images',file:'logo.png')}"   class="navbar-brand"/></a>
            </div>
            <div id="navbar" class="collapse navbar-collapse">
               <ul class="nav navbar-nav">
                  <g:if test="${session.name}">
                     <li><a href="#"><span class= 'fa fa-bell-o'></span><span style = "padding-left: 6px;" >0</span></a></a></li>
                     <li><a href="/ShouldIorV1/Question/askShouldI"><span class= 'fa fa-pencil-square-o'></span><span style = "padding-left: 6px;" >Ask</span></a></a></li>
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
                        <img style = "display:inline-block; width: 25px; height: 25px; margin-right: 4px; margin-top: -25px;  margin-bottom: -25px;" src = "/ShouldIorV1/User/getProfileImage/${session.userID}" />			
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
      <div class="container" style = "padding-top: 77px; max-width: 875px;">
         <div  class="jumbotron" style=" border-bottom-radius: 0px; background-color: #FFFFFF; margin: 0px; padding: 0px; box-shadow:0 0 10px rgba(0, 0, 0, 0.15);  height: 100%;   display: block; width: 100%; ">
            <!-- QUESTION -->	
            <g:each in="${question}">
               <input id = "questionID" type="hidden" name="country" value="${it.questionID}">	
               <div style ="display: block; width: 100%; padding-bottom: -5px; " >
                  <!-- MAIN -->	
                  <div  style="display: block;  padding: 10px;  border-bottom: solid 1px; border-color: #f3f3f3;  margin: auto;  ">
                     <!-- PROFILE INFORMATION -->	
                     <div style = "display: inline-block; width: 68px; padding-left: 5px;">
                        <img  style = "width: 100%;   display: inline-block; border-top-right-radius: 6px; border-top-left-radius: 5px;" src = "../../User/getProfileImage/${it.userID}"  />			
                     </div>
                     <div style = "display: inline-block; padding-bottom:0px; margin-right: 4px; margin-left: 4px; vertical-align: top;  ">
                        <span style = "margin-left: 1px; color: #5C5C5C; display: block; font-size: 15px;"><b>Nicolas Melia</b></span>
                        <span style = "margin-left: 1px; color: #5C5C5C; margin-top: -2px;  display: block; font-size: 15px;">Followers: 234 <span style = 'text-align: left; color: #545252;  padding-left: 2px; display: inline-block;' class='fa fa-plus'></span></span>
                        <span style = "margin-left: 1px; color: #5C5C5C; margin-top: -2px; display: block; font-size: 15px;">Reached: 34k People</span>
                     </div>
                  </div>
                  <!-- PROFILE INFORMATION -->	
                  <div style = " display: block; height: 50px; ">
                     <span style = 'text-align: left; font-size: 18px; color: #4A4A4A; padding-left: 12px; padding-top:6px; display: inline-block;'>
                  
                     <g:if test="${vote.toString().equals('NONE')}">
                      <span id = "diffPercent"style = "color: #61B7FE; font-size: 18px;"></span>
                      <span  id = "topAnswer" style = "color: #8D8D8D;">${it.totalVotes} Votes</span>
                     </g:if>
                     <g:else>
                      <span id = "diffPercent"style = "color: #61B7FE; font-size: 18px;"></span>
                      <span id = "topAnswer" style = "color: #8D8D8D;">${topAnswer}</span>
                     </g:else>
                     
                     
                     </span>
                     <div style = "padding-bottom: -10px; float:right; display: inline-block; vertical-align: top;">
                        <div  class = 'favsharButtion' onClick = "test()" style = " cursor: default; text-align: center; width: 65px; padding: 2px; padding-left: 2px; color: #4DAEFF; font-size: 13px; margin-right: 7px; margin-top:9px; ">
                           <div style = "margin: auto; padding: 0px; margin: 0px;"><span style = ' ' class='fa fa-facebook'></span> Share</div>
                        </div>
                     </div>
                     <div class = 'favsharButtion' style = "padding-bottom: -10px; float:right; display: inline-block; vertical-align: top;">
                        <div  onClick = "test()" style = "cursor: default; text-align: center; width: 65px; padding: 2px; padding-left: 0px; color: #4DAEFF; font-size: 13px; margin-right: 3px; margin-top:9px; ">
                           <div style = "margin: auto; padding: 0px; margin: 0px;"><span style = ' ' class='fa fa-star'></span> Favorite</div>
                        </div>
                     </div>
                  </div>
                  <span style = 'text-align: center; margin: center; margin-top: 0px; padding: 0px 8px 0 8px; color: #545252; font-size: 20px; display: block;' >${it.questionTitle}</span>
                  <hr style = "margin-top: 8px; width: 85%; margin-bottom: 0px; padding-top: 0px;">
               
                  <g:if test="${it.custom.toString().equals('false')}">
                  		<g:if test="${it.answerOneImage}">
	                  <div id = "ee" style = "margin-bottom: 30px; padding: 15px;  margin: auto; margin-top: 20px;  width: 50%; min-width: 290px; max-width: 330px; mag-height: 100px; background-color: #F4FAFF; display: block;" >
	                     <img id="singleImg" src = "../getAnswerImageById/${it.questionID}:1"  style ="display: block;  width: 95%;  height: 80%; margin: auto;" alt="UhOh! We cant seem to load the image." />
	                  </div>
                	  </g:if>
                  </g:if>
                  
                  
                  <div style = "padding: 15px; width: 98%; max-height: 300px; margin:auto; padding-top: 18px;   display: block;">
                   <div style = "margin: 0px; padding: 0px; width: 100%;s">
                     ${raw(it.question)}		           
                    </div>
                     
                  </div>
                  
                  
                  <div  id = "voteWarn" style = "width: 100%; text-align: center; color: #61B7FE; display:none;  ">  
                     <span class = "fa fa-check"></span> You have already voted on this question.
                  </div>


                 <table style="width: 100%; overflow:none; margin-top: 5px; padding:0px; border-top: 1px solid #E1E1E1;">

				<g:if test="${it.custom.toString().equals('true')}">
				  <tr style = "height: 100%; width: 50%; margin-top: 5px; ">		  
				  <td id = "img1"  onClick = "questionVote('1')" style = "height: 100%; width: 50%; text-align: center; border-right: solid 1px #F0F0E1;  " >
						<g:if test="${it.answerOneImage}">
							<img  src = "../getAnswerImageById/${it.questionID}:1" style = "width: 55%; padding: 10px 4px 10px 4px; min-width: 150px; "/>
						</g:if>
						<g:elseif test="${hasQuestionImage.toString().equals('true')}">
							<img  src="${resource(dir:'images',file:'noImg.png')}" style = "width: 55%; padding: 10px 4px 10px 4px; min-width: 150px; "/>
						</g:elseif>	
					</td>
					
				  <td id = "img2" onClick = "questionVote('2')" style = "height: 100%; width: 50%; text-align: center;" >
						<g:if test="${it.answerTwoImage}">
							<img  src = "../getAnswerImageById/${it.questionID}:2" style = "width: 55%; padding: 10px 4px 10px 4px; min-width: 150px; "/>
						</g:if>
						<g:elseif test="${hasQuestionImage.toString().equals('true')}">						
							<img  src="${resource(dir:'images',file:'noImg.png')}" style = "width: 55%; padding: 10px 4px 10px 4px; min-width: 150px; "/>
						</g:elseif>	
					</td>
				  </tr>
				  </g:if>			  
				<g:if test="${it.custom.toString().equals('false')}">
                     <tr style = "width: 100%; ">
                        <td  id = "ans1"  onClick = "questionVote('1')" class="picAnswer1"  style = "cursor: default; border-bottom: solid 2px #ffffff; width: 50%; text-align: center; border-right: 1px solid #E1E1E1;  " >
                           <p style = "padding:5px; width: 100%; display:block; margin: auto; bottom: 0px; text-align: center; font-size: 19px;  color: #61B7FE; ">
                              <span id = "option1Check" style = "display: none;" class = "fa fa-check">        
                              </span> Yes <span id = "Answer1Count" style = "color: #8D8D8D;">
                              <g:if test="${!vote.toString().equals('NONE')}"> 
                              (${it.answerOneVotes})
	                           </g:if> 
                              </span>       
                           </p>
                        </td>
                        <td id = "ans2"  onClick = "questionVote('2')"  class="picAnswer2"  style = " cursor: default; border-bottom: solid 2px #ffffff; width: 50%; text-align: center; " >
                           <p style = "padding:5px;  width: 100%; display:block; margin: auto; bottom: 0px; text-align: center; font-size: 19px;  color: #61B7FE; ">
                              <span id = "option2Check"  style = "display: none;" class = "fa fa-check">
                              </span> No <span id = "Answer2Count"  style = "color: #8D8D8D;">
                              <g:if test="${!vote.toString().equals('NONE')}"> 
                              (${it.answerTwoVotes})
	                           </g:if>   
                              </span>
                           </p>
                        </td>
                     </tr>
                 </g:if>
                 <g:else>
                     <tr style = "width: 100%; ">
                        <td  id = "ans1"  onClick = "questionVote('1')"  style = "cursor: default; border-bottom: solid 2px #ffffff; width: 50%; text-align: center; border-right: 1px solid #E1E1E1;  " >
                           <p style = " padding:5px; width: 100%; display:block; margin: auto; bottom: 0px; text-align: center; font-size: 19px;  color: #61B7FE; ">
                              <span id = "option1Check" style = "display: none;" class = "fa fa-check"> 
                              </span> ${it.answerOne} <span id = "Answer1Count" style = "color: #8D8D8D;">                          
	                              <g:if test="${!vote.toString().equals('NONE')}"> 
	                              	(${it.answerOneVotes})
	                              </g:if>       
                              </span>           
                           </p>
                        </td>
                        <td  id = "ans2" onClick = "questionVote('2')"  class="picAnswer2"  style = "cursor: default; border-bottom: solid 2px #ffffff;  width: 50%; text-align: center; " >
                           <p style = "padding:5px;  width: 100%; display:block; margin: auto; bottom: 0px; text-align: center; font-size: 19px;  color: #61B7FE; ">
                              <span id = "option2Check"  style = "display: none;" class = "fa fa-check">
                              </span> ${it.answerTwo} <span id = "Answer2Count"  style = "color: #8D8D8D;">
                              	 <g:if test="${!vote.toString().equals('NONE')}"> 
                              			(${it.answerTwoVotes})
	                              </g:if>       
                              </span>
                           </p>
                        </td>
                     </tr>
                 </g:else>         
                  </table>
                              
                  
                     <table style="width: 100%; overflow:none; margin-top: 0px; padding:0px; border-top: 1px solid #E1E1E1;">
				  <tr style = "height: 100%; width: 50%; margin-top: 5px; ">		  
				  
				 <g:if test="${it.answerThree}">
				  <td id = "img3" onClick = "questionVote('3')" style = "height: 100%; width: 50%; text-align: center;  " >
						<g:if test="${it.answerThreeImage}">
							<img  src = "../getAnswerImageById/${it.questionID}:3" style = "width: 55%; max-width: 250px; padding: 10px 4px 10px 4px; min-width: 150px; "/>
						</g:if>
						<g:elseif test="${hasQuestionImage.toString().equals('true')}">
							<img  src="${resource(dir:'images',file:'noImg.png')}" style = "width: 55%; padding: 10px 4px 10px 4px; min-width: 150px; "/>
						</g:elseif>	
					</td>
					</g:if>
					
				 <g:if test="${it.answerFour}">
				  <td id = "img4" onClick = "questionVote('4')" style = "height: 100%; width: 50%; text-align: center; border-left: solid 1px #F0F0E1; " >
						<g:if test="${it.answerFourImage}">
							<img  src = "../getAnswerImageById/${it.questionID}:4" style = "width: 55%; padding: 10px 4px 10px 4px; min-width: 150px; "/>
						</g:if> 
						<g:elseif test="${hasQuestionImage.toString().equals('true')}">
							<img  src="${resource(dir:'images',file:'noImg.png')}" style = "width: 55%; padding: 10px 4px 10px 4px; min-width: 150px; "/>
						</g:elseif>			
					</td>
				</g:if>
				
				  </tr>
			
                     <tr style = "width: 100%; ">
                     	<g:if test="${it.answerThree}">
                     
                        <td  id = "ans3" onClick = "questionVote('3')" class="picAnswer1"  style = " cursor: default; border-bottom: solid 2px #ffffff; width: 50%; text-align: center; border-right: 1px solid #E1E1E1;  " >
                           <p style = "padding:5px; width: 100%; display:block; margin: auto; bottom: 0px; text-align: center; font-size: 19px;  color: #61B7FE; ">
                              <span id = "option3Check" style = "display: none;" class = "fa fa-check"> 
                              </span> ${it.answerThree} <span id = "Answer3Count" style = "color: #8D8D8D;">
                              <g:if test="${!vote.toString().equals('NONE')}"> 
                           		   (${it.answerThreeVotes})
	                           </g:if>      
                              </span>
                           </p>
                        </td>
                        </g:if>
                        
                        <g:if test="${it.answerFour}">
                       
                        <td id = "ans4" onClick = "questionVote('4')"  class="picAnswer2"  style = " cursor: default; border-bottom: solid 2px #ffffff;  width: 50%; text-align: center; " >
                           <p style = "padding:5px;  width: 100%; display:block; margin: auto; bottom: 0px; text-align: center; font-size: 19px;  color: #61B7FE; ">
                              <span id = "option4Check"  style = "display: none;" class = "fa fa-check">
                              </span> ${it.answerFour} <span id = "Answer4Count"  style = "color: #8D8D8D;">
                             	<g:if test="${!vote.toString().equals('NONE')}"> 
                          		    (${it.answerFourVotes})
	                           </g:if>   
                              </span>
                           </p>
                        
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
         <div  class="jumbotron" style="box-shadow:0 0 10px rgba(0, 0, 0, 0.1);  border-top-left-radius: 5px; border-top-left-radius: 5px; background-color: rgba(255,255,255,0.88);  padding: 0px; padding-top: 0px;  display: block; margin: 10px 0px 10px 0px;  ">
            <div style = " border-top-left-radius: 5px;   border-bottom: 1px solid #ccc;   border-top-right-radius: 5px;  display:block;  margin: auto;  margin-top: 10px;   ">
               <p style = "color: #33A6DD; padding: 10px; padding-top: 12px; height: 30px;  font-size: 18px;" class = "fa  fa-random" > <span style ="margin-left: 7px; color: #3E3E3E; ">Randomly Awesome Polls!</span> </p>
            </div>
            <div style = "overflow-y: scroll; height: 200px; display: block;">
               <g:each in="${questionArray}">
                  <div style = "text-align: center; " onmouseover="glow(this)" onmouseout="unGlow(this)"  onClick = "loadQuestionURL('${it.questionID}')"  class="col-xs-6 col-md-4">
                     <div  class="row" style = "cursor: default; ">
    					  <g:if test = "${it.answerOneImage}">
                              <img  style = "width: 40%; max-height:80px; width: auto; height: auto; margin: auto;   padding: 0px; margin-top: 9px; " src = "/ShouldIorV1/Question/getAnswerImageById/${it.questionID}:1" />	
                           </g:if>
                           <g:else>
                              <img  style = "width: 40%; max-height:80px; width: auto; height: auto; margin: auto;   padding: 0px; margin-top: 9px; " src="${resource(dir:'images',file:'noImg.png')}"  />	
                           </g:else>
                        <div style = "display:block; margin-top: 5px; margin-bottom: 5px;  ">${it.questionTitle}</div>
                     </div>
                  </div>
               </g:each>
            </div>
         </div>
      </div>
           
         <!-- COMMENT BOX -->	
         <div  class="jumbotron" style="overflow: auto;  border-bottom-radius: 0px;  display: block; box-shadow:0 0 10px rgba(0, 0, 0, 0.15); min-height: 100px; margin: auto; min-width: 200px;  max-width: 875px; padding: 0px 10px 0px 10px;  margin-bottom: 50px; background-color: #FFFFFF;  ">
            <div class="fb-comments" data-href="http://localhost:8080/ShouldIorV1/Question/shouldi/${questionID}" data-numposts="5"></div>
         </div>       
         <!-- COMMENT BOX -->	
         
      </div>
      <!-- /.container -->
      
      <footer class="footer" style= " width: 90%;">
         <div class="container">
            <p class="text-muted">&copy; ShouldIOr, Developed by NightSkyCode LLC</p>
         </div>
      </footer>
      <!-- Bootstrap core JavaScript
         ================================================== -->
      <!-- Placed at the end of the document so the pages load faster -->
      <g:javascript src="dataAccess.js" />
      <script src="<g:resource dir="js" file="bootstrap.min.js" />"></script>
      <g:javascript src="buttonAnswerGlow.js" />
      
      <script>
         $(document).ready(function() {


             
         

         	// Show item that has been voted on already by logged in user
         	if ($("#vote").val() != "NONE") {
         		$("#option" + $("#vote").val()  + "Check").css("display","inline-block");
         		
        	 	// Show servers calculated question diff
      		   	$("#diffPercent").text($("#percentDiffHidden").val() + "%");
         
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
         
         function test() {
         	FB.ui({
         		  method: 'feed',
         		  display: 'iframe',
         		  app_id: '1625511597708023',
         		  link: 'https://developers.facebook.com/docs/',
         		  caption: 'How are you doing',
         		  description: 'Hello Hello Hello Hello Hello Hello Hello Hello Hello Hello Hello Hello Hello Hello Hello Hello Hello Hello Hello Hello Hello Hello Hello Hello',
         		  picture: 'https://upload.wikimedia.org/wikipedia/commons/9/95/Burning_Yellow_Sunset.jpg',
         		}, function(response){});
         	}
         	
         
         
      </script>
   </body>
</html>