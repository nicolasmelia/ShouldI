var votedFor = false;
var clicked = false; // Do not allow another click until server responds

function questionVote(vote) {
	if (!clicked) {
			clicked = true; 
		if (($('#sessionCheck').val() == "true" ||  $('#requireLoginToVote').val() == "false") && votedFor == false) {
			  $.ajax({
				  type: 'post',
				    url: "../../Question/questionVote",
				    async: true,
				    data: {questionID : $("#questionID").val(), vote: vote, requireLoginToVote: $('#requireLoginToVote').val()},
			  }).done(function(result){
				  if (result.split(":")[0]  == "True") {
					  clicked = false;
						//Show the checkMark for vote
					if ($("#vote").val() == "NONE") {
						$("#option" + vote  + "Check").css("display","inline-block");
					}
						
					  votedFor = true;
	
					  $("#vote").val(vote);
					  // Display answer counts after vote
					  var answersCount = result.split(":")
					  var answerNum = 1;
					  for (i = 4; i < answersCount.length; i++) { 	  
						  $("#Answer" + answerNum + "Count").text("(" + answersCount[i] + ")");
						  $("#Answer" + answerNum + "Count").css("display","inline-block")
						  answerNum++;
						}
					  
					  $("#diffPercent").empty();
					  $("#topAnswer").empty();
					  
					  $("#diffPercent").html(result.split(":")[1] + "%");
					  $("#topAnswer").html(result.split(":")[2]);
	      			 
					  var totalVotes =  parseInt(answersCount[4]) + parseInt(answersCount[5]) + 
					  parseInt(answersCount[6]) + parseInt(answersCount[7]);
	
						$("#voteCount").html("Votes: " + totalVotes);
	
						// Fade the old percents
						$("#per1").fadeOut(200);
						$("#per2").fadeOut(200);	
						if ($("#per3").length) {
							$("#per3").fadeOut(200);
						}
						if ($("#per4").length) {
							$("#per4").fadeOut(200);
						}
													
						setTimeout(function(){ 
							  displayMiniGraphs(totalVotes, answersCount[4], answersCount[5],answersCount[6], answersCount[7] );					
						}, 250);
	
				
				  } else if (result.split(":")[0]  == "False") {
					  clicked = false;
					if (result.split(":")[1] == 'voted') {
						$('#voteWarn').slideDown();
					} else if (result.split(":")[1] = 'login' )  {
						showNoLogin();
					}
						
				  } else {					 
					  clicked = false;
					  // Who knows what the hell went wrong
				  } 
			  });
			} else {
				if (votedFor == false) {
					showNoLogin();
					 clicked = false;
				} else {
					$('#voteWarn').slideDown();
					 clicked = false;
				}
			}
	}
}


// Add favorite to users favorites
var allowFav = true;
function addToFavorites(url, id) {
	if ($('#sessionCheck').val() == "true") {
		if (allowFav) { // dont allow button press twice without a response
			allowFav = false;
		  $.ajax({
			  type: 'post',
			    url: url,
			    async: true,
			    data: {questionID : id},
		  }).done(function(result){
				allowFav = true;
			  if (result == "True") {
					$('#starEmpty').css("display", "none");
					$('#starFull').css("display", "inline-block");
			  } else if (result == "Has") {
					$('#starEmpty').css("display", "inline-block");
					$('#starFull').css("display", "none");
			  } else {
				  // Who knows what the hell went wrong prob not logged in.
			  } 
		  });
		}
	}
}

// Comment to main post
function postMainComment() {
	if ($('#sessionCheck').val() == "true") {
		  $.ajax({
			  type: 'post',
			    url: "NONEFORNOW:TODO",
			    async: true,
			    data: {questionID : $("#questionID").val(), comment: $("#commentText").val()},
		  }).done(function(result){
			  if (result == "True") {
				  	alert("RELOAD");
			  } else if (result == "False") {
					$('#voteWarn').css('display', 'block');
			  } else {
				  // Who knows what the hell went wrong
			  } 
		  });
		}
}


// ******** LOGIN SYSTEMS ********
function loginReddit(url) {
	// Simply opens the login page for reddit
	window.location.href = url;
}

function showNoLogin() {
  	$('#noLogin').modal('show'); 
  }
  

function logout(urlHome, urlLogout) {
	  $.ajax({
		  type: 'post',
		    url: urlLogout,
		    async: true,
		    data: {logout : "true"},
	  }).done(function(result){
		  if (result == "Success:Facebook") {
			// logout of serverfirst then facebook.  
			  FB.logout(function(response) {
		         	window.location.href =  urlHome;
				});
		  } else if  (result == "Success:Reddit") {
	         	window.location.href =  urlHome;
		  } else {
	         	window.location.href =  urlHome;
		  } 
	  });
}