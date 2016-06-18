package com.voteitup.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.sound.midi.Soundbank;

import com.mysql.jdbc.PreparedStatement;
import com.voteitup.BEAN.PollBean;

public class pollDAO {

	public int savepolltitle(PollBean bean)
	{
		ConnectionDAO dao=new ConnectionDAO();
		Connection conn=dao.openconnection();
		String sql="INSERT INTO UsersPolls VALUES (?,?,?)";
		try {
			PreparedStatement pst=(PreparedStatement) conn.prepareStatement(sql);
			pst.setString(1, bean.getTimestamp());
			pst.setString(2, bean.getEmail());
			pst.setString(3, bean.getPolltitle());
			pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return 0;
		
	}
	public int saveoptions(PollBean bean)
	{
		
		ConnectionDAO dao=new ConnectionDAO();
		Connection con=dao.openconnection();
	
		String sql="INSERT INTO PollOptions VALUES (?,?,?,?)";
		try {
			PreparedStatement pst=(PreparedStatement) con.prepareStatement(sql);
			pst.setInt(1, 0);	
			pst.setString(2, bean.getTimestamp());
			pst.setString(3, bean.getPolloption());
			pst.setInt(4,0);
			int i=pst.executeUpdate();
			return i;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return 0;
	}
	
	public int polltitle(PollBean bean)
	{
		ConnectionDAO dao=new ConnectionDAO();
		Connection con=dao.openconnection();
		String query="INSERT INTO UserPolls VALUES (?,?,?)";
		try {
			PreparedStatement pst1=(PreparedStatement) con.prepareStatement(query);
			pst1.setString(1,bean.getTimestamp());
			pst1.setString(2, bean.getEmail());
			pst1.setString(3, bean.getPolltitle());
			int i=pst1.executeUpdate();
			
				
				return i;
			
			
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return 0;
	}
	
	public ArrayList<PollBean> polllist()
	{
		ConnectionDAO dao=new ConnectionDAO();
		Connection con=dao.openconnection();
		String sql="Select POLL_ID, POLL_TITLE, USER_NAME FROM UserPolls JOIN Users ON UserPolls.EMAIL_ID = Users.EMAIL_ID";
		try {
			PreparedStatement pst=(PreparedStatement) con.prepareStatement(sql);
			ResultSet rsl=pst.executeQuery();
			PollBean bean;
			ArrayList<PollBean> polllist=new ArrayList<PollBean>();
			while(rsl.next())
			{
			bean=new PollBean();
			bean.setTimestamp(rsl.getString(1));
			bean.setPolltitle(rsl.getString(2));
			bean.setName(rsl.getString(3));
			polllist.add(bean);
			}
			
			return polllist;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return null;
		
	}
	
	
	public ArrayList<PollBean> mypolllist(PollBean bean1)
	{
		ConnectionDAO dao=new ConnectionDAO();
		Connection con=dao.openconnection();
		String sql="Select POLL_ID, POLL_TITLE FROM UserPolls JOIN Users ON UserPolls.EMAIL_ID = Users.EMAIL_ID WHERE UserPolls.EMAIL_ID=?";
		try {
			PreparedStatement pst=(PreparedStatement) con.prepareStatement(sql);
			pst.setString(1, bean1.getEmail());
			ResultSet rsl=pst.executeQuery();
			PollBean bean;
			ArrayList<PollBean> polllist=new ArrayList<PollBean>();
			while(rsl.next())
			{
			bean=new PollBean();
			bean.setTimestamp(rsl.getString(1));
			bean.setPolltitle(rsl.getString(2));
			polllist.add(bean);
			}
			
			return polllist;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return null;
		
	}
	
	
	public ArrayList<PollBean> pollinfo(PollBean bean)
	{
		ConnectionDAO dao=new ConnectionDAO();
		Connection con=dao.openconnection();
		String SQL="Select POLL_TITLE, OPTIONS, USER_VOTE FROM PollOptions JOIN UserPolls ON PollOptions.POLL_ID = UserPolls.POLL_ID WHERE UserPolls.POLL_ID=? AND PollOptions.OPTIONS !=''";
		
		try {
			PreparedStatement pst=(PreparedStatement) con.prepareStatement(SQL);
			pst.setString(1, bean.getTimestamp());
			ResultSet rs=pst.executeQuery();
			PollBean bean1;
			ArrayList<PollBean> polldata=new ArrayList<PollBean>();
			while(rs.next())
			{
				bean1=new PollBean();
				bean1.setPolltitle(rs.getString(1));
				bean1.setPolloption(rs.getString(2));
				bean1.setVotes(rs.getInt(3));
				polldata.add(bean1);
			}
		return polldata;
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	
	public int pollcount(PollBean bean)
	{
		ConnectionDAO dao=new ConnectionDAO();
		Connection con=dao.openconnection();
		String sql="SELECT SUM(USER_VOTE) FROM PollOptions where POLL_ID=?";
		try {
			PreparedStatement pst=(PreparedStatement) con.prepareStatement(sql);
			pst.setString(1,bean.getTimestamp());
			ResultSet rs=pst.executeQuery();
			if(rs.next())
			{
				int count=rs.getInt(1);
				return count;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	public int votesubmit(PollBean bean)
	{
		ConnectionDAO dao=new ConnectionDAO();
		Connection con=dao.openconnection();
		String query="SELECT COUNT(POLL_ID) FROM user_votes WHERE POLL_ID=? AND USER_ID=?";
		System.out.println("fired Query"+"SELECT COUNT(POLL_ID) FROM user_votes WHERE POLL_ID="+bean.getTimestamp()+" AND USER_ID="+bean.getEmail());
		try {
			
			PreparedStatement pst=(PreparedStatement) con.prepareStatement(query);
			pst.setString(1,bean.getTimestamp());
			pst.setString(2,bean.getEmail());
			ResultSet rs=pst.executeQuery();
			int i=0;
			if(rs.next())
			{
				i=rs.getInt(1);
			}
			if(i==0)
			{
				String sql="UPDATE PollOptions SET USER_VOTE=USER_VOTE+1 WHERE POLL_ID=? AND OPTIONS=?";
				PreparedStatement pst1=(PreparedStatement) con.prepareStatement(sql);
				pst1.setString(1,bean.getTimestamp());
				pst1.setString(2,bean.getPolloption());
				int j=pst1.executeUpdate();
				if(j==1)
				{
				String sql2="INSERT INTO user_votes VALUES(?,?,?,?)";
				PreparedStatement pst2=(PreparedStatement) con.prepareStatement(sql2);
				pst2.setInt(1, 0);
				pst2.setString(2,bean.getTimestamp());
				pst2.setString(3, bean.getEmail());
				pst2.setString(4,null);
				pst2.executeUpdate();
				return 2;
				}
				
			}
			else
			{
				return 1;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	public int publicvotesubmit(PollBean bean)
	{
		ConnectionDAO dao=new ConnectionDAO();
		Connection con=dao.openconnection();
		String query="SELECT COUNT(POLL_ID) FROM user_votes WHERE POLL_ID=? AND IP=?";
		System.out.println("fired Query"+"SELECT COUNT(POLL_ID) FROM user_votes WHERE POLL_ID="+bean.getTimestamp()+" AND IP="+bean.getIP());
		try {
			
			PreparedStatement pst=(PreparedStatement) con.prepareStatement(query);
			pst.setString(1,bean.getTimestamp());
			pst.setString(2,bean.getIP());
			
			ResultSet rs=pst.executeQuery();
			int i=0;
			if(rs.next())
			{
				i=rs.getInt(1);
			}
			if(i==0)
			{
				String sql="UPDATE PollOptions SET USER_VOTE=USER_VOTE+1 WHERE POLL_ID=? AND OPTIONS=?";
				PreparedStatement pst1=(PreparedStatement) con.prepareStatement(sql);
				pst1.setString(1,bean.getTimestamp());
				pst1.setString(2,bean.getPolloption());
				int j=pst1.executeUpdate();
				if(j==1)
				{
				String sql2="INSERT INTO user_votes VALUES(?,?,?,?)";
				PreparedStatement pst2=(PreparedStatement) con.prepareStatement(sql2);
				pst2.setInt(1, 0);
				pst2.setString(2,bean.getTimestamp());
				pst2.setString(3, bean.getEmail());
				pst2.setString(4,bean.getIP());
				pst2.executeUpdate();
				return 2;
				}
				
			}
			else
			{
				return 1;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	public int polldelete(PollBean bean)
	{
		ConnectionDAO dao=new ConnectionDAO();
		Connection con=dao.openconnection();
		String sql="DELETE FROM UserPolls where POLL_ID=? AND EMAIL_ID=?";
		try {
			PreparedStatement pst=(PreparedStatement) con.prepareStatement(sql);
			pst.setString(1, bean.getTimestamp());
			pst.setString(2, bean.getEmail());
			int i=pst.executeUpdate();
			
			String sql2="DELETE FROM PollOptions where POLL_ID=?";
			PreparedStatement pst1=(PreparedStatement) con.prepareStatement(sql2);
			pst1.setString(1, bean.getTimestamp());
			int j=pst1.executeUpdate();
			String sql3="DELETE FROM user_votes where POLL_ID=?";
			PreparedStatement pst3=(PreparedStatement) con.prepareStatement(sql3);
			pst3.setString(1, bean.getTimestamp());
			int k=pst1.executeUpdate();
			return 1; 
					
				
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
		
	}
}
