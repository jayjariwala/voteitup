package com.voteitup.BO;

import java.util.ArrayList;

import com.voteitup.BEAN.PollBean;
import com.voteitup.DAO.pollDAO;

public class pollBO {
	
	public ArrayList<PollBean> polllist()
	{
		pollDAO dao=new pollDAO();
		ArrayList<PollBean> list=dao.polllist();
		return list;
	}
	public ArrayList<PollBean> polldata(PollBean bean)
	{
		pollDAO dao=new pollDAO();
		ArrayList<PollBean> list=dao.pollinfo(bean);
		return list;
	}
	public int pollcount(PollBean bean)
	{
		pollDAO dao=new pollDAO();
		int count=dao.pollcount(bean);
		return count;
	}
	public int submitvote(PollBean bean)
	{
		pollDAO dao=new pollDAO();
		int i=dao.votesubmit(bean);
		return i;
	}
	public int publicsubmitvote(PollBean bean)
	{
		pollDAO dao=new pollDAO();
		int i=dao.publicvotesubmit(bean);
		return i;
	}
	public ArrayList<PollBean> mypolllist(PollBean bean1)
	{
	pollDAO dao=new pollDAO();
	ArrayList<PollBean> list=dao.mypolllist(bean1);
	return list;
	}
	public int deletepoll(PollBean bean)
	{
		pollDAO dao=new pollDAO();
		int i=dao.polldelete(bean);
		return i;
	}
	

}
