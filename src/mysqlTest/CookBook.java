package mysqlTest;


import java.sql.*;


public class CookBook{
	public static Connection connect() throws Exception{
		String user = "cbuser";
		String pass = "cbpass";
		Connection conn = null;
		String url = "jdbc:mysql://localhost/cookbook";
	
		Class.forName("com.mysql.jdbc.Driver").newInstance();
		conn= DriverManager.getConnection(url,user,pass);
	return conn;
		}
	public static String getErrorMessage(Exception e){
		StringBuffer s = new StringBuffer();

		if (e instanceof SQLException){
			s.append("Error message"+ e.getMessage()+"\n");
			s.append("Error code"+ ((SQLException) e).getErrorCode()+"\n");
		}
		else{
		
			s.append (e + "\n");
		}
	return (s.toString ());
	}	

	// Get the error message and print it to System.err
	public static void printErrorMessage (Exception e){
		System.err.println (CookBook.getErrorMessage (e));
	}
}