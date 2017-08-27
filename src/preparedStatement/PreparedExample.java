package preparedStatement;

import java.sql.Connection;
import java.sql.DriverManager;

import java.sql.PreparedStatement;
import java.sql.Date;

public class PreparedExample {

	public static void main(String[] args) {

		String user = "cbuser";
		String pass = "cbpass";
		String url = "jdbc:mysql://localhost/cookbook";//----------------------------------------------------------------------------------------------------------------
		Connection conn = null;
		Date d = new Date(28-02-1993);
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			conn = DriverManager.getConnection(url, user, pass);
			PreparedStatement ps = conn.prepareStatement("INSERT INTO profile (name,birth,color,foods,cats )  VALUES(?,?,?,?,?)");
			
			ps.setString(1, "Nippun's");
			ps.setDate(2,d);
			ps.setNull(3,java.sql.Types.VARCHAR);
			ps.setString(4, "curry,eggroll");
			ps.setInt(5, 01);
			int x = ps.executeUpdate();
			System.out.println(x);
			
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
