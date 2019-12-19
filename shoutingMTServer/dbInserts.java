package shoutingMTServer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

class Inserts implements Runnable {
	
	@Override
	public void run() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/unwdmi","root","");
			Statement stmt = con.createStatement(); 
			StringBuilder insert = new StringBuilder();
			ArrayList<String> templist = new ArrayList<String>(ShoutingMTServer.insertData);
			//noinspection InfiniteLoopStatement
			while(true) {
				if(ShoutingMTServer.insertData.size() > 1000) {
					templist = new ArrayList<String>(ShoutingMTServer.insertData);
					ShoutingMTServer.insertData.clear();

					final int size = 2500;
					int lists = 0;
					for (int start = 0; start < templist.size(); start += size) {
						int end = Math.min(start + size, templist.size());
						List<String> sublist = templist.subList(start, end);

						insert = new StringBuilder("INSERT INTO unwdmi.measurements VALUES");
						for(int i = 0;i<sublist.size();i++) {
							if(i != sublist.size()-1) {
								insert.append(sublist.get(i)).append(",");

							}else {
								insert.append(sublist.get(i));
							}
						}
						//System.out.println(insert);
						stmt.executeUpdate(insert.toString());
						lists++;
					}
					System.out.println("Amounts of lists inserted done: " + lists);
					System.out.println("Templist size: " + templist.size());
				}
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

}
