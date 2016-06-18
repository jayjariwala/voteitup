package com.voteitup.SERVLET;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.voteitup.BEAN.PollBean;
import com.voteitup.BEAN.SessionBean;
import com.voteitup.BO.UsersBO;

/**
 * Servlet implementation class createpoll
 */
@WebServlet("/createpoll")
public class createpoll extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public createpoll() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher dis=request.getRequestDispatcher("Dashboard.jsp");
		dis.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	String title=request.getParameter("polltitle");
	String options=request.getParameter("options");	
	String[] optionarray = options.split("\\r?\\n");
	
	SessionBean sbean=(SessionBean) request.getSession(false).getAttribute("session");
	
	UsersBO bo=new UsersBO();
	String random=bo.timestamp();
	PollBean Bean=new PollBean();
	Bean.setEmail(sbean.getEmail());
	Bean.setTimestamp(random);
	Bean.setPolltitle(title);
	
	int pollstatus = bo.pollcreation(Bean);
	System.out.println(pollstatus);
	
	for(int i=0;i<optionarray.length;i++)
	{
		Bean.setPolloption(""+optionarray[i]);
		bo.polloption(Bean);
	}
	
	if(pollstatus ==1)
	{
		RequestDispatcher dispatch=request.getRequestDispatcher("Dashboard.jsp?status=1");
		dispatch.forward(request, response);
				
	}
	

	}

}
