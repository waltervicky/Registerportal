let mode = $("#hdnMode").val();
if (mode === "forget") {
	$("#signup_panel").show();
	$("#login_panel").hide();
}

$(document).ready(function(){
	/* $("#signUpRedir").on("click", function(){
	$('#login_panel').hide();
	$('#signup_panel').show();
	});
	$("#back_to_login").on("click", function(){
		$('#login_panel').show();
		$('#signup_panel').hide();
	}); */
	
	
	//slide need to implement
	 $("#signUpRedir").on("click", function() {
		$("#login_panel").hide("slide", {
			direction : "left"
		}, 500, function() {
			$("#signup_panel").show("slide", {
				direction : "right"
			}, 500);
		});
	});
	$("#back_to_login").on("click", function() {
		$("#signup_panel").hide("slide", {
			direction : "left"
		}, 500, function() {
			$("#login_panel").show("slide", {
				direction : "right"
			}, 500);
		});
	}); 
	  
});

function register(){
	
	 
	
	var loginname = $("#loginName").val();
	var fullname = $("#fullName").val();
	var Email = $("#emailAddress").val();
	var Phone = $("#phone").val();
	var pass = $("#password").val();
	
	$.ajax(
			{
				url:"register", 
				 method:"POST",
				 data:JSON.stringify({
					 "loginName": loginname,
				     "fullName": fullname,
					 "emailAddress": Email,
					 "phone": Phone,
					 "password": pass
				 }),
			     contentType: "application/json",
				 success: function(result){
					 console.log(result);
					 if(result.Status =="Success"){
							swal.fire(
						      'Success!',
						      'Registered Successfully.',
						      'success'
						    )
						}else if(result.Status == "Failed"){
							swal.fire(
						      'Error!',
						      result.Message,
						      'error'
						    )
						}
				 },
				 error: function(error){
					 console.log(error);
				 } 
			});
}

function login(){			
	var loginname = $("#username").val();	
	//var email = $("#emailAddress").val();
	var pass = $("#loginPassword").val();
				
	$.ajax({		
		url: "userlogin",
		method: "POST",
		/*contentType: "application/json",*/
		data:{
        	"lname": loginname,
           /* "emailAddress": email,*/
			"paswd": pass
		},
		dataType: "json",
		success: function(result){
			console.log(result);
			if(result.Status =="Success"){
				location.href="MainPortal";
			}else if(result.Status == "Failed"){
				alert(result.Message);
			}
			
		},
	   	error: function(error){
			alert("error");
			console.log(error);
		}
	});	
			 
}

function userprofile(){
	let userId = location.pathname.split("/MainPortal/")[1];

	//alert("userId "+userId);
	var userid = document.getElementById("hidename2").value;
	console.log(userid);
	$.ajax({
		url: "/portal/userInformation/getUserInfo/"+userid,
		method: "GET",
		/*contentType: "application/json",
		data:JSON.stringify({
			"UserId":userId,
		}),*/
		dataType: "json",
		success: function(result){
			document.getElementById("userName").value = result.loginName;
			document.getElementById("eMail").value = result.emailAddress;
			document.getElementById("phone").value = result.phone;
			document.getElementById("Password").value = result.password;
			 console.log(result);
		 },
		 error: function(error){
			 console.log(error);
		 } 
	})
}

function update(){
	let userLoginForm = new FormData(); 
	let userLogin = {};
	    userLogin.userId = document.getElementById("hidename2").value;
        userLogin.loginName = document.getElementById("userName").value;
	    userLogin.emailAddress = document.getElementById("eMail").value;
		userLogin.phone = document.getElementById("phone").value;
		userLogin.password = document.getElementById("Password").value;
		userLogin.photo = document.createElement("wizardPicturePreview").value;
		
		console.log("userLogin", JSON.stringify(userLogin));
		console.log("update file", document.getElementById("wizard-picture").files[0]);
		
		userLoginForm.append("userLoginst", JSON.stringify(userLogin));
		userLoginForm.append("profile", document.getElementById("wizard-picture").files[0]);
		
		$.ajax(
			{
				url:"/portal/userInformation/update", 
				 method:"POST",
				cache: false,
			    contentType: false,
			    processData: false,
				 data:userLoginForm,
			     //contentType: "application/json",
				 success: function(result){
					 console.log(result);
					 if(result.Status =="Success"){
							swal.fire(
						      'Success!',
						      'Your Details has been Updated.',
						      'success'
						    )
						}else if(result.Status == "Failed"){
							swal.fire(
						      'Error!',
						      result.Message,
						      'error'
						    )
						}
				 },
				 error: function(error){
					 console.log(error);
				 } 
			});
		
}


//eyecon

       function myFunction() {
  var x = document.getElementById("loginPassword");
  if (x.type === "password") {
    x.type = "text";
  } else {
    x.type = "password";
  }
}

$("#hidename3").val();

//$('html, body').animate({
//        scrollTop: $(hash).offset().top
//      }, 900, function(){
//   
//        // Add hash (#) to URL when done scrolling (default click behavior)
//        window.location.hash = hash;
//      });
//  
//  $(window).scroll(function() {
//    $(".slideanim").each(function(){
//      var pos = $(this).offset().top;
//
//      var winTop = $(window).scrollTop();
//        if (pos < winTop + 200) {
//          $(this).addClass("slide");
//        }
//    });
//  });



