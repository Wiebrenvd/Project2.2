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
				if(ShoutingMTServer.xmlData.size() > 1) {
					templist = new ArrayList<String>(ShoutingMTServer.xmlData);
					ShoutingMTServer.xmlData.clear();
					
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
					System.out.println("No Inserts found");
				}
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
		
	}
	
}
