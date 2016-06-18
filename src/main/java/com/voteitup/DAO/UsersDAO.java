package com.voteitup.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.PreparedStatement;
import com.voteitup.BEAN.RegistrationBean;

public class UsersDAO {

	private String name,email,password;
	public UsersDAO(RegistrationBean bean)
	{
		this.name=bean.getName();
		this.email=bean.getEmail();
		this.password=bean.getPassword();
	}
	public int registration()
	{
		
		ConnectionDAO dao=new ConnectionDAO();
		Connection con=dao.openconnection();
		String check="SELECT COUNT(*) FROM Users WHERE EMAIL_ID=?";
		try {
			PreparedStatement st=(PreparedStatement) con.prepareStatement(check);
			st.setString(1,email);
		
			ResultSet rs1=st.executeQuery();
			int reg = 0;
			if(rs1.next())
			{
				reg=rs1.getInt(1);
			}
			if(reg == 1)
			{
				return 2;
			}
			else
			{
				String sql="INSERT INTO Users ( EMAIL_ID, USER_NAME,PASSWORD ) VALUES ( ?, ?,? )";
				try {
					PreparedStatement pst=(PreparedStatement) con.prepareStatement(sql);
					pst.setString(1,email);
					pst.setString(2,name);
					pst.setString(3, password);
					int flag=pst.executeUpdate();
					
					return flag;
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
			
		return 0;
	}
	public String login(RegistrationBean bean)
	{
		ConnectionDAO dao=new ConnectionDAO();
		Connection con=dao.openconnection();
		String sql="SELECT USER_NAME FROM Users WHERE EMAIL_ID=? AND PASSWORD=?";
		try {
			PreparedStatement pst=(PreparedStatement) con.prepareStatement(sql);
			pst.setString(1, bean.getEmail());
			pst.setString(2, bean.getPassword());
			ResultSet rst=pst.executeQuery();
			String name = null;
			if(rst.next())
			{
				name=rst.getString(1);
			}
			System.out.println("User Name"+name);
			return name;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return null;
		
	}
	public int changepassword(RegistrationBean bean)
	{
		ConnectionDAO dao=new ConnectionDAO();
		Connection con=dao.openconnection();
		String sql="SELECT PASSWORD from Users WHERE EMAIL_ID=?";
		try {
			PreparedStatement pst=(PreparedStatement) con.prepareStatement(sql);
			pst.setString(1, bean.getEmail());
			ResultSet rst=pst.executeQuery();
			String currentpass=null;
			if(rst.next())
			{
				currentpass=rst.getString(1);
				System.out.println("currentpass="+currentpass);
			}
			if(!currentpass.equals(bean.getOldpassword()))
			{
				System.out.println("goes here A");
				return 3;
			}
			if(currentpass.equals(bean.getNewpassword()))
			{
				System.out.println("goes here B");
				return 2;	
			}
				String query="UPDATE Users SET PASSWORD=? WHERE EMAIL_ID=?";
				System.out.println("UPDATE Users SET PASSWORD="+bean.getNewpassword()+" WHERE EMAIL_ID="+bean.getEmail());
				PreparedStatement pst1=(PreparedStatement) con.prepareStatement(query);
				pst1.setString(1,bean.getNewpassword());
				pst1.setString(2,bean.getEmail());
				int i=pst1.executeUpdate();
				
				return 1;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
		
	}
	
	
	
	
}
