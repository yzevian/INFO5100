package registerDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;

import connectionDatabase.conData;

public class addNewGuestDao {
	static boolean flag = false;
	static Connection cn=null;
    static PreparedStatement ps=null;
    static ResultSet rs=null;
    static Statement stmt = null;
	public static boolean addNewGuestDao(String number,String userName,String fullName,String password,String age,String sex)throws Exception {
		//添加用户		
	    int n=0;
	    
	    String sql="insert into GuestTable (DL_number,Guest_Name,User_Name,Password,Age) values(?,?,?,?,?)";
  
	    try {
			cn=conData.getCon();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	     
        try
        {
            ps=cn.prepareStatement(sql);
            ps.setString(1, number);
            ps.setString(2, fullName);
            ps.setString(3, userName);
            ps.setString(4, password);
            ps.setString(5, age);
            
            n= ps.executeUpdate();
            if(n>0) {
            	flag=true;
            }
           
        } catch(SQLException e)
        {
            e.printStackTrace();
        }
        
        if(cn != null) {
        	conData.closeCon(cn);
        }
		return flag;
	}

	public static boolean equalName(String userName) {
		// TODO Auto-generated method stub
		String sql1="select User_Name from GuestTable";
		 try {
				cn=conData.getCon();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	        try
	        {
	        	stmt = cn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
	            rs=stmt.executeQuery(sql1);
	            
	            while(rs.next())
	            {
	            	String n = rs.getString(1);
	            	if(n.equals(userName)) {
	            		flag=true;
	            		break;
	            	}	               
	            }	            
	        }
	        catch(SQLException e)
	        {
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

	public static boolean equalNumber(String dlnumber) {
		// TODO Auto-generated method stub
		String sql1="select DL_number from GuestTable";
		 try {
				cn=conData.getCon();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	        try
	        {
	        	stmt = cn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
	            rs=stmt.executeQuery(sql1);
	            
	            while(rs.next())
	            {
	            	String n = rs.getString(1);
	            	if(n.equals(dlnumber)) {
	            		flag=true;
	            		break;
	            	}	               
	            }	            
	        }
	        catch(SQLException e)
	        {
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

}
