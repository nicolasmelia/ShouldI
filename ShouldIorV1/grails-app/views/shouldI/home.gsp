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
      <link rel="stylesheet" type="text/css" href="<g:resource dir='css' file='awesome-bootstrap-checkbox.css'/>">
      <!-- Bootstrap core JS -->
      <script src="<g:resource dir="js" file="bootstrap.min.js" />"></script>
      <!-- facebook login -->
      <g:javascript src="facebookLogin.js" />
      <g:javascript src="dataRequest.js" />
      <!-- font-awesome -->
      <link rel='stylesheet' href='https://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css'>
      <link rel="stylesheet" type="text/css" href="<g:resource dir='css' file='typehead-searchBar.css'/>">
      <script src="
      <g:resource dir="js/typedJS" file="typed.min.js" />
      "></script>
      <script src="
      <g:resource dir="js/typeaheadJS" file="typeahead.jquery.min.js" />
      "></script>
      <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
      <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
      <![endif]-->
   </head>
  <body style = "background-color: #F6F6F6!important; margin-bottom: 20px; background-size: cover;  background-attachment: fixed; min-width: 330px;  ">
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
       
				
      
      <div class="container">    
      <div  class="" style="overflow: none;  display: block; min-height: 500px; margin: auto; min-width: 300px;    max-width: 775px; padding-left: 0px; padding-right: 0px; padding-top: 15px; padding-bottom: 0px;  margin-bottom: 0px;   ">


		<div style = "width: 100%; display: block; text-align: center; margin-top: 70px;  ">
		<img style = "width:50%; display: block; min-width: 260px; margin: auto; " src="${resource(dir:'images',file:'logoDark.png')}"   />		
				
				
         <div class = 'favsharButtion' style = " font-size: 23px;  display: block; width: 100%; text-align: left; margin-top: 15px;">
                   <a  style = "color: #3d3d3d; margin:0px; padding: 0px;" href = "/ShouldIorV1/Question/askShouldI" > <span class= 'fa fa-pencil-square-o'> 
                   <span class = "element"  ></span>
                           </span> 
                     </a> 
             </div>
            
               
				
				</div>



     
        				
         
        
        
         <div  class="jumbotron" style="box-shadow:0 0 10px rgba(0, 0, 0, 0.1);  border-top-left-radius: 5px; border-top-left-radius: 5px; background-color: rgba(255,255,255,0.9);  padding: 0px; padding-top: 0px;  display: block; margin: 5px 0px 10px 0px; ">
            <div style = " border-top-left-radius: 5px;   border-bottom: 1px solid #ccc;   border-top-right-radius: 5px;  display:block;  margin: auto;  margin-top: 0px;   ">
               <p style = "color: #FD7B7B; padding: 10px; padding-top: 12px; height: 30px;  font-size: 18px;" class = "fa  fa-fire" > <span style ="margin-left: 7px; color: #3E3E3E; ">Popular Right Now</span> </p>
            </div>
            <div style = "overflow-y: scroll; height: 200px; display: block;">
               <g:each in="${question}">
                  <table onmouseover="glow(this)" onmouseout="unGlow(this)"  onClick = "loadQuestionURL('${it.questionID}')" style="width: 100%; padding: 8px 4px 8px 4px; display:block;">
                     <tr style = "display:block; max-height: 105px; width: 100%; margin-top: 0px; ">
                        <td style = "min-width: 125px;  height: 100%; text-align:center; vertical-align:top; ">
                           <g:if test="${it.answerOneImage}">
                              <img  style = "max-width:110px; max-height:100px; width: auto; height: auto; margin: auto;   padding: 0px;"    src = "/ShouldIorV1/Question/getAnswerImageById/${it.questionID}:1" />	
                           </g:if>
                           <g:else>
                              <img  style = "max-width:110px; max-height:100px; width: auto; height: auto; margin: auto;   padding: 0px;  " src="${resource(dir:'images',file:'noImg.png')}"  />	
                           </g:else>
                        </td>
                        <td style = "width: 100%; height:1px; ">
                           <table style="width:100%;  height: 100%; ">
                              <tr  style = "vertical-align: top;" >
                                 <td style = "height: 100%; ">
                                    <span style = "display: block;  font-size: 16px;" >Nicolas Melia<span> 
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
                        <hr style = "padding: 0px; margin: 0px;"/>
                     </tr>
                  </table>
               </g:each>
            </div>
         </div>
         
         
         

      
      <div style = "width: 100%; ">
         <div  class="jumbotron" style="box-shadow:0 0 10px rgba(0, 0, 0, 0.1);  border-top-left-radius: 5px; border-top-left-radius: 5px; background-color: rgba(255,255,255,0.9);  padding: 0px; padding-top: 0px; display: block; margin: 10px 0px 10px 0px; ">
            <div style = " border-top-left-radius: 5px;   border-bottom: 1px solid #ccc;   border-top-right-radius: 5px;  display:block;  margin: auto;  margin-top: 10px;   ">
               <p style = "color: #fff090; padding: 10px; padding-top: 12px; height: 30px;  font-size: 18px;" class = "fa  fa-star" > <span style ="margin-left: 7px; color: #3E3E3E; ">Get Noticed!</span> </p>
            </div>
	            <div style = "padding: 15px;">
		            <h3 style = "text-align: left; color: #6A6A6A; margin:0px;">
		               ShouldI.fm is taking off rapidly!
		            </h3>
		            <p style = "font-size: 15px; width: 100%; margin-top: 10px; text-align: left;">
		               Just like YouTube you can make extra cash from the audiance you attract to your questions. Each vote earns you money. <a href = "#">Learn More</a>
		            </p>
		            <div>
	            </div>
            </div>
         </div>
      </div>
     
            
      <div style = "width: 100%; ">
         <div  class="jumbotron" style="box-shadow:0 0 10px rgba(0, 0, 0, 0.1);  border-top-left-radius: 5px; border-top-left-radius: 5px; background-color: rgba(255,255,255,0.9);  padding: 0px; padding-top: 0px;  display: block; margin: 10px 0px 10px 0px;  ">
            <div style = " border-top-left-radius: 5px;   border-bottom: 1px solid #ccc;   border-top-right-radius: 5px;  display:block;  margin: auto;  margin-top: 10px;   ">
               <p style = "color: #33A6DD; padding: 10px; padding-top: 12px; height: 30px;  font-size: 18px;" class = "fa  fa-random" > <span style ="margin-left: 7px; color: #3E3E3E; ">Randomly Awesome Polls!</span> </p>
            </div>
	             <div  style = " margin:0px" class="row">
               <g:each in="${question}">
                  <div style = "text-align: center; padding: 10px; " onmouseover="glow(this)" onmouseout="unGlow(this)"  onClick = "loadQuestionURL('${it.questionID}')"  class="col-xs-6 col-md-4">
                     <div style = "width: 100%; ">
    					  <g:if test="${it.answerOneImage}">
                              <img  style = "max-width:130px; max-height:130px; width: auto; height: auto; margin: auto;   padding: 0px;  " src = "/ShouldIorV1/Question/getAnswerImageById/${it.questionID}:1" />	
                           </g:if>
                           <g:else>
                              <img  style = "max-width:130px; max-height:130px; width: auto; height: auto; margin: auto;   padding: 0px;  " src="${resource(dir:'images',file:'noImg.png')}"  />	
                           </g:else>
                        <div style = "display:block;margin-top: 5px; ">${it.questionTitle}</div>
                     </div>
                  </div>
               </g:each>
            </div>
         </div>
      </div>
      

      </div>
      <!-- /.container -->
      <!-- LOGIN Modal -->
      <div class="modal fade" id="noLogin" role="dialog">
         <div class="modal-dialog">
            <!-- Modal content-->
            <div class="modal-content">
               <div class="modal-header">
                  <button type="button" class="close" data-dismiss="modal">&times;</button>
                  <h4 class="modal-title"><span href="#about" style = "padding-left: 4px;" class='fa fa-exclamation-circle'> </span> Login</h4>
               </div>
               <div class="modal-body">
                  <p>Please login to ask all the questions your hear desires <span class = "fa fa-heart-o"></span></p>
                  <button style = "" type="button" class="btn btn-default" data-dismiss="modal">Login</button>
                  <button style = "" type="button" class="btn btn-default" data-dismiss="modal">Login with Facebook</button>
               </div>
               <div class="modal-footer">
                  <button style = "" type="button" class="btn btn-default" data-dismiss="modal">Close</button>
               </div>
            </div>
         </div>
      </div>
      <!-- LOGIN Modal -->
      <script>
         function showNoLogin() {
         	$('#noLogin').modal('show');
         
         
         }
         
         
         function glow(id) {
         $(id).css("background-color","#F5FAFE")
         }
         
         
         
         function unGlow(id) {
         $(id).css("background-color","")
         }
         
         function loadQuestionURL(url) {
         	window.location.href = "/ShouldIorV1/Question/shouldi/" + url;
         }
         	
         
         
          $(function(){
                $(".element").typed({
                    strings: ["Start a Poll^1000"],
                    typeSpeed: 90,
         		cursorChar: "|",			  
         		backDelay: 500,
         		callback: function(){
         			// $(".typed-cursor").css("display","none");
         			}
                });
            });
         
         
         var substringMatcher = function(strs) {
          return function findMatches(q, cb) {
            var matches, substringRegex;
         
            // an array that will be populated with substring matches
            matches = [];
         
            // regex used to determine if a string contains the substring `q`
            substrRegex = new RegExp(q, 'i');
         
            // iterate through the pool of strings and for any string that
            // contains the substring `q`, add it to the `matches` array
            $.each(strs, function(i, str) {
              if (substrRegex.test(str)) {
                matches.push(str);
              }
            });
         
            cb(matches);
          };
         };
         
         var states = ['Should I go to the bath room', 'Alaska', 'Arizona', 'Arkansas', 'California',
          'Colorado', 'Connecticut', 'Delaware', 'Florida', 'Georgia', 'Hawaii',
          'Idaho', 'Illinois', 'Indiana', 'Iowa', 'Kansas', 'Kentucky', 'Louisiana',
          'Maine', 'Maryland', 'Massachusetts', 'Michigan', 'Minnesota',
          'Mississippi', 'Missouri', 'Montana', 'Nebraska', 'Nevada', 'New Hampshire',
          'New Jersey', 'New Mexico', 'New York', 'North Carolina', 'North Dakota',
          'Ohio', 'Oklahoma', 'Oregon', 'Pennsylvania', 'Rhode Island',
          'South Carolina', 'South Dakota', 'Tennessee', 'Texas', 'Utah', 'Vermont',
          'Virginia', 'Washington', 'West Virginia', 'Wisconsin', 'Wyoming'
         ];
         
         $('#the-basics .typeahead').typeahead({
          hint: true,
          highlight: true,
          minLength: 1
         },
         {
          name: 'states',
          source: substringMatcher(states)
         });
         
         
         
      </script>
   </body>
</html>