
<%@page import="com.voteitup.BEAN.PollBean" %>
<%@page import="java.util.ArrayList" %>

<% ArrayList<PollBean> list=(ArrayList<PollBean>) request.getAttribute("list"); %>

<!DOCTYPE html>
<html lang="en">
  <head>
  <link rel="icon" href="img/icon.png">
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <title>Public Polls</title>
    
    <!-- Bootstrap -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href='https://fonts.googleapis.com/css?family=Hind' rel='stylesheet' type='text/css'>
    <link href="font-awesome-4.6.3/css/font-awesome.css" rel="stylesheet">
 <link rel="stylesheet" type="text/css" href="css/style.css">
    <link href='https://fonts.googleapis.com/css?family=Josefin+Slab' rel='stylesheet' type='text/css'>
    <link href='https://fonts.googleapis.com/css?family=Rokkitt' rel='stylesheet' type='text/css'>

<link href='https://fonts.googleapis.com/css?family=Noto+Serif' rel='stylesheet' type='text/css'>

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
  </head>
  <body>
  <li><a href="Signup.html"><span class="nav-color" style="font-family: 'Noto Serif', serif;">Public Vote Polls</span></a></li>
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
<br/>
<br/>
<br/>
<br/>
<center><img src="img/icon.png"></center>
  <br/>

  <div class="container">
    <div class="list-group">
	 <%
	
 	for(PollBean bean1 :list)
		 {
	 		out.println("<a href='publicpoleresult?poll="+bean1.getTimestamp()+"'><button type='button' class='list-group-item'>"+bean1.getPolltitle()+"<i><span class='name' style='float:right'>Poll By: "+bean1.getName()+"</span></i></button></a>");
		 }
	 %>
 
</div>
  </div>
   
 <!--  <table class="table table-responsive">
      <tr>
        <td width="400px;">
        <center><i class="fa fa-flash fa-5x" style="color:white"></i></center>
        </td>
        <td>
        <center><i class="fa fa-globe fa-5x" style="color:white"></i></center>
        </td>
        <td>
      <center><i class="fa fa-facebook fa-5x" style="color:white"></i></center>
        </td>
      </tr>
      <tr>
      <td style="font-family: 'Noto Serif', serif;"><center><h3 style="color:white">Live Result</h3></center><span style="color:#918978">Live graphs show your poll results immediately in an easy to understand format. One graph will not provide the whole picture, that's why we provide multiple graph types to better describe results.</span> </td>
      <td style="font-family: 'Noto Serif', serif;"><center><h3 style="color:white">Works Everywhere</h3></center><span style="color:#918978">Traditional desktop computers now represent only 30% of Internet traffic. Your poll must work on the tables, smart phones, net books that your visitors are using. Our responsive designs just do it.</span></td>
      <td style="font-family: 'Noto Serif', serif;"><center><h3 style="color:white">Social Integration</h3></center><span style="color:#918978">Free integrated Facebook or traditional comments allow your poll voters to provide immediate feedback and discuss results. Social share buttons encourage your poll voters to help spread the word.</span></td>
      </tr>
</table>
      -->
      
  </body>
</html>