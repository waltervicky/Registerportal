<!DOCTYPE html>
<html lang="en">
<head>
  <title>Bootstrap Example</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
<header>
<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
  <div class="container-fluid">
    <a class="navbar-brand" href="#"><img src="/img/imgvij.jpg" alt="" width="30" height="24" style="border-radius: 10px;"></a>
    <!-- <a class="navbar-brand" href="#" style="float:right;"></a> -->
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#collapsibleNavbar">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="collapsibleNavbar">
      <ul class="navbar-nav">
        <li class="nav-item">
          <a class="nav-link" href="#">Home</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="#">TournamentPlayed</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="#">AddBankAccount</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="#">HowToPlay</a>
        </li> 
        <li class="nav-item">
          <a class="nav-link" href="#">HelpAndSupport</a>
        </li>     
      </ul>
    </div>
  </div>
</nav>
<div
  class="p-5 text-center bg-image rounded-3"
  style="
    background-image: url('https://mdbcdn.b-cdn.net/img/new/slides/041.webp');
    height: 400px;">
  <!-- <div class="mask" style="background-color: rgba(0, 0, 0, 0.6);">
    <div class="d-flex justify-content-center align-items-center h-100">
      <div class="text-white">
        <h1 class="mb-3">Heading</h1>
        <h4 class="mb-3">Subheading</h4>
        <a class="btn btn-outline-light btn-lg" href="#!" role="button">Call to action</a>
      </div>
    </div>
  </div> -->
</div>
</header>
<div class="container-fluid mt-3">
  
</div>
<input type="hidden" id="hidename2" value="<%=session.getAttribute("userName1") %>">

<script>
$(document).ready(function(){
	
	$("passvalue").load(function(){
			 alert("loaded");
 });
/* function passvalue(){
$.ajax({
	url: "MainPortals",
	method: "GET",
	contentType: "application/json",
	data:JSON.stringify({
		"UserId":loginname,
	}),
	dataType: "json",
	success: function(result){
		 console.log(result);
		 if(result.Status =="Success"){
				alert("Registed Success");
			}else if(result.Status == "Failed"){
				alert(result.Message);
			}
	 },
	 error: function(error){
		 console.log(error);
	 } 
})
} */

</script>
</body>
</html>


