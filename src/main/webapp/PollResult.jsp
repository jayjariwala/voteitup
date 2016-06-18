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
<%
ArrayList<PollBean> list=(ArrayList<PollBean>) request.getAttribute("list");
int count=Integer.parseInt(request.getParameter("count"));
String pollid=request.getParameter("poll");
String status=request.getParameter("status");
%>
<!DOCTYPE html>
<html>
<head>
  <title>Vote it!</title>

  <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href='https://fonts.googleapis.com/css?family=Hind' rel='stylesheet' type='text/css'>
    <link href="font-awesome-4.6.3/css/font-awesome.css" rel="stylesheet">
 <link rel="stylesheet" type="text/css" href="css/style.css">
    <link href='https://fonts.googleapis.com/css?family=Josefin+Slab' rel='stylesheet' type='text/css'>
    <link href='https://fonts.googleapis.com/css?family=Rokkitt' rel='stylesheet' type='text/css'>
    <link href='https://fonts.googleapis.com/css?family=Noto+Serif' rel='stylesheet' type='text/css'>
     <link rel="icon" href="img/icon.png">
       

<script src="canvas/canvasjs.min.js"></script>

<script type="text/javascript">
window.onload = function () {
  var chart = new CanvasJS.Chart("chartContainer",
  {
    title:{
    	
      text: ""
    },
                animationEnabled: true,
    legend:{
      verticalAlign: "bottom",
      horizontalAlign: "center"
    },
    data: [
    {        
      indexLabelFontSize: 20,
      indexLabelFontFamily: "Monospace",       
      indexLabelFontColor: "darkgrey", 
      indexLabelLineColor: "darkgrey",        
      indexLabelPlacement: "outside",
      type: "pie",       
      showInLegend: true,
      toolTipContent: "{y} - <strong>#percent%</strong>",
      dataPoints: [
        <%
        for(PollBean bean1 :list)
		 {
        System.out.println(bean1.getPolloption()); 
        out.println("{y:"+bean1.getVotes()+", legendText:\""+bean1.getPolloption()+"\", indexLabel: '"+bean1.getPolloption()+"' },");
		 }
        %>           
   

      ]
    }
    ]
  });
  chart.render();
}
</script>
<script type="text/javascript" src="/assets/script/canvasjs.min.js"></script>




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

        <center><span class="visible-sm visible-xs"> <a class="navbar-brand " style="font-family: 'Noto Serif', serif; color: white "><i class="fa fa-user"></i><span class="nav-color"> <%=bean.getName()%></span></a></span></center>

     
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
<center><h4 style="font-family: 'Noto Serif', serif;"><i>Give Your vote</i></h4></center>
<center><h2 style="font-size:50px;color:white;  "><b><%=list.get(1).getPolltitle()%></b></h2></center>

<center><form style="font-family: 'Noto Serif', serif;" action="votesubmit" method="post">
<input type="hidden" name="pollid" value="<%=pollid%>">

      <select class="form-control" id="sel1" name='radio' >
  <%
for(PollBean bean1 :list)
		 {
out.println("<option value='"+bean1.getPolloption()+"'>"+bean1.getPolloption()+"</option>");
		 }
%>

      </select>

<br/><button class="btn btn-success" style="font-family: 'Noto Serif', serif;" type='submit'>Vote it!</button>&nbsp;</center>
</form>
</div>

<!--
 
-->
<%if(status!=null)
	
{
	if(status.equals("1"))
	{
		out.println("<div class='alert alert-danger' role='alert'><center><a class='alert-link'>You cannot vote twice!</a></center></div>");
	}
	if(status.equals("2"))
	{
		out.println("<div class='alert alert-success' role='alert'><center> <a class='alert-link'>Your vote has been registered! Thank You</a></center></div>");
	}
}
	%>



<center><a href="https://twitter.com/intent/tweet?url=http://voteplus-jayjariwala.rhcloud.com/publicpoleresult?poll=<%=pollid%>&text=Vote+On:<%=list.get(1).getPolltitle()%>&hashtags=Voting,LiveResult" target="_blank"><button id="twitter" name="singlebutton" class="btn btn-primary" style="font-family: 'Noto Serif', serif;background-color:"skyblue"><i class ="fa fa-twitter" ></i> Share on Twitter</button></a></center>

<%if(count >=1) {%>

<div id="chartContainer" style="height:500px; width: 100%;"></div>

<%} %>
<br/>
<br/>
<br/>
</body>
</html>