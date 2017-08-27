package statementPack;

import java.sql.*;

class StatementExample {
	public static void main(String[] args){
		String user = "cbuser";
		String pass = "cbpass";
		String url = "jdbc:mysql://localhost/cookbook";
		Connection conn = null;
		try {
			/*Class.forName("com.mysql.jdbc.Driver").newInstance();*/
			

			System.out.println("Connnected");
			String query = "UPDATE profile SET cats = cats+1 WHERE name = 'Sybil'";
			Statement stm = conn.createStatement();
			int count = stm.executeUpdate(query);
			System.out.println(count);

		} catch (SQLException e) {
			System.out.println(e.getSQLState());
			System.out.println(e);
		} catch (Exception e) {
			System.out.println(e);
		}

	}

}