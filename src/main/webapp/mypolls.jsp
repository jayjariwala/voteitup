<%@page import="com.voteitup.BEAN.SessionBean" %>
<%@page import="com.voteitup.BEAN.PollBean" %>
<%@page import="java.util.ArrayList" %>

<% SessionBean bean=(SessionBean)session.getAttribute("session"); %>
<%if(bean == null)
{
%>
<jsp:forward page="index.jsp"></jsp:forward>>
<%	
}
%>
<% ArrayList<PollBean> list=(ArrayList<PollBean>) request.getAttribute("list"); %>

<%if(list == null)
{
%>
<jsp:forward page="index.jsp"></jsp:forward>>
<%	
}
%>

<!DOCTYPE html>
<html>
<head>
	<title>Dashboard</title>

	<link href="css/bootstrap.min.css" rel="stylesheet">
    <link href='https://fonts.googleapis.com/css?family=Hind' rel='stylesheet' type='text/css'>
    <link href="font-awesome-4.6.3/css/font-awesome.css" rel="stylesheet">
 <link rel="stylesheet" type="text/css" href="css/style.css">
    <link href='https://fonts.googleapis.com/css?family=Josefin+Slab' rel='stylesheet' type='text/css'>
    <link href='https://fonts.googleapis.com/css?family=Rokkitt' rel='stylesheet' type='text/css'>
    <link href='https://fonts.googleapis.com/css?family=Noto+Serif' rel='stylesheet' type='text/css'>
     <link rel="icon" href="img/icon.png">

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
      <a  href="dashboard" class="navbar-brand "><i class="fa fa-check-square-o nav-color"></i> <b><span class="logo-fonts nav-color"> Voteitup!</span></b></a>

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
<div class="well" style="background-color:#00a4e4;">
<center><h2 style="font-size:50px;color:white;"><b>DashBoard</b></h2></center>
<center><h4>what you want to do today?</h4></center>
<center><a href="dashboard"><button class="btn-default btn" style="font-family: 'Noto Serif', serif;">New Poll</button> </a><a href="mypolls"><button class="btn btn-primary" style="font-family: 'Noto Serif', serif;">My Polls</button></a></center>

</div>

<!--
<div class="alert alert-success" role="alert">
 <center> <a href="#" class="alert-link"> Poll Added Successfully!</a></center>
</div> 

<div class="alert alert-danger" role="alert">
  <center><a href="#" class="alert-link">Opps something went wrong!</a></center>
</div>

-->



<center><h3 style="font-family: 'Noto Serif', serif;">My Polls</h3></center>


<div class="list-group" style="margin-left:10%;margin-right:10%; padding:15px;">
  
 <% for(PollBean bean1 :list)
		 {
 out.println("<div type='button' class='list-group-item' style='padding:25px;'><center>"+bean1.getPolltitle()+"<a href='deletepoll?poll="+bean1.getTimestamp()+"'><button class=' btn-danger' style='float:right;margin-left:10px;'>Delete</button></a><a href='pollresult?poll="+bean1.getTimestamp()+"'><button class='btn-primary' style='float:right;margin-left:10px;'>view</button></a></center></div>");
		}  %>
</div>

</body>
</html>