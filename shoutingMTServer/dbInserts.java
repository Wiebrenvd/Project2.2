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
            File data1 = new File("data1.json");
            File data2 = new File("data2.json");
            File data3 = new File("data3.json");
            File data4 = new File("data4.json");
            File data5 = new File("data5.json");
            File data6 = new File("data6.json");
            File data7 = new File("data7.json");

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
                        for (String s : sublist) {
                            insert.append(s).append("\n");
                        }
                        String s1 = insert.toString().trim();
                        String s2 = "DATE";
                        int i = (s1.indexOf(s2));
                        String s3 = s1.substring(i + 7, i + 17);
                        LocalDate date = LocalDate.parse(s3);
                        DayOfWeek dayOfWeek = DayOfWeek.from(date);
                        int val = dayOfWeek.getValue();
                        switch (val) {
                            case 1:
                                Logger log1 = new Logger("data1.json");
                                if (data1.length() == 0) {
                                    log1.log(s1);
                                } else {
                                    data1.delete();
                                    log1.log(s1);


                                }
                                break;
                            case 2:
                                Logger log2 = new Logger("data2.json");
                                if (data2.length() == 0) {
                                    log2.log(s1);
                                } else {
                                    data2.delete();
                                    log2.log(s1);


                                }
                                break;
                            case 3:
                                Logger log3 = new Logger("data3.json");
                                if (data3.length() == 0) {
                                    log3.log(s1);
                                } else {
                                    data3.delete();
                                    log3.log(s1);


                                }
                                break;
                            case 4:
                                Logger log4 = new Logger("data4.json");
                                if (data4.length() == 0) {
                                    log4.log(s1);
                                } else {
                                    data4.delete();
                                    log4.log(s1);


                                }
                                break;
                            case 5:
                                Logger log5 = new Logger("data5.json");
                                if (data5.length() == 0) {
                                    log5.log(s1);
                                } else {
                                    data5.delete();
                                    log5.log(s1);


                                }
                                break;
                            case 6:
                                Logger log6 = new Logger("data6.json");
                                if (data6.length() == 0) {
                                    log6.log(s1);
                                } else {
                                    data6.delete();
                                    log6.log(s1);


                                }
                                break;
                            default:
                                Logger log7 = new Logger("data7.json");
                                if (data7.length() == 0) {
                                    log7.log(s1);
                                } else {
                                    data7.delete();
                                    log7.log(s1);


                                }


                        }


                    }

                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}










