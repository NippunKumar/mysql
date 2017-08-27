package mysqlTest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;


public class ReadPropsFile {

	public static void main(String[] args) {

		Connection conn = null;
		String Properties = "MysqlProperty";
		String url = null;
		java.util.Properties props = new Properties();
		try {
			props.load(ReadPropsFile.class.getResourceAsStream(Properties));
		} catch (Exception e) {
			System.out.println(e);
			System.err.println("Cannot read properties file");
			System.exit(1);
		}

		try {

			url = "jdbc:mysql://" + props.getProperty("host") + "/cookbook" + "?user=" + props.getProperty("user")
					+ "&password=" + props.getProperty("password");

			conn = DriverManager.getConnection(url);
			System.out.println("connected");

		} catch (SQLException e) {

			e.printStackTrace();
		}

		finally {
			try {
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				System.out.println(e);
			}
		}

	}

}
