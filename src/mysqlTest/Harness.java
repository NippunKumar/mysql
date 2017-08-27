package mysqlTest;

import java.sql.Connection;

public class Harness {
	
	public static void main(String[] args) {
		Connection conn = null;
		try{
			
			conn =Cookbook.connect();
			System.out.println("Connected");
			
		}
		catch(Exception e){
			nk.con.Cookbook.printErrorMessage (e);
			System.exit (1);
			
		}
		finally{
			if (conn != null){
				try{
					conn.close();
					System.out.println("Disconnected");
				}
				catch(Exception e){
					System.out.println(e);
					String err = nk.con.Cookbook.getErrorMessage (e);
					System.out.println (err);
					
				}
			}
		}
	}
	
}
