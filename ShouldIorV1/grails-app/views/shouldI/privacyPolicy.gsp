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
      <title>ShouldI.fm - Policy</title>
       <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
      
    
	 <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
  
    <!-- Bootstrap core CSS -->
      <link rel="stylesheet" type="text/css" href="<g:resource dir='css' file='bootstrap.css'/>">
      <link rel="stylesheet" type="text/css" href="<g:resource dir='css' file='buttons.css'/>">
      <link rel="stylesheet" type="text/css" href="<g:resource dir='css' file='awesome-bootstrap-checkbox.css'/>">
	   
	 <!-- Bootstrap core JS -->
	<script src="<g:resource dir="js" file="bootstrap.min.js" />"></script>
			
	 <!-- facebook login -->
	<g:javascript src="facebookLogin.js" />
	 <g:javascript src="dataAccess.js" />
	

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
  


  <body style = "background-color: #f4f4f4; min-width: 330px; margin-bottom: 15px; ">
  
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
                  <li><a href = "${createLink(controller: 'Question', action: 'askShouldIQuick')}" ><span class= 'fa fa-pencil-square-o'></span><span style = "padding-left: 6px;" >Ask</span></a></li>
                  <li><a href = "${createLink(controller: 'ShouldI', action: 'category', params: [category: 'Trending'])}" ><span class= 'fa fa-book'></span><span style = "padding-left: 6px;" >Browse Categories</span></a></li>
               </g:if>
               <g:else>
                  <li><a href = "${createLink(controller: 'Question', action: 'askShouldIQuick')}" ><span class= 'fa fa-pencil-square-o'></span><span style = "padding-left: 6px;" >Ask</span></a></li>
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

    <div class="container" style = "max-width: 725px; ">
		
	<!-- Question form -->	
		<div  class="jumbotron" style="overflow: none;  display: block; box-shadow:0 0 10px rgba(0, 0, 0, 0.15); min-height: 100px; margin: auto; min-width: 200px; margin-top: 65px;  max-width: 755px; padding: 8px; margin-bottom: 20px; background-color: #FDFDFD;  ">
			<h2  style = "color: #6f6f6f; width: 100%; text-align: center; margin: auto; padding: 15px; ">Privacy Policy</h2>
			<div>
			
			<div class = "well" style = "display: block; width: 98%; margin: auto;">
				<b><span style = "color: #337ab7">www.shouldi.fm Privacy Policy</span></b> <br>
							
			This privacy policy has been compiled to better serve those who are concerned with how their 'Personally identifiable information' (PII) is being used online. PII, as used in US privacy law and information security, is information that can be used on its own or with other information to identify, contact, or locate a single person, or to identify an individual in context. Please read our privacy policy carefully to get a clear understanding of how we collect, use, protect or otherwise handle your Personally Identifiable Information in accordance with our website.
			<br><br>
			<b>What personal information do we collect from the people that visit our blog, website or app?</b>
			<br>
			When ordering or registering on our site, as appropriate, you may be asked to enter your name, Poll Information or other details to help you with your experience.
			<br><br>
			<b>When do we collect information?</b>
			<br>
			We collect information from you when you register on our site, respond to a survey, fill out a form Create Poll or enter information on our site.
			<br><br>
			
			<b>do we use your information?</b>
			<br>
			We may use the information we collect from you when you register, make a purchase, sign up for our newsletter, respond to a survey or marketing communication, surf the website, or use certain other site features in the following ways:
			
			      • To personalize user's experience and to allow us to deliver the type of content and product offerings in which you are most interested.
			      • To improve our website in order to better serve you.
			      • To allow us to better service you in responding to your customer service requests.
			      • To administer a contest, promotion, survey or other site feature.
			<br><br>
			<b> do we protect visitor information?</b>
			<br>
			Our website is scanned on a regular basis for security holes and known vulnerabilities in order to make your visit to our site as safe as possible.
			
			We use regular Malware Scanning.
			
			Your personal information is contained behind secured networks and is only accessible by a limited number of persons who have special access rights to such systems, and are required to keep the information confidential. In addition, all sensitive/credit information you supply is encrypted via Secure Socket Layer (SSL) technology.
			
			We implement a variety of security measures when a user enters, submits, or accesses their information to maintain the safety of your personal information.
			
			All transactions are processed through a gateway provider and are not stored or processed on our servers.
			<br><br>
			<b>Do we use 'cookies'?</b>
			<br>
			Yes. Cookies are small files that a site or its service provider transfers to your computer's hard drive through your Web browser (if you allow) that enables the site's or service provider's systems to recognize your browser and capture and remember certain information. For instance, we use cookies to help us remember and process the items in your shopping cart. They are also used to help us understand your preferences based on previous or current site activity, which enables us to provide you with improved services. We also use cookies to help us compile aggregate data about site traffic and site interaction so that we can offer better site experiences and tools in the future.
			
			We use cookies to:
			      • Understand and save user's preferences for future visits.
			      • Compile aggregate data about site traffic and site interactions in order to offer better site experiences and tools in the future. We may also use trusted third party services that track this information on our behalf.
			
			You can choose to have your computer warn you each time a cookie is being sent, or you can choose to turn off all cookies. You do this through your browser (like Internet Explorer) settings. Each browser is a little different, so look at your browser's Help menu to learn the correct way to modify your cookies.
			
			If users disable cookies in their browser:
			
			If you disable cookies off, some features will be disabled It will turn off some of the features that make your site experience more efficient and some of our services will not function properly.
			
			<br><br>
			
			<b>Third Party Disclosure</b>
			
			We do not sell, trade, or otherwise transfer to outside parties your personally identifiable information unless we provide you with advance notice. This does not include website hosting partners and other parties who assist us in operating our website, conducting our business, or servicing you, so long as those parties agree to keep this information confidential. We may also release your information when we believe release is appropriate to comply with the law, enforce our site policies, or protect ours or others' rights, property, or safety. 
			
			However, non-personally identifiable visitor information may be provided to other parties for marketing, advertising, or other uses.
			Poll Information and results.
			
			Third party links
			
			We do not include or offer third party products or services on our website.
			<br><br>
			<b>Google</b>
			<br>
			Google's advertising requirements can be summed up by Google's Advertising Principles. They are put in place to provide a positive experience for users.
			
			We use Google AdSense Advertising on our website.
			
			Google, as a third party vendor, uses cookies to serve ads on our site. Google's use of the DART cookie enables it to serve ads to our users based on their visit to our site and other sites on the Internet. Users may opt out of the use of the DART cookie by visiting the Google ad and content network privacy policy.
			
			We have implemented the following:
			      • Remarketing with Google AdSense
			      • Google Display Network Impression Reporting
			      • Demographics and Interests Reporting
			      • DoubleClick Platform Integration
			
			We along with third-party vendors, such as Google use first-party cookies (such as the Google Analytics cookies) and third-party cookies (such as the DoubleClick cookie) or other third-party identifiers together to compile data regarding user interactions with ad impressions, and other ad service functions as they relate to our website.
			<br><br>
			<b>Opting out:</b><br>
			Users can set preferences for how Google advertises to you using the Google Ad Settings page. Alternatively, you can opt out by visiting the Network Advertising initiative opt out page or permanently using the Google Analytics Opt Out Browser add on.
			<br><br>
			<b>California Online Privacy Protection Act</b><br>
			
			CalOPPA is the first state law in the nation to require commercial websites and online services to post a privacy policy. The law's reach stretches well beyond California to require a person or company in the United States (and conceivably the world) that operates websites collecting personally identifiable information from California consumers to post a conspicuous privacy policy on its website stating exactly the information being collected and those individuals with whom it is being shared, and to comply with this policy. - See more at: http://consumercal.org/california-online-privacy-protection-act-caloppa/#sthash.0FdRbT51.dpuf
			
			According to CalOPPA we agree to the following:
			Users can visit our site anonymously
			Once this privacy policy is created, we will add a link to it on our home page, or as a minimum on the first significant page after entering our website.
			Our Privacy Policy link includes the word 'Privacy', and can be easily be found on the page specified above.
			
			Users will be notified of any privacy policy changes:
			      • On our Privacy Policy Page
			Users are able to change their personal information:
			      • By logging in to their account
			<br><br>
			<b>How does our site handle do not track signals?</b><br>
			We honor do not track signals and do not track, plant cookies, or use advertising when a Do Not Track (DNT) browser mechanism is in place.
			<br><br>
			<b>Does our site allow third party behavioral tracking?</b><br>
			It's also important to note that we do not allow third party behavioral tracking
			<br><br>
			<b>COPPA (Children Online Privacy Protection Act)</b>
			<br>
			When it comes to the collection of personal information from children under 13, the Children's Online Privacy Protection Act (COPPA) puts parents in control. The Federal Trade Commission, the nation's consumer protection agency, enforces the COPPA Rule, which spells out what operators of websites and online services must do to protect children's privacy and safety online.
			
			We do not specifically market to children under 13.
			<br><br>
			<b>Fair Information Practices</b><br>
			
			The Fair Information Practices Principles form the backbone of privacy law in the United States and the concepts they include have played a significant role in the development of data protection laws around the globe. Understanding the Fair Information Practice Principles and how they should be implemented is critical to comply with the various privacy laws that protect personal information.
			
			In order to be in line with Fair Information Practices we will take the following responsive action, should a data breach occur:
			We will notify the users via in site notification
			      • Within 1 business day
			
			We also agree to the individual redress principle, which requires that individuals have a right to pursue legally enforceable rights against data collectors and processors who fail to adhere to the law. This principle requires not only that individuals have enforceable rights against data users, but also that individuals have recourse to courts or a government agency to investigate and/or prosecute non-compliance by data processors.
			<br><br>
			<b>CAN SPAM Act</b><br>
			
			The CAN-SPAM Act is a law that sets the rules for commercial email, establishes requirements for commercial messages, gives recipients the right to have emails stopped from being sent to them, and spells out tough penalties for violations.
			
			We collect your email address in order to:
			
			To be in accordance with CANSPAM we agree to the following:
			
			If at any time you would like to unsubscribe from receiving future emails, you can email us at
			and we will promptly remove you from ALL correspondence.
			<br><br>
			
			<b>Contacting Us</b>
			<br>
			If there are any questions regarding this privacy policy you may contact us using the information below.
			<br>
			Email: PollarisPolls@gmail.com
			<br>
			Last Edited on 2015-10-04
			<br>
			</div>
			
		</div>
		
    </div><!-- /.container -->
    
    		<footer class="footer" style = "margin-top: -13px;  width: 100%;" >
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

    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
  
    
    <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.3.14/angular.min.js"></script>
    
	 <script src="<g:resource dir="js/tagsJS" file="bootstrap-tagsinput-angular.js" />"></script>
	 <script src="<g:resource dir="js/tagsJS" file="bootstrap-tagsinput.js" />"></script>
     <link rel="stylesheet" type="text/css" href="<g:resource dir='js/tagsJS' file='bootstrap-tagsinput.css'/>">
	
	<script>

	$( document ).ready(function() {
 
	});


	function displayHelpText(id) {
		if (!$(id).is(':visible')) {
			// Help text for ID is hidden, display it
			$(id).slideDown();
		} else {
			// Hide the help text
			$(id).slideUp();
		}
	}
	
	</script>
	
	
  </body>
</html>
