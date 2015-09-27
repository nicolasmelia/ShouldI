// Gloabal Vars
var connectedToFacebook = false;
var authToken = "";

// This is called with the results from from FB.getLoginStatus().
window.fbAsyncInit = function () {
	FB.init({
		appId : '1625511597708023',
		xfbml : true,
		cookie : true, // enable cookies to allow the server to access the session
		version : 'v2.4'
	});
};

(function (d, s, id) {
	var js,
	fjs = d.getElementsByTagName(s)[0];
	if (d.getElementById(id)) {
		return;
	}
	js = d.createElement(s);
	js.id = id;
	js.src = "//connect.facebook.net/en_US/sdk.js";
	fjs.parentNode.insertBefore(js, fjs);
}
	(document, 'script', 'facebook-jssdk'));

//Get Login Status
function loginFacebook(url) {
	FB.getLoginStatus(function (response) {
		
		// See if user is connected to my app in facebook
		if (response.status === 'connected') {
			loginSuccess(response, $('#facebookLoginLink').val());
		} else {
			FB.login(function (response) {
				if (response.authResponse) {
			loginSuccess(response, url);
				} else {
					console.log('User cancelled login or did not fully authorize.');
				}
			});

		}
	});
	
}

function statusChangeCallback(response) {
	if (response.status === 'connected') {
		// Logged into your app and Facebook.
		loginSuccess(response, 'TEST');
	} else if (response.status === 'not_authorized') {
		// The person is logged into Facebook, but not your app.
	} else {
		// The person is not logged into Facebook, so we're not sure if
		// they are logged into this app or not.
	}
}

function checkLoginState() {
	FB.getLoginStatus(function (response) {
		statusChangeCallback(response);
	});
}

window.fbAsyncInit = function () {
	FB.init({
		appId : '1625511597708023',
		cookie : true, // enable cookies to allow the server to access
		// the session
		xfbml : true, // parse social plugins on this page
		version : 'v2.2' // use version 2.2
	});

	FB.getLoginStatus(function (response) {
		statusChangeCallback(response);
	});

};

// Load the SDK asynchronously
(function (d, s, id) {
	var js,
	fjs = d.getElementsByTagName(s)[0];
	if (d.getElementById(id))
		return;
	js = d.createElement(s);
	js.id = id;
	js.src = "//connect.facebook.net/en_US/sdk.js";
	fjs.parentNode.insertBefore(js, fjs);
}
	(document, 'script', 'facebook-jssdk'));


// ********** CUSTOM SHOULDI.FM FUNCTIONS BELOW **********

function loginSuccess(response, url) { 
			if ($('#sessionCheck').val() == "false" && (response.status === 'connected')) {
	  $.ajax({
		  type: 'post',
		    url: url,
		    async: true,
		    data: {token : response.authResponse.accessToken, userID: response.authResponse.userID},
	  }).done(function(result){
		  if (result == "Success") {
				location.reload();
		  } else if  (result == "Fail") {
			  // Our Server failed to create a session
		  } else {
			  // Who knows what the hell went wrong
		  } 
	  });
			}
	}

function checkFaceBookLogin() {
	if (connectedToFacebook == true) {
		return true;
	} else {
		return false
	}
}







