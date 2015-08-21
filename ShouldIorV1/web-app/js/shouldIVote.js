function questionVote(vote) {
	if ($('#sessionCheck').val() == "true") {
		  $.ajax({
			  type: 'post',
			    url: "/ShouldIorV1/Question/questionVote",
			    async: true,
			    data: {questionID : $("#questionID").val(), vote: vote},
		  }).done(function(result){
			  if (result.split(":")[0]  == "True") {
				  $("#AnswerOneCount").text("(" + result.split(":")[2] + ")");
				  $("#AnswerTwoCount").text("(" + result.split(":")[3] + ")");
				  $("#diffPercent").html("(" + result.split(":")[4] + ")" + "%");
					$("#AnswerOneCount").css("display","inline-block")
					$("#AnswerTwoCount").css("display","inline-block")
			  } else if (result.split(":")[0]  == "False") {
					$('#noVote').modal('show');
			  } else {
				  // Who knows what the hell went wrong
			  } 
		  });
		}
}

