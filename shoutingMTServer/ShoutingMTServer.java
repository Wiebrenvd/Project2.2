package shoutingMTServer;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ShoutingMTServer {
	public static final int PORT = 2500;
	private static final int maxnrofConnections=800;
	public static TelSemafoor mijnSemafoor = new TelSemafoor(maxnrofConnections);
	public static volatile ArrayList<String> xmlData = new ArrayList<String>();
	public static volatile List<String> insertData = Collections.synchronizedList(new ArrayList<String>());
	
	public static void main(String[] args) {
		Socket connection;
		try {
			ServerSocket server = new ServerSocket(PORT);
			System.err.println("MT Server started..bring on the load, to a maximum of: " + maxnrofConnections);
			
			Thread inserts = new Thread(new Inserts());
			inserts.setPriority(10);
			inserts.start();
//
			
			Thread parser = new Thread(new Saxparser());
			parser.setPriority(10);
			parser.start();

			//noinspection InfiniteLoopStatement
			while (true) {
				connection = server.accept();		
				//System.err.println("New connection accepted..handing it over to worker thread");
				Thread worker = new Thread(new Worker(connection));
				worker.start();
			}
		}

		catch (java.io.IOException ioe) { 
			ioe.printStackTrace();
		}
	}
}
