package com.voteitup.SERVLET;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.voteitup.BEAN.PollBean;
import com.voteitup.BEAN.SessionBean;
import com.voteitup.BO.pollBO;

/**
 * Servlet implementation class votesubmit
 */
@WebServlet("/votesubmit")
public class votesubmit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public votesubmit() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
		if(!(request.getParameter("pollid")==null) && !(request.getParameter("radio")==null))
		{
			doPost(request, response);
		}
		else
		{
			response.sendRedirect("publicpolls");
		}
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String pollid=request.getParameter("pollid");
		String radiovalue=request.getParameter("radio");
		SessionBean bean=(SessionBean) request.getSession(false).getAttribute("session");
		if(bean!=null)
		{
		String ip=(String)request.getSession(false).getAttribute("ip");
		String uid=bean.getEmail();
		
		PollBean bean1=new PollBean();
		bean1.setEmail(uid);
		bean1.setIP(ip);
		bean1.setPolloption(radiovalue);
		bean1.setTimestamp(pollid);
	
		pollBO bo=new pollBO();
		int status=bo.submitvote(bean1);
		
		if(status==1)
		{
			RequestDispatcher req=request.getRequestDispatcher("pollresult?poll="+pollid+"&status="+status);
			req.forward(request, response);
		}
		if(status==2)
		{
			RequestDispatcher req=request.getRequestDispatcher("pollresult?poll="+pollid+"&status="+status);
			req.forward(request, response);
		}

		}
		else
		{
			response.sendRedirect("index.jsp");
		}
	}

}
