package com.voteitup.SERVLET;

import java.awt.Desktop.Action;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.voteitup.BEAN.RegistrationBean;
import com.voteitup.BEAN.SessionBean;
import com.voteitup.BO.UsersBO;

/**
 * Servlet implementation class Userlogin
 */
@WebServlet("/Userlogin")
public class Userlogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Userlogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	 RequestDispatcher dis=request.getRequestDispatcher("login.jsp");
	 dis.forward(request, response);
	 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
	RegistrationBean bean=new RegistrationBean();	
	
	bean.setEmail(request.getParameter("id"));
	bean.setPassword(request.getParameter("password"));
	UsersBO bo=new UsersBO();
	String name=bo.login(bean);
	
	if(name == null)
	{
		int status=0;
		RequestDispatcher dis=request.getRequestDispatcher("login.jsp?status="+status);
		dis.forward(request, response);
		
	}
	else
	{
		HttpSession session=request.getSession();
		SessionBean sessionbean=new SessionBean();
		sessionbean.setEmail(request.getParameter("id"));
		sessionbean.setName(name);
		session.setAttribute("session", sessionbean);
		response.sendRedirect("dashboard");
	
	}
	
	
	
	}

}
