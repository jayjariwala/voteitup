package com.voteitup.SERVLET;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.voteitup.BEAN.RegistrationBean;
import com.voteitup.BO.UsersBO;
import com.voteitup.DAO.UsersDAO;

/**
 * Servlet implementation class UserRegister
 */
@WebServlet("/UserRegister")
public class UserRegister extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserRegister() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher dispatch=request.getRequestDispatcher("index.jsp");
		dispatch.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		RegistrationBean bean=new RegistrationBean();
		bean.setName(request.getParameter("name"));
		bean.setPassword(request.getParameter("password"));
		bean.setEmail(request.getParameter("email"));
		
		UsersBO bo=new UsersBO();
		int status=bo.Registration(bean);
		
		
		RequestDispatcher dispatch=request.getRequestDispatcher("Signup.jsp?status="+status);
		dispatch.forward(request, response);
		
		
	}

}
