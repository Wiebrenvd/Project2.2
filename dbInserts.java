package shoutingMTServer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

class Inserts implements Runnable {
	
	@Override
	public void run() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/unwdmi","root","");
			Statement stmt = con.createStatement(); 
			String insert = "";
			ArrayList<String> templist = new ArrayList<String>();
			while(true) {
				if(ShoutingMTServer.insertData.size() > 1000) {
					templist = new ArrayList<String>(ShoutingMTServer.insertData);
					ShoutingMTServer.insertData.clear();
					
					//building insert string
					insert = "";
					insert = "INSERT INTO unwdmi.measurements VALUES ";
					for(int i = 0;i<templist.size();i++) {
						if(i != templist.size()-1) {
							insert += templist.get(i) + ",";
							
						}else {
							insert += templist.get(i);
							
						}
					}
					System.out.println(insert);
					stmt.executeUpdate(insert);
				}else {
					String tmp = "";
					tmp +=1;
					System.out.println("No Inserts found" + ShoutingMTServer.insertData.size());
				}
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
		
	}
	
}
