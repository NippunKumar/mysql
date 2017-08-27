package statementPack;

import java.sql.*;

public class ResultSetExample {
	
	public static void main(String[] args) {
		
		String user = "cbuser";
		String pass = "cbpass";
		String url = "jdbc:mysql://localhost/cookbook";
		Connection conn = null;
		try{
			conn = DriverManager.getConnection(url,user,pass);
			System.out.println("connected");
			String query = "Select id,name,cats from profile";
			Statement str = conn.createStatement();
			int count =0;
			ResultSet rs =  str.executeQuery(query);
			while(rs.next()){
				int id = rs.getInt ("id");  // extract columns 1, 2, and 3
				String name = rs.getString ("name");
				int cats = rs.getInt ("cats");
				System.out.println ("id: " + id + ", name: " + name+ ", cats: " + cats);
				count++;
			}
			rs.close (); // close result set
			str.close ();// close statement
			System.out.println ("Number of rows returned: " + count);
			
		}catch(Exception e){
			System.out.println(e);
		}
		
		
	}

}
