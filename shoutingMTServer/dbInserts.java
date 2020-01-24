package shoutingMTServer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;


class Inserts implements Runnable {

	@Override
	public void run() {
		try {
			Logger log1 = new Logger("file1.txt");



			StringBuilder insert = new StringBuilder();
			ArrayList<String> templist = new ArrayList<String>(ShoutingMTServer.insertData);
			//noinspection InfiniteLoopStatement
			while (true) {
				if (ShoutingMTServer.insertData.size() > 20) {
					templist = new ArrayList<String>(ShoutingMTServer.insertData);
					ShoutingMTServer.insertData.clear();

					final int size = 2500;
					int lists = 0;
					for (int start = 0; start < templist.size(); start += size) {
						int end = Math.min(start + size, templist.size());
						List<String> sublist = templist.subList(start, end);

						insert = new StringBuilder("");
						for(String s: sublist){
							insert.append(s).append("\n");
						}
						String s1=insert.toString().trim();
						log1.log(s1);


						}

					}
				}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}










