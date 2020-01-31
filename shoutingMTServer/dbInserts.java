package shoutingMTServer;

import java.io.File;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


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
                    for (int start = 0; start < templist.size(); start += size) {
                        int end = Math.min(start + size, templist.size());
                        List<String> sublist = templist.subList(start, end);
                        insert = new StringBuilder();

                        for (String s : sublist) {
                            insert.append(s).append("\n");
                        }

                        String s1 = insert.toString().trim();
                        String s2 = "DATE";
                        int i = (s1.indexOf(s2));
                        String s3 = s1.substring(i + 7, i + 17);
                        LocalDate date = LocalDate.parse(s3);
                        Logger logger = new Logger(date + ".json");
                        logger.log(s1);
                        File ToRemove = new File((date.minusDays(7)) + ".json");
                        ToRemove.delete();
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}










