<% String status=(String)request.getParameter("status"); %>

<!DOCTYPE html>
<html>
<head>
	<title>Signup</title>

	<link href="css/bootstrap.min.css" rel="stylesheet">
    <link href='https://fonts.googleapis.com/css?family=Hind' rel='stylesheet' type='text/css'>
    <link href="font-awesome-4.6.3/css/font-awesome.css" rel="stylesheet">
 <link rel="stylesheet" type="text/css" href="css/style.css">
    <link href='https://fonts.googleapis.com/css?family=Josefin+Slab' rel='stylesheet' type='text/css'>
    <link href='https://fonts.googleapis.com/css?family=Rokkitt' rel='stylesheet' type='text/css'>
    <link href='https://fonts.googleapis.com/css?family=Noto+Serif' rel='stylesheet' type='text/css'>
     <link rel="icon" href="img/icon.png">
     <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
    <script src="js/validator.js"></script>

</head>
<body>


    <nav class="navbar navbar-default nav-background navbar-fixed-top">
  <div class="container-fluid">
    <!-- Brand and toggle get grouped for better mobile display -->
    <div class="navbar-header">
      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
      <a class="navbar-brand " href="index.jsp" ><i class="fa fa-check-square-o nav-color"></i> <b><span class="logo-fonts nav-color"> Voteitup!</span></b></a>
    </div>

    <!-- Collect the nav links, forms, and other content for toggling -->
    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
      <ul class="nav navbar-nav">
  
        
      </ul>
      
      <ul class="nav navbar-nav navbar-right">
        <li><a href="Polls"><span class="nav-color" style="font-family: 'Noto Serif', serif;"><i class="fa fa-refresh fa-spin"></i> Public Polls</span></a></li>
        <li><a href="Registration" ><span class="nav-color" style="font-family: 'Noto Serif', serif;">SignUp</span></a></li>
        <li><a href="login"><span class="nav-color" style="font-family: 'Noto Serif', serif;">Login</span></a></li>
      </ul>
    </div><!-- /.navbar-collapse -->
  </div><!-- /.container-fluid -->
</nav>

    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="js/bootstrap.min.js"></script>

<br/>
<br/>
<br/>


<%
if(status != null)
{
	if(status.equals("1")) 
	{
	out.print("<div class='alert alert-success' role='alert'><center> You have registed Successfully! please login</a></center></div>");
	}
	if( status.equals("2"))
	{
	out.print("<div class='alert alert-danger' role='alert'><center> <a class='alert-link'>This Email Id is already registed with us</a></center></div>");
	}
}

%>
    <!--login form-->
   
<!--<div class="alert alert-success" role="alert">
 <center> <a href="#" class="alert-link"> Poll Added Successfully!</a></center>
</div> 

<div class="alert alert-danger" role="alert">
  <center><a href="#" class="alert-link">Opps something went wrong!</a></center>
</div>

-->

    
<form class="form-horizontal" method="post" action="UserRegister" id="form" data-toggle="validator" >

<div class="container">
<div class="jumbotron">
<center><img src="img/register.png" height="100px;" width="280px;"></center>
 <center><legend style="font-family: 'Noto Serif', serif;"><br/></legend></center>
 <fieldset>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="textinput" style="font-family: 'Noto Serif', serif;">Name:</label>  
  <div class="col-md-5">
  <input id="textinput" name="name" type="text" placeholder="Enter your Name" class="form-control input-md" required>
  <div class="help-block with-errors"></div>
    
  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="textinput" style="font-family: 'Noto Serif', serif;">Email ID:</label>  
  <div class="col-md-5">
  <input  name="email" type="email" placeholder="Enter your Email ID" id="inputEmail" data-error="Bruh, that email address is invalid" class="form-control input-md" required>
  <div class="help-block with-errors"></div>
    
  </div>
</div>

<!-- Password input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="password" style="font-family: 'Noto Serif', serif;">Password:</label>
  <div class="col-md-5">
    <input id="password" name="password" type="password" placeholder="Enter Your Password" class="form-control input-md" required>
    <div class="help-block with-errors"></div>
    
  </div>
</div>
<!-- RePassword input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="password" style="font-family: 'Noto Serif', serif;">Re-Password:</label>
  <div class="col-md-5">
    <input id="password" name="password" type="password" placeholder="ReEnter Your Password" class="form-control input-md" data-match="#password" data-match-error="whoops, that didn't match" required>
    <div class="help-block with-errors"></div>
    
  </div>
</div>

<!-- Button -->
<div class="form-group">
  <label class="col-md-4 control-label" for="singlebutton"></label>
  <div class="col-md-4">
    <button id="singlebutton" name="singlebutton" class="btn btn-success" style="font-family: 'Noto Serif', serif;">Register</button>
    
  </div>


</div>
</div>
</fieldset>
</form>
</div>


</body>
</html>