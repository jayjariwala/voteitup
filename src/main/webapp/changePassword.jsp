<%@page import="com.voteitup.BEAN.SessionBean" %>

<% SessionBean bean=(SessionBean)session.getAttribute("session"); %>
<%if(bean == null)
{
%>
<jsp:forward page="index.jsp"></jsp:forward>>
<%	
}
%>
<%String status=request.getParameter("status");
System.out.println("status:"+status);
%>

<!DOCTYPE html>
<html>
<head>
	<title>Change Password</title>

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
      <a href="dashboard" class="navbar-brand "><i class="fa fa-check-square-o nav-color"></i> <b><span class="logo-fonts nav-color"> Voteitup!</span></b></a>

        <center><span class="visible-sm visible-xs"> <a class="navbar-brand " style="font-family: 'Noto Serif', serif; color: white "><i class="fa fa-user"></i><span class="nav-color"><%=bean.getName() %></span></a></span></center>

     
    </div>

    <!-- Collect the nav links, forms, and other content for toggling -->
    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
      <ul class="nav navbar-nav">
  
        
      </ul>
      
      <ul class="nav navbar-nav navbar-right">


      <li><a href="publicpolls"><span class="nav-color" style="font-family: 'Noto Serif', serif;"><i class="fa fa-refresh fa-spin"></i> Public Polls</span></a></li>
            <li class="visible-sm visible-xs"><a href="dashboard"><span class="nav-color" style="font-family: 'Noto Serif', serif;"><i class="fa fa-dashboard"></i> DashBoard </span></a></li>
            <li class="visible-sm visible-xs"><a href="mypolls"><span class="nav-color" style="font-family: 'Noto Serif', serif;"><i class="fa fa-cube"></i> My Polls</span></a></li>
            <li role="separator" class="divider"></li>
            <li class="visible-sm visible-xs"><a href="changepassword"><span class="nav-color" style="font-family: 'Noto Serif', serif;"><i class="fa fa-wrench"> </i> Change Password</span></a></li>
            <li class="visible-sm visible-xs"><a href="logout"><span class="nav-color" style="font-family: 'Noto Serif', serif;">Logout</span></a></li>
     
        
          <li class="dropdown visible-md visible-lg ">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false"><span class="nav-color" style="font-family: 'Noto Serif', serif;"><i class="fa fa-user"></i> <%=bean.getName() %> <span class="caret"></span></a>
          <ul class="dropdown-menu">
            <li><a href="dashboard"><i class="fa fa-dashboard"></i> DashBoard</a></li>
            <li><a href="mypolls"><i class="fa fa-cube"></i> My Polls</a></li>
            <li role="separator" class="divider"></li>
            <li><a href="changepassword"><i class="fa fa-wrench"> </i> Change Password</a></li>
            <li role="separator" class="divider"></li>
            <li><a href="logout"><span  style="font-family: 'Noto Serif', serif;">Logout</span></a></li>
          </ul>
        </li>



        
      </ul>
    </div><!-- /.navbar-collapse -->
  </div><!-- /.container-fluid -->
</nav>

    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="js/bootstrap.min.js"></script>
    <script>
        if($("#newPass").val() != ("#reNewPass").val())
        {
          $("rePassError").html("Password Doesn't match");
          return false;
        }
        else
        {
         $("rePassError").html(""); 
        }


    </script>


<div class="well" style="background-color:#00a4e4;">
<center><h2 style="font-size:50px;color:white;"><b>Change Password</b></h2></center>




</div>

<% if(status!=null)
	{
		if(status.equals("1"))
		{
			out.println("<div class='alert alert-success' role='alert'><center><a href='#' class='alert-link'> Password Changed Successfully!</a></center></div> ");
		}
		if(status.equals("2"))
		{
			out.println("<div class='alert alert-danger' role='alert'><center><a href='#' class='alert-link'>your New Password cant be same as your old password! please try a new one</a></center></div>");
		}
		if(status.equals("3"))
		{
			out.println("<div class='alert alert-danger' role='alert'><center><a href='#' class='alert-link'>you entered wrong old password!</a></center></div>");
		}
		if(status.equals("4"))
		{
			out.println("<div class='alert alert-danger' role='alert'><center><a href='#' class='alert-link'>New Password doesn't match</a></center></div>");
		}
		if(status.equals("5"))
		{
			out.println("<div class='alert alert-danger' role='alert'><center><a href='#' class='alert-link'>New password and Old password cant be same</a></center></div>");
		}
	
	}%>
<!--
<div class="alert alert-success" role="alert">
 <center> <a href="#" class="alert-link"> Poll Added Successfully!</a></center>
</div> 
<div class="alert alert-danger" role="alert">
  <center><a href="#" class="alert-link">Opps something went wrong!</a></center>
</div>

-->



<form class="form-horizontal" id="form" data-toggle="validator" action="newpassword" method="post">
<fieldset>

<!-- Form Name -->
<legend></legend>

<!-- Password input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="passwordinput" style="font-family: 'Noto Serif', serif;">Old Password</label>
  <div class="col-md-4">
    <input id="oldPass" name="oldpass" type="password" placeholder="Enter Your Old Password" class="form-control input-md" required>
    <i style="color:yellow" class="oldPassError"></i>
        <div class="help-block with-errors"></div>
    
  </div>
</div>

<!-- Password input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="passwordinput" style="font-family: 'Noto Serif', serif;">New Password</label>
  <div class="col-md-4">
    <input id="newPass" name="newpass" type="password" placeholder="Enter Your New Password" class="form-control input-md" required> <i style="color:yellow" class="newPassError"></i>
        <div class="help-block with-errors"></div>
    
  </div>
</div>



<!-- Password input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="passwordinput" style="font-family: 'Noto Serif', serif;">Re Password</label>
  <div class="col-md-4">
    <input id="reNewPass" name="renewpass" type="password" placeholder="Re Enter Your Password" data-match="#newPass" data-match-error="whoops, that didn't match" class="form-control input-md" required>
    <div class="help-block with-errors"></div>
    
    
  </div>
</div>

<!-- Button -->
<div class="form-group">
  <label class="col-md-4 control-label" for=""></label>
  <div class="col-md-4">
    <button id="submit" name="submit" class="btn btn-primary" style="font-family: 'Noto Serif', serif;">Update</button>
  </div>
</div>

</fieldset>
</form>



</body>
</html>