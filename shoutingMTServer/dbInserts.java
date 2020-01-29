package shoutingMTServer;

import JSONUtilities.JSONWriter;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.text.SimpleDateFormat;
import java.util.Date;


import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;


class Inserts implements Runnable {

	@Override
	public void run() {
		try {






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
						String s2= "DATE";
						int i=(s1.indexOf(s2));
						String s3=s1.substring(i+7,i+17);
						LocalDate date = LocalDate.parse(s3);
						DayOfWeek dayOfWeek= DayOfWeek.from(date);
						int val = dayOfWeek.getValue();
						switch (val){
							case 1:
								Logger log1 = new Logger("data1.json");
								log1.log(s1);
								break;
							case 2:
								Logger log2 = new Logger("data2.json");
								log2.log(s1);
								break;
							case 3:
								Logger log3 = new Logger("data3.json");
								log3.log(s1);
								break;
							case 4:
								Logger log4 = new Logger("data4.json");
								log4.log(s1);
								break;
							case 5:
								Logger log5 = new Logger("data5.json");
								log5.log(s1);
								break;
							case 6:
								Logger log6 = new Logger("data6.json");
								log6.log(s1);
								break;
							default:
								Logger log7 = new Logger("data7.json");
								log7.log(s1);


						}


					}

					}
				}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}










