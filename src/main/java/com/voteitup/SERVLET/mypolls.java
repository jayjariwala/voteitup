package com.voteitup.SERVLET;

import java.io.IOException;
import java.util.ArrayList;

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
 * Servlet implementation class mypolls
 */
@WebServlet("/mypolls")
public class mypolls extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public mypolls() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		SessionBean bean=(SessionBean) request.getSession(false).getAttribute("session");
		
		if(bean!=null)
		{
		
		PollBean bean2=new PollBean();
		bean2.setEmail(bean.getEmail());
		pollBO bo=new pollBO();
		ArrayList<PollBean> list=bo.mypolllist(bean2);
		
		
		request.setAttribute("list", list);
		RequestDispatcher dis=request.getRequestDispatcher("mypolls.jsp");
		dis.forward(request, response);
		}
		else
		{
			response.sendRedirect("index.jsp");
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher dis=request.getRequestDispatcher("mypolls.jsp");
		dis.forward(request, response);
	}

}
