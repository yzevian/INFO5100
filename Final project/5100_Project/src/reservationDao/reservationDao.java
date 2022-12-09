package reservationDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import connectionDatabase.conData;
import loginDao.UserDao;

public class reservationDao {
	ArrayList<String[]> list;
	static ArrayList<String> brand;
	private String n=null;
	static Connection cn=null;
    static PreparedStatement ps=null;
    static ResultSet rs=null;
    
    public void getCarInfo(String brand, String color, String price, String type) {   	
    	
    }
	
	public void getOnlyNumber(String onlynumber) {
		this.n=onlynumber;
		
	}
	
	public ArrayList<String[]> getcurrData(String b) {
		// TODO Auto-generated method stub
		ArrayList<String[]> lists = new ArrayList<String[]>();
		Connection cn=null;
	    PreparedStatement ps=null;
	    ResultSet rs=null;
	    String sql1="select * from carTable";
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
			while(rs.next() ) {	
				if(rs.getString("Brand").equals(b)) {
					String[] str = new String[5];
			    	str[0] =  String.valueOf(rs.getInt("id"));
			    	str[1] =  rs.getString("Brand");
			    	str[2] =  rs.getString("Color");
			    	str[3] =  rs.getString("Price");	
			    	str[4] =  rs.getString("Type");	
			    	lists.add(str);
					//System.out.print(str);
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
    
		return lists;
	}
	
	public ArrayList<String> getBrand(){
		ArrayList<String> brandList = new ArrayList<String>();
		Connection cn=null;
	    PreparedStatement ps=null;
	    ResultSet rs=null;
	    
	    String sql1="select Brand from CarBrandTable";
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
					brandList.add(rs.getString(1));
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
	    
		return brandList;
		
	}


	public ArrayList<String[]> getData(int n) {
		UserDao u = new UserDao();
		String un = u.getCurrName();
		// TODO Auto-generated method stub
	    String sql="select * from ReservationTable order by id asc";
        try {
			cn=conData.getCon();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
      
        try {
			ps=cn.prepareStatement(sql);
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
        list = new ArrayList<>();
        
        try {
			while(rs.next()) {
				if(rs.getString("User_Name").equals(un) && rs.getInt("State")==n) {
					String[] str = new String[9];
			    	str[0] =  rs.getString("id");
			    	str[1] =  rs.getString("Car_Brand");
			    	str[2] =  rs.getString("User_Name");
			    	str[3] =  rs.getString("Start_Date");	
			    	str[4] =  rs.getString("End_Date");	
			    	str[5] =  rs.getString("Carid");
			    	str[6] =  rs.getString("price");
			    	str[7] =  rs.getString("type");	
			    	str[8] =  rs.getString("Color");	
			    	list.add(str);
				}
			}
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        try {
			conData.closeCon(cn);
			//System.out.println("数据库断开连接！");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return list;
	}
	public boolean deleteInfo(String n) {
		// TODO Auto-generated method stub
		boolean flag = false;
		String sql2= "delete from ReservationTable where id = ?";
		try {
			cn=conData.getCon();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
      
        try {
			ps=cn.prepareStatement(sql2);
			ps.setString(1, n);
			ps.executeUpdate();
			flag = true;
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        
        try {
			conData.closeCon(cn);
		//	System.out.println("数据库断开连接！");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
        
        return flag;
	}

	
	
	
}
