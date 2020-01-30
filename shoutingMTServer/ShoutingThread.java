package shoutingMTServer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
//import java.util.concurrent.*;

class Worker implements Runnable {
    private Socket connection;

    public Worker(Socket connection) {
        this.connection = connection;
    }

    public void run() {
        try {
            String s;
            //System.err.println("New worker thread started");

            //lets check if we already accepted maximum number of connections
            ShoutingMTServer.mijnSemafoor.probeer();
            BufferedReader bin = new BufferedReader(new InputStreamReader(connection.getInputStream()));

            String currentdata = "";
            while ((s = bin.readLine()) != null) {
                if (s.equals("	<MEASUREMENT>")) {
                    currentdata = "";
                    currentdata = currentdata + s;

                } else if (s.equals("	</MEASUREMENT>")) {
                    currentdata = currentdata + s;
                    ShoutingMTServer.xmlData.add(currentdata);
                } else {
                    currentdata = currentdata + s;
                }
            }

            // now close the socket connection
            connection.close();
            // System.err.println("Connection closed: workerthread ending");
            // upping the semaphore.. since the connnection is gone....
            ShoutingMTServer.mijnSemafoor.verhoog();
        } catch (IOException | InterruptedException ioe) {
            ioe.printStackTrace();
        }
    }
}

