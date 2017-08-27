package mysqlTest;

import java.sql.*;


public class Error {

	public static void main(String[] args) {
		Connection conn = null;
		String url = "jdbc:mysql://localhost/cookbook";
		String usr = "cbuser";
		String pass = "cbpass";

		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			conn = DriverManager.getConnection(url, usr, pass);
			System.out.println("Connected");
			tryQuery(conn);

		} catch (Exception e) {
			System.out.println("cannot connect to the server");
			System.out.println(e);
			if (e instanceof SQLException) {// JDBC-specific exception?

				// e must be cast from Exception to SQLException to
				// access the SQLException-specific methods
				System.out.println((SQLException) e);
			}
		} finally {
			if (conn != null) {
				try {
					conn.close();
					System.out.println("Disconnected");
				} catch (SQLException e) {
					System.out.println(e);
				}
			}
		}
	}

	public static void tryQuery (Connection conn){
		try {
			// issue a simple query
			Statement s = conn.createStatement();
			s.execute("USE cookbook");
			s.close();
			// print any accumulated warnings
			SQLWarning w = conn.getWarnings();
			System.out.println(w);
			while (w != null) {
				System.err.println("SQLWarning: " + w.getMessage());
				System.err.println("SQLState: " + w.getSQLState());
				System.err.println("Vendor code: " + w.getErrorCode());
				w = w.getNextWarning();
			}
		} catch (SQLException e) {
			printException(e);
		}
	}

	public static void printException(SQLException e) {
		// print general message, plus any database-specific message
		System.err.println("SQLException: " + e.getMessage());
		System.err.println("SQLState: " + e.getSQLState());
		System.err.println("Vendor code: " + e.getErrorCode());
	}
}
