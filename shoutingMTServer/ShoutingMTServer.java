package shoutingMTServer;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class ShoutingMTServer {
	public static final int PORT = 2500;
	private static final int maxnrofConnections=800;
	public static TelSemafoor mijnSemafoor = new TelSemafoor(maxnrofConnections);
	public static ArrayList<String> xmlData = new ArrayList<String>();
	
	public static void main(String[] args) {
		Socket connection;
		try {
			ServerSocket server = new ServerSocket(PORT);
			System.err.println("MT Server started..bring on the load, to a maximum of: " + maxnrofConnections);
			
			//Start 5 threads voor data afhandeling naar db
			Thread parser = null; 
			for(int i = 0;i<7;i++) {
				SAXParserFactory factory = SAXParserFactory.newInstance();
				SAXParser saxParser = factory.newSAXParser();

				SAXHandler SAXHandler = new SAXHandler();
				saxParser.parse("test.xml", SAXHandler);

			}
		
			
			while (true) {
				connection = server.accept();		
				//System.err.println("New connection accepted..handing it over to worker thread");
				Thread worker = new Thread(new Worker(connection));
				worker.start();
			}
		}

		catch (java.io.IOException ioe) { } catch (SAXException e) {
			e.printStackTrace();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		}
	}
}
