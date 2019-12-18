package shoutingMTServer;

import java.io.StringReader;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.xml.sax.InputSource;

class Parser implements Runnable {

	@Override
	public void run() {
		String stn = ""; 
		String date = ""; 
		String time = "";
		String temp = ""; 
		String dewp = ""; 
		String stp = "";
		String slp = "";
		String visib = "";
		String wdsp = "";
		String prcp = "";
		String sndp = "";
		String frshtt = "";
		String cldc = "";
		String wnddir = ""; 
		try{  
			DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
			InputSource src = new InputSource();
			Document doc = null; 
			
			while(ShoutingMTServer.xmlData !=null) 
			{
				if(ShoutingMTServer.xmlData.size() > 0) {
					//System.out.println(ShoutingMTServer.xmlData.get(0));
					String data = ShoutingMTServer.xmlData.get(0);
					//data.replaceAll("\\s+","");
					ShoutingMTServer.xmlData.remove(0);
					if(data != null) {
						//System.out.println(data);
						src.setCharacterStream(new StringReader(data));
						doc = builder.parse(src);
						stn = doc.getElementsByTagName("STN").item(0).getTextContent();
						date = doc.getElementsByTagName("DATE").item(0).getTextContent();
						time = doc.getElementsByTagName("TIME").item(0).getTextContent();
						temp = doc.getElementsByTagName("TEMP").item(0).getTextContent();
						dewp = doc.getElementsByTagName("DEWP").item(0).getTextContent();
						stp = doc.getElementsByTagName("STP").item(0).getTextContent();
						slp = doc.getElementsByTagName("SLP").item(0).getTextContent();
						visib = doc.getElementsByTagName("VISIB").item(0).getTextContent();
						wdsp = doc.getElementsByTagName("WDSP").item(0).getTextContent();
						prcp = doc.getElementsByTagName("PRCP").item(0).getTextContent();
						sndp = doc.getElementsByTagName("SNDP").item(0).getTextContent();
						frshtt = doc.getElementsByTagName("FRSHTT").item(0).getTextContent();
						cldc = doc.getElementsByTagName("CLDC").item(0).getTextContent();
						wnddir = doc.getElementsByTagName("WNDDIR").item(0).getTextContent();


						if(stn.equals("") || date.equals("") || time.equals("") || temp.equals("") || dewp.equals("") || stp.equals("") || slp.equals("") || visib.equals("") || wdsp.equals("") || prcp.equals("") || sndp.equals("") || frshtt.equals("") || cldc.equals("") || wnddir.equals("")) {
							//System.out.println("Data incomplete");
						}else {
							//System.out.println("(" + stn + ",'" + date + "','" + time + "'," +temp+ "," +dewp+ "," +stp+ "," +slp+ "," +visib+ "," +wdsp+ "," +prcp+ "," +sndp+ "," +frshtt+ "," +cldc+ "," +wnddir +")");
							ShoutingMTServer.insertData.add("(" + stn + ",'" + date + "','" + time + "'," +temp+ "," +dewp+ "," +stp+ "," +slp+ "," +visib+ "," +wdsp+ "," +prcp+ "," +sndp+ "," +frshtt+ "," +cldc+ "," +wnddir +")");
						}
					}
				}else
				{
					System.out.println("No data found");
				}
			}
			
			//con.close();  
			}catch(Exception e){ 
				System.out.println(e + " NULL");
				e.printStackTrace();
			}
	}  
}  
