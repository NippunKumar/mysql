package mysqlTest;

import java.sql.*;

public class Connect {
	public static void main(String[] args) {
		Connection con = null;
		String url = "jdbc:mysql://localhost/cookbook?user=cbuser&password=cbpass";
		String user = "cbuser";
		String pass = "cbpass";

		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			con = DriverManager.getConnection(url);
			System.out.println("Connected");
			System.out.println(con);
		} catch (Exception e) {
			System.out.println(e);
			System.out.println(e.getMessage());;
			System.err.println("Cannot connect to server");
			System.exit(1);
		}

		if (con != null) {
			try {
				con.close();
				System.out.println("Disconnected");
			} catch (Exception e) {
				/* ignore close errors */ }
		}
	}

}
