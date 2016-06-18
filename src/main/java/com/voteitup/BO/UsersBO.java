package com.voteitup.BO;

import java.util.Arrays;
import java.util.Date;
import java.util.Random;
import com.voteitup.BEAN.PollBean;
import com.voteitup.BEAN.RegistrationBean;
import com.voteitup.DAO.UsersDAO;
import com.voteitup.DAO.pollDAO;



public class UsersBO {

	public int Registration(RegistrationBean bean)
	{
		md5 md=new md5();
		String pass=bean.getPassword();
		String encpass=md.crypt(pass);
		bean.setPassword(encpass);
		UsersDAO dao=new UsersDAO(bean);
		int status=dao.registration();
		return status;
	}
	
	public String login(RegistrationBean bean)
	{
		md5 md=new md5();
		String pass=bean.getPassword();
		String encpass=md.crypt(pass);
		bean.setPassword(encpass);
		UsersDAO dao=new UsersDAO(bean);
	String name=dao.login(bean);
		return name;
	}
	
	public int polloption(PollBean bean)
	{
		
		pollDAO dao=new pollDAO();
		int i=dao.saveoptions(bean);
		return i;
		
	}

	public String timestamp()
	{
		Date d=new Date();
		String date =""+d.getDate();
		String day=""+d.getDay();
		String min=""+d.getMinutes();
		String sec=""+d.getSeconds();
		
		
		final String alphabet = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	    final int N = alphabet.length();

	    Random r = new Random();
	    String[] myarray=new String[10];
	    for (int i = 0; i < 10; i++) {
	     myarray[i]=""+alphabet.charAt(r.nextInt(N));
	    }
	    return Arrays.toString(myarray).replaceAll("\\[|\\]|,|\\s", "");
		
	}
	
	public int pollcreation(PollBean bean)
	{
		pollDAO dao=new pollDAO();
		int i=dao.polltitle(bean);
		return i;
	}
	public int passwordchange(RegistrationBean bean)
	{
		md5 md=new md5();
		String oldpass=bean.getOldpassword();
		String newpass=bean.getNewpassword();
		String cryptoldpass=md.crypt(oldpass);
		String cryptnewpass=md.crypt(newpass);
		bean.setOldpassword(cryptoldpass);
		bean.setNewpassword(cryptnewpass);
		UsersDAO dao=new UsersDAO(bean);
		int i=dao.changepassword(bean);
		return i;
		
	}
	
	
}
