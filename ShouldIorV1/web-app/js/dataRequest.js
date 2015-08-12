

function getStuff() {
	  $.ajax({
		  type: 'post',
		    url: "/ShouldIorV1/Authentication/loginFaceBook",
		    async: true,
		    data: { action : 'test', test: "hello" },
	  }).done(function(result){
	    	alert("HERE" + data)
	        console.log(data); 
	  });
}

function getJson() {
	

}
