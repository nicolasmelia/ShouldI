var votedFor = false;
function questionVote(vote) {
	if (($('#sessionCheck').val() == "true" ||  $('#requireLoginToVote').val() == "false") && votedFor == false) {
		  $.ajax({
			  type: 'post',
			    url: "../../Question/questionVote",
			    async: true,
			    data: {questionID : $("#questionID").val(), vote: vote, requireLoginToVote: $('#requireLoginToVote').val()},
		  }).done(function(result){
			  if (result.split(":")[0]  == "True") {
				  
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

					$("#per1").fadeOut(900);
					$("#per2").fadeOut(900);
		
					setTimeout(function(){ 
						  displayMiniGraphs(totalVotes, answersCount[4], answersCount[5],answersCount[6], answersCount[7] );					
					}, 1000);

			
			  } else if (result.split(":")[0]  == "False") {					
				if (result.split(":")[1] == 'voted') {
					$('#voteWarn').slideDown();
				} else if (result.split(":")[1] = 'login' )  {
					alert("LOGIN PLEASE1");
				}
					
			  } else {
				  // Who knows what the hell went wrong
			  } 
		  });
		} else {
			if (votedFor == false) {
				alert("LOGIN PLEASE2");
			} else {
				$('#voteWarn').slideDown();
			}
		}
}


// Comment to main post
function postMainComment() {
	if ($('#sessionCheck').val() == "true") {
		  $.ajax({
			  type: 'post',
			    url: "../../Comment/postMainComment",
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

