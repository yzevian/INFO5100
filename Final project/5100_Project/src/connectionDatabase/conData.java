
package connectionDatabase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;  
import java.sql.ResultSet;  
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;  

public class conData {
	private static String dbUrl="jdbc:mysql://localhost:3306/CarRental?useSSL=false&serverTimezone=UTC"; // 数据库连接地址
	private static String dbUserName="root"; // 用户名
	private static String dbPassword="00000000"; // 密码
	private static String jdbcName="com.mysql.cj.jdbc.Driver"; // 驱动名称
	static Connection con= null;

	/**
	 * 获取数据库连接
	 * @return
	 * @throws Exception
	 */

	public static Connection getCon()throws Exception{
		Class.forName(jdbcName);
		con=DriverManager.getConnection(dbUrl, dbUserName, dbPassword);
		return con;
	}
	
	/**
	 * 关闭数据库连接
	 * @param con
	 * @throws Exception
	 */
	public static void closeCon(Connection con)throws Exception{
		if(con!=null){
			con.close();
		}
	}
	
	public static void main(String[] args) {
		conData dbUtil=new conData();
		try {
			dbUtil.getCon();
			//System.out.println("数据库连接成功！");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			//System.out.println("数据库连接失败");
		}
		Statement stmt = null;
		ResultSet rsst = null;
		String name = "select max(id) from ReservationTable";
		
		try {
			stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			rsst = stmt.executeQuery(name);
			while(rsst.next()) {
				//System.out.print(rsst.getString(1));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			while(rsst.next()) {
				String Age = rsst.getString(1);
				//System.out.println(Age);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		/*if(dbUtil != null) {
			try {
				dbUtil.closeCon(con);
				System.out.println("数据库断开连接！");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}*/
		
	}
	
}

