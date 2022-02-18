<html>
<head>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
<link href="/portal/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>
   <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

  <!-- Bootstrap CSS -->
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
<link rel="stylesheet" href="css/loader.css">
<jsp:include page="loader.jsp"></jsp:include>
 <style>
  /* set entire body that is webpage */
body{
	background: #383a3d;
	padding-top: 25vh;	
}
/* set form background colour*/
form{
	background: #fff;
}
/* set padding and size of th form */
.form-container{
	border-radius: 10px;
	padding: 30px;
}

/* eye */
i {
    margin-left: 391px;
    margin-top: -26px;
    cursor: pointer;
}
</style>

</head>

<body>
  <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->

<!-- Login form creation starts-->
  <section class="container-fluid" id="login_panel">
    <!-- row and justify-content-center class is used to place the form in center -->
    <section class="row justify-content-center">
      <section class="col-12 col-sm-6 col-md-4">
        <form class="form-container">
        <div class="form-group">
          <h4 class="text-center font-weight-bold"> Login </h4>
          <label for="username">username</label>
           <input type="text" class="form-control" name="username" id="username" aria-describeby="emailHelp" placeholder="username">
        </div>
        <div class="form-group">
          <label for="loginPassword">Password</label>
          <input type="password" class="form-control" id="loginPassword" name="loginPassword" placeholder="Password">
          <input type="checkbox" onclick="myFunction()">Show Password
        </div>
        <input type="button" class="button btn btn-primary btn-block" value="Login" onclick="login()">
        <div class="form-footer">
          <p> Don't have an account? <a href="#" id="signUpRedir">Sign Up</a></p>
          <a href="/portal/ForgetPassword" id="forgot_Password">Forget Password</a>
        </div>
        <!-- <div class="form-footer" style="">
          
          
        </div> -->
        </form>
      </section>
    </section>
  </section>
<!-- Login form creation ends -->





<section class="container-fluid" id="signup_panel" style="display: none; margin-top: -106px;">
    <!-- row and justify-content-center class is used to place the form in center -->
    <section class="row justify-content-center">
      <section class="col-12 col-sm-6 col-md-4">
        <form class="form-container">
        <div class="form-group">
          <h4 class="text-center font-weight-bold"> Register </h4>
          <label for="loginName">UserName</label>
           <input type="text" class="form-control" id="loginName" name="loginName" aria-describeby="emailHelp" placeholder="Name">
        </div>
        <div class="form-group">
          <label for="FullName">FullName</label>
           <input type="text" class="form-control" id="fullName" name="FullName" maxlength=30 aria-describeby="emailHelp" placeholder="Enter email">
        </div>
        <div class="form-group">
          <label for="emailAddress">Email</label>
           <input type="email" class="form-control" id="emailAddress" name="emailAddress" maxlength=30 aria-describeby="emailHelp" placeholder="Enter email">
        </div>
        <div class="form-group">
          <label for="phone">phone</label>
           <input type="text" class="form-control" id="phone" name="phone" aria-describeby="emailHelp" placeholder="phone">
        </div>
        <div class="form-group">
          <label for="password">Password</label>
          <input type="password" class="form-control" id="password" name="password" placeholder="Password">
        </div>
        <div class="form-group">
          <label for="password">Password</label>
          <input type="password" class="form-control" id="passwordCon" name="passwordCon" placeholder="passwordCon">
        </div>
        <input type="button" class="button btn btn-primary btn-block" value="register" onclick="register();" id="submit">
        <div class="form-footer">
           <a href="#" id="back_to_login">back to login</a>
          
        </div>
        
        </form>
      </section>
    </section>
  </section>

<input type="hidden" id="hdnMode" value="<%=session.getAttribute("mode") %>">
<script	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.min.js" integrity="sha256-VazP97ZCwtekAsvgPBSUwPFKdrwD3unUfSGVYrahUqU=" crossorigin="anonymous"></script>
<script src="/portal/js/comman.js"></script>



</body>
</html>