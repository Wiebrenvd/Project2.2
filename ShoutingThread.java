package shoutingMTServer;

import java.net.*;
import java.io.*;
//import java.util.concurrent.*;

class Worker implements Runnable
{
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
			
			PrintWriter pout = new PrintWriter(connection.getOutputStream(), true);
			BufferedReader bin = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			
			String currentdata = "";
			while ((s = bin.readLine()) != null) {
				if(s.equals("	<MEASUREMENT>")) {
					currentdata = "";
					currentdata = currentdata + s;
					
				}
				if(s.equals("	</MEASUREMENT>")) {
					currentdata = currentdata + s;
					ShoutingMTServer.xmlData.add(currentdata);
				}
						
				if(s.equals("	</MEASUREMENT>")|| s.equals("	<MEASUREMENT>")){
					//do nothing here
				}else{
					currentdata = currentdata + s;
				}         
	        }
	
			// now close the socket connection
			connection.close();
			System.err.println("Connection closed: workerthread ending");
			// upping the semaphore.. since the connnection is gone....
			ShoutingMTServer.mijnSemafoor.verhoog();
		}
		catch (IOException ioe) { }
		catch (InterruptedException ie) {}
	}
}

