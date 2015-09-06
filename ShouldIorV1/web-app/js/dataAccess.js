function questionVote(vote) {
	
	//Show the checkMark for vote
	if ($("#vote").val() == "NONE") {
	$("#option" + vote  + "Check").css("display","inline-block");
	}
	
	if ($('#sessionCheck').val() == "true") {
		  $.ajax({
			  type: 'post',
			    url: "../../Question/questionVote",
			    async: true,
			    data: {questionID : $("#questionID").val(), vote: vote},
		  }).done(function(result){
			  if (result.split(":")[0]  == "True") {
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

			
			  } else if (result.split(":")[0]  == "False") {
					$('#voteWarn').slideDown();
			  } else {
				  // Who knows what the hell went wrong
			  } 
		  });
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

