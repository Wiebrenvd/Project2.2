package shoutingMTServer;

import java.io.StringReader;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.xml.sax.InputSource;

class Parser implements Runnable {

	public synchronized void run() {
		try{  
			DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
			InputSource src = new InputSource();
			Document doc;

			while(ShoutingMTServer.xmlData !=null) {
				if(ShoutingMTServer.xmlData.size() > 0) {
					String data = ShoutingMTServer.xmlData.get(0);
					ShoutingMTServer.xmlData.remove(0);
					if(data != null) {
						src.setCharacterStream(new StringReader(data));
						doc = builder.parse(src);
						String stn = doc.getElementsByTagName("STN").item(0).getTextContent();
						String date = doc.getElementsByTagName("DATE").item(0).getTextContent();
						String time = doc.getElementsByTagName("TIME").item(0).getTextContent();
						String temp = doc.getElementsByTagName("TEMP").item(0).getTextContent();
						String dewp = doc.getElementsByTagName("DEWP").item(0).getTextContent();
						String stp = doc.getElementsByTagName("STP").item(0).getTextContent();
						String slp = doc.getElementsByTagName("SLP").item(0).getTextContent();
						String visib = doc.getElementsByTagName("VISIB").item(0).getTextContent();
						String wdsp = doc.getElementsByTagName("WDSP").item(0).getTextContent();
						String prcp = doc.getElementsByTagName("PRCP").item(0).getTextContent();
						String sndp = doc.getElementsByTagName("SNDP").item(0).getTextContent();
						String frshtt = doc.getElementsByTagName("FRSHTT").item(0).getTextContent();
						String cldc = doc.getElementsByTagName("CLDC").item(0).getTextContent();
						String wnddir = doc.getElementsByTagName("WNDDIR").item(0).getTextContent();

						if(!stn.equals("") && !date.equals("") && !time.equals("") && !temp.equals("") && !dewp.equals("") && !stp.equals("") && !slp.equals("") && !visib.equals("") && !wdsp.equals("") && !prcp.equals("") && !sndp.equals("") && !frshtt.equals("") && !cldc.equals("") && !wnddir.equals("")) {
							ShoutingMTServer.insertData.add("(" + stn + ",'" + date + "','" + time + "'," +temp+ "," +dewp+ "," +stp+ "," +slp+ "," +visib+ "," +wdsp+ "," +prcp+ "," +sndp+ "," +frshtt+ "," +cldc+ "," +wnddir +")");
						}
					}
				}
			}
		}catch(Exception e){
			System.out.println(e + " NULL");
			e.printStackTrace();
		}
	}  
}  
