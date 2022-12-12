package loginDao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;  

import java.sql.ResultSet;  
import java.sql.SQLException;
import java.sql.Statement;

import connectionDatabase.conData;
import loginDao.User;

public class UserDao {
	private static String name = null;
	public static boolean login(String username, String pass) {
		boolean flag = false;
		
		Connection cn=null;
	    PreparedStatement ps=null;
	    ResultSet rs=null;
	 
	        String sql="select Password from GuestTable where User_Name = ? ";
	        
	        try {
				cn=conData.getCon();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	        try
	        {
	            ps=cn.prepareStatement(sql);
	            ps.setString(1, username);
	            rs=ps.executeQuery();
	            
	            if(rs.next())
	            {
	                if(pass.equals(rs.getString(1)))
	                {
	                    flag=true;
	                    name = username;
	                }
	            }
	        }
	        catch(SQLException e)
	        {
	            e.printStackTrace();
	        }
	        try {
				conData.closeCon(cn);
				System.out.println("数据库断开连接！");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		return flag;
		
	}


	public String getCurrName() {
		return name;
	}
}
