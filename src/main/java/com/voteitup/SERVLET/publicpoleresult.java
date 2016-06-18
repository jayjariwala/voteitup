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
import com.voteitup.BO.pollBO;

/**
 * Servlet implementation class publicpoleresult
 */
@WebServlet("/publicpoleresult")
public class publicpoleresult extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public publicpoleresult() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PollBean bean=new PollBean();
		String pollid=request.getParameter("poll");
		bean.setTimestamp(pollid);
		pollBO bo=new pollBO();
		ArrayList<PollBean> list=bo.polldata(bean);
		int pollcont=bo.pollcount(bean);
		
		request.setAttribute("list", list);
		

		
		RequestDispatcher dis=request.getRequestDispatcher("publicpollsresult.jsp?count="+pollcont+"&poll="+pollid);
		dis.forward(request, response);
	
	
	
	}

}
