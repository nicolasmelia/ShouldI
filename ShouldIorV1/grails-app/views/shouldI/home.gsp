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
	

	<!-- font-awesome -->]
	<link rel='stylesheet' href='https://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css'>

     <link rel="stylesheet" type="text/css" href="<g:resource dir='css' file='typehead-searchBar.css'/>">


	<script src="<g:resource dir="js/typedJS" file="typed.min.js" />"></script>

	<script src="<g:resource dir="js/typeaheadJS" file="typeahead.jquery.min.js" />"></script>

	
    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
  </head>
  
  <body style = "background-image:url('${resource(dir: "images", file: "wall1.jpg")}');  background-size: cover;  background-attachment: fixed; min-width: 330px;  ">


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
			<li><a href="#">Popular Questions</a></li>		
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

		<!-- container -->	
		<div  class="" style="overflow: auto;  display: block; min-height: 500px; margin: auto; min-width: 300px;  margin-top: 30px;  max-width: 775px; padding-left: 0px; padding-right: 0px; padding-top: 0px; padding-bottom: 0px;  margin-bottom: 20px;   ">
			
		
			<div class="form-group">
					<p style = "margin:auto; width: 80%; display: none; text-align: center; margin-top: 60px; min-height: 50px; font-size: 30px; color: #ffffff;" id = "logo">ShouldI.FM</p>

					<div style = "height: 30px; margin: auto; margin-top: 40px; display: block; text-align: bottom; overflow: none;">
					<p class = "" style = " font-size: 25px; color: #F4F4F4; display: inline-block;"></p>
					<p class = "element" style = " font-size: 25px; color: #F4F4F4; display: inline-block;"  ></p>
					</div>

					<div id="the-basics" style = "padding: 0px; margin: auto; display: block; margin-top: 12px; text-align: center;">
                <div class="icon-addon addon-lg" style = "color: #5BC0DE;" >
                    <input type="text" placeholder="Should I..."   style = "  margin: auto;  background-color: rgba(255,255,255,0.9);   " class="form-control typeahead "  id="email">
                    <label for="email" class='fa fa-search' rel="tooltip" title="email"></label>	
                </div>
				</div>
				
				
				<div style = "display:none; width: 80%; margin: auto;">
						<div style = "margin: 0px; display:inline-block;">
			<p style = "margin-bottom: -10px;  color: white; padding: 10px; padding-top: 0px;  font-size: 18px;" class = "fa fa-star" > <span style ="margin-left: 7px;">Popular Now</span> </p>
			</div>
			
				<div style = "margin: 0px;  display:inline-block;  ">
			<p style = "margin-bottom: -10px;  color: white; padding: 10px; padding-top: 0px;  font-size: 18px;" class = "fa fa-star" > <span style ="margin-left: 7px;">Newest</span> </p>
			</div>
			</div>
				
				
            </div>
			
					
	
			
					<div style = "margin: 0px;  border-top-left-radius: 5px;    border-bottom: 1px solid #ccc;   border-top-right-radius: 5px;  display:block; background-color: rgba(255,255,255,0.9);  margin: auto;   ">
			<p style = "color: #FD7B7B; padding: 10px; padding-top: 12px; height: 30px;  font-size: 18px;" class = "fa  fa-fire" > <span style ="margin-left: 7px; color: #3E3E3E; ">Popular Right Now</span> </p>
			</div>
			
				<div  class="jumbotron" style="    border-top-left-radius: 0px;    border-top-left-radius: 0px; background-color: rgba(255,255,255,0.9); overflow-y: scroll;   padding: 0px; padding-top: 10px;   height: 250px;  display: block; margin: auto; margin-top: 0px;  ">
	
			
			<g:each in="${question}">

				<div style = " margin: auto; width: 98%;   padding: 5px;  display: table;"> 
				
				<div  style = 'width: 118px; display:table-cell;  ' >
					<img  style = "width: 110px; margin: auto;  padding: 0px;  " src = "/ShouldIorV1/question/getAnswerOneImageById/${it.questionID}" />	
				</div>
					
					<p style = " display:table-cell;    color: #414141;  text-align: left; vertical-align: top; padding:0px; margin-bottom: 0px; font-size: 17px;">
						<span style = "display:block;    margin-bottom: -4px;" >Nicolas Melia</span> 
						<span style = "display:block;  color: #6A6A6A; " >${it.questionTitle}</span> 
						<span style = "display:block;     " >
						<span class = "fa fa-line-chart"  style = "color: #5BC0DE; margin-right: 5px;" ></span>${it.totalVotes}
						<span class = "fa fa-comments" style = "color: #5BC0DE; margin-left: 8px; margin-right: 5px; "  > </span>10k  
						</span> 
	
					</p>
				
					</div>
					
					<hr style = "margin-top: 5px;  border-top: 1px solid #ccc; margin-bottom: 8px; padding-top: 0px; width:100%;">
		</g:each>

		</div>
		<!-- container -->	
		

				


		</div>
		
		

		
    </div><!-- /.container -->



	<script>
	
	 $(function(){
        $(".element").typed({
            strings: ["Ask. ^600 Share. ^600 Answer."],
            typeSpeed: 70,
			 cursorChar: "|",			  
			backDelay: 500
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
	
	$('#tagsInput1').tagsinput({
	  maxChars: 10
	});
	
	$( document ).ready(function() {
	
	$("#anonymousCheckbox").click(function() {
	  if (this.checked) {
	  alert($('#tagsInput1').val());
	  	$("#postingAs").html("Posting as anonymous");
	  } else {
		$("#postingAs").html("Posting as Nicolas");
	  }

	});
   
});
	

	</script>
	
	
	
	
	
	
	
	
	
	
	
	
  </body>
</html>
