package shoutingMTServer;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

public class Logger {

    private File logFile;

    public Logger() {

    }

    public Logger(String fileName) {
        logFile = new File(fileName);
    }

    public Logger(File f) {
        logFile = f;

    }

    public void log(String s) {

        try {
            FileWriter fw = new FileWriter(this.logFile,true);
            String date = new Date().toString();
            fw.write(s);
            fw.write(System.lineSeparator());
            fw.close();
        } catch (IOException ex) {
            System.err.println("Couldn't log this: "+s);
        }

    }

}