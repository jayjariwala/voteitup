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
import com.voteitup.BO.pollBO;

/**
 * Servlet implementation class publicvotesubmit
 */
@WebServlet("/publicvotesubmit")
public class publicvotesubmit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public publicvotesubmit() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		if(!(request.getParameter("pollid")==null) && !((request.getParameter("radio"))==null))
		{
			doPost(request, response);
		}
		else
		{
			response.sendRedirect("Polls");
		}
			
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
		String pollid=request.getParameter("pollid");
		String radiovalue=request.getParameter("radio");
	
		String ipaddress=request.getHeader("X-FORWARD-FOR");
		if (ipaddress == null) {  
			   ipaddress = request.getRemoteAddr();   
			   
		   }
		
	
		
		PollBean bean1=new PollBean();
	
		bean1.setIP(ipaddress);
		bean1.setPolloption(radiovalue);
		bean1.setTimestamp(pollid);
	
		pollBO bo=new pollBO();
		int status=bo.publicsubmitvote(bean1);
		
		if(status==1)
		{
			RequestDispatcher req=request.getRequestDispatcher("publicpoleresult?poll="+pollid+"&status="+status);
			req.forward(request, response);
		}
		if(status==2)
		{
			RequestDispatcher req=request.getRequestDispatcher("publicpoleresult?poll="+pollid+"&status="+status);
			req.forward(request, response);
		}

		
	}

}
