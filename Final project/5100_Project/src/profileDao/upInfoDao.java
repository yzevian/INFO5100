package profileDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import connectionDatabase.conData;
import loginDao.UserDao;

public class upInfoDao {
	Connection cn=null;
	PreparedStatement ps=null;
	
	public boolean upInfo(String guest,String Number,String user,String pass,String age,String gender) {
		// TODO Auto-generated method stub
		
		boolean flag = false;
		
	    int n=0;

        try {
			cn=conData.getCon();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	    //String sql1="update GuestTable set DL_number="+Number+", Guest_Name=" +guest+",Password="+pass+", Age="+age+",gerder="+gender+" where User_Name =" +user;
	    String sql1="update GuestTable set Guest_Name=?,DL_number=?,Password=?, Age=?,gender=? where User_Name =? ";
	    try {
			ps=cn.prepareStatement(sql1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}    
	   try {
		    ps.setString(1, guest);
		    ps.setString(2, Number);
		    ps.setString(3, pass);
		    ps.setString(4, age);
		    ps.setString(5, gender);
		    ps.setString(6, user);
		    ps.executeUpdate();
		    flag= true;
		    System.out.println("修改成功！");
	    } catch (SQLException e) {
	    	e.printStackTrace();
	    }
	   
	   try {
			conData.closeCon(cn);
			//System.out.println("数据库断开连接！");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	   
	return flag;
		
	}

	public String[] getPersonalData() {
		// TODO Auto-generated method stub
	  //  PreparedStatement ps=null;
	    ResultSet rs=null;
	    String sql1="select * from GuestTable";
	    UserDao u = new UserDao();
		String un = u.getCurrName();
		String[] pd = new String[6];
        try {
			cn=conData.getCon();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
      
        try {
			ps=cn.prepareStatement(sql1);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        try {
			rs = ps.executeQuery();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        
        try {
			while(rs.next()) {
				if(rs.getString("User_Name").equals(un)) {
					pd[0] =  rs.getString("DL_number");
					pd[1] =  rs.getString("Guest_Name");
					pd[2] =  rs.getString("User_Name");
					pd[3] =  rs.getString("Password");	
					pd[4] =  rs.getString("Age");
					pd[5] =  rs.getString("gender");				
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        try {
			conData.closeCon(cn);
			//System.out.println("数据库断开连接！");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        return pd;
	}

}
