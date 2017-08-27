package preparedStatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

public class NullCheckExample {
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
			ResultSetMetaData md = rs.getMetaData();
			int numColom = md.getColumnCount();
			while (rs.next()) {

				for (int i = 0; i < numColom; i++) // loop through columns
				{
					String val = rs.getString(i + 1);
					if (i > 0)
						System.out.print(", ");
					if (rs.wasNull())
						System.out.print("NULL");
					else
						System.out.print(val);
				}
				System.out.println();

			}

			rs.close();
			st.close();

			/*
			 * while (rs.next()) { int id = rs.getInt("id"); String name =
			 * rs.getString("name"); java.sql.Date birth = rs.getDate("birth");
			 * String color = rs.getString("color"); String food =
			 * rs.getString("foods"); int cats = rs.getInt("cats");
			 * System.out.println(""); System.out.print("Id -> " + id +
			 * " name -> " + name + " birth -> " + birth + " color ->" + color +
			 * " food -> " + food + " cats -> " + cats); }
			 */

		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
