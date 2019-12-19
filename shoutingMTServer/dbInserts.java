package shoutingMTServer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

class Inserts implements Runnable {

	private static int runs = 0;
	
	@Override
	public synchronized void run() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/unwdmi","root","");
			Statement stmt = con.createStatement(); 
			StringBuilder insert = new StringBuilder();
			ArrayList<String> templist = new ArrayList<String>();
			//noinspection InfiniteLoopStatement
			while(true) {
				if(ShoutingMTServer.insertData.size() > 1000) {
					templist = new ArrayList<String>(ShoutingMTServer.insertData);
					ShoutingMTServer.insertData.clear();

					insert = new StringBuilder("INSERT INTO unwdmi.measurements VALUES");
					for(int i = 0;i<templist.size();i++) {
						if(i != templist.size()-1) {
							insert.append(templist.get(i)).append(",");
							
						}else {
							insert.append(templist.get(i));
							
						}
					}
					runs++;
					System.out.println("Inserts done: " + runs);
					stmt.executeUpdate(insert.toString());
				}
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

}
