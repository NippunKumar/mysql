package statementPack;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SortingExample {

	public static void main(String[] args) {
		String user = "cbuser";
		String pass = "cbpass";
		String url = "jdbc:mysql://localhost/cookbook";
		Connection conn = null;
		try {

			conn = DriverManager.getConnection(url, user, pass);
			System.out.println("connected");

			Statement st = conn.createStatement();
			String query = "select date_format(t,'%M %e, %Y')as 'date of sent', concat(srcuser,'@',dstuser) as"
					+ " 'Message Sender',size as 'Size of message', srchost,dsthost from mail where size >50000 order by size desc";

			ResultSet rs = st.executeQuery(query);

			while (rs.next()) {
				String sendDate = rs.getString("Date of sent");
				String sender = rs.getString("Message Sender");
				String size = rs.getString("Size of message");
				String srchost = rs.getString("srchost");
				String dschost = rs.getString("dsthost");

				System.out.println("user -->" + sender + " Time -->" + sendDate + "  size -->" + size + " srchost -->"
						+ srchost + " dschost -->" + dschost);

			}
			try {
				if (conn != null) {
					conn.close();
					st.close();
					rs.close();
				}

			} catch (Exception e) {
				System.out.println(e);
			}

		} catch (SQLException e) {
			System.out.println(e);
		}
	}

}
