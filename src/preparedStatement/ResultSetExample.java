package preparedStatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


public class ResultSetExample {
	public static void main(String[] args) {
		String user = "cbuser";
		String pass = "cbpass";
		String url = "jdbc:mysql://localhost/cookbook";
		Connection con = null;
		try {

			con = DriverManager.getConnection(url, user, pass);
			System.out.println("connected");
			String query1 = "SELECT * FROM profile";
			Statement st = con.createStatement();

			ResultSet rs = st.executeQuery(query1);

			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				java.sql.Date birth = rs.getDate("birth");
				String color = rs.getString("color");
				String food = rs.getString("foods");
				int cats = rs.getInt("cats");
				System.out.println("");
				System.out.print("Id -> " + id + " name -> " + name + " birth -> " + birth + " color ->" + color
						+ " food -> " + food + " cats -> " + cats);
			}
			rs.close();
			st.close();
			

		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
