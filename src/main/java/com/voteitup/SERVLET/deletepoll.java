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
 * Servlet implementation class deletepoll
 */
@WebServlet("/deletepoll")
public class deletepoll extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public deletepoll() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
	
	
	String pollid=request.getParameter("poll");
	SessionBean bean1=(SessionBean) request.getSession(false).getAttribute("session");
	
	
	if(bean1.getEmail() !=null)
	{
		PollBean bean=new PollBean();
		bean.setEmail(bean1.getEmail());
		bean.setTimestamp(pollid);
		pollBO bo=new pollBO();
		int i=bo.deletepoll(bean);

		if(i==1)
		{
		
			RequestDispatcher dis=request.getRequestDispatcher("mypolls");
			dis.forward(request, response);
		}
		
	}
	else
	{
		
		System.out.println("Coming here!");
	 response.sendRedirect("index.jsp");	

	}
	
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	doGet(request,response);
	}

}
