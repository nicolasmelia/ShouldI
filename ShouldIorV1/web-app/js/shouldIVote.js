function questionVote(vote) {
	if ($('#sessionCheck').val() == "true") {
		  $.ajax({
			  type: 'post',
			    url: "/ShouldIorV1/Question/questionVote",
			    async: true,
			    data: {questionID : $("#questionID").val(), vote: vote},
		  }).done(function(result){
			  if (result.split(":")[0]  == "TRUE") {
				  $("#AnswerOneCount").text("(" + result.split(":")[2] + ")");
				  $("#AnswerTwoCount").text("(" + result.split(":")[3] + ")");
			  } else if (result.result.split(":")[0]  == "FAIL") {
				  // Our Server failed to create a session
			  } else {
				  // Who knows what the hell went wrong
			  } 
		  });
		}
}

