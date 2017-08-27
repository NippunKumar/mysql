package statementPack;

import java.sql.*;
public class ResultSetMataExample {

public static void main(String[] args) {
	String user = "cbuser";
	String pass = "cbpass";
	String url ="jdbc:mysql://localhost/cookbook";
	Connection conn = null;
	
	try{
		conn = DriverManager.getConnection(url,user,pass);
		System.out.println("connected");
		String query = "describe profile";
		String query2 = "INSERT INTO profile (name,birth,color,foods,cats)VALUES('De''Mont','1973-01-12','blue','eggroll',4)";
		String query3 = " Delete from profile where name =\"De'Mont\"";
		Statement str = conn.createStatement();
		int  x = str.executeUpdate(query3);
		System.out.println(x);
	/*	ResultSetMetaData rsmd = rs.getMetaData();*/
		

		/*while(rsmd.){
			String id = rs.getString ("id");
			String name = rs.getString ("name");
			String cats = rs.getString ("cats");
			System.out.println ("id: " + id	+ ", name: " + name	+ ", cats: " + cats);
			
		}*/
		
		
		
	}catch(Exception e){
		System.out.println(e);
		
	}
}
}
