/*package connector;
import java.sql.*;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.GET;
import javax.ws.rs.Path;


@Path("/test")
public class ConnectionCreator {
	//public static void main(String args[])throws Exception {

		private Connection conn;
		@GET
		@Path("/db")
		public String testDb() throws SQLException{
			DataSource ds = null;
			String s= null;
			String Query="select emp_id from amans_empleaveportal_emp_master_tbl where emp_id='AL500'";
			try {
				ds = (DataSource) new InitialContext().lookup("java:jboss/datasources/TRAINEEE");
			} catch (NamingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				conn = ds.getConnection();
			/*	Statement st =conn.createStatement();
				st.executeQuery(Query);
				ResultSet rs =st.executeQuery(Query);
				rs.next();
				 s = rs.getString(1);
				/*while(rs.next()){
					rs.getString(1);
				}*/
		/*	} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return conn.getMetaData().getUserName();
		}*/
		/*
	Class.forName("com.mysql.cj.jdbc.Driver");
	String url="jdbc:mysql://192.168.35.160/trainee17";
	String uname="trainee17";
	String pass="trainee@alac";
	String Query="select * from salesman";
	Connection con =  DriverManager.getConnection(url,uname,pass);
	Statement st =con.createStatement();
	st.executeQuery(Query);
	ResultSet rs =st.executeQuery(Query);
	ResultSetMetaData rsmd = rs.getMetaData();
	int cc=rsmd.getColumnCount();
	//System.out.println("No. of columns : " + rsmd.getColumnCount());
	for(int i=1;i<=cc;i++){
	 System.out.println("Column name of " + i + "Column : " + rsmd.getColumnName(i));
	 System.out.println("Column type of" + i + "Column  : " + rsmd.getColumnTypeName(i));
	}
	//while(rs.next())
	  //  System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3)+" "+rs.getFloat(4));
	st.close();
	con.close();
	*/
//}


//}
