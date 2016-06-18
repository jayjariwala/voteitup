package com.voteitup.SERVLET;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.voteitup.BEAN.RegistrationBean;
import com.voteitup.BEAN.SessionBean;
import com.voteitup.BO.UsersBO;

/**
 * Servlet implementation class newpassword
 */
@WebServlet("/newpassword")
public class newpassword extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public newpassword() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher dis=request.getRequestDispatcher("Deshboard");
		dis.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		SessionBean bean2=(SessionBean)request.getSession(false).getAttribute("session");
		if(bean2.getEmail()==null)
		{
			response.sendRedirect("index.jsp");
		}
	String oldpass=request.getParameter("oldpass");
	String newpass=request.getParameter("newpass");
	String renewpass=request.getParameter("renewpass");
	if(!newpass.equals(renewpass))
	{
		RequestDispatcher dis=request.getRequestDispatcher("changePassword.jsp?status=4");
		dis.forward(request,response);
	}
	if(oldpass.equals(newpass))
	{
		RequestDispatcher dis=request.getRequestDispatcher("changePassword.jsp?status=5");
		dis.forward(request,response);
	}
	RegistrationBean bean=new RegistrationBean();
	SessionBean bean1=(SessionBean) request.getSession(false).getAttribute("session");
	String email=bean1.getEmail();
	bean.setOldpassword(oldpass);
	bean.setNewpassword(renewpass);
	bean.setEmail(email);
	UsersBO bo=new UsersBO();
	int status=bo.passwordchange(bean);
	
	RequestDispatcher dis=request.getRequestDispatcher("changePassword.jsp?status="+status);
	dis.forward(request,response);
	
	}

}
